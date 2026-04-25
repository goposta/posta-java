package com.github.goposta.posta;

/**
 * Body for the explicit list subscribe endpoint. The list is identified by
 * name (created on first use); any prior list-scoped opt-out for this
 * (list, email) is cleared.
 */
public class ListSubscribeRequest {

    private String email;
    private String name;
    private String list;

    public ListSubscribeRequest email(String email) { this.email = email; return this; }
    public ListSubscribeRequest name(String name) { this.name = name; return this; }
    public ListSubscribeRequest list(String list) { this.list = list; return this; }

    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getList() { return list; }
}
