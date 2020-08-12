package com.ssh.dao.impl;

import com.ssh.dao.DepartmentDao;
import com.ssh.domain.Department;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

    @Override
    public int findCount() {
        String hql = "select count(*) from Department";
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
        if (list.size() > 0){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Department> findByPage(int begin, Integer currPage) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
        List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(criteria, begin, currPage);
        return list;
    }

    @Override
    public void save(Department department) {
        this.getHibernateTemplate().save(department);
    }

    @Override
    public Department findById(Integer did) {
        return this.getHibernateTemplate().get(Department.class, did);
    }

    @Override
    public void update(Department department) {
        this.getHibernateTemplate().update(department);
    }

    @Override
    public void delete(Department department) {
        this.getHibernateTemplate().delete(department);
    }

    @Override
    public List<Department> findAll() {
        return (List<Department>) this.getHibernateTemplate().find("from Department ");
    }
}
