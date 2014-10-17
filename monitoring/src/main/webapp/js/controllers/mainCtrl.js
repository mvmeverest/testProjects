monitorApp.controller('mainCtrl',['$scope','monitorService', function ($scope,monitorService) {
  $scope.services= monitorService.services.get();
  
}]);