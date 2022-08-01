<%@ page pageEncoding="utf-8"%>
<div class="sidebar pe-4 pb-3">
    <nav class="navbar bg-light navbar-light">
        <a href="dashboard/report" class="navbar-brand mx-4 mb-3">
            <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>DASHMIN</h3>
        </a>
        <div class="d-flex align-items-center ms-4 mb-4">
            <div class="position-relative">
                <img class="rounded-circle" src="admin/img/user.jpg" alt="" style="width: 40px; height: 40px;">
                <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
            </div>
            <div class="ms-3">
                <h6 class="mb-0">ID: ${employee.id}</h6>
                <span>Admin</span>
            </div>
        </div>
        <div class="navbar-nav w-100">
            <a href="dashboard/report" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>Sumary</a>
            <a href="dashboard/product" class="nav-item nav-link"><i class="fa fa-tachometer-alt me-2"></i>Product</a>
            <a href="dashboard/category" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>Category</a>
            <a href="dashboard/employee" class="nav-item nav-link"><i class="fa fa-th me-2"></i>Employee</a>
            <a href="dashboard/customer?p=0" class="nav-item nav-link"><i class="fa fa-table me-2"></i>Customer</a>
        </div>
    </nav>
</div>