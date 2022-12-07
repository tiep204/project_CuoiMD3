<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tiepd
  Date: 22/11/2022
  Time: 4:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header class="header-area clearfix scroll" >
    <!-- Close Icon -->
    <div class="nav-close">
        <i class="fa fa-close" aria-hidden="true"></i>
    </div>
    <!-- Logo -->
    <div class="logo">
        <a href="#"><img src="<%=request.getContextPath()%>/views/img/core-img/johnny.png" alt=""></a>
    </div>
    <!-- Amado Nav -->
    <nav class="amado-nav"  >
        <ul>
            <li class=""><a href="<%=request.getContextPath()%>/HomeServlet?action=Home">Trang chủ</a></li>
            <li><a href="<%=request.getContextPath()%>/HomeServlet?action=Shop">Cửa hàng</a></li>
<%--            <li><a href="<%=request.getContextPath()%>/HomeServlet?action=Product-detail">Sản phẩm</a></li>--%>
            <!-- <li><a href="cart.html">chi tiết</a></li> -->
            <!-- <li><a href="checkout.html">Checkout</a></li> -->
        </ul>
    </nav>
    <!-- Button Group -->
<%--    <div class="amado-btn-group mt-30 mb-100">--%>
<%--        <a href="#" class="btn amado-btn mb-15">%Discount%</a>--%>
<%--        <a href="#" class="btn amado-btn active">New this week</a>--%>
<%--    </div>--%>
    <!-- Cart Menu -->
    <div class="cart-fav-search mb-100" >
<%--        <c:forEach items="${listProduct}" var="pro">--%>
<%--            <a href="<%=request.getContextPath()%>/views/user/cart.jsp" class="cart-nav"><img src="<%=request.getContextPath()%>/views/img/core-img/cart.png" alt=""> Giỏ hàng <span>(${pro.quantity})</span></a>--%>
<%--        </c:forEach>--%>
    <a href="<%=request.getContextPath()%>/views/user/cart.jsp" class="cart-nav"><img src="<%=request.getContextPath()%>/views/img/core-img/cart.png" alt=""> Giỏ hàng <span>(${qtt})</span></a>

    <a href="<%=request.getContextPath()%>/views/user/favourite.jsp" class="fav-nav"><img src="<%=request.getContextPath()%>/views/img/core-img/favorites.png" alt=""> Yêu thích</a>
        <a href="#" class="search-nav"><img src="<%=request.getContextPath()%>/views/img/core-img/search.png" alt=""> Tìm kiếm</a>
        <c:choose>
            <c:when test="${empty account}">
                <a href="<%=request.getContextPath()%>/views/user/login2.jsp">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3Zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z"/>
                    </svg></i> Đăng Nhập</a>
            </c:when>
            <c:otherwise>
                <a href="<%=request.getContextPath()%>/UserServlet?action=logOut" class="logout-nav"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                    <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                </svg>Log Out</a>
            </c:otherwise>
        </c:choose>


    </div>
    <!-- Social Button -->
    <div class="social-info d-flex justify-content-between">
        <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
        <a href="https://www.instagram.com/dt.tiep/"><i class="fa fa-instagram" aria-hidden="true"></i></a>
        <a href="https://www.facebook.com/tiep204nekguys/"><i class="fa fa-facebook" aria-hidden="true"></i></a>
        <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
    </div>
</header>
<!-- Search Wrapper Area Start -->
