package com.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.domain.Department;
import com.ssh.domain.Employee;
import com.ssh.domain.PageBean;
import com.ssh.service.DepartmentService;
import com.ssh.service.EmployeeService;
import com.ssh.service.impl.EmployeeServiceImpl;

import java.util.List;

/**
 * 员工管理的Action类
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

    private Employee employee = new Employee();
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    /**
     * 模型驱动使用的对象
     * @return
     */
    @Override
    public Employee getModel() {
        return employee;
    }

    /**
     * 注入业务层类
     */
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * 登陆执行的方法
     * @return
     */
    public String login(){
        Employee existEmployee = employeeService.login(employee);
        if (existEmployee == null){
            this.addActionError("用户名或密码错误!");
            return INPUT;
        }else {
            ActionContext.getContext().getSession().put("existEmployee",existEmployee);
            return SUCCESS;
        }
    }

    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    // 分页查询员工执行的方法
    public String findAll(){
        PageBean<Employee> pageBean = employeeService.findbyPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    // 跳转到添加员工页面执行的方法
    public String saveUI(){
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list", list);
        return "saveUI";
    }

    // 保存员工执行的方法
    public String save(){
        employeeService.save(employee);
        return "saveSuccess";
    }

    // 编辑员工执行的方法
    public String edit(){
        employee = employeeService.findbyId(employee.getEid());
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list", list);
        return "editSuccess";
    }

    // 修改员工执行的方法
    public String update(){
        employeeService.update(employee);
        return "updateSuccess";
    }

    // 删除员工执行的方法
    public String delete(){
        employee = employeeService.findbyId(employee.getEid());
        employeeService.delete(employee);
        return "deleteSuccess";
    }
}
