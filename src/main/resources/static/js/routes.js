'use strict';

angular.module('shoppy').config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');

    $stateProvider
        .state('base', {
            controller: 'BaseController',
            abstract: true,
            templateUrl: 'views/layout.html'
        })
        .state('base.index', {
            url: '/',
            controller: 'ActionsController',
            templateUrl: 'views/actions.html'
        })
        .state('base.products', {
            url: '/products',
            controller: 'ProductsController',
            templateUrl: 'views/products/list.html',
            resolve: {
                allProducts: function (resolvers) {
                    return resolvers.allProducts();
                }
            }
        })
});