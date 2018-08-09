'user strict';

app.factory('UserRole', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/roleinfo/userrole/:roleId', {roleId: '@rId'},
                {
                    updateUserRole: {method: 'PUT'}
                }
        );
    }]);
app.controller('UserRoleController', ['$scope', 'UserRole', function ($scope, UserRole) {
        
        var ob = this;
        ob.objArray = [];
        ob.obj = new UserRole();
        
//        get All UserRole
        ob.fetchAllObject = function () {
            ob.objArray = UserRole.query();
        };
        ob.fetchAllObject();
        
//        Add UserRole
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.roleForm.$valid) {
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
        
//        Edit UserRole
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = UserRole.get({roleId: id}, function () {
                ob.flag = 'edit';
            });
        };
        
//        Update UserRole
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.roleForm.$valid) {
                ob.obj.$updateUserRole(function (obj) {
                    console.log(obj);
                    ob.updatedId = obj.rId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        
//        Delete UserRole
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = UserRole.delete({roleId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        
//        Reset All
        ob.reset = function () {
            ob.obj = new UserRole();
            $scope.roleForm.$setPristine();
        };
        
//        Cancel Update
        ob.cancelUpdate = function (id) {
            ob.obj = new UserRole();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]); 