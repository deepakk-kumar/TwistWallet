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
    }).otherwise({
        redirectTo: '/login'
    });

}]);