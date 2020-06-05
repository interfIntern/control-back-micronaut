package mx.com.burodecredito.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import mx.com.burodecredito.domain.AmbientesVersiones;
import mx.com.burodecredito.serviceImpl.AmbientesVersionesService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/ambientes-versiones")
@Produces(MediaType.APPLICATION_JSON)
@Validated
public class AmbientesVersionesController {
    @Inject
    private AmbientesVersionesService service;

    @Get("/{id}")
    public HttpResponse<AmbientesVersiones> show(@NotNull Integer id) {

        return service.findById(id);
    }

    @Get
    public HttpResponse<List<AmbientesVersiones>> getAll() {

        return service.getAll();
    }

    @Post
    public HttpResponse<AmbientesVersiones> add(@Body @Valid AmbientesVersiones param) {

        return service.save(param);
    }

    @Put
    public HttpResponse<AmbientesVersiones> update(@Body @Valid AmbientesVersiones param) {

        return service.update(param);
    }

    @Delete("/{id}")
    public HttpResponse delete(@NotNull Integer id) {

        return service.delete(id);
    }
}
