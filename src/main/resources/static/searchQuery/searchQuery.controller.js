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
				 var brandNameSelected = this.vm.brandName.value;
				 console.log("brandNameSelected :["+brandNameSelected);

				 QueryService.BrandModelSearchQuery(brandNameSelected).then(function(response) 
				 {
					 $scope.brandModels = response;
					 console.log("BrandModelSearchQuery Service is up and running! "+response);
				 });
			 }
		}	
	}
)();