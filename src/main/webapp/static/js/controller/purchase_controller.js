'use strict';

app.factory('Category', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/category/catlist/:categoryId', {categoryId: '@categoryId'},
                {
                    updateCategory: {method: 'PUT'}
                }
        );
    }]);
//Category is the entity, 
app.factory('SubCategory', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/subcategory/subcat/:subCategoryId', {subCategoryId: '@subCategoryId'},
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
// Here starts Vendor 
app.factory('Vendor', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/vendor/vendorlist/:vendorId', {vendorId: '@vendorId'},
                {
                    updateVendor: {method: 'PUT'}
                }
        );
    }]);
// Here starts Vendor 
app.factory('Purchase', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/purchase/purlist/:purId', {purId: '@purId'},
                {
                    updatePurchase: {method: 'PUT'}
                }
        );
    }]);
app.controller('PurchaseController', ['$scope', 'Category', 'SubCategory', 'Product', 'Vendor', 'Purchase', function ($scope, Category, SubCategory, Product, Vendor, Purchase) {
        
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.objArray4 = [];
        ob.objArray5 = [];
        ob.obj = new Purchase();
        ob.obj2 = new Category();
        ob.obj3 = new SubCategory();
        ob.obj4 = new Product();
        ob.obj5 = new Vendor();
        
//        get All Vendor
        ob.fetchAllObject = function () {
            ob.objArray = Purchase.query();
            $scope.names = ob.objArray2 = Category.query();
            $scope.names2 = ob.objArray3 = SubCategory.query();
            $scope.names3 = ob.objArray3 = Product.query();
            $scope.names4 = ob.objArray4 = Vendor.query();
        };
        console.log($scope.names+" Vendor");
        ob.fetchAllObject();
        
//        Add Category
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.purForm.$valid) {
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
        
//        Edit Vendor
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = Purchase.get({purId: id}, function () {
                ob.flag = 'edit';
            });
        };
        
//        Update Vendor
        ob.updatePurchaseDetail = function () {
            console.log('Inside update');
            if ($scope.purForm.$valid) {
                ob.obj.$updatePurchase(function (obj) {
                    console.log(obj);
                    ob.updatedId = obj.purId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        
//        Delete Category
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Purchase.delete({purId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        
//        Reset All
        ob.reset = function () {
            ob.obj = new Purchase();
            $scope.purForm.$setPristine();
        };
        
//        Cancel Update
        ob.cancelUpdate = function (id) {
            ob.obj = new Purchase();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]); 