package ra.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ra.model.entity.Catalog;
import ra.model.service.CatalogService;
import ra.model.serviceImp.CatalogServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CatalogServlet", value = "/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    private CatalogService<Catalog, Integer> catalogService = new CatalogServiceImp();
    private static final Gson GSON = new GsonBuilder().create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("Delete")) {
            int catalogId = Integer.parseInt(request.getParameter("catalogId"));
            boolean result = catalogService.updateCatalogStatus(catalogId);
            if (result) {
                getAllCatalog(request, response);
            }
        } else if (action!=null&&action.equalsIgnoreCase("Search")) {
            String prName = request.getParameter("searchName");
            request.setAttribute("listCatalog" , catalogService.searchByName(prName));
            request.getRequestDispatcher("views/admin/catagory.jsp").forward(request,response);
        } else if (action != null && action.equalsIgnoreCase("update")) {
            String catalogId = request.getParameter("catalogId");
            Catalog catalogUpdate = catalogService.findById(Integer.parseInt(catalogId));
            request.setAttribute("catalogUpdate", catalogUpdate);
            request.getRequestDispatcher("views/admin/updatecatalog.jsp").forward(request, response);
        } else {
            getAllCatalog(request, response);
        }
    }




    public void getAllCatalog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Catalog> listCatalog = catalogService.findAll();
        request.setAttribute("listCatalog", listCatalog);
        request.getRequestDispatcher("views/admin/catagory.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            Catalog catalog = new Catalog();
            catalog.setCatalogName(request.getParameter("catalogName"));
            catalog.setCatalogStatus(Boolean.parseBoolean(request.getParameter("catalogStatus")));
            boolean result = catalogService.create(catalog);
            if (result) {
                getAllCatalog(request, response);
            }
        } else if (action != null && action.equalsIgnoreCase("Update")) {
            Catalog catInfo = new Catalog();
            catInfo.setCatalogId(Integer.parseInt(request.getParameter("catalogId")));
            catInfo.setCatalogName(request.getParameter("catalogName"));
            catInfo.setCatalogStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = catalogService.update(catInfo);
            if (result) {
                getAllCatalog(request, response);
            }
        }else {
            request.getRequestDispatcher("views/admin/error.jsp").forward(request, response);
        }
    }
}

