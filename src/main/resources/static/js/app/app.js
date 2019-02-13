var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/event-test',
    USER_SERVICE_API : 'http://localhost:8080/events/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'EventController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, EventService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        EventService.loadAllEvents().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

