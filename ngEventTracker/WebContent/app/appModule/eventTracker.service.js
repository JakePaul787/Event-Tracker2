angular.module('appModule')
	.factory('eventService', function($http) {
		var service = {};


		service.index = function() {
			return $http({
				method : 'GET',
				url : "api/index"
			})
		};
		service.show = function(id) {
			return $http({
				method : 'GET',
				url : ``
			})
		}

		service.create = function(event) {
			return $http({
				method : 'POST',
				url : URL,
				headers : {
					'Content-Type' : 'application/json'
				},
				data : event
			})
		};

		service.update = function(id, event) {
			return $http({
				method : 'PUT',
				url : `${URL}/${id}`,
				headers : {
					'Content-Type' : 'application/json'
				},
				data : event
			})
		};

		service.destroy = function(id) {
			return $http({
				method : 'DELETE',
				url : `${URL}/${id}`
			})
		};

		return service;
	})