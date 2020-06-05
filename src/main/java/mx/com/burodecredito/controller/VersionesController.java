package mx.com.burodecredito.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import mx.com.burodecredito.domain.Versiones;
import mx.com.burodecredito.serviceImpl.VersionesService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/versiones")
@Produces(MediaType.APPLICATION_JSON)
@Validated
public class VersionesController {
    @Inject
    private VersionesService service;

    @Get("/{id}")
    public HttpResponse<Versiones> show(@NotNull Integer id) {

        return service.findById(id);
    }

    @Get
    public HttpResponse<List<Versiones>> getAll() {

        return service.getAll();
    }

    @Post
    public HttpResponse<Versiones> add(@Body @Valid Versiones param) {

        return service.save(param);
    }

    @Put
    public HttpResponse<Versiones> update(@Body @Valid Versiones param) {

        return service.update(param);
    }

    @Delete("/{id}")
    public HttpResponse delete(@NotNull Integer id) {

        return service.delete(id);
    }
}
