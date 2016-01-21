(function() 
	{
		angular.module('arrowApp',
		['ui.router']).config(config);

		config.$inject = ['$stateProvider','$urlRouterProvider'];
		
		function config($stateProvider,$urlRouterProvider) 
		{
			$stateProvider
			.state('searchQuery', 
			{
				url : '/searchquery',
				controller : 'SearchQueryController',
				templateUrl : 'searchQuery/searchQuery.view.html',
				controllerAs : 'vm'
			});
		}
	}
)();