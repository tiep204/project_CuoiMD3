package ra.model.service;

import ra.model.entity.User;

import java.util.List;

public interface UserService<T,V> extends UserAppService<T,V> {
    boolean updateUserlock(int id);
    boolean updateUserUnlock(int id);
    List<T> searchByName(String name);
    User login(String userName, String password);
    Boolean register(User user);
}
