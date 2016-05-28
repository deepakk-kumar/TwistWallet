	App.controller("resetController", function($scope,$http,$location) {
	$scope.reset = function(){
		
		$scope.password = $("#password").val();

		$scope.request = 
		{
			"user": {
				"userId" :  window.localStorage.getItem("userId")
			},
			"login": {
				"password": $scope.password
			}
		}

	$scope.url =   p.URL+"/resetPass";
		
		$http({
		    method: 'POST',
		    url: $scope.url,
		    data: $scope.request
		}).then(function successCallback(response) {
			console.log(response);
			if(response.data.resultCode==1){
				$location.path("/landingPage");
			}else{
				alert("failure")
			}
		}, function errorCallback(response) {
			alert("error")
		});
		
	}   
	
	});
