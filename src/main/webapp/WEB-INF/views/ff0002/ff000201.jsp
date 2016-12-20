<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<script type="text/javascript">
var drawGrid = function() {
	 
    $("#jsGrid").jsGrid({
        height: "auto",
        width: "100%",
 
        filtering: false,
        editing: false,
        sorting: true,
        paging: false,
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
                    data:$("#ff000201-form-search").serializeObject()
                }).done(function(response) {
                    d.resolve(response);
                });
 
                return d.promise();
            }
        },
 
        fields: [
            { name: "symbol",title:"Symbol", type: "text" },
            { name: "trading_date_label",title:"Date", type: "text" },
            { name: "open_price",title:"Open" ,type: "number" },
            { name: "close_price",title:"Close" , type: "number" },
            { name: "high_price",title:"Hight" , type: "number" },
            { name: "low_price",title:"Low" , type: "number" },
            { name: "volume", title:"Volume" ,type: "number" },
        ]
    });
 
};


var chartData = [];
var chartStockEvents = [];


var getEvents = function(){
	
	
	$.post( ctx + '/ff0000/data01',$("#ff000201-form-search").serializeObject(), function( data ) {
		  chartStockEvents = [];
		  $.each( data, function( key, val ) {
			  
			  chartStockEvents.push({
					date: new Date(val.start),
					type: "sign",
					backgroundColor: "#85CDE6",
					graph: "g1",
					text: val.event_type,
					description: val.title
			});
		    
		  });
		  
		  drawChart();
		 
	}, "json");
}
var getDataAndDrawchart = function(){
	$.post( ctx + "/ff0002/data01",$("#ff000201-form-search").serializeObject(), function( data ) {
		 chartData=[];
		  $.each( data, function( key, val ) {
			  
			  chartData.push({
					date: new Date(val.trading_date),
					open: val.open_price,
					close: val.close_price,
					high: val.high_price,
					low: val.low_price,
					volume: val.volume,
					value: val.volume * ((val.high_price+val.low_price)/2)
				});
		    
		  });
		  
		  getEvents();
		 
	}, "json");
}

