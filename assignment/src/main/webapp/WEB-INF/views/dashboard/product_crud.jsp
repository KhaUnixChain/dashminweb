<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<section id="main-content">
    <!-- /# row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="card p-4">
                <div class="card-title">
                    <h4>Form Product</h4>
                </div>
                <div class="card-body">
                    <div class="basic-elements">
                        <form:form action="product/save" modelAttribute="itemPr">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label>Id</label>
                                        <form:input type="text" class="form-control" path="id" value="${product.id}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Name</label>
                                        <form:input type="text" class="form-control" path="name" value="${product.name}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Price</label>
                                        <form:input type="number" class="form-control" min="0" path="price" value="${product.price}"/>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label>Maintenance / year:</label>
                                        <form:input type="number" class="form-control" min="0" path="maintenance" value="${product.maintenance}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Category</label>
                                        <form:select path="category" items="${categories_map}" value="${product.category.type}" class="form-control" style="background-color: white" />
                                    </div>
                                    
                                    <!--  choose a picture in here  -->
                                    <div class="form-group">
                                        <label style="margin-right: 15px">Image</label>
                                        <input type="hidden" name="image">
                                        <form:input type="file" path="image" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group mt-3">
                                    <label>Choose feature</label>
                                    <div>
                                        <button type="submit" formaction="product/save" class="btn btn-outline-success">
                                            <span class="jsgrid-button jsgrid-edit-button ti-plus" type="button"> Save</span>
                                        </button>
                                        <button type="submit" formaction="product/reset" class="btn btn-outline-danger">
                                            <span class="jsgrid-button jsgrid-edit-button ti-reload" type="button"> Reset</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
        <!-- /# column -->
        
        <!-- /# column -->
    </div>
    <!-- /# row -->
</section>