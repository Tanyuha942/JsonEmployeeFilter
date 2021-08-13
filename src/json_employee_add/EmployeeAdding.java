package json_employee_add;

import com.google.gson.annotations.SerializedName;

public class EmployeeAdding {

    @SerializedName("AddEmployees")
    private AddEmployees addEmployees;

    public AddEmployees getAddEmployees() {
        return addEmployees;
    }
}