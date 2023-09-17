package com.seam.focs.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    /**
     * Configure static file mapping
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //Find file in backend directory
        log.info("Start Static File Mapping");
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/frontend/**").addResourceLocations("classpath:/frontend/");
        registry.addResourceHandler("/dist/**").addResourceLocations("classpath:/dist/");
    }

    /**
     * Extend MVC Framework's message converter
     * For JSON <-> Java Conversion
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("Extend message converter...");

        //MappingJackson2HttpMessageConverter is provided by Web MVC Framework
        //Convert the results from backend to JSON to be responded in frontend
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        //Configure Object Converter, the fundamental is using Jackson to convert Java to JSON
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        //add to mvc framework's list, put at 0 so will take priority in using our own converter, otherwise will use their own converter
        converters.add(0, messageConverter);
    }
}
