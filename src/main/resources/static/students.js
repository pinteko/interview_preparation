angular.module('hw_students').controller('studentsController', function ($scope, $rootScope, $http, $localStorage) {
    $scope.newStudent = null;
    const contextPath = 'http://localhost:8189/app/students/';


    $scope.findStudents = function () {
        $http.get(contextPath)
            .then(function (response) {
                $scope.studentList = response.data;
            });
    };

    $scope.addStudent = function () {
        console.log($scope.newStudent)
        $http.post(contextPath, $scope.newStudent)
            .then(function (response) {
                $scope.findStudents();
            });
    };

    $scope.delete = function (id){
        $http({
            url: contextPath,
            method: 'DELETE',
            params: {
                id: id,
            }
        }).then(function (response){
            $scope.findStudents();
        });
    };

    $scope.edit = function (id, name, age){
        $http({
            url: contextPath,
            method: 'PATCH',
            params: {
                id: id,
                name: name,
                age: age
            }
        }).then(function (response){
            $scope.findStudents();
        });
    };


    $scope.findStudents();

});