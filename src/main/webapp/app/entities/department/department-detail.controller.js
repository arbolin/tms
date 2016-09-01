(function() {
    'use strict';

    angular
        .module('tmsApp')
        .controller('DepartmentDetailController', DepartmentDetailController);

    DepartmentDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Department', 'Location', 'Employee'];

    function DepartmentDetailController($scope, $rootScope, $stateParams, previousState, entity, Department, Location, Employee) {
        var vm = this;

        vm.department = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('tmsApp:departmentUpdate', function(event, result) {
            vm.department = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
