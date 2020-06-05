package mx.com.burodecredito.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import mx.com.burodecredito.domain.Aplicativos;
import mx.com.burodecredito.serviceImpl.AplicativosService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/aplicativos")
@Produces(MediaType.APPLICATION_JSON)
@Validated
public class AplicativosController {
    @Inject
    private AplicativosService service;

    @Get("/{id}")
    public HttpResponse<Aplicativos> show(@NotNull Integer id) {

        return service.findById(id);
    }

    @Get
    public HttpResponse<List<Aplicativos>> getAll() {

        return service.getAll();
    }

    @Post
    public HttpResponse<Aplicativos> add(@Body @Valid Aplicativos param) {

        return service.save(param);
    }

    @Put
    public HttpResponse<Aplicativos> update(@Body @Valid Aplicativos param) {

        return service.update(param);
    }

    @Delete("/{id}")
    public HttpResponse delete(@NotNull Integer id) {

        return service.delete(id);
    }
}
