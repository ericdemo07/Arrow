(function() 
	{
		angular.module('arrowApp').controller('SearchQueryController',SearchQueryController);
		SearchQueryController.$inject = ['$scope','QueryService','$state','$stateParams'];
		
		function SearchQueryController($scope,QueryService,$state,$stateParams) 
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

				 QueryService.ModelNameSearchQuery(brandNameSelected).then(function(response) 
				 {
					 $scope.modelNamesResponse = response;
				 });
			 }
			 
			 $scope.submitProductDetails = function() 
			 {
				 modelNameSelected = this.vm.modelNameSelected.value;
				 var searchQuery = {productTypeSelected:productTypeSelected,brandNameSelected:brandNameSelected,modelNameSelected:modelNameSelected};
				 
				 console.log("Submit product details "+productTypeSelected);
				 console.log("Submit product details "+brandNameSelected);
				 console.log("Submit product details "+searchQuery);
				 
				 $state.go('productDetail', {productTypeSelected:productTypeSelected,brandNameSelected:brandNameSelected,modelNameSelected:modelNameSelected});
			 }
		}	
	}
)();