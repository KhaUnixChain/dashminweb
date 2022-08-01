<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!-- Table Start -->
<div class="container-fluid">
    <div class="row mb-4 mt-4">
        <a class="show_product">
            <i class="bi bi-plus-circle" style="font-size:25px"></i>
        </a>
        <div class="form_product">
            <jsp:include page="product_crud.jsp" />
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="rounded h-100">
                <h6 class="mb-4">Product Table</h6>
                <table class="table table-bordered" style="width:100%">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Price</th>
                        <th>Maintenance</th>
                        <th class="text-center">Feature</th>
                    </tr>
                    <c:forEach var="item" items="${products}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td><a style="color: orange; cursor: pointer;" onclick="show_image(this)">${item.image}</a></td>
                            <td>${item.price}</td>
                            <td>${item.maintenance}</td>
                            <td class="d-flex justify-content-center">
                                <a href="product/edit?id=${item.id}" style="margin-right: 20px; color: green"><i class="bi bi-pencil"></i></a> 
                                <a href="product/delete?id=${item.id}" style="color:red"><i class="bi bi-trash"></i></a> 
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- Table End -->
