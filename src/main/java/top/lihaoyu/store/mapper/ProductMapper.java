package top.lihaoyu.store.mapper;

import top.lihaoyu.store.entity.Product;

import java.util.List;


public interface ProductMapper {


    List<Product> queryPriorityProduct();


    List<Product> queryTheNewProduct();


    Product queryProductById(Integer id);

    List<Product> queryProductByTitle(String title);
}
