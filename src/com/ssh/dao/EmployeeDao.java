package com.ssh.dao;

import com.ssh.domain.Employee;

import java.util.List;

/**
 * 员工管理的DAO接口
 */
public interface EmployeeDao {
    Employee findByUsernameAndPassword(Employee employee);

    int findCount();

    List<Employee> findByPage(int begin, Integer currPage);

    void save(Employee employee);

    Employee findById(Integer eid);

    void update(Employee employee);

    void delete(Employee employee);
}
