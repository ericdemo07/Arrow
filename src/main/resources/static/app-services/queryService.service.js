(function() 
	{
		angular.module('arrowApp').factory('QueryService',QueryService);
		QueryService.$inject = ['$http','$location'];
		
		function QueryService($http, $location) 
		{
			var service = {};
			service.BrandNameSearchQuery = BrandNameSearchQuery;
			return service;
			function BrandNameSearchQuery(query) 
			{
				console.log ("Query"+query);
				var request = $http(
				{
					method : "post",
					url : "/arrow/searchquery",
					data : query
				});
				return request.then(handleSuccess, handleError('Faliure'));
			}
			function handleSuccess(data) 
			{
				product = data.data;
				console.log(product[0]);
				return product;
			}
			function handleError(error) 
			{
				return function() 
				{
					return 
					{
						success : false
					};
				};
			}
		}
	}
)();