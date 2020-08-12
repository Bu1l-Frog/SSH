package com.ssh.service.impl;

import com.ssh.dao.impl.EmployeeDaoImpl;
import com.ssh.domain.Employee;
import com.ssh.domain.PageBean;
import com.ssh.service.EmployeeService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 员工管理的业务层实现类
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDaoImpl employeeDao;

    public void setEmployeeDao(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee login(Employee employee) {
        Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
        return existEmployee;
    }

    @Override
    public PageBean<Employee> findbyPage(Integer currPage) {
        PageBean<Employee> pageBean = new PageBean<Employee>();
        // 当前页数
        pageBean.setCurrPage(currPage);
        // 每页显示记录数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        // 总记录数
        int totalCount = employeeDao.findCount();
        pageBean.setTotalCount(totalCount);
        // 总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 每页显示的数据
        int begin = (currPage - 1) * pageSize;
        List<Employee> list = employeeDao.findByPage(begin, currPage);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public Employee findbyId(Integer eid) {
        return employeeDao.findById(eid);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeDao.delete(employee);
    }
}
