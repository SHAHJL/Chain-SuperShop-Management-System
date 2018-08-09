'use strict';
//var app = angular.module('myApp', ['ngResource']);
//Category is the entity, 
app.factory('Category', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/category/catlist/:catId', {catId: '@catId'},
                {
                    updateCategory: {method: 'PUT'}
                }
        );
    }]);
//Category is the entity, 
app.factory('SubCategory', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/subcategory/subcat/:subCatId', {subCatId: '@subCatId'},
                {
                    updateSubCategory: {method: 'PUT'}
                }
        );
    }]);
//Product Controller starts here 
app.factory('Product', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/product/prolist/:productId', {productId: '@productId'},
                {
                    updateProduct: {method: 'PUT'}
                }
        );
    }]);
app.controller('ProductController', ['$scope', 'Category', 'SubCategory', 'Product', function ($scope, Category, SubCategory, Product) {
        
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.obj = new Product();
        ob.obj2 = new Category();
        ob.obj3 = new SubCategory();
        
//        get All Product & subcategory
        ob.fetchAllObject = function () {
            ob.objArray = Product.query();
            $scope.names = ob.objArray2 = Category.query();
            $scope.names2 = ob.objArray3 = SubCategory.query();
        };
        console.log($scope.names+"hello product sub category");
        ob.fetchAllObject();
        
//        Add Product
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.productForm.$valid) {
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
        
//        Edit Product
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = Product.get({productId: id}, function () {
                ob.flag = 'edit';
            });
//            ob.obj2 = Category.get({CategoryId: id}, function () {
////                ob.flag = 'edit';
//            });
//            ob.flag = 'edit';
        };
        
//        Update Product
        ob.updateProductDetail = function () {
            console.log('Inside update');
            if ($scope.productForm.$valid) {
                ob.obj.$updateProduct(function (obj) {
                    console.log(obj);
                    ob.updatedId = obj.productId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        
//        Delete Product
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Product.delete({productId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        
//        Reset All
        ob.reset = function () {
            ob.obj = new Product();
            $scope.productForm.$setPristine();
        };
        
//        Cancel Update
        ob.cancelUpdate = function (id) {
            ob.obj = new Product();
//            ob.obj2 = new Category();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]); 