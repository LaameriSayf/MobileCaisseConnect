package CaisseConnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permet CORS sur tous les endpoints
                .allowedOrigins("http://192.168.1.102:8089","http://localhost:8080") // Origines autorisées
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes HTTP autorisées
                .allowedHeaders("*") // Tous les headers sont autorisés
                .allowCredentials(true); // Autorise les cookies ou les tokens
    }
}
