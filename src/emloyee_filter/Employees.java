package emloyee_filter;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employees {

    @SerializedName("Employee")
    private List<EmployeeObject> employee;

    public List<EmployeeObject> getEmployee() {
        return employee;
    }
}