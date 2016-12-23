package com.ff.fdemo.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class ExceptionHandler extends SimpleMappingExceptionResolver{
	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) {
		logger.error(ex);
		ex.printStackTrace();
	
		// Expose ModelAndView for chosen error view.
		String viewName = determineViewName(ex, request);
		
		if (viewName != null) {
			// Apply HTTP status code for error views, if specified.
			// Only apply it if we're processing a top-level request.
			Integer statusCode = determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			return getModelAndView(viewName, ex, request);
		}
		else {
			return null;
		}
	}

	

}
