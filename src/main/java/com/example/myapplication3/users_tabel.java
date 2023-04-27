package com.example.myapplication3;

public class users_tabel {

    private int Id;
    private  String name;
    private String email;
    private String password;


    public users_tabel(int id, String name1, String email1, String password1) {
        Id = id;
        name = name1;
        email = email1;
        password = password1;

    }

    public users_tabel(String name1, String email1, String password1) {
        name = name1;
        email = email1;
        password = password1;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name1) {
        name = name1;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email1) {
        email = email1;
    }


    public String getpassword() {
        return password;
    }

    public void setpassword(String password1) {
        password = password1;
    }


}
