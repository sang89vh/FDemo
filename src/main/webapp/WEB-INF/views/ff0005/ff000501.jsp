<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<script>
var draw01 = function(){
	/* "symbol": 2005,
	"income": 23.5,
	"expenses": 18.1 */
$.post( ctx + "/ff0005/data01?${_csrf.parameterName}=${_csrf.token}",function( chart01Data ) {
	 
	  
	  var chart = AmCharts.makeChart("chartdiv", {
			"type": "serial",
		     "theme": "light",
			"categoryField": "symbol",
			"rotate": false,
			"startDuration": 1,
			"categoryAxis": {
				"gridPosition": "start",
				"position": "left"
			},
			"trendLines": [],
			"graphs": [
				{
					"balloonText": "Income:[[value]]",
					"fillAlphas": 0.8,
					"id": "AmGraph-1",
					"lineAlpha": 0.2,
					"title": "Income",
					"type": "column",
					"valueField": "income"
				},
				{
					"balloonText": "Expenses:[[value]]",
					"fillAlphas": 0.8,
					"id": "AmGraph-2",
					"lineAlpha": 0.2,
					"title": "Expenses",
					"type": "column",
					"valueField": "expenses"
				}
			],
			"guides": [],
			"valueAxes": [
				{
					"id": "ValueAxis-1",
					"position": "top",
					"axisAlpha": 0
				}
			],
			"allLabels": [],
			"balloon": {},
			"titles": [],
			"dataProvider": chart01Data,
		    "export": {
		    	"enabled": true
		     }

		});
	 
}, "json");	

}
var draw02 = function(){
$.post( ctx + "/ff0005/data02?${_csrf.parameterName}=${_csrf.token}",function( chart02Data ) {
var chart = AmCharts.makeChart("chartdiv2", {
    "type": "serial",
    "theme": "light",
    "legend": {
        "autoMargins": false,
        "borderAlpha": 0.2,
        "equalWidths": false,
        "horizontalGap": 10,
        "markerSize": 10,
        "useGraphSettings": true,
        "valueAlign": "left",
        "valueWidth": 0
    },
    "dataProvider": [chart02Data],
    "valueAxes": [{
        "stackType": "100%",
        "axisAlpha": 0,
        "gridAlpha": 0,
        "labelsEnabled": false,
        "position": "left"
    }],
    "graphs": [{
        "balloonText": "[[title]], [[category]]<br><span style='font-size:14px;'><b>[[value]]</b> ([[percents]]%)</span>",
        "fillAlphas": 0.9,
        "fontSize": 11,
        "labelText": "[[percents]]%",
        "lineAlpha": 0.5,
        "title": "Expenses",
        "type": "column",
        "valueField": "expenses"
    }, {
        "balloonText": "[[title]], [[category]]<br><span style='font-size:14px;'><b>[[value]]</b> ([[percents]]%)</span>",
        "fillAlphas": 0.9,
        "fontSize": 11,
        "labelText": "[[percents]]%",
        "lineAlpha": 0.5,
        "title": "Income",
        "type": "column",
        "valueField": "income"
    }],
    "marginTop": 30,
    "marginRight": 0,
    "marginLeft": 0,
    "marginBottom": 40,
    "autoMargins": false,
    "categoryField": "report",
    "categoryAxis": {
        "gridPosition": "start",
        "axisAlpha": 0,
        "gridAlpha": 0
    },
    "export": {
    	"enabled": true
     }

});

}, "json");	
}
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
                    url: ctx + "/ff0005/data03?${_csrf.parameterName}=${_csrf.token}",
                    dataType: "json",
                    method:'post'
                }).done(function(response) {
                    d.resolve(response);
                });
 
                return d.promise();
            }
        },
 
        fields: [
        	{ name: "symbol",title:"Symbol", type: "text" },
        	{ name: "expenses",title:"Expenses", type: "number" },
            { name: "income",title:"Income", type: "number" },
            { name: "profit",title:"Profit", type: "number" },
            { name: "roe",title:"ROE" ,type: "number" }
        ]
    });
 
};
$(document).ready(function(){
	draw01();
	draw02();
	drawGrid();
})
</script>
<div class="col-md-12">

<div th:if="${message}">
	<h5 th:text="${message}" />
</div>
<div class="table-responsive form-group">
<h5>Trading log</h5>
<form method="POST" enctype="multipart/form-data" action="${ctx}/ff0005/upload?${_csrf.parameterName}=${_csrf.token}">
	<table class="table">
		<tr>
			<td></td>
			<td>
				<div class="form-group">
					<input type="file" name="file" /><br/>
					<input type="submit" value="Upload" class="btn"/>
				</div>
			</td>
		</tr>
	</table>
</form>
</div>
<div class="table-responsive form-group">
<h5>Asset Report</h5>
<form method="POST" enctype="multipart/form-data" action="${ctx}/ff0005/upload02?${_csrf.parameterName}=${_csrf.token}">
	<table class="table">
		<tr>
			<td></td>
			<td>
				<div class="form-group">
					<input type="file" name="file" /><br/>
					<input type="submit" value="Upload" class="btn"/>
				</div>
			</td>
		</tr>
	</table>
</form>
</div>
</div>
<div class="col-md-12">
<!-- HTML -->
<div id="chartdiv" style="height: 500px"></div>
</div>
<div class="col-md-12">
<!-- HTML -->
<div id="chartdiv2" style="height: 500px"></div>
</div>
<div class="col-md-12">
<div id="jsGrid"></div>
</div>
<iframe height="1000px" width="100%" src="https://eztrade.fpts.com.vn/EzTrade/AssetReport2"></iframe>
