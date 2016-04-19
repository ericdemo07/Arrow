(function() 
	{
		angular.module('arrowApp').factory('QueryService',QueryService);
		QueryService.$inject = ['$http','$location','Upload'];
		
		function QueryService($http, $location,Upload) 
		{
			var service = {};
			service.BrandNameSearchQuery = BrandNameSearchQuery;
			service.ModelNameSearchQuery = ModelNameSearchQuery;
			service.ProductImage1UploadQuery = ProductImage1UploadQuery;
			service.ProductImage2UploadQuery = ProductImage2UploadQuery;
			service.ProductImage3UploadQuery = ProductImage3UploadQuery;
			service.ProductInvoiceUploadQuery = ProductInvoiceUploadQuery;
			service.UploadProductTextDetails = UploadProductTextDetails;


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
			function ProductImage1UploadQuery(productImage1) 
			{
				console.log("Output   :"+productImage1);
				var request = Upload.upload({
			        url: '/arrow/productimage1upload',
			        fields: {'username': 'productImage1'}, // additional data to send
			        file: productImage1
			    }).then(handleSuccess, handleError('Faliure'));
				return request.then(handleSuccess, handleError('Faliure'));
			}
			function ProductImage2UploadQuery(productImage2) 
			{
				console.log("Output   :"+productImage2);
				var request = Upload.upload({
			        url: '/arrow/productimage2upload',
			        fields: {'username': 'productImage2'}, // additional data to send
			        file: productImage2
			    }).then(handleSuccess, handleError('Faliure'));
				return request.then(handleSuccess, handleError('Faliure'));
			}
			function ProductImage3UploadQuery(productImage3) 
			{
				console.log("Output   :"+productImage3);
				var request = Upload.upload({
			        url: '/arrow/productimage3upload',
			        fields: {'username': 'productImage3'}, // additional data to send
			        file: productImage3
			    }).then(handleSuccess, handleError('Faliure'));
				return request.then(handleSuccess, handleError('Faliure'));
			}
			function ProductInvoiceUploadQuery(invoiceFileType) 
			{
				console.log("Output   :"+invoiceFileType);
				var request = Upload.upload({
			        url: '/arrow/productinvoiceupload',
			        fields: {'username': 'zouroto'}, // additional data to send
			        file: invoiceFileType
			    }).then(handleSuccess, handleError('Faliure'));
				return request.then(handleSuccess, handleError('Faliure'));
			}
			function UploadProductTextDetails(productTextDetails) 
			{
				console.log ("Query"+productTextDetails);
				var request = $http(
				{
					method : "post",
					url : "/arrow/producttextdetailsupload",
					data : productTextDetails
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