<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>History order</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="home1/assets/img/favicon.png" rel="icon">
  <link href="home1/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="order/history.css" rel="stylesheet">
  <link href="home1/assets/css/style.css" rel="stylesheet">
  <link href="home1/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="home1/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container-fluid p-4 bg-light">
        <c:forEach var="item" items="${invoicesDetails}">
            <div class="row pt-2 pb-3" style="background: white;margin: 30px 20%">
                <span class="text-start col-lg-12" style="font-weight:500;color:rgb(128, 128, 137)">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-truck mr-1" viewBox="0 0 16 16">
                        <path d="M0 3.5A1.5 1.5 0 0 1 1.5 2h9A1.5 1.5 0 0 1 12 3.5V5h1.02a1.5 1.5 0 0 1 1.17.563l1.481 1.85a1.5 1.5 0 0 1 .329.938V10.5a1.5 1.5 0 0 1-1.5 1.5H14a2 2 0 1 1-4 0H5a2 2 0 1 1-3.998-.085A1.5 1.5 0 0 1 0 10.5v-7zm1.294 7.456A1.999 1.999 0 0 1 4.732 11h5.536a2.01 2.01 0 0 1 .732-.732V3.5a.5.5 0 0 0-.5-.5h-9a.5.5 0 0 0-.5.5v7a.5.5 0 0 0 .294.456zM12 10a2 2 0 0 1 1.732 1h.768a.5.5 0 0 0 .5-.5V8.35a.5.5 0 0 0-.11-.312l-1.48-1.85A.5.5 0 0 0 13.02 6H12v4zm-9 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm9 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
                    </svg> ${!item.invoice.status?"Đã Hủy":"Đã bàn giao hàng"}
                    <hr>
                </span>
                <div class="col-lg-12">
                    <div class="d-flex justify-content-between">
                        <div>
                            <img style="float:left;margin-right:10px" src="home1/assets/img/portfolio/${item.product.image}" width="100">
                            <span>
                                ${item.product.name}
                                <p>
                                    <strong>
                                        <span>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-sort-numeric-down" viewBox="0 0 16 16">
                                                <path d="M12.438 1.668V7H11.39V2.684h-.051l-1.211.859v-.969l1.262-.906h1.046z"/>
                                                <path fill-rule="evenodd" d="M11.36 14.098c-1.137 0-1.708-.657-1.762-1.278h1.004c.058.223.343.45.773.45.824 0 1.164-.829 1.133-1.856h-.059c-.148.39-.57.742-1.261.742-.91 0-1.72-.613-1.72-1.758 0-1.148.848-1.835 1.973-1.835 1.09 0 2.063.636 2.063 2.687 0 1.867-.723 2.848-2.145 2.848zm.062-2.735c.504 0 .933-.336.933-.972 0-.633-.398-1.008-.94-1.008-.52 0-.927.375-.927 1 0 .64.418.98.934.98z"/>
                                                <path d="M4.5 2.5a.5.5 0 0 0-1 0v9.793l-1.146-1.147a.5.5 0 0 0-.708.708l2 1.999.007.007a.497.497 0 0 0 .7-.006l2-2a.5.5 0 0 0-.707-.708L4.5 12.293V2.5z"/>
                                            </svg>
                                        </span>
                                        ${item.invoice.purchaseDate}
                                    </strong>
                                </p>
                            <span>
                        </div>
                        <div>
                            <p style="background: red;color:white" class="p-2">Số lượng: ${item.quantity}</p>
                        </div>
                    </div>
                    <hr>
                    <div class="text-right" style="font-size:20px">
                        Tổng tiền : $ ${item.invoice.amount}
                    </div>
                    <div class="text-right pt-2" style="font-size:20px">
                        <button type="button" class="btn btn-outline-primary">Mua lại</button>
                        <button type="button" class="btn btn-outline-secondary">Chi tiết</button>
                    </div>
                </div>
            </div>
        </c:forEach>

            <%-- this is link back index --%>
            <div class="row pt-2 pb-3 text-center" style="margin: 30px 20%">
                <h6 class="mb-0">
                    <a href="/" class="text-body">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
                        </svg> Back to shop
                    </a>
                </h6>
            </div>
            <%----%>

        <%-- <jsp:include page=""> --%>
        <footer id="footer">
            <div class="container bg-white w-100 p-3">
                <h3>Brandon Johnson</h3>
                <p>Et aut eum quis fuga eos sunt ipsa nihil. Labore corporis magni eligendi fuga maxime saepe commodi placeat.</p>
                <div class="social-links">
                    <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
                    <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
                    <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
                    <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
                    <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
                </div>
                <div class="copyright">
                    &copy; Copyright <strong><span>MyResume</span></strong>. All Rights Reserved
                </div>
                <div class="credits">
                    <!-- All the links in the footer should remain intact. -->
                    <!-- You can delete the links only if you purchased the pro version. -->
                    <!-- Licensing information: [license-url] -->
                    <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/free-html-bootstrap-template-my-resume/ -->
                    Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                </div>
            </div>
        </footer>
    </div>
</body>
</html>