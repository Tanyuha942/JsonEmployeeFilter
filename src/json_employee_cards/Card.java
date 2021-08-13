package json_employee_cards;

import com.google.gson.annotations.SerializedName;

public class Card {

    @SerializedName("ModificationStatus")
    private int modificationStatus;

    @SerializedName("Token")
    private Long token;

    @SerializedName("Name")
    private String name;

    @SerializedName("AntipassbackDisabled")
    private boolean antipassbackDisabled;

    @SerializedName("Code")
    private String code;

    @SerializedName("ConfirmationUrl")
    private String confirmationUrl;

    @SerializedName("Disalarm")
    private boolean disalarm;

    @SerializedName("Email")
    private String email;

    @SerializedName("EmailRequestCode")
    private String emailRequestCode;

    @SerializedName("IdentifierType")
    private int identifierType;

    @SerializedName("PIN")
    private String pin;

    @SerializedName("PoolToken")
    private long poolToken;

    @SerializedName("Security")
    private boolean security;

    @SerializedName("Status")
    private int status;

    @SerializedName("UserName")
    private String userName;

    @SerializedName("UserToken")
    private long userToken;

    @SerializedName("UserType")
    private int userType;

    @SerializedName("VIP")
    private boolean vip;

    @SerializedName("ValidFrom")
    private String validFrom;

    public int getModificationStatus() {
        return modificationStatus;
    }

    public Long getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public boolean isAntipassbackDisabled() {
        return antipassbackDisabled;
    }

    public String getCode() {
        return code;
    }

    public String getConfirmationUrl() {
        return confirmationUrl;
    }

    public boolean isDisalarm() {
        return disalarm;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailRequestCode() {
        return emailRequestCode;
    }

    public int getIdentifierType() {
        return identifierType;
    }

    public String getPin() {
        return pin;
    }

    public long getPoolToken() {
        return poolToken;
    }

    public boolean isSecurity() {
        return security;
    }

    public int getStatus() {
        return status;
    }

    public String getUserName() {
        return userName;
    }

    public long getUserToken() {
        return userToken;
    }

    public int getUserType() {
        return userType;
    }

    public boolean isVip() {
        return vip;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public boolean isValidFromUsed() {
        return ValidFromUsed;
    }

    public String getValidTo() {
        return validTo;
    }

    public boolean isValidToUsed() {
        return validToUsed;
    }

    @SerializedName("ValidFromUsed")
    private boolean ValidFromUsed;

    @SerializedName("ValidTo")
    private String validTo;

    @SerializedName("ValidToUsed")
    private boolean validToUsed;
}