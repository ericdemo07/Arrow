(function() 
	{
		angular.module('arrowApp').controller('UserLoginController',UserLoginController);
		UserLoginController.$inject = ['$scope','$stateParams', '$state','LoginService'];
		
		function UserLoginController($scope,$stateParams,$state,LoginService) 
		{
			 $scope.userLogin = function()
			 {
				 var temp = this.vm;
				 LoginService.Login(temp).then(function(response) 
				 {
				 });
			 }
		}	
	}
)();