package mx.com.burodecredito.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import mx.com.burodecredito.domain.Servers;
import mx.com.burodecredito.serviceImpl.ServersService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/servers")
@Produces(MediaType.APPLICATION_JSON)
@Validated
public class ServersController {
    @Inject
    private ServersService service;

    @Get("/{id}")
    public HttpResponse<Servers> show(@NotNull Integer id) {

        return service.findById(id);
    }

    @Get
    public HttpResponse<List<Servers>> getAll() {

        return service.getAll();
    }

    @Post
    public HttpResponse<Servers> add(@Body @Valid Servers param) {

        return service.save(param);
    }

    @Put
    public HttpResponse<Servers> update(@Body @Valid Servers param) {

        return service.update(param);
    }

    @Delete("/{id}")
    public HttpResponse delete(@NotNull Integer id) {

        return service.delete(id);
    }
}
