package mx.com.burodecredito;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Micronaut Application",
                version = "1.0",
                description = "API for Buro de crédito",
                contact = @Contact(name = "Buro de crédito", email = "contacto@contacto.com")
        )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}