(function() 
	{
		angular.module('arrowApp').controller('ProductDetailController',ProductDetailController);
		ProductDetailController.$inject = ['$scope','$stateParams', '$state','QueryService'];
		
		function ProductDetailController($scope,$stateParams,$state,QueryService) 
		{
			 $scope.submitProductDetails = function() 
			 {	
				 var productTypeSelected = $stateParams.productTypeSelected;
				 var brandNameSelected = $stateParams.brandNameSelected;
				 var modelNameSelected = $stateParams.modelNameSelected;
				 var temp = this.vm;
				 var productDetails = {productDescription:temp.productDescription,imageUpload1:temp.productImage1,
						 imageUpload2:temp.productImage2,imageUpload3:temp.productImage1,invoiceDetails:""};
				 console.log("Details "+productDetails);
				 console.log("This page invoice : "+temp.productInvoiceUpload.type)
				 
				 QueryService.ProductDetailUploadQuery(temp.productInvoiceUpload).then(function(response) 
				 {
					 //$scope.selected = undefined;
					// $scope.brandNamesResponse = response;
				 });
			 }
		}	
	}
)();