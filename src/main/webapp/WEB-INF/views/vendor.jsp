<%-- 
    Document   : vendor
    Created on : Jul 13, 2018, 10:41:52 PM
    Author     : SHAH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Product Vendor Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>-->
    <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>-->
    </head>
    <body ng-app="myApp">
        <div ng-controller="VendorController as vCtrl">
            <h1> Vendor </h1>
            <form name="vendorForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="vCtrl.flag != 'edit'">
                                <h3> Add New Vendor </h3> 
                            </div>
                            <div ng-if="vCtrl.flag == 'edit'">
                                <h3> Update Vendor for ID: {{ vCtrl.obj.vendorId}} </h3> 
                            </div> </td>
                    </tr>
                    
                    <tr>
                        <td>User Name</td>
                        <td>
                            <select ng-model="vCtrl.obj.user" ng-options="x.userName for x in names">
</select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td> vendorName</td> <td> <input type="text" name="vendorName" ng-model="vCtrl.obj.vendorName" required/> 
                            <span ng-show="vendorForm.vendorName.$error.required" class="msg-val">Vendor vendorName is required.</span> </td>
                    </tr>
                    
                    <tr>
                        <td> vendorLocation</td> <td> <input type="text" name="vendorLocation" ng-model="vCtrl.obj.vendorLocation" required/> 
                            <span ng-show="vendorForm.vendorLocation.$error.required" class="msg-val">Vendor vendorLocation is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Vendor Type</td> <td> <input type="text" name="vendorType" ng-model="vCtrl.obj.vendorType" required/> 
                            <span ng-show="vendorForm.vendorType.$error.required" class="msg-val">Vendor Type is required.</span> </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2"> <span ng-if="vCtrl.flag == 'created'" class="msg-success">Vendor successfully added.</span>
                            <span ng-if="vCtrl.flag == 'failed'" class="msg-val">Vendor already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="vCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="vCtrl.addObject()" value="Add Vendor"/> 
                                <input type="button" ng-click="vCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="vCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="vCtrl.updateVendorDetail()" value="Update Vendor"/> 	
                                <input type="button" ng-click="vCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="vCtrl.flag == 'deleted'" class="msg-success">Vendor successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>User Name</th> <th>Vendor Name</th> <th>Vendor Location</th></tr>
                <tr ng-repeat="row in vCtrl.objArray">
                    <td><span ng-bind="row.vendorId"></span></td>
                    <td><span ng-bind="row.user.userName"></span></td>
                    <td><span ng-bind="row.vendorName"></span></td>
                    <td><span ng-bind="row.vendorLocation"></span></td>
                    <td><span ng-bind="row.vendorType"></span></td>
                    <td>
                        <input type="button" ng-click="vCtrl.deleteObject(row.vendorId)" value="Delete"/>
                        <input type="button" ng-click="vCtrl.editObject(row.vendorId)" value="Edit"/>
                        <span ng-if="vCtrl.flag == 'updated' && row.vendorId == vCtrl.updatedId" class="msg-success">Vendor successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/vendor_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 