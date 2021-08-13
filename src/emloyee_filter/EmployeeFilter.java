package emloyee_filter;

import com.google.gson.annotations.SerializedName;

public class EmployeeFilter {
    @SerializedName("Employees")
    private Employees employees;

    public Employees getEmployees() {
        return employees;
    }
}