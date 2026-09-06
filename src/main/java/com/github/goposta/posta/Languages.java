package com.github.goposta.posta;

import java.io.IOException;

/** Manages the languages a workspace's templates can be localized into. */
public class Languages {

    private final Http http;

    Languages(Http http) {
        this.http = http;
    }

    /** Adds a language. The code is a BCP 47 tag such as {@code en} or {@code pt-BR}. */
    public Language create(CreateLanguageRequest request) throws PostaException, IOException {
        return http.post(Http.WS + "/languages", request, Language.class);
    }

    /** Returns a page of languages. */
    public PageableResponse<Language> list(int page, int size) throws PostaException, IOException {
        return http.getPage(Http.WS + "/languages" + Http.query("page", page, "size", size),
                Language.class);
    }

    /** Changes a language. */
    public Language update(long id, UpdateLanguageRequest request)
            throws PostaException, IOException {
        return http.put(Http.WS + "/languages/" + Http.seg(id), request, Language.class);
    }

    /** Removes a language. Localizations already written in it are kept. */
    public void delete(long id) throws PostaException, IOException {
        http.delete(Http.WS + "/languages/" + Http.seg(id));
    }
}
