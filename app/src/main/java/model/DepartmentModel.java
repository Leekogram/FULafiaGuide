package model;

public class DepartmentModel {
    private String DepartmentName;

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public DepartmentModel(String departmentName) {
        DepartmentName = departmentName;
    }

    public DepartmentModel(){

    }


}
