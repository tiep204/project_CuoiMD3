<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tiepd
  Date: 22/11/2022
  Time: 7:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Jhonny Dang- Furniture store</title>

    <!-- Favicon  -->
    <link rel="icon" href="../img/core-img/faviconcon.png">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/core-style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/style.css">

</head>

<body>
<!-- Search Wrapper Area Start -->
<div class="search-wrapper section-padding-100">
    <div class="search-close">
        <i class="fa fa-close" aria-hidden="true"></i>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="search-content">
                    <form action="#" method="get">
                        <input type="search" name="search" id="search" placeholder="Type your keyword...">
                        <button type="submit"><img src="../img/core-img/search.png" alt=""></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Search Wrapper Area End -->

<!-- ##### Main Content Wrapper Start ##### -->
<div class="main-content-wrapper d-flex clearfix">

    <!-- Mobile Nav (max width 767px)-->
    <div class="mobile-nav">
        <!-- Navbar Brand -->
        <div class="amado-navbar-brand">
            <a href="index.jsp"><img src="../img/core-img/logo.png" alt=""></a>
        </div>
        <!-- Navbar Toggler -->
        <div class="amado-navbar-toggler">
            <span></span><span></span><span></span>
        </div>
    </div>

    <!-- Header Area Start -->
    <jsp:include page="../asset/header.jsp"/>
    <!-- Header Area End -->

    <div class="cart-table-area section-padding-100">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 col-lg-8">
                    <div class="cart-title mt-50">
                        <h2>Giỏ hàng</h2>
                    </div>
                    <form action="<%=request.getContextPath()%>/CartServlet?action=update">
                        <div class="cart-table clearfix">
                            <table class="table table-responsive">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>Tên sản phẩm</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
<%--                                    <th>Amount</th>--%>
                                    <th colspan="2">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <C:forEach items="${listCart}" var="cart">

                                    <tr>
                                        <td class="cart_product_img">
                                            <a href="#"><img src="<%=request.getContextPath()%>/images/${cart.product.productImage}" alt="Product"></a>
                                        </td>
                                        <td class="cart_product_desc">
                                            <h5>${cart.product.productName}</h5>
                                        </td>
                                        <td class="price">
                                            <span>${cart.product.price}</span>
                                        </td>
                                        <td class="qty">
                                            <input type="number" class="qty-text" id="qty" step="1" min="1" max="300" name="quantity" value="${cart.quantity}">
                                        </td>
<%--                                        <td class="price">--%>
<%--                                            <span>${cart.quantity}</span>--%>
<%--                                        </td>--%>
                                        <td class="price">
                                            <input type="submit" name="action" value="Update"/>
                                            <a href="<%=request.getContextPath()%>/CartServlet?action=Delete&&productId=${cart.product.productId}">Delete</a>
                                        </td>
                                    </tr>
                                </C:forEach>


                                </tbody>
                            </table>
                        </div>
                    </form>
                </div>
                <div class="col-12 col-lg-4">
                    <div class="cart-summary">
                        <h5>Tổng số giỏ hàng</h5>
                        <ul class="summary-table">
                            <li><span>Tên đăng nhập</span> <span>${account.userName}</span></li>
                            <li><span>Giao hàng:</span> <span> miễn phí</span></li>
                            <li><span>Tổng tiền:</span> <span>${totalAmount}</span></li>
                        </ul>
                        <div class="cart-btn mt-100">
                            <a href="<%=request.getContextPath()%>/views/user/checkout.jsp" class="btn amado-btn w-100">Thanh toán</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ##### Main Content Wrapper End ##### -->

<!-- ##### Newsletter Area Start ##### -->
<section class="newsletter-area section-padding-100-0">
    <div class="container">
        <div class="row align-items-center">
            <!-- Newsletter Text -->
            <div class="col-12 col-lg-6 col-xl-7">
                <div class="newsletter-text mb-100">
                    <h2>Đăng ký để được <span>giảm giá 25%</span></h2>
                </div>
            </div>
            <!-- Newsletter Form -->
            <div class="col-12 col-lg-6 col-xl-5">
                <div class="newsletter-form mb-100">
                    <form action="<%=request.getContextPath()%>/views/user/register.jsp" method="post">
                        <input type="email" name="email" class="nl-email" placeholder="Your E-mail">
                        <input type="submit" value="Đăng ký ngay">
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- ##### Newsletter Area End ##### -->

<!-- ##### Footer Area Start ##### -->
<jsp:include page="../asset/foodter.jsp"/>
<!-- ##### Footer Area End ##### -->

<!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
<script src="<%=request.getContextPath()%>/views/js/jquery/jquery-2.2.4.min.js"></script>
<!-- Popper js -->
<script src="<%=request.getContextPath()%>/views/js/popper.min.js"></script>
<!-- Bootstrap js -->
<script src="<%=request.getContextPath()%>/views/js/bootstrap.min.js"></script>
<!-- Plugins js -->
<script src="<%=request.getContextPath()%>/views/js/plugins.js"></script>
<!-- Active js -->
<script src="<%=request.getContextPath()%>/views/js/active.js"></script>

</body>

</html>
