
App.controller('signupController', function($scope,$http,$location) {
	
	$scope.email = $("#email").val();
	$scope.password = $("#password").val();
	$scope.firstName = $("#firstName").val();
	$scope.lastName = $("#lastName").val();
	var mob = $("#mobileNo").val();
	
	
	$scope.signUp = function(){
	$scope.url = p.URL+"/createUser";
	$scope.request = {
			"user": {
				"firstName":$("#firstName").val(),// $scope.firstName,
				"lastName": $("#lastName").val(),//$scope.lastName,
				"emailAddress": $("#email").val(),//$scope.email,
				"isAdmin": 1,
				"password": $("#password").val(),//$scope.password,
				"mobileNumber": $("#mobileNo").val(),//$scope.mobileNo
			}
		}
	$http({ 
			method: 'POST',
		    url: $scope.url,
		    data: $scope.request
		    }).then(function successCallback(response) {
				console.log(response);
				if(response.data.resultCode==1){
					alert("success")
					$location.path("/login")
				}else{
					alert("failure")
				}
			}, function errorCallback(response) {
				alert("error")
			});
		
	}
	});
