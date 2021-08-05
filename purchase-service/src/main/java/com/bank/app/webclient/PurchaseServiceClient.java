package com.bank.app.webclient;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import com.bank.app.model.Purchase;
import com.bank.app.webclient.model.PurchaseDTO;

import reactor.core.publisher.Mono;

@Component
public class PurchaseServiceClient {

 private final Logger logger = LoggerFactory.getLogger(PurchaseServiceClient.class);
  
  @Value("${url.apigateway.service}")
  private String urlApiGatewayService;
   
  
  WebClient client;
  
  @Bean
  public void init() {
         client = WebClient.create(urlApiGatewayService);
   }
  
  public Mono<PurchaseDTO> sendSavePurchaseToPayment(Purchase purchase) {
    logger.info("Se envio purchase a db payment:..." + purchase.toString() );
    logger.info("URI:..." + urlApiGatewayService );
    return  client.post()
           .uri("/payment/save-purchase")
           .accept(MediaType.APPLICATION_JSON)  
           .contentType(MediaType.APPLICATION_JSON)
           .body(BodyInserters.fromValue(purchase))
          // .body(Mono.just(customer), Customer.class)
           .retrieve()
           .bodyToMono(PurchaseDTO.class);
      }     
  
  public Mono<PurchaseDTO> sendSavePurchaseToCredit(Purchase purchase) {
    logger.info("Se envio purchase a db credit :..." + purchase.toString() );
    logger.info("URI:..." + urlApiGatewayService );
    return  client.post()
           .uri("/credit/save-purchase")
           .accept(MediaType.APPLICATION_JSON)  
           .contentType(MediaType.APPLICATION_JSON)
           .body(BodyInserters.fromValue(purchase))
           .retrieve()
           .bodyToMono(PurchaseDTO.class);
      } 
  
  public Mono<PurchaseDTO> sendSavePurchaseToAccount(Purchase purchase) {
    logger.info("Se envio purchase a db Account :..." + purchase.toString() );
    logger.info("URI:..." + urlApiGatewayService );
    return  client.post()
           .uri("/account/save-purchase")
           .accept(MediaType.APPLICATION_JSON)  
           .contentType(MediaType.APPLICATION_JSON)
           .body(BodyInserters.fromValue(purchase))
           .retrieve()
           .bodyToMono(PurchaseDTO.class)
           .onErrorResume(e -> {
              if (e instanceof UnknownHostException) {
                logger.warn("Failed to get myStuff, desired service not present................");
              }
              else
              { logger.error("Failed to get myStuff..............." + e.getMessage().toString() );}
              
              return Mono.empty();
           });//.subscribe(p->log.info(Sistem.out.println(p.toString())),error -> logger.error(System.out.println(error.getMessage().toString())));
           
      }     
  
}
