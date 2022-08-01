<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!-- Table Start -->
<div class="container-fluid">
    <div class="row mb-4 mt-4">
        <a class="show_employee">
            <i class="bi bi-plus-circle" style="font-size:25px"></i>
        </a>
        <div class="form_employee">
            <jsp:include page="employee_crud.jsp" />
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="rounded h-100">
                <table class="table table-bordered table-hover" style="width:100%">
                    <tr class="bg-primary text-white">
                        <th>Id</th>
                        <th>Name</th>
                        <th>Password</th>
                        <th>Email</th>
                        <th>Birth</th>
                        <th>Role</th>
                    </tr>
                    <c:forEach var="item" items="${employees.content}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.password}</td>
                            <td>${item.email}</td>
                            <td>${item.birth}</td>
                            <td>${item.role?'Staff':'Admin'}</td>
                        </tr>
                    </c:forEach>
                </table>
                <a href="dashboard/employee?p=0" style="color: red; margin-right:10px" ><i class="bi bi-backspace"></i></a>
                <a href="dashboard/employee?p=${employees.number-1 < 0 ? 0 : employees.number-1}"><i class="bi bi-chevron-double-left"></i></a>
                <a href="dashboard/employee?p=${employees.number+1 >= employees.totalPages ? employees.totalPages-1 : employees.number+1 }"><i class="bi bi-chevron-double-right"></i></a>
                <a href="dashboard/employee?p=${employees.totalPages-1}"  style="color: red; margin-left:10px"><i class="bi bi-backspace-reverse"></i></a>
            </div>
        </div>
    </div>
    <br><br><br>
</div>
<!-- Table End -->
