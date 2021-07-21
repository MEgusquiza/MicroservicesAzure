package com.client.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.client.app.handler.ProductHandler;

@Configuration
public class RouterConfig {
   
  
  @Bean
  public RouterFunction<ServerResponse> rutas (ProductHandler handler){
    return RouterFunctions.route(RequestPredicates.GET("api/product/"),handler::list)
        .andRoute(RequestPredicates.GET("/api/product/{id}"),handler::see);
    
    
  }

}
