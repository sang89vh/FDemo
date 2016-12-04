<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/taglib.jsp"%>
<script type="text/javascript">
$(function() {
	 
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
 
});

</script>
<div id="jsGrid"></div>