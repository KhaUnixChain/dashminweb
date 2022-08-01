<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- /# row -->
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
                        <form:form action="dashboard/category" modelAttribute="itemCa">
                            <div class="row">
                                <div class="col-6">
                                    <div class="form-group">
                                        <label>Id</label>
                                        <form:input type="number" class="form-control" path="id"/>
                                    </div>                                                
                                </div>
                                <div class="col-6">
                                    <div class="form-group">
                                        <label>Name</label>
                                        <form:input type="text" class="form-control" path="type"/>
                                    </div> 
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group mt-3">
                                    <label>Choose feature</label>
                                    <div>
                                        <button type="submit" formaction="category/save" class="btn btn-outline-success">
                                            <span class="jsgrid-button jsgrid-edit-button ti-plus" type="button"> Save</span>
                                        </button>
                                        <button type="submit" formaction="category/delete" class="btn btn-outline-danger">
                                            <span class="jsgrid-button jsgrid-edit-button ti-plus" type="button"> Delete</span>
                                        </button>
                                        <button type="submit" formaction="category/reset" class="btn btn-outline-warning">
                                            <span class="jsgrid-button jsgrid-edit-button ti-reload" type="reset"> Reset</span>
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