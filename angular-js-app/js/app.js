var app = angular.module('blog', []);

app.controller('HomeController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/persoana';

    $scope.persoane = [];
    $scope.fields = [];
    $scope.persoana = {};


    $scope.person = {};
    $scope.editPerson = {};



    $http.get(url).then(function successCallback(response) {

        $scope.persoane = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.persoane);
        //console.log($scope.fields);

    });


    $scope.addPersoana = function(persoana) {
        persoana.id = parseInt(persoana.id);
        console.log(persoana.id);
        $http({
            method: 'POST',
            url: url,
            data: persoana
        }).then(function successCallback(response) {
            console.log(response);
            $scope.persoane.push(persoana);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deletePersoana = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.persoane = $scope.persoane.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdatePerson = function(person) {
        $scope.editPerson = person;
    };


    $scope.updatePerson = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editPerson
        }).then(function successCallback(response) {
            $scope.editPerson = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editPerson = {};
            console.log(response);
        });
    };

}]);



app.controller('LaptopController', ['$scope', '$http', function ($scope, $http) {

    var url = 'http://localhost:8080/laptop';

    $scope.laptopuri = [];
    $scope.fields = [];
    $scope.laptop = {};


    $scope.laptop = {};
    $scope.editLaptop = {};



    $http.get(url).then(function successCallback(response) {

        $scope.laptopuri = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.laptopuri);
        //console.log($scope.fields);

    });


    $scope.addLaptop = function(laptop) {
        laptop.id = parseInt(laptop.idLaptop);
        console.log(laptop.idLaptop);
        $http({
            method: 'POST',
            url: url,
            data: laptop
        }).then(function successCallback(response) {
            console.log(response);
            $scope.laptopuri.push(laptop);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteLaptop = function(idLaptop) {
        $http({
            method: 'DELETE',
            url: url+'/' + idLaptop,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.laptopuri = $scope.laptopuri.filter(function(obj) {
                return obj.idLaptop !== idLaptop;
            });
        });
    };



    $scope.setUpdateLaptop = function(laptop) {
        $scope.editLaptop = laptop;
    };


    $scope.updateLaptop = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editLaptop
        }).then(function successCallback(response) {
            $scope.editLaptop = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editLaptop = {};
            console.log(response);
        });
    };

}]);


app.controller('FilmController', ['$scope', '$http', function ($scope, $http) {

    var url = 'http://localhost:8080/film';

    $scope.filme = [];
    $scope.fields = [];
    $scope.filme = {};


    $scope.film = {};
    $scope.editFilm = {};



    $http.get(url).then(function successCallback(response) {

        $scope.filme = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.filme);
        //console.log($scope.fields);

    });


    $scope.addFilm = function(film) {
        film.id = parseInt(film.id);
        console.log(film.id);
        $http({
            method: 'POST',
            url: url,
            data: film
        }).then(function successCallback(response) {
            console.log(response);
            $scope.filme.push(film);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteFilm = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.filme = $scope.filme.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateFilm = function(film) {
        $scope.editFilm = filme;
    };


    $scope.updateFilm = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editFilm
        }).then(function successCallback(response) {
            $scope.editFilm = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editFilm = {};
            console.log(response);
        });
    };

}]);


app.controller('CarteController', ['$scope', '$http', function ($scope, $http) {

    var url = 'http://localhost:8080/carte';

    $scope.carti = [];
    $scope.fields = [];
    $scope.carti = {};


    $scope.carte = {};
    $scope.editCarte = {};



    $http.get(url).then(function successCallback(response) {

        $scope.carti = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.carti);
        //console.log($scope.fields);

    });


    $scope.addCarte = function(carte) {
        carte.id = parseInt(carte.id);
        console.log(carte.id);
        $http({
            method: 'POST',
            url: url,
            data: carte
        }).then(function successCallback(response) {
            console.log(response);
            $scope.carti.push(carte);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteCarte = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.carti = $scope.carti.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateCarte = function(carte) {
        $scope.editCarte = carti;
    };


    $scope.updateCarte = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editCarte
        }).then(function successCallback(response) {
            $scope.editCarte = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editCarte = {};
            console.log(response);
        });
    };

}]);
