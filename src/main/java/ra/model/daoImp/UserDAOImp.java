package ra.model.daoImp;

import ra.model.dao.UserDAO;
import ra.model.entity.User;
import ra.model.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImp implements UserDAO<User, Integer> {
    @Override
    public Boolean register(User user) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_register(?,?,?)}");
            callSt.setString(1, user.getUserName());
            callSt.setString(2, user.getEmail());
            callSt.setString(3, user.getPassWork());
            callSt.executeUpdate();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);

        }
        return result;
    }

    @Override
    public boolean updateUserlock(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_DeleteUsers(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (Exception ex) {
            result = false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean updateUserUnlock(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_DeleteUsersUnlock(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (Exception ex) {
            result = false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public List<User> searchByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<User> listUser = null;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_SearchbyNameUser(?)}");
            listUser = new ArrayList<>();
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                User ur = new User();
                ur.setUserId(rs.getInt("userId"));
                ur.setUserName(rs.getString("userName"));
                ur.setEmail(rs.getString("email"));
                ur.setPassWork(rs.getString("passWork"));
                ur.setAddress(rs.getString("address"));
                ur.setPhoneNumber(rs.getString("phoneNumber"));
                ur.setUserStatus(rs.getBoolean("userStatus"));
                ur.setPermission(rs.getInt("permission"));
                listUser.add(ur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listUser;

    }

    @Override
    public User login(String userName, String password) {
        Connection conn = null;
        CallableStatement callSt = null;
        User user = null;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_login2(?,?)}");
            callSt.setString(1, userName);
            callSt.setString(2, password);
            ResultSet resultSet = callSt.executeQuery();
            user = new User();
            if (resultSet.next()) {
                user.setUserId(resultSet.getInt("userId"));
                user.setUserName(resultSet.getString("userName"));
                user.setEmail(resultSet.getString("email"));
                user.setPassWork(resultSet.getString("passWork"));
                user.setAddress(resultSet.getString("address"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
                user.setUserStatus(resultSet.getBoolean("userStatus"));
                user.setPermission(resultSet.getInt("permission"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<User> listUser = null;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_getAllUsers()}");
            ResultSet rs = callSt.executeQuery();
            listUser = new ArrayList<>();
            while (rs.next()) {
                User ur = new User();
                ur.setUserId(rs.getInt("userId"));
                ur.setUserName(rs.getString("userName"));
                ur.setEmail(rs.getString("email"));
                ur.setPassWork(rs.getString("passWork"));
                ur.setAddress(rs.getString("address"));
                ur.setPhoneNumber(rs.getString("phoneNumber"));
                ur.setUserStatus(rs.getBoolean("userStatus"));
                ur.setPermission(rs.getInt("permission"));
                listUser.add(ur);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listUser;
    }

    @Override
    public User findById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        User user = null;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_GetUsersById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            user = new User();
            if (rs.next()) {
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setPassWork(rs.getString("passWork"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setDateOfBirth(rs.getDate("dateOfBirth"));
                user.setUserStatus(rs.getBoolean("userStatus"));
                user.setPermission(rs.getInt("permission"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return user;
    }

    @Override
    public boolean create(User user) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_insertproduct(?,?,?,?,?,?,?)}");
            callSt.setString(1, user.getUserName());
            callSt.setString(2, user.getEmail());
            callSt.setString(3, user.getPassWork());
            callSt.setString(4, user.getAddress());
            callSt.setString(5, user.getPhoneNumber());
            callSt.setDate(6, user.getDateOfBirth());
            callSt.setBoolean(7, user.getUserStatus());

        } catch (SQLException ex1) {
            result = false;
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean update(User user) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_UpdateUsers(?,?,?,?,?,?,?,?)}");
            callSt.setInt(1, user.getUserId());
            callSt.setString(2, user.getUserName());
            callSt.setString(3, user.getEmail());
            callSt.setString(4, user.getPassWork());
            callSt.setString(5, user.getAddress());
            callSt.setString(6, user.getPhoneNumber());
            callSt.setDate(7, user.getDateOfBirth());
            callSt.setBoolean(8, user.getUserStatus());
        } catch (SQLException ex1) {
            result = false;
            ex1.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
