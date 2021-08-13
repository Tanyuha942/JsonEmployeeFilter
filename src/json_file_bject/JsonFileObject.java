package json_file_bject;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class JsonFileObject {

    @SerializedName("Employee")
    private List<Employee> employee;

    @SerializedName("Language")
    private String language;

    @SerializedName("NextToken")
    private long nextToken;

    @SerializedName("UserSID")
    private long userSid;

    public List<Employee> getEmployee() {
        return employee;
    }

    public String getLanguage() {
        return language;
    }

    public long getNextToken() {
        return nextToken;
    }

    public long getUserSid() {
        return userSid;
    }
}
