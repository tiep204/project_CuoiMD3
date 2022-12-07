package ra.model.daoImp;

import ra.model.dao.CatalogDAO;
import ra.model.entity.Catalog;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAOImp implements CatalogDAO<Catalog, Integer> {


    @Override
    public boolean updateCatalogStatus(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_deletecategories(?)}");
            callSt.setInt(1,id);
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
    public List<Catalog> searchByName(String catalogName) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> listCatalog = null;
        try {
            //////////////
            conn = ConnectionDB.oprenConnection();
            //////////////////
            callSt = conn.prepareCall("{call proc_searchCatagogibyName(?)}");
            /////////////////////////////
            listCatalog = new ArrayList<>();
            callSt.setString(1,catalogName);
            ResultSet rs = callSt.executeQuery();
            //////////////////////////
            while (rs.next()) {
                Catalog pr = new Catalog();
                pr.setCatalogId(rs.getInt("categoriesId"));
                pr.setCatalogName(rs.getString("categoriesName"));
                pr.setCatalogStatus(rs.getBoolean("categoriesStatus"));
                listCatalog.add(pr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listCatalog;
    }


    @Override
    public List<Catalog> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> listCatalog = null;
        try {
            //////////////
            conn = ConnectionDB.oprenConnection();
            //////////////////
            callSt = conn.prepareCall("{call proc_getAllcategories()}");
            /////////////////////////////
            ResultSet rs = callSt.executeQuery();
            listCatalog = new ArrayList<>();
            //////////////////////////
            while (rs.next()){
                Catalog pr = new Catalog();
                pr.setCatalogId(rs.getInt("categoriesId"));
                pr.setCatalogName(rs.getString("categoriesName"));
                pr.setCatalogStatus(rs.getBoolean("categoriesStatus"));
                listCatalog.add(pr);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listCatalog;
    }

    @Override
    public Catalog findById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Catalog catalogInfo = null;
        try {
            //////////////
            conn = ConnectionDB.oprenConnection();
            //////////////////
            callSt = conn.prepareCall("{call proc_getCategoriById(?)}");
            callSt.setInt(1, id);
            /////////////////////////////
            ResultSet rs = callSt.executeQuery();
            catalogInfo = new Catalog();
            //////////////////////////
            if (rs.next()) {
                catalogInfo.setCatalogId(rs.getInt("categoriesId"));
                catalogInfo.setCatalogName(rs.getString("categoriesName"));
                catalogInfo.setCatalogStatus(rs.getBoolean("categoriesStatus"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return catalogInfo;
    }

    @Override
    public boolean create(Catalog catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_insertcategories(?)}");
            callSt.setString(1,catalog.getCatalogName());;
            ////////////////////////////////////////////////////////////
            callSt.execute();
        }catch (Exception ex){
            result = false;
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean update(Catalog catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_updatecategories(?,?,?)}");
            callSt.setInt(1, catalog.getCatalogId());
            callSt.setString(2, catalog.getCatalogName());
            callSt.setBoolean(3, catalog.isCatalogStatus());
            callSt.executeUpdate();
        } catch (Exception ex) {
            result = false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
