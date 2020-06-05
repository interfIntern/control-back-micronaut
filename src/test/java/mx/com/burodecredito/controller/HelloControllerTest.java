package mx.com.burodecredito.controller;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class HelloControllerTest {


    private static EmbeddedServer server;
    private static HttpClient client;

    @BeforeAll
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server
                .getApplicationContext()
                .createBean(HttpClient.class, server.getURL());
    }

    @AfterAll
    public static void stopServer() {
        if(server != null) {
            server.stop();
        }
        if(client != null) {
            client.stop();
        }
    }

    @Test
    public void testIssue() {
        String body = client.toBlocking().retrieve("/hello/Jorge");

        assertNotNull(body);
        assertEquals("Hello Jorge", body);
    }


    @Test
    public void testIssueWithoutNumber() {
        HttpClientResponseException e = Assertions.assertThrows(HttpClientResponseException.class, () ->
                client.toBlocking().exchange("/hello"));

        assertEquals(404, e.getStatus().getCode());
    }

}
