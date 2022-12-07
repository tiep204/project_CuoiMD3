package ra.model.service;

import java.util.List;

public interface UserAppService<T,V> {
    List<T> findAll();
    T findById(V id);
    boolean create(T t);
    boolean update(T t);
}
