package ra.model.service;

import ra.model.entity.Product;

import java.util.List;

public interface ProductAppService<T,V> {
    List<T> findAll();
    Product finById(V id);
    boolean create(T t);
    boolean update(T t);
    boolean delete(V id);
}
