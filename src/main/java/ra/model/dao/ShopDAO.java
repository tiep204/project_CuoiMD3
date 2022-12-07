package ra.model.dao;

import ra.model.entity.Catalog;

import java.util.List;

public interface ShopDAO<T,V> {
    List<T> findAll();
    Catalog findById(V id);
    boolean create(T t);
    boolean update(T t);
}
