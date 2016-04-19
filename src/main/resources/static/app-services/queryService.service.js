(function() 
	{
		angular.module('arrowApp').factory('QueryService',QueryService);
		QueryService.$inject = ['$http','$location','Upload'];
		
		function QueryService($http, $location,Upload) 
		{
			var service = {};
			service.BrandNameSearchQuery = BrandNameSearchQuery;
			service.ModelNameSearchQuery = ModelNameSearchQuery;
			service.ProductDetailUploadQuery = ProductDetailUploadQuery;

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
			function ProductDetailUploadQuery(invoiceFileType) 
			{
				console.log("Output   :"+invoiceFileType);
				var request = Upload.upload({
			        url: '/arrow/productdetailinvoiceupload',
			        fields: {'username': 'zouroto'}, // additional data to send
			        file: invoiceFileType
			    }).then(handleSuccess, handleError('Faliure'));
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