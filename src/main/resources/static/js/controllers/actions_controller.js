'use strict';

angular.module('shoppy').controller('ActionsController', function ($scope, $state) {
    $scope.productsCount = function(){
        $state.go("base.products");
    };
});
