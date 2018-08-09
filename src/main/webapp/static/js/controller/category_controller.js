//var app = angular.module('myApp', ['ngResource']);
//Category is the entity, 
app.factory('Category', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/category/catlist/:categoryId', {categoryId: '@catId'},
                {
                    updateCategory: {method: 'PUT'}
                }
        );
    }]);
app.controller('CategoryController', ['$scope', 'Category', function ($scope, Category) {
        
        var ob = this;
        ob.objArray = [];
        ob.obj = new Category();
        
//        get All Category
        ob.fetchAllObject = function () {
            ob.objArray = Category.query();
        };
        ob.fetchAllObject();
        
//        Add Category
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.catForm.$valid) {
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
        
//        Edit Category
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = Category.get({categoryId: id}, function () {
                ob.flag = 'edit';
            });
        };
        
//        Update Category
        ob.updateCategoryDetail = function () {
            console.log('Inside update');
            if ($scope.catForm.$valid) {
                ob.obj.$updateCategory(function (obj) {
                    console.log(obj);
                    ob.updatedId = obj.catId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        
//        Delete Category
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Category.delete({categoryId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        
//        Reset All
        ob.reset = function () {
            ob.obj = new Category();
            $scope.catForm.$setPristine();
        };
        
//        Cancel Update
        ob.cancelUpdate = function (id) {
            ob.obj = new Category();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]); 