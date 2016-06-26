
App.controller('forgotPasswordController', function($scope,$http,$location) {
	$scope.email = $("#email").val();
	
	$scope.sendMail = function(){
		alert("send mail")
	$scope.url = p.URL+"/forgotPassword";
	$scope.request = {
			"user": {
				"emailAddress": $("#email").val()//$scope.email,
			}
		}
	$http({ 
			method: 'POST',
		    url: $scope.url,
		    data: $scope.request
		    }).then(function successCallback(response) {
				console.log(response);
				if(response.data.resultCode==1){
					alert("password is reset and send over mail")
					$location.path("/login")
				}else{
					alert("failure")
				}
			}, function errorCallback(response) {
				alert("error")
			});
		
	}
	});
