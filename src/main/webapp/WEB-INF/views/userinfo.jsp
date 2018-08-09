<%-- 
    Document   : user
    Created on : Jul 12, 2018, 10:07:19 AM
    Author     : R-34
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> User Management </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="UserController as userCtrl">
            <h1> User User </h1>
            <form name="userForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="userCtrl.flag != 'edit'">
                                <h3> Add New User </h3> 
                            </div>
                            <div ng-if="userCtrl.flag == 'edit'">
                                <h3> Update User for ID: {{ userCtrl.obj.userId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Role ID:</td>
                        <td>
                            <select ng-model="userCtrl.obj.userRole" ng-options="x.roleName for x in names"></select>
                        </td>
                    </tr>
                    
                    <tr>
                    <div ng-if="userCtrl.flag != 'edit'" ng-focus="userCtrl.obj.firstName">
                        <td>First Name: </td> <td><input type="text" name="name" ng-model="userCtrl.obj.firstName" required/> 
                            <span ng-show="userForm.firstName.$error.required" class="msg-val">First Name is required.</span> </td>
                    </div>                        
                    </tr>
                    
                    <tr>
                        <td>Last Name: </td> <td><input type="text" name="name" ng-model="userCtrl.obj.lastName" required/> 
                            <span ng-show="userForm.lastName.$error.required" class="msg-val">Last Name is required.</span> </td>
                    </tr>
                    
                    <tr>
                        <td>Reg Date</td> <td><input type="text" name="regDate" ng-model="userCtrl.obj.regDate" required/> 
                            <span ng-show="userForm.regDate.$error.required" class="msg-val">Reg Date is required.</span> </td>
                    </tr>
                    
                    <tr>
                        <td>userName: </td> <td><input type="text" name="userName" ng-model="userCtrl.obj.userName" required/> 
                            <span ng-show="userForm.userName.$error.required" class="msg-val">LuserName is required.</span> </td>
                    </tr>
                    
                    <tr>
                        <td>userPassword: </td> <td><input type="text" name="userPassword" ng-model="userCtrl.obj.userPassword" required/> 
                            <span ng-show="userForm.userPassword.$error.required" class="msg-val">Last userPassword is required.</span> </td>
                    </tr>
                    
                    <tr>
                        <td>email: </td> <td><input type="text" name="email" ng-model="userCtrl.obj.email" required/> 
                            <span ng-show="userForm.email.$error.required" class="msg-val">email Name is required.</span> </td>
                    </tr>
                    
                    <tr>
                        <td>phone: </td> <td><input type="text" name="phone" ng-model="userCtrl.obj.phone" required/> 
                            <span ng-show="userForm.phone.$error.required" class="msg-val">phone Name is required.</span> </td>
                    </tr>
                    
                    <tr>
                        <td>Last Name Again: </td> <td><input type="text" name="name" ng-model="userCtrl.obj.lastName" required/> 
                            <span ng-show="userForm.lastName.$error.required" class="msg-val">Last Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="userCtrl.flag == 'created'" class="msg-success">User successfully added.</span>
                            <span ng-if="userCtrl.flag == 'failed'" class="msg-val">User already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="userCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="userCtrl.addObject()" value="Add User"/> 
                                <input type="button" ng-click="userCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="userCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="userCtrl.updateUserDetail()" value="Update User"/> 	
                                <input type="button" ng-click="userCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="userCtrl.flag == 'deleted'" class="msg-success">User successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr>
                    <th>ID </th>
                    <th>Role NAme</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Registration Date</th>
                    <th>Luser Name</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>Phone</th>
                </tr>
                <tr ng-repeat="row in userCtrl.objArray">
                    <td><span ng-bind="row.userId"></span></td>
                    <td><span ng-bind="row.userRole.roleName"></span></td>
                    <td><span ng-bind="row.firstName"></span></td>
                    <td><span ng-bind="row.lastName"></span></td>
                    <td><span ng-bind="row.regDate"></span></td>
                    <td><span ng-bind="row.userName"></span></td>
                    <td><span ng-bind="row.userPassword"></span></td>
                    <td><span ng-bind="row.email"></span></td>
                    <td><span ng-bind="row.phone"></span></td>
                    <td>
                        <input type="button" ng-click="userCtrl.deleteObject(row.userId)" value="Delete"/>
                        <input type="button" ng-click="userCtrl.editObject(row.userId)" value="Edit"/>
                        <span ng-if="userCtrl.flag == 'updated' && row.userId == userCtrl.updatedId" class="msg-success">User successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/user_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 