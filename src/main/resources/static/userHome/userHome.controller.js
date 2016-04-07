(function() {
	angular.module('arrowApp').controller('UserHomeController', UserHomeController);
	UserHomeController.$inject = [ '$scope', 'QueryService', '$state', '$stateParams' ];
	
	function UserHomeController($scope, QueryService, $state, $stateParams) 
	{
		$scope.products = [ 'Headphones', 'Television', 'Refrigrator' ];
		var productTypeSelected;
		var brandNameSelected;
		var modelNameSelected;
	}
})();