package ra.model.serviceImp;

import ra.model.dao.CatalogDAO;
import ra.model.daoImp.CatalogDAOImp;
import ra.model.entity.Catalog;
import ra.model.service.CatalogService;

import java.util.List;

public class CatalogServiceImp implements CatalogService<Catalog,Integer> {
    CatalogDAO catalogDAO = new CatalogDAOImp();


    @Override
    public List<Catalog> findAll() {
        return catalogDAO.findAll();
    }

    @Override
    public Catalog findById(Integer id) {
        return catalogDAO.findById(id);
    }

    @Override
    public boolean create(Catalog catalog) {
        return catalogDAO.create(catalog);
    }

    @Override
    public boolean update(Catalog catalog) {
        return catalogDAO.update(catalog);
    }

    @Override
    public boolean updateCatalogStatus(int status) {
        return catalogDAO.updateCatalogStatus(status);
    }

    @Override
    public List<Catalog> searchByName(String catalogName) {
        return catalogDAO.searchByName(catalogName);
    }
}
