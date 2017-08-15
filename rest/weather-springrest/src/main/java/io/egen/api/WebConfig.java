package io.egen.api;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
		//	.allowedOrigins("http://mocker.egen.io")
			.allowedOrigins("*")
			.allowedMethods("GET","POST")
			.allowedHeaders("*")
			.allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                    "Access-Control-Request-Headers","Access-Control-Allow-Origin")	
//			.allowedHeaders("*")
			.exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
            .allowCredentials(false).maxAge(3600);
            		
}

//@Override
//	public class CorsFilter extends OncePerRequestFilter {
//
//	    static final String ORIGIN = "Origin";
//
//	    protected void doFilterInternal(
//	        HttpServletRequest request, 
//	        HttpServletResponse response, 
//	        FilterChain filterChain) throws ServletException, IOException {
//	    
//	        String origin = request.getHeader(ORIGIN);
//	    
//	        response.setHeader("Access-Control-Allow-Origin", "*");//* or origin as u prefer
//	        response.setHeader("Access-Control-Allow-Credentials", "true");
//	        response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");
//	        response.setHeader("Access-Control-Max-Age", "3600");
//	        response.setHeader("Access-Control-Allow-Headers", "content-type, authorization");
//	    
//	        if (request.getMethod().equals("OPTIONS"))
//	            response.setStatus(HttpServletResponse.SC_OK);
//	        else 
//	            filterChain.doFilter(request, response);
//	    
//	    }
//	}
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//	    web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
//	}

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
