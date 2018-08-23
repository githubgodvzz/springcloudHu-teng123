package com.chinasofti.huateng.servicezuulcenter;

import java.io.FilenameFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;

import groovy.ui.GroovyFileFilter;


@EnableZuulProxy
@SpringCloudApplication
@EnableConfigurationProperties({FilterConfiguration.class})
public class ServicezuulcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicezuulcenterApplication.class, args);
	}
	
	@RefreshScope
	@ConfigurationProperties("zuul")
	public ZuulProperties zuulProperties()
	{
		return new ZuulProperties();
	}
	@Bean
	public FilterLoader filterLoader(FilterConfiguration filterConfituration)
	{
		FilterLoader filterLoader = FilterLoader.getInstance();
		filterLoader.setCompiler(new GroovyCompiler());
		
		try
		{
			FilterFileManager.setFilenameFilter(new com.netflix.zuul.groovy.GroovyFileFilter());
			FilterFileManager.init(filterConfituration.getInterval(), filterConfituration.getRoot()+"/pre", filterConfituration.getRoot()+"/post");
		}
		catch(Exception ex)
		{
			throw new RuntimeException(ex);
		}
		return filterLoader;
		
	}
	
}
