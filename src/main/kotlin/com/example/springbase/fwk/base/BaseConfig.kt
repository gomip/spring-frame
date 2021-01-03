package com.example.springbase.fwk.base

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.servlet.config.annotation.*

/**
 * 21.01.03 | gomip | created
 */

@Configuration
@ComponentScan(basePackages = ["com.example.springbase"], lazyInit = true)
@EnableTransactionManagement                                                                                            // 트랜잭션 활성화
class BaseConfig : WebMvcConfigurer{
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        super.addResourceHandlers(registry)

        registry.addResourceHandler("/swagger-ui/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
            .resourceChain(false)
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedMethods("OPTIONS", "GET", "POST", "PATCH", "PUT", "DELETE")
    }

    override fun configureContentNegotiation(configurer: ContentNegotiationConfigurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON)
    }

    override fun addViewControllers(registry: ViewControllerRegistry) {
        super.addViewControllers(registry)

        registry.addViewController("/swagger-ui/")
            .setViewName("forward:/swagger-ui/index.html")
    }
}