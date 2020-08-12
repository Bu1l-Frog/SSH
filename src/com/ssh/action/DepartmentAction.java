package com.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.domain.Department;
import com.ssh.domain.PageBean;
import com.ssh.service.DepartmentService;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

    private Department department = new Department();
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public Department getModel() {
        return department;
    }

    private Integer currPage = 1;

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public String findAll(){
        PageBean<Department> pageBean = departmentService.findByPage(currPage);
        // 将pageBean存入到值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "fildAll";
    }

    // 跳转到添加部门页面
    public String saveUI(){
        return "saveUI";
    }

    // 添加部门的执行方法
    public String save(){
        departmentService.save(department);
        return "saveSuccess";
    }

    // 编辑部门的执行方法
    public String edit(){
        department = departmentService.findById(department.getDid());
        return "editSuccess";
    }

    // 修改部门的执行方法
    public String update(){
        departmentService.update(department);
        return "updateSuccess";
    }

    // 删除部门执行的方法
    public String delete(){
        department = departmentService.findById(department.getDid());
        departmentService.delete(department);
        return "deleteSuccess";
    }

}
