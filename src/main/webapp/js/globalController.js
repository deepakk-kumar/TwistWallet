var loginUser = [];

App.controller("globalcontroller", function($scope,$http,$location,$route) {
	$scope.isLogin=window.localStorage.getItem("isLogin");
	//console.log("$scope.isLogin:-"+$scope.isLogin);
	$scope.loginUserName=window.localStorage.getItem("loginUserName");
	console.log("global controller")
	$scope.url =   p.URL+"/getAllProduct";
	$http({
	    method: 'GET',
	    url: $scope.url,
	}).then(function successCallback(response) {
		console.log(response);
		if(response.data.resultCode==1){
			$scope.productData = response.data.product;
		}else{
			alert("failure")
		}
	}, function errorCallback(response) {
		alert("error")
	});
	
	$scope.buy = function(price,name,quantity,sellerId){
		console.log("buy ")
		console.log("price "+price)
		console.log("name "+name)
		window.localStorage.setItem("productName", name);
		window.localStorage.setItem("productPrice", price);
		window.localStorage.setItem("productQuantity", quantity);
		window.localStorage.setItem("sellerId", sellerId);
		var isLogin = window.localStorage.getItem("isLogin");
		if(isLogin == null){
			$location.path("/login")
		}else{
			$location.path("/confirmDetails");
		}
	}
	console.log(loginUser);
	
	$scope.loginPage = function(){
		console.log("loginPage redirect")
		$location.path("/login");
	} 
	
	$scope.signUpPage = function(){
		console.log("signUpPage redirect")
		$location.path("/signUp");
	}
	
	$scope.getCart = function(){

		$scope.request = 
			{	
					"login": {
						"loginId": window.localStorage.getItem("loginId")
					}
			}
		$scope.url =   p.URL+"/getCart";
		$http({
		    method: 'POST',
		    url: $scope.url,
		    data: $scope.request
		}).then(function successCallback(response) {
			console.log("cartList"+response.data.cartList);
			if(response.data.resultCode==1){
				$scope.cartListData = response.data.cartList;
				$scope.totalAmount=response.data.totalAmount;
			}else{
				alert("failure")
			}
		}, function errorCallback(response) {
			alert("error")
		});
		
	}
	$scope.addToCart= function(data){
		
		if($scope.isLogin==null || $scope.isLogin==false){
			$location.path("/login");
			return;
		}
	
		$scope.request = 
		{
				"cart": {
					"login": {
						"loginId": window.localStorage.getItem("loginId")
					},
					"product": {
						"productId": data.productId
					},
					"quantity": 1
				}
			}

	$scope.url =   p.URL+"/addToCart";
		
		$http({
		    method: 'POST',
		    url: $scope.url,
		    data: $scope.request
		}).then(function successCallback(response) {
			if(response.data.resultCode==1){
				alert("item addedd successfully");
			}
		}, function errorCallback(response) {
			alert("error")
		});
		
	}
	
	$scope.deleteFromCart=function(cartId){
		
		$scope.url =   p.URL+"/deleteFromCart?cartId="+cartId;
		$http({
		    method: 'GET',
		    url: $scope.url,
		}).then(function successCallback(response) {
			//console.log(response);
			if(response.data.resultCode==1){
				alert("item removed successfully")
				$route.reload();
			}else{
				alert("item not removed")
			}
		}, function errorCallback(response) {
			alert("error")
		});
		
	}
	
	$scope.checkOut=function(){
		alert("check out")
		if($scope.isLogin==null || $scope.isLogin==false){
			$location.path("/login");
			return;
		}else{
			alert("else");
			$scope.cartListData
			//window.localStorage.setItem("productDetails",$scope.productDetails);
			//window.localStorage.setItem("totalAmount", $scope.totalAmount);
			//window.localStorage.setItem("sellerId", sellerId);
			$location.path("/confirmDetails");
		}
	}
	
});

App.controller("placeOrderController", function($scope,$http,$location) {
	console.log("placeOrderController");
	
	console.log(loginUser);
	console.log("lastName "+loginUser.lastName);
	$scope.loginUserArr = window.localStorage.getItem("loginUserArr");
	console.log("loginUserArr "+$scope.loginUserArr)
	//console.log(JSON.parse($scope.loginUserArr));
	//var parsed = JSON.parse(window.localStorage.getItem("loginUserArr"))
	//console.log("loginUserArr lastName:- "+$scope.loginUserArr.)
	
	if($scope.loginUserArr !=null ){
		
	}
	
	$scope.productName = window.localStorage.getItem("productName");
	$scope.productPrice = window.localStorage.getItem("productPrice");
	$scope.productQuantity = window.localStorage.getItem("productQuantity");

	console.log($scope.productName);
	$scope.loginUser = loginUser;
	$scope.buy = function(){
		var isLogin = window.localStorage.getItem("isLogin");
		if(isLogin == null){
			$location.path("/login")
		}
	}
	$scope.placeOrder = function(){	
		$scope.request = 
		{
			"orderDetails": {
				"user": {
					"userId": 7,
					"firstName": $("#firstName").val(),
					"lastName": $("#lastName").val(),
		              "emailAddress":$("#email").val(),
					"mobileNumber": $("#mobileNo").val(),
					"address": $("#address").val(),
					"postelCode": $("#postalCode").val()
				},
				"seller": {
					"sellerId": window.localStorage.getItem("sellerId")
				},
				"orderInfo": "productCode:1",
				  "amount":"100.00"
			}
		}
		
		$scope.url =   p.URL+"/placeOrder";
		$http({
		    method: 'POST',
		    url: $scope.url,
		    data: $scope.request,
		}).then(function successCallback(response) {
			console.log(response);
			if(response.data.resultCode==1){
				$scope.productData = response.data.product;
			}else{
				alert("failure")
			}
		}, function errorCallback(response) {
			alert("error")
		});
		
	}
});

var signout=function(){
	window.localStorage.clear();
	window.location.reload();
}

var openFlag = true;
$(document).on('click', '#openDropDown', function(event) {
	 event.stopPropagation();
	 if(openFlag){
		 openFlag = false;
		 $('.dropDownCustom').show();
	 }
	 else{
		 openFlag = true;
		 $('.dropDownCustom').hide();
	 }
});


var openFlagForCart = true;
$(document).on('click', '#openDropDownForCart', function(event) {
	 event.stopPropagation();
	 if(openFlagForCart){
		 openFlagForCart = false;
		 $('.dropDownCustomForCart').show();
		 //$('.crossImage').show();
	 }
	 else{
		 openFlagForCart = true;
		 $('.dropDownCustomForCart ').hide();
		 //$('.crossImage').hide(); 
	 }
});