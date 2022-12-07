package ra.model.daoImp;

import ra.model.dao.ProductDAO;
import ra.model.entity.Catalog;
import ra.model.entity.Product;
import ra.model.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements ProductDAO<Product,Integer> {

    @Override
    public List<Product> searchByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct = null;
        try {
            //////////////
            conn = ConnectionDB.oprenConnection();
            //////////////////
            callSt = conn.prepareCall("{call proc_searchProductbyName(?)}");
            /////////////////////////////
            listProduct = new ArrayList<>();
            callSt.setString(1,name);
            ResultSet rs = callSt.executeQuery();
            //////////////////////////
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductId(rs.getInt("productId"));
                pro.setProductName(rs.getString("productName"));
                pro.setPrice(rs.getFloat("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setTitle(rs.getString("title"));
                pro.setProductImage(rs.getString("productImage"));
                pro.setProductStatus(rs.getBoolean("productStatus"));
                pro.setCatalogId(rs.getInt("categoriesId"));
                pro.setDescriptions(rs.getString("descriptions"));
                listProduct.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProduct;
    }

    @Override
    public List<Product> getProductByCategoryId(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct = null;
        try {
            //////////////
            conn = ConnectionDB.oprenConnection();
            //////////////////
            callSt = conn.prepareCall("{call proc_getProductByCatalogId(?)}");
            /////////////////////////////
            listProduct = new ArrayList<>();
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            //////////////////////////
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductId(rs.getInt("productId"));
                pro.setProductName(rs.getString("productName"));
                pro.setPrice(rs.getFloat("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setTitle(rs.getString("title"));
                pro.setProductImage(rs.getString("productImage"));
                pro.setProductStatus(rs.getBoolean("productStatus"));
                pro.setCatalogId(rs.getInt("categoriesId"));
                pro.setDescriptions(rs.getString("descriptions"));
                listProduct.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProduct;
    }

    @Override
    public boolean updateProductStatus(int id) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_deleteproduct(?)}");
            callSt.setInt(1,id);
            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }


    @Override
    public List<Product> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listPro = null;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_getAllproduct()}");
            ResultSet rs = callSt.executeQuery();
            listPro = new ArrayList<>();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductId(rs.getInt("productId"));
                pro.setProductName(rs.getString("productName"));
                pro.setPrice(rs.getFloat("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setTitle(rs.getString("title"));
                pro.setProductImage(rs.getString("productImage"));
                pro.setProductStatus(rs.getBoolean("productStatus"));
                pro.setCatalogId(rs.getInt("categoriesId"));
                pro.setDescriptions(rs.getString("descriptions"));
                listPro.add(pro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listPro;
    }

    @Override
    public Product finById(Integer id) {
        Product pr = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_getproductById(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            pr = new Product();
            if(rs.next()){
                pr.setProductId(rs.getInt("productId"));
                pr.setProductName(rs.getString("productName"));
                pr.setPrice(rs.getFloat("price"));
                pr.setQuantity(rs.getInt("quantity"));
                pr.setTitle(rs.getString("title"));
                pr.setProductImage(rs.getString("productImage"));
                pr.setProductStatus(rs.getBoolean("productStatus"));
                pr.setCatalogId(rs.getInt("categoriesId"));
                pr.setDescriptions(rs.getString("descriptions"));
            }
            CallableStatement callSt2 = conn.prepareCall("{call proc_getimageById(?)}");
                callSt2.setInt(1,id);
                ResultSet rs2 = callSt2.executeQuery();
                while (rs2.next()){
                    pr.getListImage().add(rs2.getString("imageURL"));
                }
                callSt2.close();

        }catch (SQLException ex1){
                ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return pr;
    }
    @Override
    public boolean create(Product product) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_insertproduct(?,?,?,?,?,?,?,?)}");
                callSt.setString(1, product.getProductName());
                callSt.setFloat(2, product.getPrice());
                callSt.setInt(3, product.getQuantity());
                callSt.setString(4, product.getTitle());
                callSt.setString(5, product.getProductImage());
                callSt.setInt(6, product.getCatalogId());
                callSt.setString(7, product.getDescriptions());
                callSt.registerOutParameter(8, Types.INTEGER);
                callSt.execute();

                int productId = callSt.getInt(8);
                for (String imgLink : product.getListImage()) {
                    CallableStatement callSt2 = conn.prepareCall("{call proc_insertimage(?,?)}");
                    callSt2.setString(1, imgLink);
                    callSt2.setInt(2, productId);
                    callSt2.executeUpdate();
                    callSt2.close();
                }
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean update(Product product) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_updateProduct(?,?,?,?,?,?,?,?,?)}");
            callSt.setInt(1,product.getProductId());
            callSt.setString(2,product.getProductName());
            callSt.setFloat(3,product.getPrice());
            callSt.setInt(4,product.getQuantity());
            callSt.setString(5,product.getTitle());
            callSt.setString(6,product.getProductImage());
            callSt.setBoolean(7,product.isProductStatus());
            callSt.setInt(8,product.getCatalogId());
            callSt.setString(9,product.getDescriptions());
            CallableStatement callableStatement = conn.prepareCall("{call proc_deleteimage(?)}");
            callableStatement.setInt(1,product.getProductId());
            callableStatement.executeUpdate();
            callableStatement.close();

            for (String imgLink : product.getListImage()) {
                CallableStatement callSt2 = conn.prepareCall("{call proc_insertimage(?,?)}");
                callSt2.setString(1, imgLink);
                callSt2.setInt(2,product.getProductId() );
                callSt2.executeUpdate();
                callSt2.close();
            }

            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.oprenConnection();
            callSt = conn.prepareCall("{call proc_deleteproduct(?)}");
            callSt.setInt(1,id);
            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }
}
