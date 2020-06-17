package mx.com.burodecredito.serviceImpl;

import io.micronaut.data.model.Sort;
import io.micronaut.http.HttpResponse;
import mx.com.burodecredito.dao.VersionesRepository;
import mx.com.burodecredito.domain.Versiones;
import mx.com.burodecredito.service.IGenericService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class VersionesService implements IGenericService<Versiones, Integer> {

    @Inject
    private VersionesRepository repository;

    @Override
    public HttpResponse<Versiones> findById(Integer param) {
        Versiones responseBody = repository.findById(param).orElse(null);
        return HttpResponse.ok(responseBody);
    }

    @Override
    public HttpResponse<List<Versiones>> getAll() {
        List<Versiones> responsBody = repository.findAll(Sort.of(Sort.Order.asc("idVersion")));
        return HttpResponse.ok(responsBody);
    }

    @Override
    public HttpResponse<Versiones> save(Versiones param) {
        Versiones responseBody = repository.save(param);
        return HttpResponse.created(responseBody);
    }

    @Override
    public HttpResponse<Versiones> update(Versiones param) {
        Versiones responseBody;
        Optional<Versiones> findById = repository.findById(param.getIdVersion());
        if(findById.isPresent()) {
            responseBody = repository.update(param);
            return HttpResponse.ok(responseBody);
        }

        return HttpResponse.notFound(param);
    }

    @Override
    public HttpResponse delete(Integer param) {
        repository.deleteById(param);
        return HttpResponse.noContent();
    }

}