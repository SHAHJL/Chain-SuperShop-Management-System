'use strict';


app.factory('Branch', ['$resource', function ($resource){
        return $resource('http://localhost:8080/ChainSuperShop/branch/branchlist/:branchId', {branchId: '@branchRegId'},
	{
		updateBranch: {method: 'PUT'}
	}
                );
}]);
//Customer is the entity, 
app.factory('Customer', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/customer/custlist/:customerId', {customerId: '@customerId'},
                {
                    updateCustomer: {method: 'PUT'}
                }
        );
    }]);
//Sales is the entity, 
app.factory('Sales', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/sales/saleslist/:saleId', {saleId: '@saleId'},
                {
                    updateSales: {method: 'PUT'}
                }
        );
    }]);

app.controller('SalesController', ['$scope', 'Branch', 'Customer', 'Sales', function ($scope, Branch, Customer, Sales) {
        
        var ob = this;
        ob.objArray = [];
        ob.objArray3 = [];
        ob.objArray4 = [];
        ob.obj = new Sales();
        ob.obj3 = new Branch();
        ob.obj4 = new Customer();
        
//        get All 
        ob.fetchAllObject = function () {
            ob.objArray = Sales.query();
            ob.objArray3 = Branch.query();
            ob.objArray4 = Customer.query();
            $scope.names = ob.objArray3 = Branch.query();
            $scope.names3 = ob.objArray4 = Customer.query();
        };
        console.log($scope.names+" saless");
        ob.fetchAllObject();
        
//        Add 
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.salesForm.$valid) {
                ob.obj.$save(function (obj) {
                    ob.obj2.$save();
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
            ob.obj = Sales.get({saleId: id}, function () {
                ob.flag = 'edit';
            });
        };
        
//        Update saleDetail
        ob.updateSalesDetail = function () {
            console.log('Inside update');
            if ($scope.salesForm.$valid) {
                ob.obj.$updateSales(function (obj) {
                    console.log(obj);
                    ob.updatedId = obj.saleId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        
//        Delete saleDetail
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Sales.delete({saleId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        
//        Reset All
        ob.reset = function () {
            ob.obj = new Sales();
            $scope.salesForm.$setPristine();
        };
        
//        Cancel Update
        ob.cancelUpdate = function (id) {
            ob.obj = new Sales();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]); 