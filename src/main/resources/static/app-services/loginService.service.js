(function() 
	{
		angular.module('arrowApp').factory('LoginService',UserLoginService);
		UserLoginService.$inject = ['$http','$location'];
		
		function UserLoginService($http, $location) 
		{
			var service = {};
			service.Login = Login;
			
			return service;
			function Login(loginData) 
			{
				console.log ("Query"+loginData);
				var request = $http(
				{
					method : "post",
					url : "/arrow/login",
					data : loginData
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