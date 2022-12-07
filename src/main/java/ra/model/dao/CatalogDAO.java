package ra.model.dao;

import ra.model.entity.Catalog;

import java.util.List;

public interface CatalogDAO<T,V> extends ShopDAO<T,V> {
    boolean updateCatalogStatus(int status);
    List<T> searchByName(String catalogName);
}
