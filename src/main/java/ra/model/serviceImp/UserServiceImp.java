package ra.model.serviceImp;

import ra.model.dao.UserDAO;
import ra.model.daoImp.UserDAOImp;
import ra.model.entity.User;
import ra.model.service.UserAppService;
import ra.model.service.UserService;

import java.util.List;

public class UserServiceImp implements UserService<User,Integer> {
    UserDAO userDAO = new UserDAOImp();
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userDAO.findById(id);
    }

    @Override
    public boolean create(User user) {
        return userDAO.create(user);
    }

    @Override
    public boolean update(User user) {
        return userDAO.update(user);
    }


    @Override
    public boolean updateUserlock(int id) {
        return userDAO.updateUserlock(id);
    }

    @Override
    public boolean updateUserUnlock(int id) {
        return userDAO.updateUserUnlock(id);
    }

    @Override
    public List<User> searchByName(String name) {
        return userDAO.searchByName(name);
    }

    @Override
    public User login(String userName, String password) {
        return userDAO.login(userName,password);
    }


    @Override
    public Boolean register(User user) {
        return userDAO.register(user);
    }
}
