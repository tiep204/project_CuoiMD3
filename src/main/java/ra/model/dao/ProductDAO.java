package ra.model.dao;

import java.util.List;

public interface ProductDAO<T,V> extends ProductShopDAO<T,V> {
    List<T> searchByName(String name);
    List<T> getProductByCategoryId(Integer id);
    boolean updateProductStatus(int id);


}
