package mx.com.burodecredito.serviceImpl;

import io.micronaut.http.HttpResponse;
import mx.com.burodecredito.dao.ServersRepository;
import mx.com.burodecredito.domain.Servers;
import mx.com.burodecredito.service.IGenericService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class ServersService implements IGenericService<Servers, Integer> {

    @Inject
    private ServersRepository repository;

    @Override
    public HttpResponse<Servers> findById(Integer param) {
        Servers responseBody = repository.findById(param).orElse(null);
        return HttpResponse.ok(responseBody);
    }

    @Override
    public HttpResponse<List<Servers>> getAll() {
        List<Servers> responsBody = repository.findAll();
        return HttpResponse.ok(responsBody);
    }

    @Override
    public HttpResponse<Servers> save(Servers param) {
        Servers responseBody = repository.save(param);
        return HttpResponse.created(responseBody);
    }

    @Override
    public HttpResponse<Servers> update(Servers param) {
        Servers responseBody;
        Optional<Servers> findById = repository.findById(param.getIdServer());
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