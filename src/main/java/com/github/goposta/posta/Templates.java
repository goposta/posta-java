package com.github.goposta.posta;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages templates and the versions and localizations beneath them.
 *
 * <p>A template is a named container. Its content lives on immutable versions,
 * and each version carries one localization per language. Sending resolves the
 * template's active version unless a caller names another.</p>
 */
public class Templates {

    private final Http http;

    Templates(Http http) {
        this.http = http;
    }

    /** Adds a template. Content is added afterwards as a version. */
    public Template create(CreateTemplateRequest request) throws PostaException, IOException {
        return http.post(Http.WS + "/templates", request, Template.class);
    }

    /** Returns a page of templates, without the non-active version bodies. */
    public PageableResponse<TemplateListItem> list(int page, int size)
            throws PostaException, IOException {
        return list(page, size, null);
    }

    /** Returns a page of templates matching a free-text search. */
    public PageableResponse<TemplateListItem> list(int page, int size, String search)
            throws PostaException, IOException {
        return http.getPage(Http.WS + "/templates"
                + Http.query("page", page, "size", size, "search", search), TemplateListItem.class);
    }

    /** Returns one template with its active version. */
    public Template get(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/templates/" + Http.seg(id), Template.class);
    }

    /** Changes a template's metadata. */
    public Template update(long id, UpdateTemplateRequest request)
            throws PostaException, IOException {
        return http.put(Http.WS + "/templates/" + Http.seg(id), request, Template.class);
    }

    /** Removes a template and every version under it. */
    public void delete(long id) throws PostaException, IOException {
        http.delete(Http.WS + "/templates/" + Http.seg(id));
    }

    /** Renders unsaved template source with the given variables. */
    public PreviewResult preview(PreviewTemplateRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/templates/preview", request, PreviewResult.class);
    }

    /** Sends a test rendering of a template to real inboxes. */
    public SendResponse sendTest(long id, SendTestRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/templates/" + Http.seg(id) + "/send-test",
                request, SendResponse.class);
    }

    /** Returns a template and all its versions in portable form. */
    public TemplateExport export(long id) throws PostaException, IOException {
        return http.get(Http.WS + "/templates/" + Http.seg(id) + "/export", TemplateExport.class);
    }

    /** Recreates a template from an exported payload. */
    public Template importTemplate(TemplateExport payload) throws PostaException, IOException {
        return http.post(Http.WS + "/templates/import", payload, Template.class);
    }

    /** Creates a template from a raw HTML document. */
    public Template importHtml(ImportHTMLRequest request) throws PostaException, IOException {
        return http.post(Http.WS + "/templates/import-html", request, Template.class);
    }

    /** Returns every version of a template, newest first. */
    public List<TemplateVersion> listVersions(long templateId) throws PostaException, IOException {
        return http.getList(Http.WS + "/templates/" + Http.seg(templateId) + "/versions",
                TemplateVersion.class);
    }

    /** Opens a new draft version, copying the active one's localizations. */
    public TemplateVersion createVersion(long templateId, CreateVersionRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/templates/" + Http.seg(templateId) + "/versions",
                request == null ? new CreateVersionRequest() : request, TemplateVersion.class);
    }

    /** Changes a version's stylesheet. */
    public TemplateVersion updateVersion(long templateId, long versionId, Long stylesheetId)
            throws PostaException, IOException {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("stylesheet_id", stylesheetId);
        return http.put(Http.WS + "/templates/" + Http.seg(templateId)
                + "/versions/" + Http.seg(versionId), body, TemplateVersion.class);
    }

    /** Removes a version. The active version cannot be deleted. */
    public void deleteVersion(long templateId, long versionId) throws PostaException, IOException {
        http.delete(Http.WS + "/templates/" + Http.seg(templateId)
                + "/versions/" + Http.seg(versionId));
    }

    /** Makes a version the one that sends. */
    public Template activateVersion(long templateId, long versionId)
            throws PostaException, IOException {
        return http.post(Http.WS + "/templates/" + Http.seg(templateId)
                + "/activate/" + Http.seg(versionId), null, Template.class);
    }

    /** Returns every language defined on a version. */
    public List<TemplateLocalization> listLocalizations(long templateId, long versionId)
            throws PostaException, IOException {
        return http.getList(Http.WS + "/templates/" + Http.seg(templateId)
                + "/versions/" + Http.seg(versionId) + "/localizations",
                TemplateLocalization.class);
    }

    /** Adds a language to a version. */
    public TemplateLocalization createLocalization(long templateId, long versionId,
                                                   CreateLocalizationRequest request)
            throws PostaException, IOException {
        return http.post(Http.WS + "/templates/" + Http.seg(templateId)
                + "/versions/" + Http.seg(versionId) + "/localizations",
                request, TemplateLocalization.class);
    }

    /**
     * Changes a language's content. Localizations are addressed by their own id,
     * not by template and version.
     */
    public TemplateLocalization updateLocalization(long localizationId,
                                                   UpdateLocalizationRequest request)
            throws PostaException, IOException {
        return http.put(Http.WS + "/localizations/" + Http.seg(localizationId),
                request, TemplateLocalization.class);
    }

    /** Removes a language from its version. */
    public void deleteLocalization(long localizationId) throws PostaException, IOException {
        http.delete(Http.WS + "/localizations/" + Http.seg(localizationId));
    }

    /** Renders a saved version in one language. */
    public PreviewResult previewLocalization(long templateId, long versionId,
                                             String language, Map<String, Object> templateData)
            throws PostaException, IOException {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("language", language);
        if (templateData != null) {
            body.put("template_data", templateData);
        }
        return http.post(Http.WS + "/templates/" + Http.seg(templateId)
                + "/versions/" + Http.seg(versionId) + "/preview", body, PreviewResult.class);
    }
}
