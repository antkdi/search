package com.saramin.lab.search.param;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class SearchParameterMethodResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return SearchParameter.class.isAssignableFrom(parameter.getParameterType());
	}

	@Override
	public SearchParameter resolveArgument(final MethodParameter methodParam,
			final ModelAndViewContainer modelAndViewContainer, 
			final NativeWebRequest webRequest,
			final WebDataBinderFactory webDataBinderFactory) throws Exception {
		SearchParameter param = new SearchParameter();
		if(webRequest.getNativeRequest() instanceof HttpServletRequest){
			
			final HttpServletRequest req = webRequest.getNativeRequest(HttpServletRequest.class);
			SearchParameter tempParam = new SearchParameter();
			
			tempParam.setDocId(req.getParameter("docId"));
			tempParam.setKwd(req.getParameter("kwd"));
			//tempParam.setPageNum(Integer.valueOf(req.getParameter("docId")));
			tempParam.setPageNum(999);
			tempParam.setPageSize(999);
			//tempParam.setPageSize(Integer.valueOf(req.getParameter("docId")));
			
			
			param = tempParam;
		}
		return param;
	}

}
