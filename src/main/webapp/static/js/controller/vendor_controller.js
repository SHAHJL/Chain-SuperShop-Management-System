'use strict';

app.factory('User', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/userinfo/user/:userId', {userId: '@userId'},
                {
                    updateUser: {method: 'PUT'}
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
app.controller('VendorController', ['$scope', 'User', 'Vendor', function ($scope, User, Vendor) {
        
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.obj = new Vendor();
        ob.obj2 = new User();
        
//        get All Vendor
        ob.fetchAllObject = function () {
            ob.objArray = Vendor.query();
            $scope.names = ob.objArray2 = User.query();
        };
        console.log($scope.names+" Vendor");
        ob.fetchAllObject();
        
//        Add Category
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.vendorForm.$valid) {
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
            ob.obj = Vendor.get({vendorId: id}, function () {
                ob.flag = 'edit';
            });
        };
        
//        Update Vendor
        ob.updateVendorDetail = function () {
            console.log('Inside update');
            if ($scope.vendorForm.$valid) {
                ob.obj.$updateVendor(function (obj) {
                    console.log(obj);
                    ob.updatedId = obj.vendorId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        
//        Delete Category
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Vendor.delete({vendorId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        
//        Reset All
        ob.reset = function () {
            ob.obj = new Vendor();
            $scope.vendorForm.$setPristine();
        };
        
//        Cancel Update
        ob.cancelUpdate = function (id) {
            ob.obj = new Vendor();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]); 