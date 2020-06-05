package mx.com.burodecredito.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import mx.com.burodecredito.domain.Ambientes;
import mx.com.burodecredito.serviceImpl.AmbientesService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/ambientes")
@Produces(MediaType.APPLICATION_JSON)
@Validated
public class AmbientesController {
    @Inject
    private AmbientesService service;

    @Get("/{id}")
    public HttpResponse<Ambientes> show(@NotNull Integer id) {

        return service.findById(id);
    }

    @Get
    public HttpResponse<List<Ambientes>> getAll() {

        return service.getAll();
    }

    @Post
    public HttpResponse<Ambientes> add(@Body @Valid Ambientes param) {

        return service.save(param);
    }

    @Put
    public HttpResponse<Ambientes> update(@Body @Valid Ambientes param) {

        return service.update(param);
    }

    @Delete("/{id}")
    public HttpResponse delete(@NotNull Integer id) {

        return service.delete(id);
    }
}
