package ra.controller;

import ra.model.entity.Catalog;
import ra.model.entity.Product;
import ra.model.service.CatalogService;
import ra.model.service.ProductService;
import ra.model.serviceImp.CatalogServiceImp;
import ra.model.serviceImp.ProductSeviceImp;
import ra.model.util.ConnectionDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10
)
public class ProductServlet extends HttpServlet {
    private static ProductService productService = new ProductSeviceImp();
    private static CatalogService catalogService = new CatalogServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("GetAll")) {
            getAllProduct(request, response);
        } else if (action != null && action.equalsIgnoreCase("Delete")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            boolean reuslt = productService.updateProductStatus(productId);
            if(reuslt){
                getAllProduct(request,response);
            }else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request,response);
            }
        } else if (action!=null&&action.equalsIgnoreCase("Search")) {
            String prName = request.getParameter("searchName");
            request.setAttribute("listPro" , productService.searchByName(prName));
            request.getRequestDispatcher("views/admin/product.jsp").forward(request,response);
        } else if (action.equals("newProduct")) {
                List<Catalog> listCatalog = catalogService.findAll();
                request.setAttribute("listCatalog",listCatalog);
                request.getRequestDispatcher("views/admin/newProduct.jsp").forward(request,response);
        } else if (action.equalsIgnoreCase("finById")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            Product pro =productService.finById(productId);
            request.setAttribute("pro",pro);
            request.getRequestDispatcher("views/admin/productDetail.jsp").forward(request,response);
        }else if (action.equalsIgnoreCase("update")) {
            List<Catalog> listCatalog = catalogService.findAll();
            request.setAttribute("listCatalog",listCatalog);
            int productId = Integer.parseInt(request.getParameter("productId"));
            Product productUpdate = productService.finById(productId);
            request.setAttribute("productUpdate", productUpdate);
            request.getRequestDispatcher("views/admin/updateProduct.jsp").forward(request, response);
        }
    }
    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listPro = productService.findAll();
        request.setAttribute("listPro", listPro);
        request.getRequestDispatcher("views/admin/product.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("Create")) {
            Product proNew = new Product();
            proNew.setProductName(request.getParameter("productName"));
            proNew.setPrice(Float.parseFloat(request.getParameter("price")));
            proNew.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            proNew.setTitle(request.getParameter("title"));
            proNew.setCatalogId(Integer.parseInt(request.getParameter("catalog")));
            String pathFolderImage = "D:/BAIHOC/MD-3/Project-MD3/projectMd3/src/main/webapp/images";
            File file = new File(pathFolderImage);
            if (!file.exists()) {
                file.mkdir();
            }
            for (Part part : request.getParts()) {
                if (part.getName().equals("productImage")) {
                    proNew.setProductImage(part.getSubmittedFileName());
                    part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
                } else if (part.getName().equals("subImage")) {
                    proNew.getListImage().add(part.getSubmittedFileName());
                    part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
                }
            }
            proNew.setProductStatus(Boolean.parseBoolean(request.getParameter("productStatus")));
            proNew.setDescriptions(request.getParameter("descriptions"));
            Boolean result = productService.create(proNew);
            if(result){
                getAllProduct(request,response);

            }else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request, response);
            }
        } else if (action!=null&&action.equalsIgnoreCase("Update")) {
            Product produc = new Product();
            produc.setProductId(Integer.parseInt(request.getParameter("productId")));
            produc.setProductName(request.getParameter("productName"));
            produc.setPrice(Float.parseFloat(request.getParameter("price")));
            produc.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            produc.setTitle(request.getParameter("title"));
            produc.setProductImage(request.getParameter("productImageOld"));
            produc.setProductStatus(Boolean.parseBoolean(request.getParameter("status")));
            produc.setCatalogId(Integer.parseInt(request.getParameter("catalog")));
            produc.setDescriptions(request.getParameter("descriptions"));
            String pathFolderImage = "D:/BAIHOC/MD-3/Project-MD3/projectMd3/src/main/webapp/images";
            for (Part part : request.getParts()) {
                if (part.getName().equals("productImage")) {
                    produc.setProductImage(part.getSubmittedFileName());
                    part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
                } else if (part.getName().equals("subImage")) {
                    produc.getListImage().add(part.getSubmittedFileName());
                    part.write(pathFolderImage + File.separator + part.getSubmittedFileName());
                }
            }
            boolean result = productService.update(produc);
            if(result){
                getAllProduct(request,response);
            } else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request,response);

            }
        }

    }
}
