//var app = angular.module('myApp', ['ngResource']);
//customer is the entity, 
app.factory('Customer', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/customer/custlist/:customerId', {customerId: '@customerId'},
                {
                    updateCustomer: {method: 'PUT'}
                }
        );
    }]);
app.controller('CustomerController', ['$scope', 'Customer', function ($scope, Customer) {
        
        var ob = this;
        ob.objArray = [];
        ob.obj = new Customer();
        
//        get All Customer
        ob.fetchAllCustomer = function () {
            ob.objArray = Customer.query();
        };
        ob.fetchAllCustomer();
        
//        Add Customer
        ob.addCustomer = function () {
            console.log('Inside save');
            if ($scope.customerForm.$valid) {
                ob.obj.$save(function (obj) {
                    console.log(obj);
                    ob.flag = 'created';
                    ob.reset();
                    ob.fetchAllCustomer();
                },
                        function (err) {
                            console.log(err.status);
                            ob.flag = 'failed';
                        }
                );
            }
        };
        
//        Edit Customer
        ob.editCustomer = function (id) {
            console.log('Inside edit');
            ob.obj = Customer.get({customerId: id}, function () {
                ob.flag = 'edit';
            });
        };
        
//        Update Customer
        ob.updateCustomerDetail = function () {
            console.log('Inside update');
            if ($scope.customerForm.$valid) {
                ob.obj.$updateCustomer(function (obj) {
                    console.log(obj);
                    ob.updatedId = obj.customerId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllCustomer();
                });
            }
        };
        
//        Delete Customer
        ob.deleteCustomer = function (id) {
            console.log('Inside delete');
            ob.obj = Customer.delete({customerId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllCustomer();
            });
        };
        
//        Reset All
        ob.reset = function () {
            ob.obj = new Customer();
            $scope.customerForm.$setPristine();
        };
        
//        Cancel Update
        ob.cancelUpdate = function (id) {
            ob.obj = new Customer();
            ob.flag = '';
            ob.fetchAllCustomer();
        };
    }]); 