<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>API LIST</title>
<%@include file="/WEB-INF/views/common/header.jsp"%>
</head>
<body>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<%@include file="/WEB-INF/views/common/menu.jsp"%>
<div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Tables</li>
      </ol>
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Data Table Example</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>id</th>
                  <th>title</th>
                  <th>type</th>
                  <th>clientId</th>
                  <th>clientSecret</th>
                  <th>regDate</th>
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th>id</th>
                  <th>title</th>
                  <th>type</th>
                  <th>clientId</th>
                  <th>clientSecret</th>
                  <th>regDate</th>
                </tr>
              </tfoot>

              <tbody>
              <c:forEach var="api" items="${lists}" varStatus="idx">
                <tr>
                  <td>${api.id}</td>
                  <td><a href="/api/read?id=${api.id}">${api.title }</a></td>
                  <td>${api.type }</td>
                  <td>${api.clientId}</td>
                  <td>${api.clientSecret}</td>
                  <td>${api.created }</td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
          <a class="btn btn-primary btn-block"  href="/api/form">Register</a>
        </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Your Website 2017</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="/resources/bootstrap/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="/resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="/resources/bootstrap/vendor/datatables/jquery.dataTables.js"></script>
    <script src="/resources/bootstrap/vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="/resources/bootstrap/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="/resources/bootstrap/js/sb-admin-datatables.min.js"></script>
  </div>
  

</body>
</html>	