<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!-- Button Start -->
<div class="container-fluid pt-4 px-4">
    <div class="row mb-4">
        <a class="show_product">
            <i class="bi bi-plus-circle" style="font-size:25px"></i>
        </a>
        <div class="form_product">
            <jsp:include page="category_crud.jsp"/>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12 col-xl-12">
            <div  class="bg-light rounded h-100 p-4">
                <h6 class="mb-4">Category Type</h6>
                <div class="m-n2">
                    <c:forEach var="c" items="${categories}">
                        <a href="category/edit?id=${c.id}">
                            <button class="btn btn-dark m-2">- ${c.id} -<br> ${c.type}</button>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Button End -->
