(function() 
	{
		angular.module('arrowApp').controller('SearchQueryController',SearchQueryController);
		SearchQueryController.$inject = ['$stateParams','$scope','QueryService'];
		
		function SearchQueryController($stateParams,$scope,QueryService) 
		{
			 $scope.productTypes = ['Headphones','Television'];
			 $scope.getBrandNames = function() 
			 {
				 var productTypeSelected = this.vm.productType.value;
				 
				 QueryService.BrandNameSearchQuery(productTypeSelected).then(function(response) 
				 {
					 $scope.selected = undefined;
					 $scope.states = response;
				 });
			 }
			 $scope.getModelNames = function() 
			 {
				 var productTypeSelected = this.vm.productType.value;
				 
				 QueryService.BrandNameSearchQuery(productTypeSelected).then(function(response) 
				 {
					 $scope.selected = undefined;
					 $scope.states = response;
					 console.log("Query Service is up and running!"+response);
				 });
			 }
		}
	}
)();