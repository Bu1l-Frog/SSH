package com.ssh.dao.impl;

import com.ssh.dao.EmployeeDao;
import com.ssh.domain.Employee;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 员工管理的DAO实现类
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
    @Override
    public Employee findByUsernameAndPassword(Employee employee) {
        String hql = "from Employee where username = ? and password = ?";
        List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
        if (list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public int findCount() {
        String hql = "select count(*) from Employee";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
        if (list.size() > 0){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Employee> findByPage(int begin, Integer currPage) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
        List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, begin, currPage);
        return list;
    }

    @Override
    public void save(Employee employee) {
        this.getHibernateTemplate().save(employee);
    }

    @Override
    public Employee findById(Integer eid) {
        return this.getHibernateTemplate().get(Employee.class, eid);
    }

    @Override
    public void update(Employee employee) {
        this.getHibernateTemplate().update(employee);
    }

    @Override
    public void delete(Employee employee) {
        this.getHibernateTemplate().delete(employee);
    }
}
