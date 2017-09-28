package com.shibuyaxpress.mbrt;

/**
 * Created by paulf on 28-Sep-17.
 */

public class User {

    private String username;
    private String password;
    private String name;
    private String lastName;
    private String role;
    private String imgprofile;

    public String getImgprofile() {
        return imgprofile;
    }

    public void setImgprofile(String imgprofile) {
        this.imgprofile = imgprofile;
    }

    public User(String username, String password, String name, String lastName, String role, String imgprofile) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.imgprofile=imgprofile;

    }
    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private static User _INSTANCE=null;

    public String getUsername() {
        return username;
    }

    public static User getInstance(){
        if(_INSTANCE==null){
            _INSTANCE=new User();
        }
        return _INSTANCE;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
