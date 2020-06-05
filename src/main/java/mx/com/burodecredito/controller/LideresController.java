package mx.com.burodecredito.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import mx.com.burodecredito.domain.Lideres;
import mx.com.burodecredito.serviceImpl.LideresService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/lideres")
@Produces(MediaType.APPLICATION_JSON)
@Validated
public class LideresController {
    @Inject
    private LideresService service;

    @Get("/{id}")
    public HttpResponse<Lideres> show(@NotNull Integer id) {

        return service.findById(id);
    }

    @Get
    public HttpResponse<List<Lideres>> getAll() {

        return service.getAll();
    }

    @Post
    public HttpResponse<Lideres> add(@Body @Valid Lideres param) {

        return service.save(param);
    }

    @Put
    public HttpResponse<Lideres> update(@Body @Valid Lideres param) {

        return service.update(param);
    }

    @Delete("/{id}")
    public HttpResponse delete(@NotNull Integer id) {

        return service.delete(id);
    }
}
