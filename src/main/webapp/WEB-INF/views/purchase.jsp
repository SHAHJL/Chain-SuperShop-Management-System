<%-- 
    Document   : purchase
    Created on : Jul 18, 2018, 12:04:05 PM
    Author     : R-34
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Product Purchase Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>-->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>-->
    </head>
    <body ng-app="myApp">
        <div ng-controller="PurchaseController as purCtrl">
            <h1> Purchase </h1>
            <form name="purForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="purCtrl.flag != 'edit'">
                                <h3> Add New Purchase </h3> 
                            </div>
                            <div ng-if="purCtrl.flag == 'edit'">
                                <h3> Update Purchase for ID: {{ purCtrl.obj.purId}} </h3> 
                            </div> </td>
                    </tr>

                    <tr>
                        <td>Category</td>
                        <td>
                            <select ng-model="purCtrl.obj.category" ng-options="x.catName for x in names"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Sub Category</td>
                        <td>
                            <select ng-model="purCtrl.obj.subCategory" ng-options="x.subCatName for x in names2"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Product</td>
                        <td>
                            <select ng-model="purCtrl.obj.product" ng-options="x.productName for x in names3"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Vendor</td>
                        <td>
                            <select ng-model="purCtrl.obj.vendor" ng-options="x.vendorName for x in names4"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Purchase Date</td> <td> <input type="text" name="purDate" ng-model="purCtrl.obj.purDate" required/> 
                            <span ng-show="purForm.purDate.$error.required" class="msg-val">Purchase Date is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Purchase Price</td> <td> <input type="text" name="purPrice" ng-model="purCtrl.obj.purPrice" required/> 
                            <span ng-show="purForm.purPrice.$error.required" class="msg-val">Purchase Price is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Purchase Quantity</td> <td> <input type="text" name="purQty" ng-model="purCtrl.obj.purQty" required/> 
                            <span ng-show="purForm.purQty.$error.required" class="msg-val">Purchase qty is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Purchase desc</td> <td> <input type="text" name="purDesc" ng-model="purCtrl.obj.purDesc" required/> 
                            <span ng-show="purForm.purDesc.$error.required" class="msg-val">Purchase Desc is required.</span> </td>
                    </tr>


                    <tr>
                        <td colspan="2"> <span ng-if="purCtrl.flag == 'created'" class="msg-success">Purchase successfully added.</span>
                            <span ng-if="purCtrl.flag == 'failed'" class="msg-val">Purchase already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="purCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="purCtrl.addObject()" value="Add Purchase"/> 
                                <input type="button" ng-click="purCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="purCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="purCtrl.updatePurchaseDetail()" value="Update Purchase"/> 	
                                <input type="button" ng-click="purCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="purCtrl.flag == 'deleted'" class="msg-success">Purchase successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr>
                    <th>ID </th>
                    <th>Category</th>
                    <th>Sub Category</th>
                    <th>Product</th>
                    <th>Vendor</th>
                    <th> Date</th>
                    <th> Price</th>
                    <th> Quantity</th>
                    <th> D</th>
                </tr>
                <tr ng-repeat="row in purCtrl.objArray">
                    <td><span ng-bind="row.purId"></span></td>
                    <td><span ng-bind="row.category.catName"></span></td>
                    <td><span ng-bind="row.subCategory.subCatName"></span></td>
                    <td><span ng-bind="row.product.productName"></span></td>
                    <td><span ng-bind="row.vendor.vendorName"></span></td>
                    <td><span ng-bind="row.purDate"></span></td>
                    <td><span ng-bind="row.purQty"></span></td>
                    <td><span ng-bind="row.purPrice"></span></td>
                    <td><span ng-bind="row.purDesc"></span></td>
                    <td>
                        <input type="button" ng-click="purCtrl.deleteObject(row.purId)" value="Delete"/>
                        <input type="button" ng-click="purCtrl.editObject(row.purId)" value="Edit"/>
                        <span ng-if="purCtrl.flag == 'updated' && row.purId == purCtrl.updatedId" class="msg-success">Purchase successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/purchase_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 