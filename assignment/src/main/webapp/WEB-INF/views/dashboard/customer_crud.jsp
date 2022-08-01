<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- /# row -->
<section id="main-content">
    <!-- /# row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="card p-3">
                <div class="card-title">
                    <h4>Search customer</h4>
                </div>
                <div class="card-body">
                    <div class="basic-elements">
                        <form action="dashboard/customer">
                            <div class="row">
                                <div class="col-10">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="keyword" value="${keyword}" placeholder="* Enter keyword  ..."/>
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