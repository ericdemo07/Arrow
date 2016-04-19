(function() {
	angular.module('arrowApp').controller('UserHomeController', UserHomeController);
	UserHomeController.$inject = [ '$scope', 'QueryService', '$state', '$stateParams' ];
	
	function UserHomeController($scope, QueryService, $state, $stateParams) 
	{
		$scope.products = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'];
		var productTypeSelected;
		var brandNameSelected;
		var modelNameSelected;
	}
})();