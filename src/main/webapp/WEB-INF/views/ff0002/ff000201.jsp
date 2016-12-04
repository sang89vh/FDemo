<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<script type="text/javascript">
$(function() {
	 
    $("#jsGrid").jsGrid({
        height: "auto",
        width: "100%",
 
        sorting: true,
        paging: false,
        autoload: true,
 
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
            { name: "symbol", type: "text" }
           
        ]
    });
 
});

</script>
<div id="jsGrid"></div>