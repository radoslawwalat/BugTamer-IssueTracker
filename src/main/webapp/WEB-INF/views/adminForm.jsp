
<%--
  Created by IntelliJ IDEA.
  User: radek
  Date: 23/03/2021
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Register</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/resources/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/resources/css/sb-admin-2.min.css"/>" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                        </div>
                        <form:form class="user" method="post" modelAttribute="admin">
                            <div class="form-group ">
                                <div class="mb-3 mb-sm-0">
                                    <form:input type="text" class="form-control form-control-user" id="exampleFirstName" path="username"
                                           placeholder="User Name"/>
                                    <form:errors path="username" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="mb-3 mb-sm-0">
                                <form:input type="email" class="form-control form-control-user" id="exampleInputEmail" path="email"
                                       placeholder="Email Address"/>
                                <form:errors path="email" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="mb-3 mb-sm-0">
                                    <form:input type="password" class="form-control form-control-user" path="password"
                                           id="exampleInputPassword" placeholder="Password"/>
                                    <form:errors path="password" />
                                </div>
                            </div>
                        <button type="submit" class="btn btn-primary btn-user btn-block">
                                Register Account
                        </button>



                        </form:form>
                        <hr>
<%--                        <div class="text-center">--%>
<%--                            <a class="small" href="forgot-password.html">Forgot Password?</a>--%>
<%--                        </div>--%>
                        <div class="text-center">
                            <a class="small" href="/login">Already have an account? Login!</a>
                        </div>
                    </div>
            </div>
        </div>
    </div>

</div>

<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/resources/js/sb-admin-2.min.js"/>"></script>

</body>

</html>
