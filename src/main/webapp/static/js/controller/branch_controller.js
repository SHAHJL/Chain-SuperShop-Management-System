'use strict';

app.factory('User', ['$resource', function ($resource){
        return $resource('http://localhost:8080/ChainSuperShop/userinfo/user/:userId', {userId: '@userId'},
	{
		updateUser: {method: 'PUT'}
	}
                );
}]);

app.factory('Branch', ['$resource', function ($resource){
        return $resource('http://localhost:8080/ChainSuperShop/branch/branchlist/:branchId', {branchId: '@branchRegId'},
	{
		updateBranch: {method: 'PUT'}
	}
                );
}]);

app.controller('BranchController', ['$scope', 'User', 'Branch', function ($scope, User, Branch){
        
        var ob = this;
        ob.obArray = [];
        ob.obArray2 = [];
        ob.obj = new Branch();
        ob.obj2 = new User();
        
        ob.fetchAllBranch = function (){
          ob.obArray = Branch.query();  
          $scope.users = ob.obArray2 = User.query();  
        };
        console.log($scope.users+" Request");
        ob.fetchAllBranch();
        
        ob.addBranch = function (){
          console.log('Inside save');
            if ($scope.branchForm.$valid) {
                ob.obj.$save(function (obj) {
                    console.log(obj);
                    ob.flag = 'created';
                    ob.reset();
                    ob.fetchAllBranch();
                },
                        function (err) {
                            console.log(err.status);
                            ob.flag = 'failed';
                        }
                );
            }
        };
        
        ob.editBranch = function (id) {
            console.log('Inside edit');
            ob.obj = Branch.get({branchId: id}, function () {
                ob.flag = 'edit';
            });
        };
        
        ob.updateBranchDetail = function () {
            console.log('Inside update');
            if ($scope.branchForm.$valid) {
                ob.obj.$updateBranch(function (object) {
                    console.log(object);
                    ob.updatedId = object.branchRegId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllBranch();
                });
            }
        };
        
        ob.deleteBranch = function (id) {
            console.log('Inside delete');
            ob.obj = Branch.delete({branchId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllBranch();
            });
        };
        
        ob.reset = function () {
          ob.obj = new Branch();
          $scope.branchForm.$setPristine();
        };
        
        ob.cancelUpdate = function (id) {
            ob.obj = new Branch();
            ob.flag = '';
            ob.fetchAllBranch();
        };
}]);