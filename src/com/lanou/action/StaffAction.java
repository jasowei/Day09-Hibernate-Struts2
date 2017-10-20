package com.lanou.action;

import com.lanou.domain.Department;
import com.lanou.domain.Post;
import com.lanou.domain.Staff;
import com.lanou.service.DepartmentService;
import com.lanou.service.StaffService;
import com.lanou.service.impl.DepartmentServiceImpl;
import com.lanou.service.impl.StaffServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by dllo on 17/10/20.
 */
public class StaffAction extends ActionSupport {

    private String code;
    private String departid;
    private Set<Post> postList;

    //表单
    private String dept;
    private String post;
    private List<Staff> staffs;

    @Override
    public String execute() throws Exception {
        /*跳转到员工列表首页时需要进行的操作
        * 1.获取所有员工
        * 2.获取所有部门*/
        DepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> departments = departmentService.findAll();
        //将部门集合放入request对象中的属性集合中
        ServletActionContext.getRequest().getSession().setAttribute("departments",departments);
        return SUCCESS;
    }

    /**
     * 查询部门对应职务
     * @return
     */
    public String findPost(){
        System.out.println("选中的部门id"+departid);
        //通过部门id查找当前选中的部门对象
        DepartmentService departmentService = new DepartmentServiceImpl();
        Department selectDepart = departmentService.findById(Integer.parseInt(departid));

        //从部门对象中获取选中的职务集合
        postList = selectDepart.getPosts();
        System.out.println(postList);

        //将职务集合
        return SUCCESS;
    }

    /**
     * 查询员工
     * @return
     */
    public String query(){
        System.out.println(dept+"   &   "+post);
        StaffService staffService = new StaffServiceImpl();
        Map<String,Object> params = new HashMap();

        if (post.equals("-1") && dept.equals("-1")){
            staffs = staffService.findAll();
        }else if (!post.equals("-1") && !dept.equals("-1")) {
            String hql = "from Staff where 1=1 and department_id like:did and post_id like:pid";
            params.put("did", dept);
            params.put("pid", post);
            staffs = staffService.find(hql, params);
        }else if (post.equals("-1") && !dept.equals("-1")){
            String hql = "from Staff where 1=1 and department_id like:did";
            params.put("did", dept);
            staffs = staffService.find(hql, params);
        }

        System.out.println("查询员工 : "+staffs);
        return SUCCESS;
    }





    public String login(){
        String imgTest = (String) ActionContext.getContext().getApplication().get("verifyCode");
        if (code.equalsIgnoreCase(imgTest)) {
            return SUCCESS;
        }
        addActionError("验证码错误!");
        return INPUT;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Set<Post> getPostList() {
        return postList;
    }

    public void setPostList(Set<Post> postList) {
        this.postList = postList;
    }

    public String getDepartid() {
        return departid;
    }

    public void setDepartid(String departid) {
        this.departid = departid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
