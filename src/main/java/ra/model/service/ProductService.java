package ra.model.service;

import java.util.List;

public interface ProductService<T,V> extends ProductAppService<T,V> {
    List<T> searchByName(String name);
    List<T> getProductByCategoryId(Integer id);
    boolean updateProductStatus(int id);

}
