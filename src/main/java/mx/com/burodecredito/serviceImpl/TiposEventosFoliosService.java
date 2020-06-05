package mx.com.burodecredito.serviceImpl;

import io.micronaut.http.HttpResponse;
import mx.com.burodecredito.dao.TiposEventosFoliosRepository;
import mx.com.burodecredito.domain.TiposEventosFolios;
import mx.com.burodecredito.service.IGenericService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class TiposEventosFoliosService implements IGenericService<TiposEventosFolios, Integer> {

    @Inject
    private TiposEventosFoliosRepository repository;

    @Override
    public HttpResponse<TiposEventosFolios> findById(Integer param) {
        TiposEventosFolios responseBody = repository.findById(param).orElse(null);
        return HttpResponse.ok(responseBody);
    }

    @Override
    public HttpResponse<List<TiposEventosFolios>> getAll() {
        List<TiposEventosFolios> responsBody = repository.findAll();
        return HttpResponse.ok(responsBody);
    }

    @Override
    public HttpResponse<TiposEventosFolios> save(TiposEventosFolios param) {
        TiposEventosFolios responseBdoy = repository.save(param);
        return HttpResponse.created(responseBdoy);
    }

    @Override
    public HttpResponse<TiposEventosFolios> update(TiposEventosFolios param) {
        TiposEventosFolios responseBody;
        Optional<TiposEventosFolios> findById = repository.findById(param.getIdTipoEvento());
        if(findById.isPresent()) {
            responseBody = repository.update(param);
            return HttpResponse.ok(responseBody);
        }

        return HttpResponse.notFound();
    }

    @Override
    public HttpResponse delete(Integer param) {
        repository.deleteById(param);
        return HttpResponse.noContent();
    }

}