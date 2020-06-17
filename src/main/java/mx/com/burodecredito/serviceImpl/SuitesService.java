package mx.com.burodecredito.serviceImpl;

import io.micronaut.data.model.Sort;
import io.micronaut.http.HttpResponse;
import mx.com.burodecredito.dao.SuitesRepository;
import mx.com.burodecredito.domain.Suites;
import mx.com.burodecredito.service.IGenericService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class SuitesService implements IGenericService<Suites, Integer> {

    @Inject
    private SuitesRepository repository;

    @Override
    public HttpResponse<Suites> findById(Integer param) {
        Suites responseBody = repository.findById(param).orElse(null);
        return HttpResponse.ok(responseBody);
    }

    @Override
    public HttpResponse<List<Suites>> getAll() {
        List<Suites> responsBody = repository.findAll(Sort.of(Sort.Order.asc("idSuite")));
        return HttpResponse.ok(responsBody);
    }

    @Override
    public HttpResponse<Suites> save(Suites param) {
        Suites responseBody = repository.save(param);
        return HttpResponse.created(responseBody);
    }

    @Override
    public HttpResponse<Suites> update(Suites param) {
        Suites responseBody;
        Optional<Suites> findById = repository.findById(param.getIdSuite());
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