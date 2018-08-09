<%-- 
    Document   : sales
    Created on : Jul 15, 2018, 9:37:10 AM
    Author     : R-34
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Product Sales Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>-->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>-->
    </head>
    <body ng-app="myApp">
        <div ng-controller="SalesController as sdCtrl">
            <h1> Sales </h1>
            <form name="salesForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="sdCtrl.flag != 'edit'">
                                <h3> Add New Sales </h3> 
                            </div>
                            <div ng-if="sdCtrl.flag == 'edit'">
                                <h3> Update Sales for ID: {{ sdCtrl.obj.saleId}} </h3> 
                            </div> </td>
                    </tr>

                    <tr>
                        <td>User Name</td>
                        <td>
                            <select ng-model="sdCtrl.obj.branch" ng-options="x.branchName for x in names"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>User Name</td>
                        <td>
                            <select ng-model="sdCtrl.obj.customer" ng-options="y.customerName for y in names3"></select>
                        </td>
                    </tr>

                    <!--                    <tr>
                                            <td>Customer</td> <td> <input type="text" name="customer.customerId" ng-model="sdCtrl.obj.customer.customerId" required/> 
                                                <span ng-show="salesForm.customer.customerId.$error.required" class="msg-val">customer customerId  is required.</span> </td>
                                        </tr>
                                        <tr>
                                            <td>Branch</td> <td> <input type="text" name="branch" ng-model="sdCtrl.obj.branch.branchName" required/> 
                                                <span ng-show="salesForm.branch.branchName.$error.required" class="msg-val">Sales Branch is required.</span> </td>
                                        </tr>-->
                    <tr>
                        <td>Sales Date</td> <td> <input type="text" name="saleDate" ng-model="sdCtrl.obj.saleDate" required/> 
                            <span ng-show="salesForm.saleDate.$error.required" class="msg-val">Sales Type is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Sales Price</td> <td> <input type="text" name="salePrice" ng-model="sdCtrl.obj.salePrice" required/> 
                            <span ng-show="salesForm.salePrice.$error.required" class="msg-val">Sales salePrice is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Sales Quantity</td> <td> <input type="text" name="saleQty" ng-model="sdCtrl.obj.saleQty" required/> 
                            <span ng-show="salesForm.saleQty.$error.required" class="msg-val">Sales qty is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Sales desc</td> <td> <input type="text" name="saleDesc" ng-model="sdCtrl.obj.saleDesc" required/> 
                            <span ng-show="salesForm.saleDesc.$error.required" class="msg-val">Sales saleDesc is required.</span> </td>
                    </tr>


                    <tr>
                        <td colspan="2"> <span ng-if="sdCtrl.flag == 'created'" class="msg-success">Sales successfully added.</span>
                            <span ng-if="sdCtrl.flag == 'failed'" class="msg-val">Sales already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="sdCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="sdCtrl.addObject()" value="Add Sales"/> 
                                <input type="button" ng-click="sdCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="sdCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="sdCtrl.updateSalesDetail()" value="Update Sales"/> 	
                                <input type="button" ng-click="sdCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="sdCtrl.flag == 'deleted'" class="msg-success">Sales successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr>
                    <th>ID </th>
                    <th>Sales Date</th>
                    <th>Branch</th>
                    <th>Customer</th>
                    <th>Sales Price</th>
                    <th>Sales Quantity</th>
                    <th>Sales D</th>
                </tr>
                <tr ng-repeat="row in sdCtrl.objArray">
                    <td><span ng-bind="row.saleId"></span></td>
                    <td><span ng-bind="row.branch.branchName"></span></td>
                    <td><span ng-bind="row.customer.customerName"></span></td>
                    <td><span ng-bind="row.saleDate"></span></td>
                    <td><span ng-bind="row.saleQty"></span></td>
                    <td><span ng-bind="row.salePrice"></span></td>
                    <td><span ng-bind="row.saleDesc"></span></td>
                    <td>
                        <input type="button" ng-click="sdCtrl.deleteObject(row.saleId)" value="Delete"/>
                        <input type="button" ng-click="sdCtrl.editObject(row.saleId)" value="Edit"/>
                        <span ng-if="sdCtrl.flag == 'updated' && row.saleId == sdCtrl.updatedId" class="msg-success">Sales successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/sales_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 