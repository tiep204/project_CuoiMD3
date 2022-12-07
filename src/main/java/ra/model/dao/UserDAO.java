package ra.model.dao;


import ra.model.entity.User;

import java.util.List;

public interface UserDAO<T,V> extends UserShopDAO<T,V> {
    Boolean register(User user);
    boolean updateUserlock(int id);
    boolean updateUserUnlock(int id);
    List<T> searchByName(String name);
    User login(String userName, String password);
}
