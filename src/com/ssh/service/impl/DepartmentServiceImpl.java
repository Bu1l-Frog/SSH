package com.ssh.service.impl;

import com.ssh.dao.DepartmentDao;
import com.ssh.domain.Department;
import com.ssh.domain.PageBean;
import com.ssh.service.DepartmentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public PageBean<Department> findByPage(Integer currPage) {
        PageBean<Department> pageBean = new PageBean<Department>();
        // 当前页数
        pageBean.setCurrPage(currPage);
        // 每页显示记录数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        // 总记录数
        int totalCount = departmentDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 每页显示的数据
        int begin = (currPage - 1) * pageSize;
        List<Department> list = departmentDao.findByPage(begin, currPage);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Override
    public Department findById(Integer did) {
        return departmentDao.findById(did);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public void delete(Department department) {
        departmentDao.delete(department);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
