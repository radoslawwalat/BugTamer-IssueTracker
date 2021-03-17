<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Project Details</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/resources/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/resources/css/sb-admin-2.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.css"/>" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <jsp:include page="sidebar.jsp"/>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <jsp:include page="topbar.jsp"/>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-6">
                <h1 class="h3 mb-2 text-gray-800">Project Name : ${project.name}</h1>
                    </div>
                    <div class="col-lg-6">
                <h1 class="h3 mb-2 text-gray-800">Project Description : ${project.name}</h1>
                    </div>
                </div>
                <a href="/projects/add" class="btn btn-primary btn-icon-split btn-lg">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-flag"></i>
                                        </span>
                    <span class="text">Add Project</span>
                </a>
                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">This Project's Tickets</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered display" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Ticket Name</th>
                                    <th>Ticket Description</th>
                                    <th>Actions</th>

                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Ticket Name</th>
                                    <th>Ticket Description</th>
                                    <th>Actions</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach items="${project.tickets}" var="ticket">
                                    <tr>
                                        <td>${ticket.title}</td>
                                        <td> ${ticket.description}</td>
                                        <td>
                                            <a href="/tickets/details/${ticket.id}" class="btn btn-info btn-icon-split">
                                            <span class="icon text-white-50">
                                                <i class="fas fa-info-circle"></i>
                                            </span>
                                                <span class="text">Details</span>
                                            </a>
                                        </td>

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
                <%--db2--%>
            <div class="container-fluid">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Assigned Personel</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered display" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Username</th>
                                    <th>Email</th>
                                    <th>Role</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Username</th>
                                    <th>Email</th>
                                    <th>Role</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach items="${project.admins}" var="admin">
                                    <tr>
                                        <td>${admin.username}</td>
                                        <td>${admin.email}</td>
                                        <td>${admin.role.name}</td>

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>

            <!-- /.container-fluid -->



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
<script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/resources/js/sb-admin-2.min.js"/>"></script>


        <!-- Page level plugins -->
        <script src="<c:url value="/resources/vendor/datatables/jquery.dataTables.min.js"/>"></script>
        <script src="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.js"/>"></script>

        <!-- Page level custom scripts -->
        <script src="<c:url value="/resources/js/demo/datatables-demo.js"/>"> </script>

</body>

</html>