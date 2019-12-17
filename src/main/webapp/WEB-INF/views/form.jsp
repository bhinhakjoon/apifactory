<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert ApiInfo</title>
<%@include file="/WEB-INF/views/common/header.jsp"%>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<%@include file="/WEB-INF/views/common/menu.jsp"%>
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register ApiInfo</div>
      <div class="card-body">
        <form name="apiForm" action="/api/save" method="POST">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Id</label>
                <input class="form-control" id="exampleInputName" name="id" type="text" aria-describedby="nameHelp" value="${api.id}" placeholder="Enter first name">
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Title</label>
                <input class="form-control" id="exampleInputLastName" name="title"  type="text" aria-describedby="nameHelp" value="${api.title}"  placeholder="Enter last name">
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">type</label>
            <input class="form-control" name="type" type="text" aria-describedby="nameHelp" placeholder="Enter type" value="${api.type}">
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">url</label>
            <input class="form-control" name="url" type="text" aria-describedby="nameHelp" placeholder="Enter url" value="${api.url}">
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">clientId</label>
            <input class="form-control" name="clientId" type="text" aria-describedby="nameHelp" placeholder="Enter clientId" value="${api.clientId}">
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">clientSecret</label>
            <input class="form-control" name="clientSecret" type="text" aria-describedby="nameHelp" placeholder="Enter clientKey" value="${api.clientSecret}">
          </div>
          
          <div class="form-group">
            <label for="exampleInputEmail1">Spreaker</label>
            <select name="speaker">
            	<option value="minjin" <c:if test="${attr.speaker == 'minjin'}">selected='selected'</c:if>>한국어,여성 음색</option>
            	<option value="jinho" <c:if test="${attr.speaker == 'jinho'}">selected='selected'</c:if>>한국어, 남성 음색</option>
            	<option value="clara" <c:if test="${attr.speaker == 'clara'}">selected='selected'</c:if>>영어, 여성 음색</option>
            	<option value="matt" <c:if test="${attr.speaker == 'matt'}">selected='selected'</c:if>>영어, 남성 음색</option>
            </select> 
          </div>
          
          <div class="form-group">
            <label for="exampleInputEmail">텍스트</label>
            <input class="form-control" name="text" type="text" aria-describedby="nameHelp" placeholder="Enter text" value="${attr.text}">
          </div>
          <c:if test="${attr.filePath != null}"><a href="/api/download?filePath=${attr.filePath }">${attr.filePath }</a></c:if>
          <a class="btn btn-primary btn-block" onclick="apiForm.submit()" href="#">Register</a>
          <!-- <audio controls="controls" src="${fileName}" type="audio/mp3"  preload="auto" />  -->
		
          
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="login.html">Login Page</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="/resources/bootstrap/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="/resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>