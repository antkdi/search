package com.saramin.lab.search;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.saramin.lab.search.param.SearchParameterMethodResolver;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(new SearchParameterMethodResolver());

  }
}
