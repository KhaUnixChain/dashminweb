<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="row px-4">
    <%-- this is sumary report revenue --%>
    <div class="row g-4">
        <div class="col-sm-6 col-xl-3">
            <div class="bg-primary rounded d-flex align-items-center justify-content-between p-4">
                <i class="fa fa-chart-line fa-3x text-white"></i>
                <div class="ms-3">
                    <p class="mb-2 text-warning">ToYear Sale</p>
                    <h6 class="mb-0">$ ${saleToYear}</h6>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-xl-3">
            <div class="bg-primary rounded d-flex align-items-center justify-content-between p-4">
                <i class="fa fa-chart-bar fa-3x text-white"></i>
                <div class="ms-3">
                    <p class="mb-2 text-warning">ToYear Orders</p>
                    <h6 class="mb-0">${invoices}</h6>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-xl-3">
            <div class="bg-primary rounded d-flex align-items-center justify-content-between p-4">
                <i class="fa fa-chart-area fa-3x text-white"></i>
                <div class="ms-3">
                    <p class="mb-2 text-warning">LastYear Sale</p>
                    <h6 class="mb-0">$ ${saleLastYear}</h6>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-xl-3">
            <div class="bg-primary rounded d-flex align-items-center justify-content-between p-4">
                <i class="fa fa-chart-pie fa-3x text-white"></i>
                <div class="ms-3">
                    <p class="mb-2 text-warning">Total Revenue</p>
                    <h6 class="mb-0">${percent} %</h6>
                </div>
            </div>
        </div>
    </div>


    <%-- this is MAIN sumary report --%>
    <div class="row mt-4">
        <div class="col-sm-12 col-xl-6">
            <div class="bg-light rounded h-100 p-4">
                <h6 class="mb-4 text-primary">Top 5 Best Amount</h6>
                <c:forEach var="invoice" items="${invoices_list}" varStatus="loop">
                    <c:if test="${loop.index < 6}">
                    <div class="alert alert-dark alert-dismissible d-flex justify-content-between" role="alert">
                        <i class="fa fa-exclamation-circle me-2"> Invoice ${invoice.id}</i>
                        <span class="text-center">${invoice.customer.name} (ID : ${invoice.customer.id})</span>
                        <span>$ ${invoice.amount}</span>
                        <%-- <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button> --%>
                    </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="col-sm-12 col-xl-6">
            <div class="bg-light rounded h-100 p-4">
                <h6 class="mb-4 text-primary">Top 5 Besst Product</h6>
                <c:forEach var="detail" items="${top_product}" varStatus="loop">
                    <c:if test="${loop.index < 6}">
                    <div class="alert alert-dark alert-dismissible d-flex justify-content-between">
                        <span class="text-center"><i class="fas fa-coffee text-danger"></i> ${detail.productId.name}</span>
                        <span>${detail.count}</span>
                    </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>

    </div>
    <!-- Other Elements End -->
</div>
<br><br>