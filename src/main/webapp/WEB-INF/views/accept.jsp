<%-- 
    Document   : accept
    Created on : Jul 20, 2018, 10:36:36 AM
    Author     : R-34
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Product Accept Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>-->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>-->
    </head>
    <body ng-app="myApp">
        <div ng-controller="AcceptController as accCtrl">
            <h1> Accept </h1>
            <form name="accForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="accCtrl.flag != 'edit'">
                                <h3> Add New Accept </h3> 
                            </div>
                            <div ng-if="accCtrl.flag == 'edit'">
                                <h3> Update Accept for ID: {{ accCtrl.obj.accId}} </h3> 
                            </div> </td>
                    </tr>

                    <tr>
                        <td>Category</td>
                        <td>
                            <select ng-model="accCtrl.obj.category" ng-options="x.catName for x in names"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Sub Category</td>
                        <td>
                            <select ng-model="accCtrl.obj.subCategory" ng-options="x.subCatName for x in names2"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Product</td>
                        <td>
                            <select ng-model="accCtrl.obj.product" ng-options="x.productName for x in names3"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Branch</td>
                        <td>
                            <select ng-model="accCtrl.obj.branch" ng-options="x.branchName for x in names4"></select>
                        </td>
                    </tr>

                    <tr>
                        <td>Accept Date</td> <td> <input type="text" name="accDate" ng-model="accCtrl.obj.accDate" required/> 
                            <span ng-show="accForm.accDate.$error.required" class="msg-val">Accept Date is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Accept s</td> <td> <input type="text" name="accStatus" ng-model="accCtrl.obj.accStatus" required/> 
                            <span ng-show="accForm.accStatus.$error.required" class="msg-val">Accept accStatus is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Accept Quantity</td> <td> <input type="text" name="accQty" ng-model="accCtrl.obj.accQty" required/> 
                            <span ng-show="accForm.accQty.$error.required" class="msg-val">Accept qty is required.</span> </td>
                    </tr>                    

                    <tr>
                        <td colspan="2"> <span ng-if="accCtrl.flag == 'created'" class="msg-success">Accept successfully added.</span>
                            <span ng-if="accCtrl.flag == 'failed'" class="msg-val">Accept already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="accCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="accCtrl.addObject()" value="Add Accept"/> 
                                <input type="button" ng-click="accCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="accCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="accCtrl.updateAcceptDetail()" value="Update Accept"/> 	
                                <input type="button" ng-click="accCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="accCtrl.flag == 'deleted'" class="msg-success">Accept successfully deleted.</span>
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
                    <th> Quantity</th>
                    <th> Status</th>
                </tr>
                <tr ng-repeat="row in accCtrl.objArray">
                    <td><span ng-bind="row.accId"></span></td>
                    <td><span ng-bind="row.category.catName"></span></td>
                    <td><span ng-bind="row.subCategory.subCatName"></span></td>
                    <td><span ng-bind="row.product.productName"></span></td>
                    <td><span ng-bind="row.branch.branchName"></span></td>
                    <td><span ng-bind="row.accDate"></span></td>
                    <td><span ng-bind="row.accQty"></span></td>
                    <td><span ng-bind="row.accStatus"></span></td>
                    <td>
                        <input type="button" ng-click="accCtrl.deleteObject(row.accId)" value="Delete"/>
                        <input type="button" ng-click="accCtrl.editObject(row.accId)" value="Edit"/>
                        <span ng-if="accCtrl.flag == 'updated' && row.accId == accCtrl.updatedId" class="msg-success">Accept successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/accept_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html>