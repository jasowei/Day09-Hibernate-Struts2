package com.lanou.domain;

/**
 * Created by dllo on 17/10/20.
 */
public class Staff {
    private int id;//主键id
    private String sname;//员工姓名
    private Department department;//所属部门
    private Post post;//所属职务

    public Staff(String sname) {
        this.sname = sname;
    }

    public Staff(String sname, Department department, Post post) {

        this.sname = sname;
        this.department = department;
        this.post = post;
    }

    public Staff() {

    }

    public Staff(int id, String sname, Department department, Post post) {

        this.id = id;
        this.sname = sname;
        this.department = department;
        this.post = post;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", department=" + department +
                ", post=" + post +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
