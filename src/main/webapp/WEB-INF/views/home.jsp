<%-- 
    Document   : home
    Created on : Jul 10, 2018, 10:56:13 AM
    Author     : R-34
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>-->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>-->
    </head>
    <body ng-app="myApp">
        <div ng-controller="PersonController as personCtrl">
            <h1> Spring MVC 4 REST + AngularJS </h1>
            <form name="personForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="personCtrl.flag != 'edit'">
                                <h3> Add New Person </h3> 
                            </div>
                            <div ng-if="personCtrl.flag == 'edit'">
                                <h3> Update Person for ID: {{ personCtrl.person.pid}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Name: </td> <td><input type="text" name="name" ng-model="personCtrl.person.name" required/> 
                            <span ng-show="personForm.name.$error.required" class="msg-val">Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Location: </td> <td> <input type="text" name="location" ng-model="personCtrl.person.location" required/> 
                            <span ng-show="personForm.location.$error.required" class="msg-val">Location is required.</span> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="personCtrl.flag == 'created'" class="msg-success">Person successfully added.</span>
                            <span ng-if="personCtrl.flag == 'failed'" class="msg-val">Person already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="personCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="personCtrl.addPerson()" value="Add Person"/> 
                                <input type="button" ng-click="personCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="personCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="personCtrl.updatePersonDetail()" value="Update Person"/> 	
                                <input type="button" ng-click="personCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="personCtrl.flag == 'deleted'" class="msg-success">Person successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>Name</th> <th>Location</th></tr>
                <tr ng-repeat="row in personCtrl.persons">
                    <td><span ng-bind="row.pid"></span></td>
                    <td><span ng-bind="row.name"></span></td>
                    <td><span ng-bind="row.location"></span></td>
                    <td>
                        <input type="button" ng-click="personCtrl.deletePerson(row.pid)" value="Delete"/>
                        <input type="button" ng-click="personCtrl.editPerson(row.pid)" value="Edit"/>
                        <span ng-if="personCtrl.flag == 'updated' && row.pid == personCtrl.updatedId" class="msg-success">Person successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/person_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 