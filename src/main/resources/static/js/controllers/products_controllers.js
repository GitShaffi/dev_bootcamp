'use strict';

angular.module('shoppy').controller('ProductsController', function ($scope, allProducts) {
    $scope.allProducts = allProducts;
});
