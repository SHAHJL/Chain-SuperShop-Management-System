'user strict';

app.factory('UserRole', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/roleinfo/userrole/:roleId', {roleId: '@rId'},
                {
                    updateUserRole: {method: 'PUT'}
                }
        );
    }]);
//Category is the entity, 
app.factory('User', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/ChainSuperShop/userinfo/user/:userId', {userId: '@userId'},
                {
                    updateUser: {method: 'PUT'}
                }
        );
    }]);
app.controller('UserController', ['$scope', 'UserRole', 'User', function ($scope, UserRole, User) {
        
        var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.obj = new User();
        ob.obj2 = new UserRole();
        
//        get All User
        ob.fetchAllObject = function () {
            ob.objArray = User.query();
            $scope.names = ob.objArray2 = UserRole.query();
        };
        console.log($scope.names+"hello Userrrr");
        ob.fetchAllObject();
        
//        Add User
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.userForm.$valid) {
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
        
//        Edit User
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = User.get({userId: id}, function () {
                ob.flag = 'edit';
            });
        };
        
//        Update User
        ob.updateUserDetail = function () {
            console.log('Inside update');
            if ($scope.userForm.$valid) {
                ob.obj.$updateUser(function (obj) {
                    console.log(obj);
                    ob.updatedId = obj.userId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        
//        Delete User
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = User.delete({userId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        
//        Reset All
        ob.reset = function () {
            ob.obj = new User();
            $scope.userForm.$setPristine();
        };
        
//        Cancel Update
        ob.cancelUpdate = function (id) {
            ob.obj = new User();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]); 