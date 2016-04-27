	App.controller("loginController", function($scope,$http) {
	$scope.login = function(){
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
			if(response.data.resultCode==1){
				alert("success")
			}else{
				alert("failure")
			}
		}, function errorCallback(response) {
			alert("error")
		});
		
	}});
var signUp = function (){
	window.location.href=("http://localhost:8080/TwistWallet/#/signUp")
}