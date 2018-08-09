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
// Here starts Branch
app.factory('Branch', ['$resource', function ($resource){
        return $resource('http://localhost:8080/ChainSuperShop/branch/branchlist/:branchId', {branchId: '@branchRegId'},
	{
		updateBranch: {method: 'PUT'}
	}
                );
}]);
// Here starts Accept 
app.factory('Accept', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/accept/acceptlist/:accId', {accId: '@accId'},
                {
                    updateAccept: {method: 'PUT'}
                }
        );
    }]);
app.controller('AcceptController', ['$scope', 'Category', 'SubCategory', 'Product', 'Branch', 'Accept', function ($scope, Category, SubCategory, Product, Branch, Accept) {
        
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.objArray4 = [];
        ob.objArray5 = [];
        ob.obj = new Accept();
        ob.obj2 = new Category();
        ob.obj3 = new SubCategory();
        ob.obj4 = new Product();
        ob.obj5 = new Branch();
        
//        get All Accept
        ob.fetchAllObject = function () {
            ob.objArray = Accept.query();
            $scope.names = ob.objArray2 = Category.query();
            $scope.names2 = ob.objArray3 = SubCategory.query();
            $scope.names3 = ob.objArray3 = Product.query();
            $scope.names4 = ob.objArray4 = Branch.query();
        };
        console.log($scope.names+" acc");
        ob.fetchAllObject();
        
//        Add Accept
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.accForm.$valid) {
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
        
//        Edit Accept
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = Accept.get({accId: id}, function () {
                ob.flag = 'edit';
            });
        };
        
//        Update Accept
        ob.updateAcceptDetail = function () {
            console.log('Inside update');
            if ($scope.accForm.$valid) {
                ob.obj.$updateAccept(function (obj) {
                    console.log(obj);
                    ob.updatedId = obj.accId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        
//        Delete Accept
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Accept.delete({accId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        
//        Reset All
        ob.reset = function () {
            ob.obj = new Accept();
            $scope.accForm.$setPristine();
        };
        
//        Cancel Update
        ob.cancelUpdate = function (id) {
            ob.obj = new Accept();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]); 