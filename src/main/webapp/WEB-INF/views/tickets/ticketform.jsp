<%--
  Created by IntelliJ IDEA.
  User: radek
  Date: 16/03/2021
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add Ticket</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/resources/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/resources/css/sb-admin-2.min.css" />" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <jsp:include page="../sidebar.jsp"/>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <jsp:include page="../topbar.jsp"/>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-4 text-gray-800">Add Ticket</h1>

                <form:form method="post" modelAttribute="ticket">
                    <div class="form-group">
                        <form:hidden path="created"/>
                        <label for="exampleInputEmail1">Ticket Title</label>
                        <form:input class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter title" path="title"/>
                        <small id="nameHelp" class="form-text text-muted"><form:errors path="title" /></small>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Ticket Description</label>
                        <form:input  class="form-control" id="exampleInputPassword1" placeholder="Enter description" path="description"/>
                        <small id="nameHelp" class="form-text text-muted"><form:errors path="description" /></small>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Select Priority</label>
                        <form:select class="custom-select" path="priority.id" items="${priorities}"
                                     itemLabel="name" itemValue="id"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Select Type</label>
                        <form:select class="custom-select" path="type.id" items="${types}"
                                     itemLabel="name" itemValue="id"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Select Project</label>
                        <form:select class="custom-select" path="project.id" items="${projects}"
                                     itemLabel="name" itemValue="id"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Select Status</label>
                        <form:select class="custom-select" path="status.id" items="${statuses}"
                                     itemLabel="name" itemValue="id"/>
                    </div>


                    <button type="submit" class="btn btn-primary">Add Ticket</button>
                </form:form>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">??</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <form action="<c:url value="/logout"/>" method="post">
                    <input class="btn btn-primary" type="submit" value="Logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
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
