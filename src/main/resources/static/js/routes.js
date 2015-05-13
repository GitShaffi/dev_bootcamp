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
});