package json_employee_add;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AddEmployees {

    @SerializedName("AddEmployee")
    private List<AddEmployeeObject> addEmployee;

    public List<AddEmployeeObject> getAddEmployee() {
        return addEmployee;
    }

    public void setAddEmployee(List<AddEmployeeObject> addEmployee) {
        this.addEmployee = addEmployee;
    }
}