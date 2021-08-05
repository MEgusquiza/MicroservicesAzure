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
    return RouterFunctions.route(RequestPredicates.GET("api/client/"),handler::list)
                          .andRoute(RequestPredicates.GET("/api/client/{id}"),handler::see)
                          .andRoute(RequestPredicates.POST("/api/client/"),handler::create)
                          .andRoute(RequestPredicates.PUT("/api/client/{id}"),handler::edit)
                          .andRoute(RequestPredicates.DELETE("/api/client/{id}"),handler::delete);
   }

}
