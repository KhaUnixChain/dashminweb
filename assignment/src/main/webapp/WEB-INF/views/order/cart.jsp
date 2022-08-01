<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Dashmin</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="home1/assets/img/favicon.png" rel="icon">
  <link href="home1/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <link href="order/cart.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>

<body>
<section class="h-100 h-custom mt-2">
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="card card-registration card-registration-2" style="border-radius: 15px;">
        <div class="card-body p-0">
          <div class="row">
            <div class="col-lg-8">
              <div class="p-5">

                <div class="d-flex justify-content-between align-items-center mb-5">
                    <h1 class="fw-bold mb-0 text-black">Cart</h1>
                    <h6 class="mb-0 text-muted"><span class="bg-danger text-light p-2">${carts.getCount()}</span> Product
                      <a href="cart/clear" class="ml-3">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                          <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                          <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                        </svg> Delete all
                      </a>
                    </h6>
                </div>
                
                <%-- this is title --%>
                <div class="row mb-4 d-flex justify-content-between align-items-center">
                    <div class="col-md-2 col-lg-2 col-xl-2">
                      <h6 class="text-muted">Avatar</h6>
                    </div>
                    <div class="col-md-3 col-lg-3 col-xl-3">
                      <h6 class="text-muted">Title</h6>
                    </div>
                    <div class="col-md-2 col-lg-2 col-xl-2 d-flex">
                      <h6 class="text-muted">Number</h6>
                    </div>
                    <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                      <h6 class="text-muted">Price</h6>
                    </div>
                    <div class="col-md-2 col-lg-2 col-xl-2 text-center">
                      <h6 class="text-muted">Action</h6>
                    </div>
                </div>

                <%-- --------------------- --%>
                <hr class="my-4">

                  <c:forEach var="cart" items="${carts.getCarts()}">
                  <div class="row mb-4 d-flex justify-content-between align-items-center">
                      <div class="col-md-2 col-lg-2 col-xl-2">
                        <img src="home1/assets/img/portfolio/${cart.product.image}" class="img-fluid rounded-3" >
                      </div>
                      <div class="col-md-3 col-lg-3 col-xl-3">
                        <h6 class="text-muted">${cart.product.category.signal}</h6>
                        <h6 class="text-black mb-0">${cart.product.name}</h6>
                      </div>
                      <div class="col-md-2 col-lg-2 col-xl-2 d-flex">
                          <div class="btn-group">
                            <%-- + - --%>
                            <a href="cart/update?id=${cart.id}&action=minus">
                              <button type="button" class="btn btn-light">-</button>
                            </a>

                            <button type="button" name="qty" class="btn" disabled>${cart.qty}</button>

                            <a href="cart/update?id=${cart.id}&action=plus">
                              <button type="button" class="btn btn-light">+</button>
                            </a>
                          </div>

                      </div>
                      <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                          <h6 class="mb-0">$ ${cart.product.price}</h6>
                      </div>
                      <div class="col-md-2 col-lg-2 col-xl-2 text-center">
                          <a href="cart/remove?id=${cart.id}">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                              <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                              <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                            </svg>
                          </a>
                      </div>
                  </div>
                  </c:forEach>

                <hr class="my-4">
                <%-- ----------------------- --%>

              </div>
            </div>

            <%-- this is sumary --%>
            <div class="col-lg-4 bg-light">
              <div class="p-5">
                <h3 class="fw-bold text-uppercase mb-5 mt-2 p-3 bg-primary text-light text-center">SUMMARY</h3>

                <h5 class="mb-3 text-uppercase">ATM Card</h5>

                <div class="mb-4 pb-2">
                  <select class="select w-100 p-2">
                    <option value="1">Sacombank</option>
                    <option value="2">MPBank</option>
                    <option value="3">Agribank</option>
                    <option value="4">TPBank</option>
                    <option value="5">Đông Á</option>
                    <option value="6">Vietcombank</option>
                  </select>
                </div>

                <h5 class="text-uppercase mb-3">Account number</h5>

                <div class="mb-5">
                  <div class="input-group mb-3">
                    <input type="text" name="atm" id="atm" class="form-control" placeholder="* Account number ...">
                    <div class="input-group-append">
                      <button class="btn btn-dark" onclick="createHref()">Check</button>
                    </div>
                  </div>
                </div>

                <hr class="my-4">

                <div class="d-flex justify-content-between mb-5">
                  <h5 class="text-uppercase">Total price</h5>
                  <h5>$ ${carts.getAmount()}</h5>
                </div>

                <a id="btn-payment" onclick="checkPay()">
                  <button type="submit" class="col btn btn-dark">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-currency-dollar" viewBox="0 0 16 16">
                      <path d="M4 10.781c.148 1.667 1.513 2.85 3.591 3.003V15h1.043v-1.216c2.27-.179 3.678-1.438 3.678-3.3 0-1.59-.947-2.51-2.956-3.028l-.722-.187V3.467c1.122.11 1.879.714 2.07 1.616h1.47c-.166-1.6-1.54-2.748-3.54-2.875V1H7.591v1.233c-1.939.23-3.27 1.472-3.27 3.156 0 1.454.966 2.483 2.661 2.917l.61.162v4.031c-1.149-.17-1.94-.8-2.131-1.718H4zm3.391-3.836c-1.043-.263-1.6-.825-1.6-1.616 0-.944.704-1.641 1.8-1.828v3.495l-.2-.05zm1.591 1.872c1.287.323 1.852.859 1.852 1.769 0 1.097-.826 1.828-2.2 1.939V8.73l.348.086z"></path>
                    </svg>
                    Payment
                  </button>
                </a>
              </div>
            </div>
            <%----%>


          </div>
        </div>
      </div>

      <%-- this is link back index --%>
      <div class="pt-3">
        <h6 class="mb-0">
          <a href="/" class="text-body">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
            </svg> Back to shop
          </a>
        </h6>
      </div>
      <%----%>
      
    </div>
  </div>
</section>

<!-- Template Main JS File -->
<script src="home1/assets/js/main.js"></script>
</body>
</html>