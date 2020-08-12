package com.ssh.dao;

import com.ssh.domain.Product;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 商品管理的Dao类
 */
public class ProductDao extends HibernateDaoSupport {
    /**
     * Dao中保存商品的方法
     * @param product
     */
    public void save(Product product) {
        System.out.println("DAO中的save方法执行了");
        this.getHibernateTemplate().save(product);
    }
}
