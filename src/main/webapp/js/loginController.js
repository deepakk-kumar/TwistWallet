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


var  onSignIn = function(googleUser) {
	alert("inside 3");
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail());
	}
