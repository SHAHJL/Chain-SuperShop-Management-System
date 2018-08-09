<%-- 
    Document   : branch
    Created on : Jul 4, 2018, 1:37:21 PM
    Author     : R-34
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Product Branch Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>-->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>-->
    </head>
    <body ng-app="myApp">
        <div ng-controller="BranchController as branchCtrl">
            <h1> Branch </h1>
            <form name="branchForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="branchCtrl.flag != 'edit'">
                                <h3> Add New Branch </h3> 
                            </div>
                            <div ng-if="branchCtrl.flag == 'edit'">
                                <h3> Update Branch for ID: {{ branchCtrl.obj.branchRegId}} </h3> 
                            </div> </td>
                    </tr>

                    <tr>
                        <td>User Name</td>
                        <td>
                            <select ng-model="branchCtrl.obj.user" ng-options="x.userName for x in users">
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>Branch Name: </td> <td><input type="text" name="name" ng-model="branchCtrl.obj.branchName" required/> 
                            <span ng-show="branchForm.branchName.$error.required" class="msg-val">Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Branch Location</td> <td> <input type="text" name="location" ng-model="branchCtrl.obj.branchLocation" required/> 
                            <span ng-show="branchForm.branchLocation.$error.required" class="msg-val">Branch Location is required.</span> </td>
                    </tr>

                    <tr>
                        <td colspan="2"> <span ng-if="branchCtrl.flag == 'created'" class="msg-success">Branch successfully added.</span>
                            <span ng-if="branchCtrl.flag == 'failed'" class="msg-val">Branch already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="branchCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="branchCtrl.addBranch()" value="Add Branch"/> 
                                <input type="button" ng-click="branchCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="branchCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="branchCtrl.updateBranchDetail()" value="Update Branch"/> 	
                                <input type="button" ng-click="branchCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="branchCtrl.flag == 'deleted'" class="msg-success">Branch successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>User Name</th> <th>Branch Name</th> <th>Branch Location</th></tr>
                <tr ng-repeat="row in branchCtrl.obArray">
                    <td><span ng-bind="row.branchRegId"></span></td>
                    <td><span ng-bind="row.user.userName"></span></td>
                    <td><span ng-bind="row.branchName"></span></td>
                    <td><span ng-bind="row.branchLocation"></span></td>
                    <td>
                        <input type="button" ng-click="branchCtrl.deleteBranch(row.branchRegId)" value="Delete"/>
                        <input type="button" ng-click="branchCtrl.editBranch(row.branchRegId)" value="Edit"/>
                        <span ng-if="branchCtrl.flag == 'updated' && row.branchRegId == branchCtrl.updatedId" class="msg-success">Branch successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/branch_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 