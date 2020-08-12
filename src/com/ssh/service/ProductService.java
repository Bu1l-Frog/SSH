package com.ssh.service;

import com.ssh.dao.ProductDao;
import com.ssh.domain.Product;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品管理的业务层类
 */
@Transactional
public class ProductService {
    private ProductDao productDao;

    // 业务层注入Dao类
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    /**
     * 业务层保存商品的方法
     * @param product
     */
    public void save(Product product) {
        System.out.println("Service中的save方法执行了");
        productDao.save(product);
    }
}
