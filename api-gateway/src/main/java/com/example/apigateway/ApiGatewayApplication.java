package com.example.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.filter.TokenRelayFilterFunctions.tokenRelay;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class ApiGatewayApplication {

    @Bean
    public RouterFunction<ServerResponse> gatewayRouterFunctionsLoadBalancer() {
       return route("bookingService")
                .route(path("/booking/**"), http())
                   .route(path("/booking/{id}"), http())
                .filter(lb("bookingService"))
                .filter(tokenRelay())
               .add(route("carInventory")
                       .route(path("/list-available-car/**"), http())
                       .route(path("/reserve/**"), http())
                       .route(path("/return/**"), http())
                       .route(path("/add-car/**"), http())
                       .filter(lb("carInventory"))
                       .filter(tokenRelay())
                       .build())
               .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}

record Car(String name) {
}

@FeignClient(name = "carService", fallback = Fallback.class)
@Component
interface CarClient {

    @GetMapping("/cars")
    CollectionModel<Car> readCars();

}

@Component
class Fallback implements CarClient {

    @Override
    public CollectionModel<Car> readCars() {
        return CollectionModel.empty();
    }
}
@Configuration
class CoolCarConfiguration {


    @Bean(name = "carClient1")
    public CarClient carClient() {
        return new Fallback();
    }

    @RestController
    static
    class CoolCarController {

        private final CarClient carClient;

        public CoolCarController(CarClient carClient) {
            this.carClient = carClient;
        }

        @GetMapping("/cool-cars")
        public Collection<Car> coolCars() {
            if (carClient == null) {
                // Manejar la situación en la que carClient es nulo
                // Por ejemplo, lanzar una excepción, devolver una lista vacía, etc.
                return Collections.emptyList();
            }

            return carClient.readCars()
                    .getContent()
                    .stream()
                    .filter(this::isCool)
                    .collect(Collectors.toList());
        }

        private boolean isCool(Car car) {
            return !car.name().equals("AMC Gremlin") &&
                    !car.name().equals("Triumph Stag") &&
                    !car.name().equals("Ford Pinto") &&
                    !car.name().equals("Yugo GV");
        }

    }
}
