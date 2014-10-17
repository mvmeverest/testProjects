monitorApp.service('monitorService',['$resource',   function($resource) {
        
        this.services = $resource('/monitoring/pages/services', {}, {
            get: {method: 'GET', isArray: true }
        });

    }]);