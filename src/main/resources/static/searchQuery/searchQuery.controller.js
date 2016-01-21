(function() 
	{
		angular.module('arrowApp').controller('SearchQueryController',SearchQueryController);
		SearchQueryController.$inject = ['$stateParams','$scope','QueryService'];
		
		function SearchQueryController($stateParams,$scope,QueryService) 
		{
			 $scope.productTypes = ['Headphones','Television'];
			 $scope.onChanged = function() 
			 {
				 var currentItem = this.item;
				 
				 QueryService.BrandNameSearchQuery("abc").then(function(response) 
				 {
					 console.log("Query Service is up and running!");
				 });
				 console.log("Cool How do you do it!");
			 }
		}
	}
)();