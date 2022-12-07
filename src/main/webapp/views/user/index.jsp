<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
  <link rel="icon" href="<%=request.getContextPath()%>/views/img/core-img/faviconcon.png">

  <!-- Core Style CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/core-style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/style.css">

</head>

<body>
<!--carousel-->
<div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="<%=request.getContextPath()%>/views/img/bg-img/Screenshot_20221122_110233.png" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="<%=request.getContextPath()%>/views/img/bg-img/sd.png" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="<%=request.getContextPath()%>/views/img/bg-img/ff.png" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Trang trước</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Trang tiếp</span>
  </button>
</div>


<!-- Search Wrapper Area Start -->
<div class="search-wrapper section-padding-100">
  <div class="search-close">
    <i class="fa fa-close" aria-hidden="true"></i>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="search-content">
          <form action="<%=request.getContextPath()%>/HomeServlet" method="get">
            <input type="search" name="search" id="search" placeholder="Type your keyword...">
            <input type="hidden" name="action" value="Search">
            <button type="submit"><img src="<%=request.getContextPath()%>/views/img/core-img/search.png" alt=""></button>
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
      <a href="index.jsp"><img src="<%=request.getContextPath()%>/views/img/core-img/johnny.png" alt=""></a>
    </div>
    <!-- Navbar Toggler -->
    <div class="amado-navbar-toggler">
      <span></span><span></span><span></span>
    </div>
  </div>

  <!-- Header Area Start -->
  <jsp:include page="../asset/header.jsp"/>
  <!-- Header Area End -->

  <!-- Product Catagories Area Start -->
  <div class="products-catagories-area clearfix">
    <div class="amado-pro-catagory clearfix">

      <!-- Single Catagory -->
      <c:forEach items="${listProduct}" var="pro">
        <div class="single-products-catagory clearfix">
          <a href="<%=request.getContextPath()%>/HomeServlet?action=Detail&&productId=${pro.productId}">
            <img src="<%=request.getContextPath()%>/images/${pro.productImage}" alt="">
            <!-- Hover Content -->
            <div class="hover-content">
              <div class="line"></div>
              <p>${pro.price}VNĐ</p>
              <h4>${pro.productName}</h4>
            </div>
          </a>
        </div>
      </c:forEach>


    </div>
  </div>
  <!-- Product Catagories Area End -->
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
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