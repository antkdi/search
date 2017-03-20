package com.saramin.lab.search.param;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.saramin.lab.search.common.CommonUtils;
import com.saramin.lab.search.common.GlobalConstant;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class SearchParameterMethodResolver implements HandlerMethodArgumentResolver{
	
	@Autowired
	Environment env;

	@Autowired
	CommonUtils common;
	
	@Autowired
	SearchParameter param;

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
		if(webRequest.getNativeRequest() instanceof HttpServletRequest){
			
			final HttpServletRequest req = webRequest.getNativeRequest(HttpServletRequest.class);
			SearchParameter tempParam = new SearchParameter();
			
			//Origin Kwd
			tempParam.setOriginKwd(common.null2Str(req.getParameter("kwd"),""));
			//Kwd - SpellCheck
			tempParam.setKwd(tempParam.getOriginKwd().replaceAll(env.getProperty(GlobalConstant.KWD_SPELL_CHECK_NM), ""));
			//pageNum
			tempParam.setPageNum(Integer.valueOf(common.null2Str(req.getParameter("pageNum"), "1")));
			//pageSize
			tempParam.setPageSize(Integer.valueOf(common.null2Str(req.getParameter("pageNum"), "10")));
			
			
			param = tempParam;
		}
		return param;
	}

}
