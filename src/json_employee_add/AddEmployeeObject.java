package json_employee_add;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AddEmployeeObject implements Serializable {

    @SerializedName("Emp")
    private long emp;

    @SerializedName("Code")
    private String code;

    @SerializedName("Rang")
    private String rang;

    @SerializedName("UserToken")
    private Long userToken;

    @SerializedName("EmpName")
    private String empName;

    public AddEmployeeObject() {

    }

    public AddEmployeeObject(String code, Long userToken) {
        this.code = code;
        this.userToken = userToken;
    }

    public long getEmp() {
        return emp;
    }

    public String getCode() {
        return code;
    }

    public String getRang() {
        return rang;
    }

    public Long getUserToken() {
        return userToken;
    }

    public String getEmpName() {
        return empName;
    }

    public String setCode(String code) {
        this.code = code;
        return code;
    }

    public Long setUserToken(Long userToken) {
        this.userToken = userToken;
        return userToken;
    }

//    @Override
//    public String toString() {
//        return "AddEmployeeObject{" +
//                "emp=" + emp +
//                ", code='" + code + '\'' +
//                ", rang='" + rang + '\'' +
//                ", userToken=" + userToken +
//                ", empName='" + empName + '\'' +
//                '}';
//    }
}