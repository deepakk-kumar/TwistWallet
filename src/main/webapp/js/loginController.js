	App.controller("loginController", function($scope,$http,$location) {
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

	$scope.url =   p.URL+"/login";
		
		$http({
		    method: 'POST',
		    url: $scope.url,
		    data: $scope.request
		}).then(function successCallback(response) {
			console.log(response);
			if(response.data.resultCode==1){
				console.log("userId "+response.data.user.userId);
				window.localStorage.setItem("u" +
						"serId", response.data.user.userId);
				if(response.data.user.newUser == true){
					$location.path("/resetPassword")
				}
				alert("success")
			}else{
				alert("failure")
			}
		}, function errorCallback(response) {
			alert("error")
		});
		
	}
	$scope.gotoReset = function(){
		$location.path("/resetPassword")
	}
	
	});
var signUp = function (){
	window.location.href=(p.URL+"/#/signUp")
}