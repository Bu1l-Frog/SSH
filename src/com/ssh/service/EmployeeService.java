package com.ssh.service;

import com.ssh.domain.Employee;
import com.ssh.domain.PageBean;

/**
 * 员工管理的业务层的接口
 */
public interface EmployeeService {
    Employee login(Employee employee);

    PageBean<Employee> findbyPage(Integer currPage);

    void save(Employee employee);

    Employee findbyId(Integer eid);

    void update(Employee employee);

    void delete(Employee employee);
}
