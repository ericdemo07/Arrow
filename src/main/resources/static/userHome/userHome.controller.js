(function() {
	angular.module('arrowApp').controller('UserHomeController', UserHomeController);
	UserHomeController.$inject = [ '$scope', 'UserHomeService', '$state', '$stateParams' ];
	
	function UserHomeController($scope, UserHomeService, $state, $stateParams) 
	{
		//$scope.products = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'];
		var productTypeSelected;
		var brandNameSelected;
		var modelNameSelected;
		console.log("hello hello 11");
		
		UserHomeService.UserData().then(
				function(response, $stateProvider, $urlRouterProvider) {
					$scope.products = response;
				});
		
		$scope.getProductDetail = function()
		 {
			var temp = this.vm;
			console.log("hello hello 22");
			$state.go('productHome', {a:"a"
			});
		 }
	}
})();