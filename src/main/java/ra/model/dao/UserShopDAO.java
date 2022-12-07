package ra.model.dao;

import ra.model.entity.User;

import java.util.List;

public interface UserShopDAO<T,V> {
    List<T> findAll();
    User findById(V id);
    boolean create(T t);
    boolean update(T t);
}
