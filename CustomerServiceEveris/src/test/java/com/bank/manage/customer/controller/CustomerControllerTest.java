package com.bank.manage.customer.controller;

import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;


import com.bank.manage.customer.domain.repository.CustomerRepository;
import com.bank.manage.customer.domain.service.CustomerService;
import com.bank.manage.customer.domain.service.impl.CustomerServiceImpl;
import com.bank.manage.customer.persistence.entity.Customer;
import org.assertj.core.api.Assertions;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CustomerController.class)
@Import(CustomerServiceImpl.class)

class CustomerControllerTest {

  @MockBean
  CustomerRepository repository;

  @Autowired
  private CustomerService service;
  
  @Autowired
  private WebTestClient webClient;
  
  private String url= "/customer";

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
  }

  @BeforeEach
  void setUp() throws Exception {
  }

  @AfterEach
  void tearDown() throws Exception {
  }

  @Test
  void testGetCustomerById() {
    Customer customer = new Customer();
    customer.setFirstName("Katy");
    customer.setLastName("Puente");
    customer.setMail("manuel@everis.com");
    customer.setDocument(34563563);
    customer.setDocumentType("DNI");
    customer.setPhone(205649060);
    customer.setState("A");
    Mockito
        .when(repository.findById("60e231e30d2f326bba123479"))
        .thenReturn(Mono.just(customer));
    webClient.get().uri(url.concat("/{id}"), "60e231e30d2f326bba123479")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$.firstName").isNotEmpty()
        .jsonPath("$.lastName").isEqualTo("Puente");
   Mockito.verify(repository, times(1)).findById("60e231e30d2f326bba123479");
  }

  @Test
  void testGetCustomerByName() {
    Customer customer = new Customer();
    customer.setFirstName("Katy");
    customer.setLastName("Puente");
    customer.setMail("manuel@everis.com");
    customer.setDocument(34563563);
    customer.setDocumentType("DNI");
    customer.setPhone(205649060);
    customer.setState("A");

    Mockito
        .when(repository.findByFirstName("Katy"))
        .thenReturn(Mono.just(customer));

    webClient.get().uri(url.concat("/name/{name}"), "Katy")
     .exchange()
    .expectStatus().isOk()
    .expectBodyList(Customer.class);
     
   Mockito.verify(repository, times(1)).findByFirstName("Katy");
  }
  
   @Test
   void testGetAllCustomers() {
 
    List<Customer> list = new ArrayList<Customer>();
    Flux<Customer> customerFlux = Flux.fromIterable(list);
     
    Mockito
        .when(repository.findAll())
        .thenReturn(customerFlux);
    
    webClient.get().uri(url.concat("/"))
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .expectBodyList(Customer.class)
        .consumeWith(response -> {
          List<Customer> customer = response.getResponseBody();
          customer.forEach(c -> {
              System.out.println("FirstName:" +c.getFirstName());
          });
       //    Assertions.assertThat(customer.size()>0).isTrue();
      });
    Mockito.verify(repository, times(1)).findAll();
 } 
  
 /* @Test
  void testCreateCustomer() {
   
    
    Customer customer = new Customer();
    customer.setId("343");
    customer.setFirstName("Maria");
    customer.setLastName("Meza");
    customer.setDocument(5463456);
    customer.setDocumentType("DNI");
    customer.setMail("anny@everis.com");
    customer.setPhone(998598586);
    customer.setState("A");
    
    webClient.post().uri(url.concat("/"))
    .contentType(MediaType.APPLICATION_JSON)
    .accept(MediaType.APPLICATION_JSON)
    .body(Mono.just(customer), Customer.class)
    .exchange()
    .expectStatus().isCreated()
    .expectHeader().contentType(MediaType.APPLICATION_JSON)
    .expectBody(Customer.class)
    .consumeWith(response -> {
      Customer p = response.getResponseBody();
      Assertions.assertThat(p.getId()).isNotEmpty();
      Assertions.assertThat(p.getFirstName()).isEqualTo("Maria");
    });
  }

  @Test
  void testDeleteCustomer() 
  {   Customer customer = new Customer();
      Mono<Void> voidReturn  = Mono.empty();
      Mockito
          .when(repository.delete(customer))
          .thenReturn(voidReturn);

            webClient.get().uri(url+"/{id}", "60e231ee0d2f326bba12347a")
          .exchange()
          .expectStatus().isOk();
  } */
}
