(function() {
	angular.module('arrowApp').controller('ProductDetailController',
			ProductDetailController);
	ProductDetailController.$inject = [ '$scope', '$stateParams', '$state' ,'QueryService'];

	function ProductDetailController($scope, $stateParams, $state, QueryService) {
		$scope.submitProductDetails = function() {
			console.log("Param : [ "+ $stateParams);
			var productSelected = $stateParams;
			var temp = this.vm;
			var productDetails = {
				productSelected : productSelected,	
				productDescription : temp.productDescription,
				imageUpload1 : temp.productImage1,
				imageUpload2 : temp.productImage2,
				imageUpload3 : temp.productImage1,
				invoiceDetails : temp.productInvoiceUpload
			};
			console.log("Details " + productDetails);
			QueryService.SendProductDetails(productTypeSelected).then(
					function(response) {
						$scope.selected = undefined;
						$scope.brandNamesResponse = response;
					});
		}
	}
})();