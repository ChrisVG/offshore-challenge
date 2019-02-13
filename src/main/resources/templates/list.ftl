<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Event Information</span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessdate">{{ctrl.successMessdate}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessdate">{{ctrl.errorMessdate}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.event.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.event.name" id="uname" class="eventname form-control input-sm" placeholder="Enter Event Name." required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="date">Date</label>
	                        <div class="col-md-7">
	                            <input type="date" ng-model="ctrl.event.date" id="date" class="form-control input-sm" placeholder="Enter the Event date."/>
	                        </div>
	                    </div>
	                </div>
					<div class="panel-heading"><span class="lead"><b>Venue Information</b> </span></div>
						<br/>
						<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="venueUname">Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.event.venue.name" id="venueUname" class="eventname form-control input-sm" placeholder="Enter Venue Name." required ng-minlength="3"/>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="venueCity">City</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.event.venue.city" id="venueCity" class="form-control input-sm" placeholder="Enter Venue City." required ng-minlength="3"/>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="venueState">State</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.event.venue.state" id="venueState" class="form-control input-sm" placeholder="Enter Venue State." required ng-minlength="3"/>
							</div>
						</div>
					</div>
	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.event.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>

    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Events </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>NAME</th>
		                <th>DATE</th>
		                <th>VENUE</th>
		                <th>CITY</th>
		                <th>STATE</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllEvents()">
		                <td>{{u.id}}</td>
		                <td>{{u.name}}</td>
		                <td>{{u.date | date:'dd	-MM-yyyy' }}</td>
		                <td>{{u.venue.name}}</td>
		                <td>{{u.venue.city}}</td>
		                <td>{{u.venue.state}}</td>
		                <td><button type="button" ng-click="ctrl.editEvent(u.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="ctrl.removeEvent(u.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>