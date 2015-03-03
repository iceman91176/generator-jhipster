'use strict';

angular.module('<%=angularAppName%>')
    .controller('SettingsController', function ($scope, Principal, Auth) {
        $scope.success = null;
        $scope.error = null;
        Principal.identity().then(function(account) {
            $scope.settingsAccount = account;
            <% if ((socialAuth == 'yes')||(openidconnectAuth == 'yes')) { %>
            if(angular.isArray(account.externalAccounts)) {
            	if (account.externalAccounts.length > 0){
            		$scope.disableSettings=true;
            	}
            }
            <% } %>
        });

        $scope.save = function () {
            Auth.updateAccount($scope.settingsAccount).then(function() {
                $scope.error = null;
                $scope.success = 'OK';
                Principal.identity().then(function(account) {
                    $scope.settingsAccount = account;
                });
            }).catch(function() {
                $scope.success = null;
                $scope.error = 'ERROR';
            });
        };
    });
