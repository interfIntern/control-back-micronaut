package mx.com.burodecredito.serviceImpl;

import io.micronaut.http.HttpResponse;
import mx.com.burodecredito.dao.FoliosRepository;
import mx.com.burodecredito.domain.Folios;
import mx.com.burodecredito.service.IGenericService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class FoliosService implements IGenericService<Folios, Integer> {

    @Inject
    private FoliosRepository repository;

    @Override
    public HttpResponse<Folios> findById(Integer param) {
        Folios responseBody = repository.findById(param).orElse(null);
        return HttpResponse.ok(responseBody);
    }

    @Override
    public HttpResponse<List<Folios>> getAll() {
        List<Folios> responsBody = repository.findAll();
        return HttpResponse.ok(responsBody);
    }

    @Override
    public HttpResponse<Folios> save(Folios param) {
        Folios responseBody = repository.save(param);
        return HttpResponse.created(responseBody);
    }

    @Override
    public HttpResponse<Folios> update(Folios param) {
        Folios responseBody;
        Optional<Folios> findById = repository.findById(param.getIdFolio());
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