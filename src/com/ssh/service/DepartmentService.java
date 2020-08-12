package com.ssh.service;

import com.ssh.domain.Department;
import com.ssh.domain.PageBean;

import java.util.List;

public interface DepartmentService {
    PageBean<Department> findByPage(Integer currPage);

    void save(Department department);

    Department findById(Integer did);

    void update(Department department);

    void delete(Department department);

    List<Department> findAll();
}
