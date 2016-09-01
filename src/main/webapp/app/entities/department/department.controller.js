(function() {
    'use strict';

    angular
        .module('tmsApp')
        .controller('DepartmentController', DepartmentController);

    DepartmentController.$inject = ['$scope', '$state', 'Department'];

    function DepartmentController ($scope, $state, Department) {
        var vm = this;
        
        vm.departments = [];

        loadAll();

        function loadAll() {
            Department.query(function(result) {
                vm.departments = result;
            });
        }
    }
})();
