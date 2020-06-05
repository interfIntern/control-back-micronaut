package mx.com.burodecredito.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import mx.com.burodecredito.domain.Suites;
import mx.com.burodecredito.serviceImpl.SuitesService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/suites")
@Produces(MediaType.APPLICATION_JSON)
@Validated
public class SuitesController {
    @Inject
    private SuitesService service;

    @Get("/{id}")
    public HttpResponse<Suites> show(@NotNull Integer id) {

        return service.findById(id);
    }

    @Get
    public HttpResponse<List<Suites>> getAll() {

        return service.getAll();
    }

    @Post
    public HttpResponse<Suites> add(@Body @Valid Suites param) {

        return service.save(param);
    }

    @Put
    public HttpResponse<Suites> update(@Body @Valid Suites param) {

        return service.update(param);
    }

    @Delete("/{id}")
    public HttpResponse delete(@NotNull Integer id) {

        return service.delete(id);
    }
}
