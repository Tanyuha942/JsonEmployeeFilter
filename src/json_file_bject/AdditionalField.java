package json_file_bject;

import com.google.gson.annotations.SerializedName;

public class AdditionalField {

    @SerializedName("Name")
    private String name;

    @SerializedName("Value")
    private String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
