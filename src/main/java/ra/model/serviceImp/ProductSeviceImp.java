package ra.model.serviceImp;

import ra.model.dao.ProductDAO;
import ra.model.daoImp.ProductDAOImp;
import ra.model.entity.Product;
import ra.model.service.ProductService;

import java.util.List;

public class ProductSeviceImp implements ProductService<Product,Integer> {
    ProductDAO productDAO = new ProductDAOImp();
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product finById(Integer id) {
        return productDAO.finById(id);
    }

    @Override
    public boolean create(Product product) {
        return productDAO.create(product);
    }

    @Override
    public boolean update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public boolean delete(Integer id) {
        return productDAO.delete(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productDAO.searchByName(name);
    }

    @Override
    public List<Product> getProductByCategoryId(Integer id) {
        return productDAO.getProductByCategoryId(id);
    }

    @Override
    public boolean updateProductStatus(int status) {
        return productDAO.updateProductStatus(status);
    }


}
