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
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Ticket #${ticket.id}</h1>
                </div>

                <div class="row">

                    <div class="col-lg-6">

                        <!-- Basic Card Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3 d-sm-flex align-items-center justify-content-between">
                                <h3 class="m-0 font-weight-bold text-primary">Ticket Details</h3>

                                <a href="/tickets/edit/${ticket.id}" class="btn btn-primary btn-icon-split btn">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-flag"></i>
                                        </span>
                                    <span class="text">Edit Ticket</span>
                                </a>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="col"><h4 class="m-0 font-weight-bold text-primary">Title</h4>${ticket.title}</div>
                                    </div>
                                    <div class="col-lg-6">

                                        <div class="col"><h4 class="m-0 font-weight-bold text-primary">Description</h4>${ticket.description}</div>
                                    </div>
                                </div>
                                <div class="dropdown-divider"></div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="col"><h4 class="m-0 font-weight-bold text-primary">AssignedDev</h4>${ticket.submitter.username}</div>
                                    </div>
                                    <div class="col-lg-6">

                                        <div class="col"><h4 class="m-0 font-weight-bold text-primary">Submitter</h4>${ticket.submitter.username}</div>
                                    </div>
                                </div>
                                <div class="dropdown-divider"></div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="col"><h4 class="m-0 font-weight-bold text-primary">Project</h4>${ticket.project.name}</div>
                                    </div>
                                    <div class="col-lg-6">

                                        <div class="col"><h4 class="m-0 font-weight-bold text-primary">Ticket Priority</h4>${ticket.priority.name}</div>
                                    </div>
                                </div>
                                <div class="dropdown-divider"></div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="col"><h4 class="m-0 font-weight-bold text-primary">Ticket Status</h4>${ticket.status.name}</div>
                                    </div>
                                    <div class="col-lg-6">

                                        <div class="col"><h4 class="m-0 font-weight-bold text-primary">Ticket Type</h4>${ticket.type.name}</div>
                                    </div>
                                </div>
                                <div class="dropdown-divider"></div>
                                <div class="row">
                                    <div class="col-lg-6">
<%--                                        TODO format daty --%>
                                        <div class="col"><h4 class="m-0 font-weight-bold text-primary">Created</h4>${ticket.created}</div>
                                    </div>
                                    <div class="col-lg-6">

                                        <div class="col"><h4 class="m-0 font-weight-bold text-primary">Updated</h4>${ticket.updated}</div>
                                    </div>
                                </div>

                            </div>
                        </div>



                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h3 class="m-0 font-weight-bold text-primary">History Of Changes</h3>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered display" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th>User</th>
                                        <th>Property</th>
                                        <th>Old Value</th>
                                        <th>New Value</th>
                                        <th>Date</th>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${ticket.histories}" var="history">
                                        <tr>
                                            <td>${history.admin.username}</td>
                                            <td> ${history.property}</td>
                                            <td> ${history.oldvalue}</td>
                                            <td> ${history.newvalue}</td>
                                            <td> ${history.date}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    </div>

                    <div class="col-lg-6">
                        <form:form action="/addcomment/${ticket.id}" modelAttribute="comment" method="post">
                        <div class="input-group mb-3">
                            <form:input path="message" type="text" class="form-control" placeholder="Add comment" aria-label="Recipient's username" aria-describedby="basic-addon2"/>
                            <div class="input-group-append">
                                <button class="btn btn-outline-secondary" type="submit">Add</button>
                            </div>
                        </div>
                        </form:form>
                        <!-- Default Card Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h3 class="m-0 font-weight-bold text-primary">Comments</h3>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered display" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                        <tr>
                                            <th>User</th>
                                            <th>Message</th>
                                            <th>Posted</th>

                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${ticket.comments}" var="comment">
                                            <tr>
                                                <td>${comment.commenter.username}</td>
                                                <td> ${comment.message}</td>
                                                <td> ${comment.created}</td>

                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <!-- Basic Card Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Basic Card Example</h6>
                            </div>
                            <div class="card-body">
                                The styling for this basic card example is created by using default Bootstrap
                                utility classes. By using utility classes, the style of the card component can be
                                easily modified with no need for any custom CSS!
                            </div>
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