(function() 
	{
		angular.module('arrowApp').controller('ProductDetailController',ProductDetailController);
		ProductDetailController.$inject = ['$scope','$stateParams', '$state'];
		
		function ProductDetailController($scope,$stateParams,$state) 
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
			 }
		}	
	}
)();