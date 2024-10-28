package ar.edu.ubp.das.supermercadosoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SupermercadoSoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupermercadoSoapApplication.class, args);
    }
    @Bean
    public ApplicationListener<WebServerInitializedEvent> onServerReady() {
        return event -> {
            int port = event.getWebServer().getPort();  // Obtiene el puerto del servidor
            System.out.println("La aplicación se está ejecutando en el puerto: " + port);
        };
    }
}
