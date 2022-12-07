package ra.model.service;

import java.util.List;

public interface CatalogService<T,V> extends AppService<T,V> {
    boolean updateCatalogStatus(int id );
    List<T> searchByName(String catalogName);
}
