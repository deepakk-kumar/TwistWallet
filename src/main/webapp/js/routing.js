App.config(['$routeProvider', function($routeProvider) { 
    $routeProvider.when('/login', {
        templateUrl: 'view/login.html',
        controller: 'loginController'
    }).when("/signUp", {
    	templateUrl : "view/signUp.html",
    	controller: "signupController"
    }).when("/resetPassword", {
    	templateUrl : "view/resetPassword.html",
    	controller: "resetController"
    }).when("/confirmDetails", {
    	templateUrl : "view/confirmDetails.html",
    	controller: "placeOrderController"
    }).when("/landingPage", {
    	templateUrl : "view/landingPage.html",
    	//controller: "globalcontroller"
    }).otherwise({
        redirectTo: '/landingPage'
    });

}]);