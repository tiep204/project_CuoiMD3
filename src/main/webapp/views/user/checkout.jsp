<%--
  Created by IntelliJ IDEA.
  User: tiepd
  Date: 22/11/2022
  Time: 7:18 CH
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
    <title>Jhonny Dang furniture store</title>

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
            <a href="index.jsp"><img src="../img/core-img/johnny.png" alt=""></a>
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
                    <div class="checkout_details_area mt-50 clearfix">

                        <div class="cart-title">
                            <h2>Thanh toán</h2>
                        </div>

                        <form action="#" method="post">
                            <div class="row">
<%--                                <div class="col-md-6 mb-3">--%>
<%--                                    <input type="text" class="form-control" id="first_name" value="" placeholder="First Name" required>--%>
<%--                                </div>--%>
<%--                                <div class="col-md-6 mb-3">--%>
<%--                                    <input type="text" class="form-control" id="last_name" value="" placeholder="Last Name" required>--%>
<%--                                </div>--%>
                                <div class="col-12 mb-3">

                                    <input type="text" class="form-control" id="company"  placeholder="Company Name" value="${account.userName}">
                                </div>
                                <div class="col-12 mb-3">
                                    <input type="email" class="form-control" id="email" placeholder="Email" value="${account.email}">
                                </div>
<%--                                <div class="col-12 mb-3">--%>
<%--                                    <select class="w-100" id="country">--%>
<%--                                        <option value="usa">United States</option>--%>
<%--                                        <option value="uk">United Kingdom</option>--%>
<%--                                        <option value="ger">Germany</option>--%>
<%--                                        <option value="fra">France</option>--%>
<%--                                        <option value="ind">India</option>--%>
<%--                                        <option value="aus">Australia</option>--%>
<%--                                        <option value="bra">Brazil</option>--%>
<%--                                        <option value="cana">Canada</option>--%>
<%--                                    </select>--%>
<%--                                </div>--%>
                                <div class="col-12 mb-3">
                                    <input type="text" class="form-control mb-3" id="street_address" placeholder="Address" value="${account.address}">
                                </div>


                                <div class="col-md-6 mb-3">
                                    <input type="number" class="form-control" id="phone_number" min="0" placeholder="Phone No" value="${account.phoneNumber}">
                                </div>
                                <div class="col-12">
                                    <div class="custom-control custom-checkbox d-block mb-2">
                                        <input type="checkbox" class="custom-control-input" id="customCheck2">
                                        <label class="custom-control-label" for="customCheck2">Tạo tài khoản</label>
                                    </div>
                                    <div class="custom-control custom-checkbox d-block">
                                        <input type="checkbox" class="custom-control-input" id="customCheck3">
                                        <label class="custom-control-label" for="customCheck3">Gửi đến một địa chỉ khác
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-12 col-lg-4">
                    <div class="cart-summary">
                        <h5>Tổng số giỏ hàng</h5>
                        <ul class="summary-table">
                            <li><span>Phí giao hàng:</span> <span>Free</span></li>
                            <li><span>Tổng tiền:</span> <span>${totalAmount}</span></li>
                        </ul>

                        <div class="payment-method">
                            <!-- Cash on delivery -->
                            <div class="custom-control custom-checkbox mr-sm-2">
                                <input type="checkbox" class="custom-control-input" id="cod" checked>
                                <label class="custom-control-label" for="cod">Thanh toán khi giao hàng</label>
                            </div>
                            <!-- Paypal -->
                            <div class="custom-control custom-checkbox mr-sm-2">
                                <input type="checkbox" class="custom-control-input" id="paypal">
                                <label class="custom-control-label" for="paypal">Paypal <img class="ml-15" src="../img/core-img/paypal.png" alt=""></label>
                            </div>
                        </div>

                        <div class="cart-btn mt-100">
                            <a href="#" class="btn amado-btn w-100">Thanh toán</a>
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
