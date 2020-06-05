package mx.com.burodecredito.serviceImpl;

import io.micronaut.http.HttpResponse;
import mx.com.burodecredito.dao.LideresRepository;
import mx.com.burodecredito.domain.Lideres;
import mx.com.burodecredito.service.IGenericService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class LideresService implements IGenericService<Lideres, Integer> {

    @Inject
    private LideresRepository repository;

    @Override
    public HttpResponse<Lideres> findById(Integer param) {
        Lideres responseBody = repository.findById(param).orElse(null);
        return HttpResponse.ok(responseBody);
    }

    @Override
    public HttpResponse<List<Lideres>> getAll() {
        List<Lideres> responsBody = repository.findAll();
        return HttpResponse.ok(responsBody);
    }

    @Override
    public HttpResponse<Lideres> save(Lideres param) {
        Lideres responseBody = repository.save(param);
        return HttpResponse.created(responseBody);
    }

    @Override
    public HttpResponse<Lideres> update(Lideres param) {
        Lideres responseBody;
        Optional<Lideres> findById = repository.findById(param.getIdLider());
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