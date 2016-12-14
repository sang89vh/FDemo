<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<script type="text/javascript">
var drawGrid = function() {
	 
    $("#jsGrid").jsGrid({
        height: "auto",
        width: "100%",
 
        filtering: true,
        editing: true,
        sorting: true,
        paging: true,
        autoload: true,
 
        pageSize: 15,
        pageButtonCount: 5,
 
        deleteConfirm: "Do you really want to delete the client?",
 
        controller: {
            loadData: function() {
                var d = $.Deferred();
 
                $.ajax({
                    url: ctx + "/ff0002/data01",
                    dataType: "json",
                    method:'post',
                    data:{
                    		"${_csrf.parameterName}":"${_csrf.token}" 
                    	 }
                }).done(function(response) {
                    d.resolve(response);
                });
 
                return d.promise();
            }
        },
 
        fields: [
            { name: "symbol", type: "text" },
            { type: "control" },
        ]
    });
 
};


var chartData = [];

var getDataAndDrawchart = function(){
	$.post( ctx + "/ff0002/data01",$("#form-search").serializeObject(), function( data ) {
		  $.each( data, function( key, val ) {
			  
			  chartData.push({
					date: new Date(val.trading_date),
					value: val.close_price,
					volume: val.volume
				});
		    
		  });
		  
		  drawChart();
		 
	}, "json");
}

var drawChart = function(){
	AmCharts.makeChart("chartdiv", {
		type: "stock",
		dataSets: [{
			color: "#b0de09",
			fieldMappings: [{
				fromField: "value",
				toField: "value"
			}, {
				fromField: "volume",
				toField: "volume"
			}],
			dataProvider: chartData,
			categoryField: "date",
			// EVENTS
			stockEvents: [{
				date: new Date(2010, 8, 19),
				type: "sign",
				backgroundColor: "#85CDE6",
				graph: "g1",
				text: "S",
				description: "This is description of an event"
			}, {
				date: new Date(2010, 10, 19),
				type: "flag",
				backgroundColor: "#FFFFFF",
				backgroundAlpha: 0.5,
				graph: "g1",
				text: "F",
				description: "Some longer\ntext can also\n be added"
			}, {
				date: new Date(2010, 11, 10),
				showOnAxis: true,
				backgroundColor: "#85CDE6",
				type: "pin",
				text: "X",
				graph: "g1",
				description: "This is description of an event"
			}, {
				date: new Date(2010, 11, 26),
				showOnAxis: true,
				backgroundColor: "#85CDE6",
				type: "pin",
				text: "Z",
				graph: "g1",
				description: "This is description of an event"
			}, {
				date: new Date(2011, 0, 3),
				type: "sign",
				backgroundColor: "#85CDE6",
				graph: "g1",
				text: "U",
				description: "This is description of an event"
			}, {
				date: new Date(2011, 1, 6),
				type: "sign",
				graph: "g1",
				text: "D",
				description: "This is description of an event"
			}, {
				date: new Date(2011, 3, 5),
				type: "sign",
				graph: "g1",
				text: "L",
				description: "This is description of an event"
			}, {
				date: new Date(2011, 3, 5),
				type: "sign",
				graph: "g1",
				text: "R",
				description: "This is description of an event"
			}, {
				date: new Date(2011, 5, 15),
				type: "arrowUp",
				backgroundColor: "#00CC00",
				graph: "g1",
				description: "This is description of an event"
			}, {
				date: new Date(2011, 6, 25),
				type: "arrowDown",
				backgroundColor: "#CC0000",
				graph: "g1",
				description: "This is description of an event"
			}, {
				date: new Date(2011, 8, 1),
				type: "text",
				graph: "g1",
				text: "Longer text can\nalso be displayed",
				description: "This is description of an event"
			}]
		}],


		panels: [{
			title: "Value",
			percentHeight: 70,

			stockGraphs: [{
				id: "g1",
				valueField: "value"
			}],

			stockLegend: {
				valueTextRegular: " ",
				markerType: "none"
			}
		}],

		chartScrollbarSettings: {
			graph: "g1",
			updateOnReleaseOnly:false
		},

		chartCursorSettings: {
			valueBalloonsEnabled: true,
			graphBulletSize: 1,
			valueLineEnabled:true,
			valueLineBalloonEnabled:true
		},

		periodSelector: {
			periods: [{
				period: "DD",
				count: 10,
				label: "10 days"
			}, {
				period: "MM",
				count: 1,
				label: "1 month"
			}, {
				period: "YYYY",
				count: 1,
				label: "1 year"
			}, {
				period: "YTD",
				label: "YTD"
			}, {
				period: "MAX",
				label: "MAX"
			}]
		},

		panelsSettings: {
			mouseWheelZoomEnabled:true,
			usePrefixes: true
		}
	});
}
var search = function(){
	getDataAndDrawchart();
}
$(document).ready(function(){
	getDataAndDrawchart();
	drawGrid();
})



</script>

<form id="form-search">
<div class="table-responsive form-group">
	<table class="table">
	  <tr>
	  	<td>
	  		<div class="form-group">
			    <input name = "symbol" type="text" class="form-control" placeholder="Symbol" style="text-transform:uppercase" value="MSN">
			    <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			 </div>
		</td>
		<td>	 
			 <div class="form-group">
			    <button type="button" class="btn btn-primary" onclick="search()">Search</button>
			 </div>
	  	</td>
	  </tr>
	</table>
</div>
</form>
<div>

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#chartprice" aria-controls="chart" role="tab" data-toggle="tab">Chart</a></li>
    <li role="presentation"><a href="#listprice" aria-controls="listprice" role="tab" data-toggle="tab">Grid</a></li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="chartprice">
    	<div id="chartdiv" style="width:100%; height:500px;"></div>
    </div>
    <div role="tabpanel" class="tab-pane" id="listprice">
    	<div id="jsGrid"></div>
    </div>
  </div>

</div>
