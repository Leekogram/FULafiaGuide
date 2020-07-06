package model;

public class PrincipalOfficersModel {
    private int photoid;
    private String name;
    private String post;

    PrincipalOfficersModel(){

    }

    public PrincipalOfficersModel(int photoid, String name, String post) {
        this.photoid = photoid;
        this.name = name;
        this.post = post;
    }

    public int getPhotoid() {
        return photoid;
    }

    public void setPhotoid(int photoid) {
        this.photoid = photoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
