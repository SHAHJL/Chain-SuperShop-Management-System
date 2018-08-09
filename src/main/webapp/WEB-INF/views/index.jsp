<%-- 
    Document   : index
    Created on : Jul 20, 2018, 8:45:59 PM
    Author     : SHAH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Index Page</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" >
    </head>
    
    <body ng-app="myApp">
        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Chain Super Shop 2018</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Services</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contact</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Page Content -->
        <!-- /.col-lg-3 -->
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <h1 class="my-4">Shop Name</h1>

                    <div class="list-group">
                        <a href="info/home" class="list-group-item">Person Info</a>
                        <a href="category/home" class="list-group-item">Category</a>
                        <a href="subcategory/home" class="list-group-item">Sub Category</a>
                        <a href="product/home" class="list-group-item">Product</a>
                        <a href="branch/home" class="list-group-item">Branch</a>
                        <a href="vendor/home" class="list-group-item">Vendor</a>
                        <a href="customer/home" class="list-group-item">Customers</a>
                        <a href="purchase/home" class="list-group-item">Purchase Details</a>
                        <a href="distribution/home" class="list-group-item">Distribution</a>
                        <a href="accept/home" class="list-group-item">Accept</a>
                        <a href="sales/home" class="list-group-item">Sales</a>
                        <a href="userinfo/home" class="list-group-item">Users Information</a>
                    </div>
                </div>

                <!--/.col-lg-9-->
                <div class="col-lg-9">
                    <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active">
                                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>

                    <div class="row">

                        <ul class="list-group-item-info">
                            <li><a href="info/home"> person info</a></li>
                            <li><a href="category/home"> category</a></li>
                            <li><a href="subcategory/home"> sub category</a></li>
                            <li><a href="product/home"> product</a></li>
                            <li><a href="branch/home"> branch</a></li>
                            <li><a href="vendor/home"> vendor</a></li>
                            <li><a href="customer/home"> customer</a></li>
                            <li><a href="purchase/home"> purchase</a></li>
                            <li><a href="distribution/home"> distribution</a></li>
                            <li><a href="accept/home"> accept</a></li>
                            <li><a href="sales/home"> sales</a></li>
                            <li><a href="userinfo/home"> userinfo</a></li>
                        </ul>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.col-lg-9 end -->

            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->

        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Chain Super Shop 2018</p>
            </div>
            <!-- /.container -->
        </footer>





        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <!--<script src="${pageContext.request.contextPath}/static/js/controller/_controller.js"></script>-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>

    </body>
</html>
