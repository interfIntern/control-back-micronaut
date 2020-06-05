package mx.com.burodecredito.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import mx.com.burodecredito.domain.DependenciasAplicativos;
import mx.com.burodecredito.serviceImpl.DependenciasAplicativosService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/dependencias-aplicativos")
@Produces(MediaType.APPLICATION_JSON)
@Validated
public class DependenciasAplicativosController {
    @Inject
    private DependenciasAplicativosService service;

    @Get("/{id}")
    public HttpResponse<DependenciasAplicativos> show(@NotNull Integer id) {

        return service.findById(id);
    }

    @Get
    public HttpResponse<List<DependenciasAplicativos>> getAll() {

        return service.getAll();
    }

    @Post
    public HttpResponse<DependenciasAplicativos> add(@Body @Valid DependenciasAplicativos param) {

        return service.save(param);
    }

    @Put
    public HttpResponse<DependenciasAplicativos> update(@Body @Valid DependenciasAplicativos param) {

        return service.update(param);
    }

    @Delete("/{id}")
    public HttpResponse delete(@NotNull Integer id) {

        return service.delete(id);
    }
}
