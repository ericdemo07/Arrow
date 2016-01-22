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
				 
				 QueryService.BrandNameSearchQuery("abc").then(function(response) 
				 {
					 console.log("Query Service is up and running!");
				 });
				 console.log("Cool How do you do it!");
				 console.log(productTypeSelected);

			 }
			 $scope.selected = undefined;
			 $scope.states = ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Dakota', 'North Carolina', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'];

			 $scope.getProducts = function() 
			 {
				 var currentItem = this.item;
				 var movies;

				 movies = ["The Wolverine", "The Smurfs 2", "The Mortal Instruments: City of Bones", "Drinking Buddies", "All the Boys Love Mandy Lane", "The Act Of Killing", "Red 2", "Jobs", "Getaway", "Red Obsession", "2 Guns", "The World's End", "Planes", "Paranoia", "The To Do List", "Man of Steel"];
				 console.log("getProducts");
			 }
		}
	}
)();