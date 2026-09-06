package com.github.goposta.posta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * WorkspaceDataExport is a portable snapshot of a workspace's configuration
 * and content, as produced by [WorkspacesService.ExportData] and consumed by
 * [WorkspacesService.ImportData].
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceDataExport {

    private List<TemplateExport> templates;

    private List<Language> languages;

    private List<Stylesheet> stylesheets;

    private List<Domain> domains;

    @JsonProperty("smtp_servers")
    private List<SMTPServer> smtpServers;

    private List<Webhook> webhooks;

    private List<Subscriber> subscribers;

    @JsonProperty("subscriber_lists")
    private List<SubscriberList> subscriberLists;

    @JsonProperty("contact_lists")
    private List<SubscriberList> contactLists;

    private List<Contact> contacts;

    private List<Suppression> suppressions;

    @JsonProperty("unsubscribe_lists")
    private List<UnsubscribeList> unsubscribeLists;

    private List<Campaign> campaigns;

    private List<Form> forms;

    @JsonProperty("message_filters")
    private List<MessageFilter> messageFilters;

    @JsonProperty("posta_version")
    private String postaVersion;

    @JsonProperty("exported_at")
    private String exportedAt;

    public WorkspaceDataExport templates(List<TemplateExport> templates) { this.templates = templates; return this; }
    public List<TemplateExport> getTemplates() { return templates; }
    public WorkspaceDataExport languages(List<Language> languages) { this.languages = languages; return this; }
    public List<Language> getLanguages() { return languages; }
    public WorkspaceDataExport stylesheets(List<Stylesheet> stylesheets) { this.stylesheets = stylesheets; return this; }
    public List<Stylesheet> getStylesheets() { return stylesheets; }
    public WorkspaceDataExport domains(List<Domain> domains) { this.domains = domains; return this; }
    public List<Domain> getDomains() { return domains; }
    public WorkspaceDataExport smtpServers(List<SMTPServer> smtpServers) { this.smtpServers = smtpServers; return this; }
    public List<SMTPServer> getSmtpServers() { return smtpServers; }
    public WorkspaceDataExport webhooks(List<Webhook> webhooks) { this.webhooks = webhooks; return this; }
    public List<Webhook> getWebhooks() { return webhooks; }
    public WorkspaceDataExport subscribers(List<Subscriber> subscribers) { this.subscribers = subscribers; return this; }
    public List<Subscriber> getSubscribers() { return subscribers; }
    public WorkspaceDataExport subscriberLists(List<SubscriberList> subscriberLists) { this.subscriberLists = subscriberLists; return this; }
    public List<SubscriberList> getSubscriberLists() { return subscriberLists; }
    public WorkspaceDataExport contactLists(List<SubscriberList> contactLists) { this.contactLists = contactLists; return this; }
    public List<SubscriberList> getContactLists() { return contactLists; }
    public WorkspaceDataExport contacts(List<Contact> contacts) { this.contacts = contacts; return this; }
    public List<Contact> getContacts() { return contacts; }
    public WorkspaceDataExport suppressions(List<Suppression> suppressions) { this.suppressions = suppressions; return this; }
    public List<Suppression> getSuppressions() { return suppressions; }
    public WorkspaceDataExport unsubscribeLists(List<UnsubscribeList> unsubscribeLists) { this.unsubscribeLists = unsubscribeLists; return this; }
    public List<UnsubscribeList> getUnsubscribeLists() { return unsubscribeLists; }
    public WorkspaceDataExport campaigns(List<Campaign> campaigns) { this.campaigns = campaigns; return this; }
    public List<Campaign> getCampaigns() { return campaigns; }
    public WorkspaceDataExport forms(List<Form> forms) { this.forms = forms; return this; }
    public List<Form> getForms() { return forms; }
    public WorkspaceDataExport messageFilters(List<MessageFilter> messageFilters) { this.messageFilters = messageFilters; return this; }
    public List<MessageFilter> getMessageFilters() { return messageFilters; }
    public WorkspaceDataExport postaVersion(String postaVersion) { this.postaVersion = postaVersion; return this; }
    public String getPostaVersion() { return postaVersion; }
    public WorkspaceDataExport exportedAt(String exportedAt) { this.exportedAt = exportedAt; return this; }
    public String getExportedAt() { return exportedAt; }
}
