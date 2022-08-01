<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!-- Table Start -->
<div class="container-fluid">
    <div class="row mb-4 mt-4">
        <a class="show_customer">
            <i class="bi bi-plus-circle" style="font-size:25px"></i>
        </a>
        <div class="form_search">
            <jsp:include page="customer_crud.jsp" />
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="rounded h-100">
                <table class="table table-bordered table-hover" style="width:100%">
                    <tr class="bg-primary text-white">
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Phone</th>
                    </tr>
                    <c:forEach var="item" items="${customers.content}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.email}</td>
                            <td>${item.password}</td>
                            <td>${item.phone}</td>
                        </tr>
                    </c:forEach>
                </table>
                <a href="dashboard/customer?p=0" style="color: red; margin-right:10px" ><i class="bi bi-backspace"></i></a>
                <a href="dashboard/customer?p=${customers.number-1}"><i class="bi bi-chevron-double-left"></i></a>
                <a href="dashboard/customer?p=${customers.number+1}"><i class="bi bi-chevron-double-right"></i></a>
                <a href="dashboard/customer?p=${customers.totalPages-1}"  style="color: red; margin-left:10px"><i class="bi bi-backspace-reverse"></i></a>
            </div>
        </div>
    </div>
    <br><br><br>
</div>
<!-- Table End -->
