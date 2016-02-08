(function() 
	{
		angular.module('arrowApp').controller('SearchQueryController',SearchQueryController);
		SearchQueryController.$inject = ['$scope','QueryService'];
		
		function SearchQueryController($scope,QueryService) 
		{
			 $scope.productTypes = ['Headphones','Television'];
			 var productTypeSelected;
			 var brandNameSelected;
			 var modelNameSelected;
			 $scope.getBrandNames = function() 
			 {
				 productTypeSelected = this.vm.productType.value;
				 QueryService.BrandNameSearchQuery(productTypeSelected).then(function(response) 
				 {
					 $scope.selected = undefined;
					 $scope.brandNamesResponse = response;
				 });
			 }
		
			 $scope.getModelNames = function() 
			 {
				 brandNameSelected = this.vm.brandName.value;
				 console.log("brandNameSelected :["+brandNameSelected);

				 QueryService.ModelNameSearchQuery(brandNameSelected).then(function(response) 
				 {
					 $scope.modelNamesResponse = response;
					 console.log("BrandModelSearchQuery Service is up and running! "+response);
				 });
			 }
			 
			 $scope.submitProductDetails = function() 
			 {
				 modelNameSelected = this.vm.modelNameSelected.value;
				 console.log("Submit product details "+productTypeSelected);
				 console.log("Submit product details "+brandNameSelected);
				 console.log("Submit product details "+modelNameSelected);
			 }
		}	
	}
)();