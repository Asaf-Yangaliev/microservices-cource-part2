package uz.yangaliev.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f.addRequestHeader("MyRequestHeader", "MyValue")
                                .addRequestParameter("myParam", "myParamValue"))
                        .uri("http://httpbin.org:80"))
//                .route(p -> p.path("/functions/**")
//                        .uri("lb://functions-service"))
                .route(p -> p.path("/spring-cloud/**")
                        .uri("lb://user-service"))
                .build();
    }
}
