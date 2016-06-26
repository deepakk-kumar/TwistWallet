	App.controller("loginController", function($scope,$http,$location,$route) {
	$scope.login = function(){
		$scope.email = $("#email").val();
		$scope.password = $("#password").val();

		$scope.request = 
		{
			"user": {
				"emailAddress": $scope.email
			},
			"login": {
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
				window.localStorage.setItem("userId", response.data.user.userId);
				window.localStorage.setItem("isLogin",true);
				window.localStorage.setItem("loginId",response.data.login.loginId);
				window.localStorage.setItem("loginUserName",response.data.user.firstName);
				console.log("loginUserName "+response.data.user.firstName);
				loginUser = response.data.user;
				window.localStorage.setItem("loginUserArr", loginUser);
				//window.localStorage.setItem("loginUserArr", JSON.stringify(loginUser));
				if(response.data.user.newUser == true){
					alert("new user");
					$location.path("/resetPassword");
				}else{
				$location.path("/landingPage")
				$route.reload();
				} 
			}else{
				alert("failure")
			}
		}, function errorCallback(response) {
			alert("error")
		});
		
	}
	$scope.gotoforgotPassword = function(){
		$location.path("/forgotPassword")
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
