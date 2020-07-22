app.controller('MainController', function($scope, $http) {
   $http.get('http://localhost:8080/mmi/employee').
       then(function(response) {
           $scope.employees = response.data.content;
       });
});
