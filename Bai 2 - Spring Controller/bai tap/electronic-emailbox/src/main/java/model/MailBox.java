package model;

public class MailBox {
    private int id;
    private int idLanguage;
    private int pageSize;
    private int spamFilter;
    private String signature;

    public MailBox() {
    }

    public MailBox(int id, int idLanguages, int pageSize, int spamFilter, String signature) {
        this.id = id;
        this.idLanguage = idLanguages;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(int idLanguage) {
        this.idLanguage = idLanguage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(int spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
