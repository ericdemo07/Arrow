(function() 
	{
		angular.module('arrowApp').controller('ProductDetailController',ProductDetailController);
		ProductDetailController.$inject = ['$scope','$stateParams', '$state','QueryService'];
		
		function ProductDetailController($scope,$stateParams,$state,QueryService) 
		{
			 $scope.uploadProductImage1 = function()
			 {
				 var temp = this.vm;
				 QueryService.ProductImage1UploadQuery(temp.productImage1).then(function(response) 
				 {
				 });
			 }
			 $scope.uploadProductImage2 = function()
			 {
				 var temp = this.vm;
				 QueryService.ProductImage2UploadQuery(temp.productImage2).then(function(response) 
				 {
				 });
			 }
			 $scope.uploadProductImage3 = function()
			 {
				 var temp = this.vm;
				 QueryService.ProductImage3UploadQuery(temp.productImage3).then(function(response) 
				 {
				 });
			 }
			 $scope.uploadProductInvoice = function()
			 {
				 var temp = this.vm;
				 QueryService.ProductInvoiceUploadQuery(temp.productInvoiceUpload).then(function(response) 
				 {
				 });
			 }
			 $scope.submitProductDetails = function() 
			 {	
				 var productDescription = this.vm.productDescription;
				 var productTypeSelected = $stateParams.productTypeSelected;
				 var brandNameSelected = $stateParams.brandNameSelected;
				 var modelNameSelected = $stateParams.modelNameSelected;
				 console.log("ProductDetails : "+productTypeSelected+" "+brandNameSelected+" "+modelNameSelected);

				 var temp = this.vm;
				 var productTextDetails = {productDescription:productDescription,productType:productTypeSelected,
						 brandName:brandNameSelected,modelName:modelNameSelected};
				 console.log("productTextDetails "+productTextDetails);				 
				 QueryService.UploadProductTextDetails(productTextDetails).then(function(response) 
				 {
				 });
			 }
		}	
	}
)();