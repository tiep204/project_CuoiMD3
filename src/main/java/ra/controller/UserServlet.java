package ra.controller;

import ra.model.entity.Catalog;
import ra.model.entity.User;
import ra.model.service.CatalogService;
import ra.model.service.ProductService;
import ra.model.service.UserService;
import ra.model.serviceImp.CatalogServiceImp;
import ra.model.serviceImp.ProductSeviceImp;
import ra.model.serviceImp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImp();
    private ProductService productServiceImp = new ProductSeviceImp();
    private CatalogService<Catalog,Integer> catalogService = new CatalogServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equalsIgnoreCase("GetAll")) {
            getAllUser(request, response);
        } else if (action != null && action.equalsIgnoreCase("lock")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            boolean reuslt = userService.updateUserlock(userId);
            if(reuslt){
                getAllUser(request,response);
            }else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request,response);
            }
        } else if (action != null &&action.equalsIgnoreCase("unLock")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            boolean reuslt = userService.updateUserUnlock(userId);
            if(reuslt){
                getAllUser(request,response);
            }else {
                request.getRequestDispatcher("views/admin/error.jsp").forward(request,response);
            }
        } else if (action != null && action.equalsIgnoreCase("Search")) {
            String uName = request.getParameter("searchName");
            request.setAttribute("listUser", userService.searchByName(uName));
            request.getRequestDispatcher("views/admin/user.jsp").forward(request, response);
        } else if (action != null && action.equalsIgnoreCase("logOut")) {
            HttpSession session = request.getSession();
            session.removeAttribute("account");
            request.setAttribute("listProduct",productServiceImp.findAll());
            List<Catalog> listCatalog = catalogService.findAll();
            request.setAttribute("listCatalog",listCatalog);
            request.getRequestDispatcher("views/user/index.jsp").forward(request,response);
        }
    }


    public void getAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userService.findAll();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("views/admin/user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action.equals("login")){
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            User user = userService.login(userName,password);
            if(user!=null){
                HttpSession session = request.getSession();
                session.setAttribute("userLogin",user);
                if (user.getUserName()==null){
                    request.setAttribute("mess", "Tài khoản hoặc mật khẩu của bạn không chính xác");
                    request.getRequestDispatcher("views/user/login2.jsp").forward(request, response);
                }
                if(user.getPermission()==1){
                    request.getRequestDispatcher("views/admin/index.jsp").forward(request,response);
                } else if (user.getUserStatus()==false) {
                    request.setAttribute("mess", "Tài khoản của bạn đã bị khóa!  vui lòng liên hệ với admin");
                    request.getRequestDispatcher("views/user/login2.jsp").forward(request, response);
                } else {
                    session.setAttribute("account",user);
                    request.setAttribute("listProduct",productServiceImp.findAll());
                    List<Catalog> listCatalog = catalogService.findAll();
                    request.setAttribute("listCatalog",listCatalog);
                    request.getRequestDispatcher("views/user/index.jsp").forward(request,response);
                }
            } else if (user.getUserName()==null) {
                request.setAttribute("mess", "Tài khoản hoặc mật khẩu của bạn không chính xác");
                request.getRequestDispatcher("views/user/login2.jsp").forward(request, response);
            }else {
                request.setAttribute("miss", "Tài khoản hoặc mật khẩu của bạn không chính xác");
                request.getRequestDispatcher("views/user/login2.jsp").forward(request, response);
            }

        } else if (action.equals("register")) {
            User userNew = new User();
            userNew.setUserName(request.getParameter("userName"));
            userNew.setEmail(request.getParameter("email"));
            userNew.setPassWork( request.getParameter("passWord"));
            String confirm = request.getParameter("confirm");
            if(userNew.getPassWork().equals(confirm)){
                boolean result = userService.register(userNew);
                if (result){
                    request.getRequestDispatcher("views/user/login2.jsp").forward(request,response);
                }else {
                    request.getRequestDispatcher("views/admin/error.jsp").forward(request,response);
                }
            }
        }
    }
}

