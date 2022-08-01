<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- /# row -->
<section id="main-content">
    <!-- /# row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="card p-3">
                <div class="card-title">
                    <h4>Search employee</h4>
                </div>
                <div class="card-body">
                    <div class="basic-elements">
                        <form action="dashboard/search">
                            <div class="row">
                                <div class="col-8">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="keyId" placeholder="* Enter ID, email  ..."/>
                                    </div> 
                                </div>
                                <div class="col-2">
                                    <div class="form-group">
                                        <select class="form-control bg-light" id="sel1" name="keyRol">
                                            <option value="false">Admin</option>
                                            <option value="true">Staffs</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-2">
                                    <button type="submit" class="btn btn-outline-success w-4">
                                        <span class="jsgrid-button jsgrid-edit-button ti-plus"> Search</span>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>