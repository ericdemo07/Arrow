(function() 
	{
		angular.module('arrowApp').factory('QueryService',QueryService);
		QueryService.$inject = ['$http','$location'];
		
		function QueryService($http, $location) 
		{
			var service = {};
			service.BrandNameSearchQuery = BrandNameSearchQuery;
			service.ModelNameSearchQuery = ModelNameSearchQuery;

			return service;
			function BrandNameSearchQuery(productType) 
			{
				console.log ("Query"+productType);
				var request = $http(
				{
					method : "post",
					url : "/arrow/searchbrand",
					data : productType
				});
				return request.then(handleSuccess, handleError('Faliure'));
			}
			function ModelNameSearchQuery(brandName) 
			{
				console.log ("BrandName : ["+brandName);
				var request = $http(
				{
					method : "post",
					url : "/arrow/searchmodel",
					data : brandName
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