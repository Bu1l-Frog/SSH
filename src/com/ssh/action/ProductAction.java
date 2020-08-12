package com.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.domain.Product;
import com.ssh.service.ProductService;

/**
 * 商品管理的action类
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product> {
    private Product product = new Product();
    private ProductService productService;

    // 模型驱动使用的类
    @Override
    public Product getModel() {
        return product;
    }

    // Struts和Spring整合过程中按名称自动注入的业务层类
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 保存商品的执行方法:save
     */
    public String save(){
        System.out.println("Action中的save方法执行了");
        productService.save(product);
        return NONE;
    }

}
