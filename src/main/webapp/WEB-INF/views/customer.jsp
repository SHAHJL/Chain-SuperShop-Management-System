<%-- 
    Document   : customer
    Created on : Jul 14, 2018, 12:03:13 AM
    Author     : SHAH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Customer</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>-->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>-->
    </head>
    <body ng-app="myApp">
        <div ng-controller="CustomerController as custCtrl">
            <h1> Customer </h1>
            <form name="customerForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="custCtrl.flag != 'edit'">
                                <h3> Add New Customer </h3> 
                            </div>
                            <div ng-if="custCtrl.flag == 'edit'">
                                <h3> Update Customer for ID: {{ custCtrl.obj.customerId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>customerName </td> <td><input type="text" name="name" ng-model="custCtrl.obj.customerName" required/> 
                            <span ng-show="customerForm.customerName.$error.required" class="msg-val">Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>customerAddress </td> <td> <input type="text" name="location" ng-model="custCtrl.obj.customerAddress" required/> 
                            <span ng-show="customerForm.customerAddress.$error.required" class="msg-val">customerAddress is required.</span> </td>
                    </tr>
                    <tr>
                        <td>customer Email</td> <td> <input type="text" name="email" ng-model="custCtrl.obj.customerEmail" required/> 
                            <span ng-show="customerForm.customerEmail.$error.required" class="msg-val">customer Email is required.</span> </td>
                    </tr>
                    <tr>
                        <td>customer Phone</td> <td> <input type="text" name="phone" ng-model="custCtrl.obj.customerPhone" required/> 
                            <span ng-show="customerForm.customerPhone.$error.required" class="msg-val">customer Phone is required.</span> </td>
                    </tr>
                    <tr>
                        <td>customer Order Date</td> <td> <input type="text" name="orderDate" ng-model="custCtrl.obj.orderDate" required/> 
                            <span ng-show="customerForm.orderDate.$error.required" class="msg-val">orderDate is required.</span> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="custCtrl.flag == 'created'" class="msg-success">Customer successfully added.</span>
                            <span ng-if="custCtrl.flag == 'failed'" class="msg-val">Customer already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="custCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="custCtrl.addCustomer()" value="Add Customer"/> 
                                <input type="button" ng-click="custCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="custCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="custCtrl.updateCustomerDetail()" value="Update Customer"/> 	
                                <input type="button" ng-click="custCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="custCtrl.flag == 'deleted'" class="msg-success">Customer successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>Name</th> <th>Location</th> <th>email </th> <th>Phone</th> <th>Date</th></tr>
                <tr ng-repeat="row in custCtrl.objArray">
                    <td><span ng-bind="row.customerId"></span></td>
                    <td><span ng-bind="row.customerName"></span></td>
                    <td><span ng-bind="row.customerAddress"></span></td>
                    <td><span ng-bind="row.customerEmail"></span></td>
                    <td><span ng-bind="row.customerPhone"></span></td>
                    <td><span ng-bind="row.orderDate"></span></td>
                    <td>
                        <input type="button" ng-click="custCtrl.deleteCustomer(row.customerId)" value="Delete"/>
                        <input type="button" ng-click="custCtrl.editCustomer(row.customerId)" value="Edit"/>
                        <span ng-if="custCtrl.flag == 'updated' && row.customerId == custCtrl.updatedId" class="msg-success">Customer successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/customer_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 