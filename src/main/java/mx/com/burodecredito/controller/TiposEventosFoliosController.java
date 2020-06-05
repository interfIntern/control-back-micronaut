package mx.com.burodecredito.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import mx.com.burodecredito.domain.TiposEventosFolios;
import mx.com.burodecredito.serviceImpl.TiposEventosFoliosService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/tipo-evento-folio")
@Produces(MediaType.APPLICATION_JSON)
@Validated
public class TiposEventosFoliosController {
    @Inject
    private TiposEventosFoliosService service;

    @Get
    public HttpResponse<List<TiposEventosFolios>> getAll() {

        return service.getAll();
    }

    @Get("/{id}")
    public HttpResponse<TiposEventosFolios> show(@NotNull Integer id) {

        return service.findById(id);
    }

    @Post
    public HttpResponse<TiposEventosFolios> add(@Body @Valid TiposEventosFolios param) {

        return service.save(param);
    }

    @Put
    public HttpResponse<TiposEventosFolios> update(@Body @Valid TiposEventosFolios param) {

        return service.update(param);
    }

    @Delete("/{id}")
    public HttpResponse delete(@NotNull Integer id) {

        return service.delete(id);
    }
}
