package eu.nimble.core.infrastructure.identity.entity.dto;

public class CompanyCertificate {
    private String id;
    private String name;
    private String description;
    private String type;
    private boolean hasFile; // whether the certificate has a file or not

    public CompanyCertificate() {
    }

    public CompanyCertificate(String name, String type, String id, String description, boolean hasFile) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.description = description;
        this.hasFile = hasFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasFile() {
        return hasFile;
    }

    public void setHasFile(boolean hasFile) {
        this.hasFile = hasFile;
    }
}
