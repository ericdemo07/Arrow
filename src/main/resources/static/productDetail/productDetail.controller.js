(function() 
	{
		angular.module('arrowApp').controller('ProductDetailController',ProductDetailController);
		ProductDetailController.$inject = ['$stateParams','$scope','QueryService'];
		
		function ProductDetailController($stateParams,$scope,QueryService) 
		{
			 $scope.productTypes = ['Headphones','Television'];

		}	
	}
)();