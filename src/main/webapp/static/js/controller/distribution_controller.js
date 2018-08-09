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
// Here starts Distribution 
app.factory('Distribution', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/distribution/distlist/:distId', {distId: '@distId'},
                {
                    updateDistribution: {method: 'PUT'}
                }
        );
    }]);
app.controller('DistributionController', ['$scope', 'Category', 'SubCategory', 'Product', 'Branch', 'Distribution', function ($scope, Category, SubCategory, Product, Branch, Distribution) {
        
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.objArray4 = [];
        ob.objArray5 = [];
        ob.obj = new Distribution();
        ob.obj2 = new Category();
        ob.obj3 = new SubCategory();
        ob.obj4 = new Product();
        ob.obj5 = new Branch();
        
//        get All Distribution
        ob.fetchAllObject = function () {
            ob.objArray = Distribution.query();
            $scope.names = ob.objArray2 = Category.query();
            $scope.names2 = ob.objArray3 = SubCategory.query();
            $scope.names3 = ob.objArray3 = Product.query();
            $scope.names4 = ob.objArray4 = Branch.query();
        };
        console.log($scope.names+" dist");
        ob.fetchAllObject();
        
//        Add Distribution
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.distForm.$valid) {
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
        
//        Edit Distribution
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = Distribution.get({distId: id}, function () {
                ob.flag = 'edit';
            });
        };
        
//        Update Distribution
        ob.updateDistributionDetail = function () {
            console.log('Inside update');
            if ($scope.distForm.$valid) {
                ob.obj.$updateDistribution(function (obj) {
                    console.log(obj);
                    ob.updatedId = obj.distId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        
//        Delete Distribution
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Distribution.delete({distId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        
//        Reset All
        ob.reset = function () {
            ob.obj = new Distribution();
            $scope.distForm.$setPristine();
        };
        
//        Cancel Update
        ob.cancelUpdate = function (id) {
            ob.obj = new Distribution();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]); 