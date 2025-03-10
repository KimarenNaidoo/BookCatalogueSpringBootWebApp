package com.example.BookCatalogueSpringBootWebApp.config;

import java.io.IOException;

import org.springframework.web.servlet.config.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(@SuppressWarnings("null") ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }

    @Override
    public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:8081")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

    @Override
    public void addResourceHandlers(@SuppressWarnings("null") ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver() {

                    @Override
                    protected Resource getResource(@SuppressWarnings("null") String resourcePath, @SuppressWarnings("null") Resource location) throws IOException {
                        Resource resource = location.createRelative(resourcePath);
                        if (resource.exists() && resource.isReadable()) {
                            return resource;
                        }
                        
                        // Forward to index.html only for non-API requests
                        if (!resourcePath.startsWith("api/")) {
                            return location.createRelative("index.html");
                        }
                        
                        return null;
                    }
                });
    }
}