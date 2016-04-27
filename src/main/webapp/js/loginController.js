/*App.controller('loginController', function($scope) {*/
	App.controller("loginController", function($scope,$http) {
	alert("login")
	/*$scope.login = function(){
		$scope.email = $("#email").val();
		$scope.password = $("#password").val();

		$scope.request = 
		{
			"user": {
				"emailAddress": $scope.email,
				"password": $scope.password
			}
		}

	$scope.url =   "http://localhost:8080/TwistWallet/login";
		
		$http({
		    method: 'POST',
		    url: $scope.url,
		    data: $scope.request
		}).then(function successCallback(response) {
			console.log(response);
		}, function errorCallback(response) {
			alert("error")
		});
	
	}*/});
