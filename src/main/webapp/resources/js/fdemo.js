$.ajaxSetup({
	timeout: 30000000 
});

$(document).ajaxStart(function(){
	console.log("ajaxStart");
});  
$(document).ajaxStop(function(){
	console.log("ajaxStop");
});

$(document).ajaxComplete(function(a,b,c,d,e){
	console.log("ajaxComplete");
});


$(document).ajaxError(function(event, jqxhr, settings, exception) {
	  
	if(settings.suppressErrors) {
        return;
    }else{
		var cont = "";
		
	    if (jqxhr.status === 400) { 
	
			var restError = JSON.parse(jqxhr.responseText);
			
			console.log(restError);
			
			if(restError.errorCode === 'FORM_VALIDATE_ERROR'){
				showFormError(restError,settings.formId);
			}else if(restError.errorCode === 'BUSINESS_ERROR'){
				showBusinessError(restError);
			}else if(restError.errorCode === 'UNKNOWN_ERROR'){
				showBusinessError(restError);
			}else{
				showBusinessError(restError);
			}
			//hidden confirm message
			swal.close()
			return;
			
	    } else if (jqxhr.status === 0) {
	        cont = 'Not connect. Verify Network.('+exception+')';
	    } else if (jqxhr.status == 404) {
	        cont = 'Requested page not found. [404].('+exception+')';
	    } else if (jqxhr.status == 500) {
	        cont = 'Internal Server Error [500].('+exception+')';
	    } else if (exception === 'parsererror') {
	        cont = 'Requested JSON parse failed.';
	    } else if (exception === 'timeout') {
	        cont = 'Time out error.';
	    } else if (exception === 'abort') { 
	        cont = 'Ajax request aborted.';
	    } else {
	        cont = 'Uncaught Error.<br/>' + jqxhr.responseText;
	    }
    }
});

$(document).ready(function() {
	$(".fffancybox").fancybox({
		maxWidth	: 2560,
		maxHeight	: 1600,
		fitToView	: false,
		width		: '98%',
		height		: '98%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'none',
		closeEffect	: 'none'
	});
});

$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
        	var oldVal = o[this.name];
            o[this.name] = oldVal + "," + this.value;
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};