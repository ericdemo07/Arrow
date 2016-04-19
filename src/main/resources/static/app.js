(function() 
	{
		angular.module('arrowApp',
		['ui.router','ui.bootstrap','ngFileUpload','naif.base64']).config(config);

		config.$inject = ['$stateProvider','$urlRouterProvider'];
		
		function config($stateProvider,$urlRouterProvider) 
		{
			$urlRouterProvider.otherwise("/searchquery");

			$stateProvider
			.state('searchQuery', 
			{
				url : '/searchquery',
				controller : 'SearchQueryController',
				templateUrl : 'searchQuery/searchQuery.view.html',
				controllerAs : 'vm'
			})
			.state('productDetail', 
			{
				url : '/productdetail',
				controller : 'ProductDetailController',
				templateUrl : 'productDetail/productDetail.view.html',
				controllerAs : 'vm',
				params : {
					'productTypeSelected' : 'some default','brandNameSelected':'some default','modelNameSelected':'some default'
				}
			})
			.state('userHome', 
			{
				url : '/userhome',
				controller : 'UserHomeController',
				templateUrl : 'userHome/userHome.view.html',
				controllerAs : 'vm'
			})
			.state('productHome', 
			{
				url : '/producthome',
				controller : '',
				templateUrl : 'productHome/productHome.view.html',
				controllerAs : 'vm'
			})
			.state('userLogin', 
			{
				url : '/userlogin',
				controller : '',
				templateUrl : 'userLogin/userLogin.view.html',
				controllerAs : 'vm'
			})
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