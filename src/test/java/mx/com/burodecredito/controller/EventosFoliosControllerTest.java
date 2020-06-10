package mx.com.burodecredito.controller;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import lombok.extern.slf4j.Slf4j;
import mx.com.burodecredito.domain.EventosFolios;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
@Slf4j
class EventosFoliosControllerTest {

    private static final String API_URI = "/eventos-folios";
    private static EmbeddedServer server;
    private static HttpClient client;
    private static Integer idPrueba = 1;

    @BeforeAll
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server
                .getApplicationContext()
                .createBean(HttpClient.class, server.getURL());
    }

    @AfterAll
    public static void stopServer() {
        if (server != null) {
            server.stop();
        }
        if (client != null) {
            client.stop();
        }
    }

    @Test
    void testGetAll() {
        HttpRequest<Object> request = HttpRequest.GET(API_URI);
        String response = client.toBlocking().retrieve(request);
        assertNotNull(response);
    }

    @Test
    @Order(2)
    void testAdd() {
        HttpClientResponseException thrown = assertThrows(HttpClientResponseException.class, () -> {
            client.toBlocking().retrieve(HttpRequest.GET(API_URI.concat("/") + idPrueba));
        }, "Ya existe el registro con el id: " + idPrueba);

        assertNotNull(thrown.getResponse());
        addData();

    }

    @Test
    @Order(3)
    void testShow() {
        HttpRequest<Object> request = HttpRequest.GET(API_URI.concat("/") + idPrueba);
        String response = client.toBlocking().retrieve(request);
        assertNotNull(response);
    }


    @Test
    @Order(4)
    void testUpdate() {
        EventosFolios params = new EventosFolios();
        params.setIdEvento(idPrueba);
        params.setIdFolio(3);
        params.setIdLider(3);
        params.setDescripcion("Evento: Automatizar pruebas");
        params.setFechaHora(LocalDateTime.now());
        params.setIdTipoEvento(2);
        params.setRegistradoEn(LocalDateTime.now());

        HttpRequest<Object> request = HttpRequest.PUT(API_URI, params);
        EventosFolios response = client.toBlocking().retrieve(request, EventosFolios.class);
        log.info("Respuesta {}", response);
        assertEquals(idPrueba, response.getIdEvento());

        //testDelete();
    }

    private void testDelete() {
        HttpRequest<Object> request = HttpRequest.DELETE(API_URI.concat("/") + idPrueba);
        HttpResponse<Object> response = client.toBlocking().exchange(request);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatus());
    }

    private void addData() {
        log.info("Fecha {}", LocalDateTime.now());
        EventosFolios params = new EventosFolios();
        params.setIdFolio(3);
        params.setIdLider(3);
        params.setDescripcion("Evento: Automatizar pruebas");
        params.setFechaHora(LocalDateTime.now());
        params.setIdTipoEvento(2);
        params.setRegistradoEn(LocalDateTime.now());

        HttpRequest<Object> request = HttpRequest.POST(API_URI, params);
        EventosFolios response = client.toBlocking().retrieve(request, EventosFolios.class);

        log.info("Respuesta {}", response);
        assertNotNull(response);
        idPrueba = response.getIdEvento();
    }
}