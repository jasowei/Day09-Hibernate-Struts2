package com.lanou.domain;

/**
 * Created by dllo on 17/10/20.
 */
public class Post {
    private int id;
    private String pname;

    public Post(String pname) {
        this.pname = pname;
    }

    public Post() {

    }

    public Post(int id, String pname) {

        this.id = id;
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
