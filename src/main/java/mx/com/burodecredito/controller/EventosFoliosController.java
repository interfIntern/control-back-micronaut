package mx.com.burodecredito.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import mx.com.burodecredito.domain.DependenciasAplicativos;
import mx.com.burodecredito.domain.EventosFolios;
import mx.com.burodecredito.serviceImpl.DependenciasAplicativosService;
import mx.com.burodecredito.serviceImpl.EventosFoliosService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/eventos-folios")
@Produces(MediaType.APPLICATION_JSON)
@Validated
public class EventosFoliosController {
    @Inject
    private EventosFoliosService service;

    @Get("/{id}")
    public HttpResponse<EventosFolios> show(@NotNull Integer id) {

        return service.findById(id);
    }

    @Get
    public HttpResponse<List<EventosFolios>> getAll() {

        return service.getAll();
    }

    @Post
    public HttpResponse<EventosFolios> add(@Body @Valid EventosFolios param) {

        return service.save(param);
    }

    @Put
    public HttpResponse<EventosFolios> update(@Body @Valid EventosFolios param) {

        return service.update(param);
    }

    @Delete("/{id}")
    public HttpResponse delete(@NotNull Integer id) {

        return service.delete(id);
    }
}
