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
			$stateProvider
			.state('userHome', 
			{
				url : '/userhome',
				controller : '',
				templateUrl : 'userHome/userHome.view.html',
				controllerAs : 'vm'
			});
			$stateProvider
			.state('producthome', 
			{
				url : '/producthome',
				controller : '',
				templateUrl : 'productHome/productHome.view.html',
				controllerAs : 'vm'
			});
			$stateProvider
			.state('userLogin', 
			{
				url : '/userlogin',
				controller : '',
				templateUrl : 'userLogin/userLogin.view.html',
				controllerAs : 'vm'
			});
			$stateProvider
			.state('userSignUp', 
			{
				url : '/usersignup',
				controller : '',
				templateUrl : 'userSignUp/userSignUp.view.html',
				controllerAs : 'vm'
			});
		}
	}
)();