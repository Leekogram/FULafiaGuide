package model;

public class SearchModel {

    private int faculty_Image;
    private String faculty_Name;

    public int getFaculty_Image() {
        return faculty_Image;
    }

    public void setFaculty_Image(int faculty_Image) {
        this.faculty_Image = faculty_Image;
    }

    public String getFaculty_Name() {
        return faculty_Name;
    }

    public void setFaculty_Name(String faculty_Name) {
        this.faculty_Name = faculty_Name;
    }

    public SearchModel(int faculty_Image, String faculty_Name) {
        this.faculty_Image = faculty_Image;
        this.faculty_Name = faculty_Name;

    }
    public SearchModel(){

    }


}
