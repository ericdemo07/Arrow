(function() 
	{
		angular.module('arrowApp',
		['ui.router','ui.bootstrap','ngFileUpload']).config(config);

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
			$stateProvider
			.state('productDetail', 
			{
				url : '/productdetail',
				controller : 'ProductDetailController',
				templateUrl : 'productDetail/productDetail.view.html',
				controllerAs : 'vm'
			});
		}
	}
)();