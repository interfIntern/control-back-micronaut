package mx.com.burodecredito.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import mx.com.burodecredito.domain.Folios;
import mx.com.burodecredito.serviceImpl.FoliosService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/folios")
@Produces(MediaType.APPLICATION_JSON)
@Validated
public class FoliosController {
    @Inject
    private FoliosService service;

    @Get("/{id}")
    public HttpResponse<Folios> show(@NotNull Integer id) {

        return service.findById(id);
    }

    @Get
    public HttpResponse<List<Folios>> getAll() {

        return service.getAll();
    }

    @Post
    public HttpResponse<Folios> add(@Body @Valid Folios param) {

        return service.save(param);
    }

    @Put
    public HttpResponse<Folios> update(@Body @Valid Folios param) {

        return service.update(param);
    }

    @Delete("/{id}")
    public HttpResponse delete(@NotNull Integer id) {

        return service.delete(id);
    }
}
