'use strict';
//var app = angular.module('myApp', ['ngResource']);
//Category is the entity, 
app.factory('Category', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/category/catlist/:categoryId', {categoryId: '@catId'},
                {
                    updateCategory: {method: 'PUT'}
                }
        );
    }]);
//Category is the entity, 
app.factory('SubCategory', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/subcategory/subcat/:subCategoryId', {subCategoryId: '@subCatId'},
                {
                    updateSubCategory: {method: 'PUT'}
                }
        );
    }]);
app.controller('SubCategoryController', ['$scope', 'Category', 'SubCategory', function ($scope, Category, SubCategory) {
        
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.obj = new SubCategory();
        ob.obj2 = new Category();
        
//        get All Category & subcategory
        ob.fetchAllObject = function () {
            ob.objArray = SubCategory.query();
            $scope.names = ob.objArray2 = Category.query();
        };
        console.log($scope.names+"hello product sub category");
        ob.fetchAllObject();
        
//        Add SubCategory
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.subCatForm.$valid) {
                ob.obj.$save(function (obj) {
                    console.log(obj);
                    ob.flag = 'created';
                    ob.reset();
                    ob.fetchAllObject();
                },
                        function (err) {
                            console.log(err.status);
                            ob.flag = 'failed';
                        }
                );
            }
        };
        
//        Edit SubCategory
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = SubCategory.get({subCategoryId: id}, function () {
                ob.flag = 'edit';
            });
//            ob.obj2 = Category.get({CategoryId: id}, function () {
////                ob.flag = 'edit';
//            });
//            ob.flag = 'edit';
        };
        
//        Update SubCategory
        ob.updateSubCategoryDetail = function () {
            console.log('Inside update');
            if ($scope.subCatForm.$valid) {
                ob.obj.$updateSubCategory(function (obj) {
                    console.log(obj);
                    ob.updatedId = obj.subCatId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        
//        Delete SubCategory
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = SubCategory.delete({subCategoryId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        
//        Reset All
        ob.reset = function () {
            ob.obj = new SubCategory();
            $scope.subCatForm.$setPristine();
        };
        
//        Cancel Update
        ob.cancelUpdate = function (id) {
            ob.obj = new SubCategory();
            ob.obj2 = new Category();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]); 