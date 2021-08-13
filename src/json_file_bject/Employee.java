package json_file_bject;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Employee {

    @SerializedName("ModificationStatus")
    private int modificationStatus;

    @SerializedName("Token")
    private long token;

    @SerializedName("Name")
    private String name;

    @SerializedName("AdditionalFields")
    private List<AdditionalField> additionalFields;

    @SerializedName("FieldGroupToken")
    private long fieldGroupToken;

    @SerializedName("AccessGroupInherited")
    private boolean accessGroupInherited;

    @SerializedName("AccessGroupToken")
    private long accessGroupToken;

    @SerializedName("CardCount")
    private int cardCount;

    @SerializedName("DepartmentName")
    private String departmentName;

    @SerializedName("DepartmentToken")
    private long departmentToken;

    @SerializedName("Email")
    private String email;

    @SerializedName("IconToken")
    private long iconToken;

    @SerializedName("IconVersion")
    private long iconVersion;

    @SerializedName("LastModified")
    private String lastModified;

    @SerializedName("OwnAccessRulesAssigned")
    private boolean ownAccessRulesAssigned;

    @SerializedName("PhotoToken")
    private long photoToken;

    @SerializedName("PhotoVersion")
    private long photoVersion;

    @SerializedName("Post")
    private String post;

    public int getModificationStatus() {
        return modificationStatus;
    }

    public long getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public List<AdditionalField> getAdditionalFields() {
        return additionalFields;
    }

    public long getFieldGroupToken() {
        return fieldGroupToken;
    }

    public boolean isAccessGroupInherited() {
        return accessGroupInherited;
    }

    public long getAccessGroupToken() {
        return accessGroupToken;
    }

    public int getCardCount() {
        return cardCount;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public long getDepartmentToken() {
        return departmentToken;
    }

    public String getEmail() {
        return email;
    }

    public long getIconToken() {
        return iconToken;
    }

    public long getIconVersion() {
        return iconVersion;
    }

    public String getLastModified() {
        return lastModified;
    }

    public boolean isOwnAccessRulesAssigned() {
        return ownAccessRulesAssigned;
    }

    public long getPhotoToken() {
        return photoToken;
    }

    public long getPhotoVersion() {
        return photoVersion;
    }

    public String getPost() {
        return post;
    }
}
