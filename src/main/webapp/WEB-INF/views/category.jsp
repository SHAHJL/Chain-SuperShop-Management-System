<%-- 
    Document   : category
    Created on : Jul 13, 2018, 10:37:08 AM
    Author     : SHAH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Product Category Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>-->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>-->
    </head>
    <body ng-app="myApp">
        <div ng-controller="CategoryController as catCtrl">
            <h1> Category </h1>
            <form name="catForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="catCtrl.flag != 'edit'">
                                <h3> Add New Category </h3> 
                            </div>
                            <div ng-if="catCtrl.flag == 'edit'">
                                <h3> Update Category for ID: {{ catCtrl.obj.catId}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Name: </td> <td><input type="text" name="name" ng-model="catCtrl.obj.catName" required/> 
                            <span ng-show="catForm.catName.$error.required" class="msg-val">Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Location: </td> <td> <input type="text" name="descriptipon" ng-model="catCtrl.obj.catDesc" required/> 
                            <span ng-show="catForm.catDesc.$error.required" class="msg-val">Category Description is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Location: </td> <td> <input type="text" name="Image" ng-model="catCtrl.obj.imgPath" required/> 
                            <span ng-show="catForm.imgPath.$error.required" class="msg-val">Image Path is required.</span> </td>
                    </tr>

                    <tr>
                        <td colspan="2"> <span ng-if="catCtrl.flag == 'created'" class="msg-success">Category successfully added.</span>
                            <span ng-if="catCtrl.flag == 'failed'" class="msg-val">Category already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="catCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="catCtrl.addObject()" value="Add Category"/> 
                                <input type="button" ng-click="catCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="catCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="catCtrl.updateCategoryDetail()" value="Update Category"/> 	
                                <input type="button" ng-click="catCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="catCtrl.flag == 'deleted'" class="msg-success">Category successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>Name</th> <th>Description</th> <th>Image</th></tr>
                <tr ng-repeat="row in catCtrl.objArray">
                    <td><span ng-bind="row.catId"></span></td>
                    <td><span ng-bind="row.catName"></span></td>
                    <td><span ng-bind="row.catDesc"></span></td>
                    <td><span ng-bind="row.imgPath"></span></td>
                    <td>
                        <input type="button" ng-click="catCtrl.deleteObject(row.catId)" value="Delete"/>
                        <input type="button" ng-click="catCtrl.editObject(row.catId)" value="Edit"/>
                        <span ng-if="catCtrl.flag == 'updated' && row.catId == catCtrl.updatedId" class="msg-success">Category successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/category_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 