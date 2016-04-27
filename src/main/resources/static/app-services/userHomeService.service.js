(function() 
	{
		angular.module('arrowApp').factory('UserHomeService',UserHomeService);
		UserHomeService.$inject = ['$http','$location'];
		
		function UserHomeService($http, $location) 
		{
			var service = {};
			service.UserData = UserData;
			
			return service;
			function UserData() 
			{
				console.log ("Hello folks");

				var request = $http(
				{
					method : "post",
					url : "/arrow/userhome",
					data : "hello"
				});
				return request.then(handleSuccess, handleError('Faliure'));
			}	
			function handleSuccess(data) 
			{
				product = data.data;
				//console.log(product[0]);
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