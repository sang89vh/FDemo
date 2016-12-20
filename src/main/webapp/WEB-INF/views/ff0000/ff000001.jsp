<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<script>
    var search = function(){
    	$('#calendar').fullCalendar( 'destroy');
    	$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,listMonth'
			},
			defaultDate: new Date(),
			navLinks: true, // can click day/week names to navigate views
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			events: { // you can also specify a plain string like 'json/events.json'
				url: ctx + '/ff0000/data01',
				method:'POST',
				data:$("#form-search").serializeObject(),
				error: function() {
					$('#script-warning').show();
				}
			},
			eventClick: function(calEvent, jsEvent, view) {

		        console.log(calEvent.resourceId);
				var $historicalPrice = $("#historicalPrice");
				$historicalPrice.attr("href",ctx + "/ff0002/index?path=dialog&symbol="+calEvent.resourceId)
		        $historicalPrice.click();
				// change the border color just for fun
		        $(this).css('border-color', 'red');

		    }
		});
    }
	$(document).ready(function() {
		
		search();
		
	});

</script>
<style>

	#calendar {
		margin: 0 auto;
	}

</style>
<form id="form-search">
<div class="table-responsive form-group">
	<table class="table">
	  <tr>
	  	<td>
	  		<div class="form-group">
			    <input name = "symbol" type="text" class="form-control" placeholder="Symbol" style="text-transform:uppercase">
			    <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			 </div>
	  	</td>
	    <td>	
		    <div class="form-group form-group-sm">
		    	<div class="col-sm-10">
					<div class="btn-group">
					  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    Year <span class="caret"></span>
					  </button>
					  <ul class="dropdown-menu">
					    <li><a href="#">2016</a></li>
					    <li><a href="#">2015</a></li>
					    <li><a href="#">2014</a></li>
					    <li><a href="#">2013</a></li>
					  </ul>
					</div>
				    <div class="btn-group">
					  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    Month <span class="caret"></span>
					  </button>
					  <ul class="dropdown-menu">
					    <li><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
					    <li><a href="#">6</a></li>
					    <li><a href="#">7</a></li>
					    <li><a href="#">8</a></li>
					    <li><a href="#">9</a></li>
					    <li><a href="#">10</a></li>
					    <li><a href="#">11</a></li>
					    <li><a href="#">12</a></li>
					  </ul>
					</div>
				</div>
			</div>
	    </td>
	    <td>
	    	<div>
			    <label style="margin-right: 5px;margin-left: 10px"><input name="events" type="checkbox" value="CASH" checked="checked"> Cash Dividends</label>
			    <label style="margin-right: 5px;margin-left: 10px"><input name="events" type="checkbox" value="STOCK" checked="checked"> Stock Dividends</label>
			 	<label style="margin-right: 5px;margin-left: 10px"><input name="events" type="checkbox" value="OTHER"> Other</label>
			 </div>
		</td>
		<td >
	  		<div class="form-group">
			    <button type="button" class="btn btn-primary" onclick="search()">Search</button>
			 </div>
	  	</td>
	  </tr>
	</table>
</div>
</form>

<a id="historicalPrice" class="fffancybox fancybox.ajax" href="#" hidden="true">data</a>
<div id='calendar'></div>
