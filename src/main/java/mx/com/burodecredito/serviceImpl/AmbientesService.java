package mx.com.burodecredito.serviceImpl;

import io.micronaut.data.model.Sort;
import io.micronaut.http.HttpResponse;
import mx.com.burodecredito.dao.AmbientesRepository;
import mx.com.burodecredito.domain.Ambientes;
import mx.com.burodecredito.service.IGenericService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class AmbientesService implements IGenericService<Ambientes, Integer> {

    @Inject
    private AmbientesRepository repository;

    @Override
    public HttpResponse<Ambientes> findById(Integer param) {
        Ambientes responseBody = repository.findById(param).orElse(null);
        return HttpResponse.ok(responseBody);
    }

    @Override
    public HttpResponse<List<Ambientes>> getAll() {
        List<Ambientes> responsBody = repository.findAll(Sort.of(Sort.Order.asc("idAmbiente")));
        return HttpResponse.ok(responsBody);
    }

    @Override
    public HttpResponse<Ambientes> save(Ambientes param) {
        Ambientes responseBody = repository.save(param);
        return HttpResponse.created(responseBody);
    }

    @Override
    public HttpResponse<Ambientes> update(Ambientes param) {
        Ambientes responseBody;
        Optional<Ambientes> findById = repository.findById(param.getIdAmbiente());
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