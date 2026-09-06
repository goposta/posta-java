package com.github.goposta.posta;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The public endpoints: signing in, registering, and recovering a password.
 *
 * <p>They need no credential, so a client built for them can be created with an
 * empty key.</p>
 */
public class Auth {

    private final Http http;

    Auth(Http http) {
        this.http = http;
    }

    /** Exchanges an email and password for a session token. */
    public AuthResponse login(String email, String password) throws PostaException, IOException {
        return login(email, password, null);
    }

    /**
     * Exchanges an email and password for a session token.
     *
     * @param twoFactorCode required when the account has 2FA enabled, else null
     */
    public AuthResponse login(String email, String password, String twoFactorCode)
            throws PostaException, IOException {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("email", email);
        body.put("password", password);
        if (twoFactorCode != null) {
            body.put("two_factor_code", twoFactorCode);
        }
        return http.post("/auth/login", body, AuthResponse.class);
    }

    /**
     * Creates an account, when the deployment allows self-registration. Check
     * first with {@link #registrationStatus()}.
     */
    public AuthResponse register(String name, String email, String password)
            throws PostaException, IOException {
        return http.post("/auth/register",
                Map.of("name", name, "email", email, "password", password), AuthResponse.class);
    }

    /** Reports whether self-registration is enabled. */
    public JsonNode registrationStatus() throws PostaException, IOException {
        return http.tree("GET", "/auth/registration-status", null).path("data");
    }

    /**
     * Emails a reset link. It always succeeds, whether or not the address has an
     * account, so it cannot be used to enumerate users.
     */
    public void forgotPassword(String email) throws PostaException, IOException {
        http.post("/auth/forgot-password", Map.of("email", email), Void.class);
    }

    /** Redeems a reset token and sets a new password. */
    public void resetPassword(String token, String newPassword)
            throws PostaException, IOException {
        http.post("/auth/reset-password", Map.of("token", token, "new_password", newPassword),
                Void.class);
    }

    /** Redeems the token from a verification email. */
    public void verifyEmail(String token) throws PostaException, IOException {
        http.tree("GET", "/auth/verify-email" + Http.query("token", token), null);
    }

    /**
     * Reports which SSO provider, if any, an email domain is bound to, so a
     * login page can send the user straight to it.
     */
    public SSOProvider discoverSso(String email) throws PostaException, IOException {
        return http.post("/auth/oauth/discover", Map.of("email", email), SSOProvider.class);
    }

    /** Returns the SSO providers offered on the sign-in page. */
    public JsonNode listOAuthProviders() throws PostaException, IOException {
        return http.tree("GET", "/auth/oauth/providers", null).path("data");
    }

    /**
     * Returns the URL that begins an OAuth sign-in with {@code provider}.
     * Redirect the browser here; Posta handles the callback itself.
     */
    public String authorizeUrl(String provider) {
        return http.baseUrl() + "/auth/oauth/" + Http.seg(provider) + "/authorize";
    }
}
