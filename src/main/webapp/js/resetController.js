	App.controller("resetController", function($scope,$http) {
	$scope.reset = function(){
		
		$scope.password = $("#password").val();

		$scope.request = 
		{
			"user": {
				"password": $scope.password,
				"userId" :  window.localStorage.getItem("userId")
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
				alert("Password changed successfully")
			}else{
				alert("failure")
			}
		}, function errorCallback(response) {
			alert("error")
		});
		
	}
	
	});
