<%-- 
    Document   : product
    Created on : Jul 13, 2018, 7:00:33 PM
    Author     : SHAH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Product Product Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>-->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>-->
    </head>
    <body ng-app="myApp">
        <div ng-controller="ProductController as proCtrl">
            <h1> Product </h1>
            <form name="productForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="proCtrl.flag != 'edit'">
                                <h3> Add New Product </h3> 
                            </div>
                            <div ng-if="proCtrl.flag == 'edit'">
                                <h3> Update Product for ID: {{ proCtrl.obj.productId}} </h3> 
                            </div> </td>
                    </tr>

                    <tr>
                        <td>Category Name</td>
                        <td>
                            <select ng-model="proCtrl.obj.category" ng-options="x.catName for x in names"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Sub Category Name</td>
                        <td>
                            <select ng-model="proCtrl.obj.subCategory" ng-options="x.subCatName for x in names2"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Product Name: </td> <td><input type="text" name="productName" ng-model="proCtrl.obj.productName" required/> 
                            <span ng-show="productForm.productName.$error.required" class="msg-val">Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Product Price: </td> <td> <input type="text" name="productPrice" ng-model="proCtrl.obj.productPrice" required/> 
                            <span ng-show="productForm.productPrice.$error.required" class="msg-val">Product price is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Product Quantity: </td> <td> <input type="text" name="productQty" ng-model="proCtrl.obj.productQty" required/> 
                            <span ng-show="productForm.productQty.$error.required" class="msg-val">Product Quantity is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Product Description: </td> <td> <input type="text" name="productDesc" ng-model="proCtrl.obj.productDesc" required/> 
                            <span ng-show="productForm.productDesc.$error.required" class="msg-val">Product Description is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Image: </td> <td> <input type="text" name="imgPath" ng-model="proCtrl.obj.imgPath" required/> 
                            <span ng-show="productForm.imgPath.$error.required" class="msg-val">Image Path is required.</span> </td>
                    </tr>

                    <tr>
                        <td colspan="2"> <span ng-if="proCtrl.flag == 'created'" class="msg-success">Product successfully added.</span>
                            <span ng-if="proCtrl.flag == 'failed'" class="msg-val">Product already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="proCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="proCtrl.addObject()" value="Add Product"/> 
                                <input type="button" ng-click="proCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="proCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="proCtrl.updateProductDetail()" value="Update Product"/> 	
                                <input type="button" ng-click="proCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="proCtrl.flag == 'deleted'" class="msg-success">Product successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>Category Name</th> <th>Sub Category Name</th> <th>Product Name</th> <th>Price</th> <th>Quantity</th>  <th>Description</th>  <th>Image</th></tr>
                <tr ng-repeat="row in proCtrl.objArray">
                    <td><span ng-bind="row.productId"></span></td>
                    <td><span ng-bind="row.category.catName"></span></td>
                    <td><span ng-bind="row.subCategory.subCatName"></span></td>
                    <td><span ng-bind="row.productName"></span></td>
                    <td><span ng-bind="row.productPrice"></span></td>
                    <td><span ng-bind="row.productQty"></span></td>
                    <td><span ng-bind="row.productDesc"></span></td>
                    <td><span ng-bind="row.imgPath"></span></td>
                    <td>
                        <input type="button" ng-click="proCtrl.deleteObject(row.productId)" value="Delete"/>
                        <input type="button" ng-click="proCtrl.editObject(row.productId)" value="Edit"/>
                        <span ng-if="proCtrl.flag == 'updated' && row.productId == proCtrl.updatedId" class="msg-success">Product successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/product_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 