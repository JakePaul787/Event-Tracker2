angular.module('appModule')
	.component('eventComponent', {
		templateUrl : 'app/appModule/eventTracker.component.html',
		controller : function(eventService) {

			var vm = this;
			console.log(eventService.index().then());
		
			vm.list = null;
			
			var getEvents = function(){
				return eventService.index().then(function(res){
					console.log(res.data)
					vm.list = res.data;
					})
					.catch(function(reason){
				
			})};
			getEvents();
			
			vm.displayEvents = function (){
				
			}
			
		},	
		controllerAs : 'vm'
			
	});