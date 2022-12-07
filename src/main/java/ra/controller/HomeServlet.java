package ra.controller;

import ra.model.entity.Catalog;
import ra.model.entity.Product;
import ra.model.service.CatalogService;
import ra.model.service.ProductService;
import ra.model.serviceImp.CatalogServiceImp;
import ra.model.serviceImp.ProductSeviceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    private CatalogService<Catalog,Integer> catalogService = new CatalogServiceImp();
    private ProductService<Product,Integer> productService = new ProductSeviceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("Home")){
            request.setAttribute("listProduct",productService.findAll());
            request.getRequestDispatcher("views/user/index.jsp").forward(request,response);
        } else if (action.equals("Shop")) {
            request.setAttribute("listProduct",productService.findAll());
            request.setAttribute("listCatalog",catalogService.findAll());
            request.getRequestDispatcher("views/user/shop.jsp").forward(request,response);
        } else if (action.equals("Detail")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            request.setAttribute("proDetail",productService.finById(productId));
            request.getRequestDispatcher("views/user/product-details.jsp").forward(request,response);
        }else if (action.equals("product")) {
            int catId = Integer.parseInt(request.getParameter("catId"));
            List<Product> listPro = productService.getProductByCategoryId(catId);
            request.setAttribute("listProduct",listPro);
            request.setAttribute("listCatalog",catalogService.findAll());
            request.setAttribute("catId",catId);
            request.getRequestDispatcher("views/user/shop.jsp").forward(request,response);
        }else if (action.equals("Search")) {
            String name  = request.getParameter("search");
            List<Product> listPro = productService.searchByName(name);
            request.setAttribute("listProduct",listPro);
            request.getRequestDispatcher("views/user/index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
