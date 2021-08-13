package emloyee_filter;

import com.google.gson.annotations.SerializedName;

public class EmployeeObject {

    @SerializedName("EMP")
    private String emp;

    public String getEmp() {
        return emp;
    }
}