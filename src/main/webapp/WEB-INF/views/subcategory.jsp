<%-- 
    Document   : subcategory
    Created on : Jul 13, 2018, 4:51:12 PM
    Author     : SHAH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Product SubCategory Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>-->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>-->
    </head>
    <body ng-app="myApp">
        <div ng-controller="SubCategoryController as subCatCtrl">
            <h1> SubCategory </h1>
            <form name="subCatForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="subCatCtrl.flag != 'edit'">
                                <h3> Add New SubCategory </h3> 
                            </div>
                            <div ng-if="subCatCtrl.flag == 'edit'">
                                <h3> Update SubCategory for ID: {{ subCatCtrl.obj.subCatId}} </h3> 
                            </div> </td>
                    </tr>

                    <tr>
                        <td>Category Name</td>
                        <td>
                            <select ng-model="subCatCtrl.obj.category" ng-options="x.catName for x in names">
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td>Sub Category Name: </td> <td><input type="text" name="subCatName" ng-model="subCatCtrl.obj.subCatName" required/> 
                            <span ng-show="subCatForm.subCatName.$error.required" class="msg-val">Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Sub Category Description: </td> <td> <input type="text" name="descriptipon" ng-model="subCatCtrl.obj.subCatDesc" required/> 
                            <span ng-show="subCatForm.subCatDesc.$error.required" class="msg-val">SubCategory Description is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Image: </td> <td> <input type="text" name="Image" ng-model="subCatCtrl.obj.imgPath" required/> 
                            <span ng-show="subCatForm.imgPath.$error.required" class="msg-val">Image Path is required.</span> </td>
                    </tr>

                    <tr>
                        <td colspan="2"> <span ng-if="subCatCtrl.flag == 'created'" class="msg-success">SubCategory successfully added.</span>
                            <span ng-if="subCatCtrl.flag == 'failed'" class="msg-val">SubCategory already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="subCatCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="subCatCtrl.addObject()" value="Add SubCategory"/> 
                                <input type="button" ng-click="subCatCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="subCatCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="subCatCtrl.updateSubCategoryDetail()" value="Update SubCategory"/> 	
                                <input type="button" ng-click="subCatCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="subCatCtrl.flag == 'deleted'" class="msg-success">SubCategory successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>Category Name</th> <th>Sub Category Name</th> <th>Description</th> <th>Image</th></tr>
                <tr ng-repeat="row in subCatCtrl.objArray">
                    <td><span ng-bind="row.subCatId"></span></td>
                    <td><span ng-bind="row.category.catName"></span></td>
                    <td><span ng-bind="row.subCatName"></span></td>
                    <td><span ng-bind="row.subCatDesc"></span></td>
                    <td><span ng-bind="row.imgPath"></span></td>
                    <td>
                        <input type="button" ng-click="subCatCtrl.deleteObject(row.subCatId)" value="Delete"/>
                        <input type="button" ng-click="subCatCtrl.editObject(row.subCatId)" value="Edit"/>
                        <span ng-if="subCatCtrl.flag == 'updated' && row.subCatId == subCatCtrl.updatedId" class="msg-success">SubCategory successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/subcategory_controller.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>
    </body>
</html> 