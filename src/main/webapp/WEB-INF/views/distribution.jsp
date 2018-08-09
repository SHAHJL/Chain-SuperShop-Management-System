<%-- 
    Document   : distribution
    Created on : Jul 20, 2018, 10:05:28 AM
    Author     : R-34
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Product Distribution Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>-->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>-->
    </head>
    <body ng-app="myApp">
        <div ng-controller="DistributionController as distCtrl">
            <h1> Distribution </h1>
            <form name="distForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="distCtrl.flag != 'edit'">
                                <h3> Add New Distribution </h3> 
                            </div>
                            <div ng-if="distCtrl.flag == 'edit'">
                                <h3> Update Distribution for ID: {{ distCtrl.obj.distId}} </h3> 
                            </div> </td>
                    </tr>

                    <tr>
                        <td>Category</td>
                        <td>
                            <select ng-model="distCtrl.obj.category" ng-options="x.catName for x in names"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Sub Category</td>
                        <td>
                            <select ng-model="distCtrl.obj.subCategory" ng-options="x.subCatName for x in names2"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Product</td>
                        <td>
                            <select ng-model="distCtrl.obj.product" ng-options="x.productName for x in names3"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Branch</td>
                        <td>
                            <select ng-model="distCtrl.obj.branch" ng-options="x.branchName for x in names4"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Distribution Date</td> <td> <input type="text" name="distDate" ng-model="distCtrl.obj.distDate" required/> 
                            <span ng-show="distForm.distDate.$error.required" class="msg-val">Distribution Date is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Distribution s</td> <td> <input type="text" name="distStatus" ng-model="distCtrl.obj.distStatus" required/> 
                            <span ng-show="distForm.distStatus.$error.required" class="msg-val">Distribution distStatus is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Distribution Quantity</td> <td> <input type="text" name="distQty" ng-model="distCtrl.obj.distQty" required/> 
                            <span ng-show="distForm.distQty.$error.required" class="msg-val">Distribution qty is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Distribution total</td> <td> <input type="text" name="totalAmount" ng-model="distCtrl.obj.totalAmount" required/> 
                            <span ng-show="distForm.totalAmount.$error.required" class="msg-val">Distribution totalAmount is required.</span> </td>
                    </tr>


                    <tr>
                        <td colspan="2"> <span ng-if="distCtrl.flag == 'created'" class="msg-success">Distribution successfully added.</span>
                            <span ng-if="distCtrl.flag == 'failed'" class="msg-val">Distribution already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="distCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="distCtrl.addObject()" value="Add Distribution"/> 
                                <input type="button" ng-click="distCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="distCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="distCtrl.updateDistributionDetail()" value="Update Distribution"/> 	
                                <input type="button" ng-click="distCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="distCtrl.flag == 'deleted'" class="msg-success">Distribution successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr>
                    <th>ID </th>
                    <th>Category</th>
                    <th>Sub Category</th>
                    <th>Product</th>
                    <th>Branch</th>
                    <th> Date</th>
                    <th> Price</th>
                    <th> Quantity</th>
                    <th> D</th>
                </tr>
                <tr ng-repeat="row in distCtrl.objArray">
                    <td><span ng-bind="row.distId"></span></td>
                    <td><span ng-bind="row.category.catName"></span></td>
                    <td><span ng-bind="row.subCategory.subCatName"></span></td>
                    <td><span ng-bind="row.product.productName"></span></td>
                    <td><span ng-bind="row.branch.branchName"></span></td>
                    <td><span ng-bind="row.distDate"></span></td>
                    <td><span ng-bind="row.distQty"></span></td>
                    <td><span ng-bind="row.distStatus"></span></td>
                    <td><span ng-bind="row.totalAmount"></span></td>
                    <td>
                        <input type="button" ng-click="distCtrl.deleteObject(row.distId)" value="Delete"/>
                        <input type="button" ng-click="distCtrl.editObject(row.distId)" value="Edit"/>
                        <span ng-if="distCtrl.flag == 'updated' && row.distId == distCtrl.updatedId" class="msg-success">Distribution successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/distribution_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 