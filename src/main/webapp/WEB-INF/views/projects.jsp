<%--
  Created by IntelliJ IDEA.
  User: radek
  Date: 15/03/2021
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="header.jsp"/>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <jsp:include page="sidebar.jsp"/>
    <!-- Custom styles for this page -->
    <link href="<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.css"/>" rel="stylesheet">

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <jsp:include page="topbar.jsp"/>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                <h1 class="h3 mb-2 text-gray-800">Projects</h1>
                <a href="/projects/add" class="btn btn-primary btn-icon-split btn-lg">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-flag"></i>
                                        </span>
                    <span class="text">Add Project</span>
                </a>
                </div>
                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Your Projects</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Project Name</th>
                                    <th>Description</th>
                                    <th>Actions</th>

                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Project Name</th>
                                    <th>Description</th>
                                    <th>Actions</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach items="${projects}" var="project">
                                    <tr>
                                        <td>${project.name}</td>
                                        <td> ${project.description}</td>
                                        <td>
                                            <a href="/projects/details/${project.id}" class="btn btn-info btn-icon-split">
                                            <span class="icon text-white-50">
                                                <i class="fas fa-info-circle"></i>
                                            </span>
                                                <span class="text">Details</span>
                                            </a>
                                            <a href="#" class="btn btn-secondary btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-arrow-right"></i>
                                        </span>
                                                <span class="text">Menage Users</span>
                                            </a>
                                            <a href="#" class="btn btn-danger btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-trash"></i>
                                        </span>
                                                <span class="text">Delete Plan</span>
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
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; BugTamer 2021</span>
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