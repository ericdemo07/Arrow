(function() 
	{
		angular.module('arrowApp').controller('SearchQueryController',SearchQueryController);
		SearchQueryController.$inject = ['$scope','QueryService'];
		
		function SearchQueryController($scope,QueryService) 
		{
			 $scope.productTypes = ['Headphones','Television'];
			 
			 $scope.getBrandNames = function() 
			 {
				 var productTypeSelected = this.vm.productType.value;
				 QueryService.BrandNameSearchQuery(productTypeSelected).then(function(response) 
				 {
					 $scope.selected = undefined;
					 $scope.brandNamesResponse = response;
				 });
			 }
		
			 $scope.getModelNames = function() 
			 {
				 var brandNameSelected = this.vm.brandName.value;
				 console.log("brandNameSelected :["+brandNameSelected);

				 QueryService.ModelNameSearchQuery(brandNameSelected).then(function(response) 
				 {
					 $scope.modelNamesResponse = response;
					 console.log("BrandModelSearchQuery Service is up and running! "+response);
				 });
			 }
		}	
	}
)();