var drawChart = function(){
	
	var chart = AmCharts.makeChart("chartdiv", {
		type: "stock",

		dataSets: [{
			fieldMappings: [{
				fromField: "open",
				toField: "open"
			}, {
				fromField: "close",
				toField: "close"
			}, {
				fromField: "high",
				toField: "high"
			}, {
				fromField: "low",
				toField: "low"
			}, {
				fromField: "volume",
				toField: "volume"
			}, {
				fromField: "value",
				toField: "value"
			}],

			color: "#7f8da9",
			dataProvider: chartData,
			title: $("#symbol").val(),
			categoryField: "date"
		}],
		panels: [{
				title: "Value",
				showCategoryAxis: false,
				percentHeight: 70,
				valueAxes: [{
					id:"v1",
					dashLength: 5
				}],

				categoryAxis: {
					dashLength: 5
				},

				stockGraphs: [{
					type: "candlestick",
					id: "g1",
					openField: "open",
					closeField: "close",
					highField: "high",
					lowField: "low",
					valueField: "close",
					lineColor: "#7f8da9",
					fillColors: "#7f8da9",
					negativeLineColor: "#db4c3c",
					negativeFillColors: "#db4c3c",
					fillAlphas: 1,
					useDataSetColors: false,
					comparable: true,
					compareField: "value",
					showBalloon: false
				}],

				stockLegend: {
					valueTextRegular: undefined,
					periodValueTextComparing: "[[percents.value.close]]%"
				}
			},

			{
				title: "Volume",
				percentHeight: 30,
				marginTop: 1,
				showCategoryAxis: true,
				valueAxes: [{
					id:"v2",
					dashLength: 5
				}],

				categoryAxis: {
					dashLength: 5
				},

				stockGraphs: [{
					valueField: "volume",
					type: "column",
					showBalloon: false,
					fillAlphas: 1
				}],

				stockLegend: {
					markerType: "none",
					markerSize: 0,
					labelText: "",
					periodValueTextRegular: "[[value.close]]"
				}
			}
		],

		chartCursorSettings: {
			valueLineEnabled:true,
			valueLineBalloonEnabled:true,
			categoryBalloonDateFormats:[{period:"YYYY", format:"YYYY"}, {period:"MM", format:"MM/YYYY"}, {period:"WW", format:"DD/MM/YYYY"}, {period:"DD", format:"DD/MM/YYYY"}, {period:"hh", format:"JJ:NN"}, {period:"mm", format:"JJ:NN"}, {period:"ss", format:"JJ:NN:SS"}, {period:"fff", format:"JJ:NN:SS"}]
		},


		chartScrollbarSettings: {
			graph: "g1",
			graphType: "line",
			usePeriod: "WW",
			updateOnReleaseOnly:false
		},

		periodSelector: {
			position: "bottom",
			periods: [{
				period: "DD",
				count: 10,
				label: "10 days"
			}, {
				period: "MM",
				selected: true,
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
		}
	});
	
	
	AmCharts.makeChart("chartdivevent", {
		type: "stock",
		dataSets: [{
			color: "#b0de09",
			fieldMappings: [{
				fromField: "volume",
				toField: "volume"
			}, {
				fromField: "close",
				toField: "close"
			}],
			dataProvider: chartData,
			categoryField: "date",
			// EVENTS
			stockEvents: chartStockEvents
		}],


		panels: [{
			title: "Value",
			percentHeight: 70,

			stockGraphs: [{
				id: "g1",
				valueField: "close"
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
			valueLineBalloonEnabled:true,
			categoryBalloonDateFormats:[{period:"YYYY", format:"YYYY"}, {period:"MM", format:"MM/YYYY"}, {period:"WW", format:"DD/MM/YYYY"}, {period:"DD", format:"DD/MM/YYYY"}, {period:"hh", format:"JJ:NN"}, {period:"mm", format:"JJ:NN"}, {period:"ss", format:"JJ:NN:SS"}, {period:"fff", format:"JJ:NN:SS"}]
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
var companyProfileUrl = '${COMPANY_PROFILE_URL}';
var search = function(){
	var symbol = $("#symbol").val();
	var tmpCompanyProfileUrl = companyProfileUrl.replace("{0}", symbol);
	$("#companyProfile").attr("href",tmpCompanyProfileUrl);
	getDataAndDrawchart();
}


$(document).ready(function(){
	getDataAndDrawchart();
	
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		  var target = $(e.target).attr("href") // activated tab
		  if(target === "#listprice"){
			  drawGrid();
		  }
	});
	
})



</script>

<form id="ff000201-form-search">
<div class="table-responsive form-group">
	<table class="table">
	  <tr>
	  	<td>
	  		<div class="form-group">
			    <input id="symbol" name = "symbol" type="text" class="form-control" placeholder="Symbol" style="text-transform:uppercase" value='${symbol}'>
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
<a id="companyProfile" class="fffancybox fancybox.iframe" href="${COMPANY_PROFILE_URL.replace('{0}',symbol)}">Profile</a>
<div>

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    
    <li role="presentation" class="active"><a href="#chartevent" aria-controls="chartevent" role="tab" data-toggle="tab">Event</a></li>
    <li role="presentation" ><a href="#chartprice" aria-controls="chart" role="tab" data-toggle="tab">Chart</a></li>
    <li role="presentation"><a href="#listprice" aria-controls="listprice" role="tab" data-toggle="tab">Grid</a></li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    
    <div role="tabpanel" class="tab-pane  active" id="chartevent">
    	<div id="chartdivevent" style="width:100%; height:500px;"></div>
    </div>
    <div role="tabpanel" class="tab-pane" id="chartprice">
    	<div id="chartdiv" style="width:100%; height:500px;"></div>
    </div>
    <div role="tabpanel" class="tab-pane" id="listprice">
    	<div id="jsGrid"></div>
    </div>
  </div>

</div>
