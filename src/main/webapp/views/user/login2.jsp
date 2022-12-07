<%--
  Created by IntelliJ IDEA.
  User: tiepd
  Date: 22/11/2022
  Time: 7:16 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đăng nhập</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/login2.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="login-box">
  <h2>Đăng nhập</h2>
  <form action="<%=request.getContextPath()%>/UserServlet?action=login" method="post" id="loginForm">
    <div class="user-box">

      <input type="text" name="userName" required>
      <label>Tên đăng nhập</label>
    </div>
    <div class="user-box">
      <input type="password" name="password" required>
      <label>Mật khẩu</label>
    </div>
    <div style="color:red;">
      ${miss}
      ${mess}
    </div>

      <a  href="#" onclick="document.getElementById('loginForm').submit()">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        Đăng nhập
      </a>

    <a href="register.jsp" style="margin-left: 50px;">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      Đăng ký
    </a>
  </form>
  <a href="index.jsp" style="margin-left: 140px;"><i class="bi bi-arrow-left-circle"></i><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-circle" viewBox="0 0 16 16">
    <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
  </svg></a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>


