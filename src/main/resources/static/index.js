(function () {
    angular
        .module('hw_students', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'welcome.html',
                controller: 'welcomeController'
            })
            .when('/students', {
                templateUrl: 'students.html',
                controller: 'studentsController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }
    function run($rootScope, $http, $localStorage) {}
})();

angular.module('hw_students').controller('indexController', function ($rootScope, $scope, $http, $location, $localStorage) {
});