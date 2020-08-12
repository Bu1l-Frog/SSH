package com.ssh.dao;

import com.ssh.domain.Department;

import java.util.List;

public interface DepartmentDao {
    int findCount();

    List<Department> findByPage(int begin, Integer currPage);

    void save(Department department);

    Department findById(Integer did);

    void update(Department department);

    void delete(Department department);

    List<Department> findAll();
}
