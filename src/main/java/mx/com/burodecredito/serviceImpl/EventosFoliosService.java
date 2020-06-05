package mx.com.burodecredito.serviceImpl;

import io.micronaut.http.HttpResponse;
import mx.com.burodecredito.dao.DependenciasAplicativosRepository;
import mx.com.burodecredito.dao.EventosFoliosRepository;
import mx.com.burodecredito.domain.DependenciasAplicativos;
import mx.com.burodecredito.domain.EventosFolios;
import mx.com.burodecredito.service.IGenericService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class EventosFoliosService implements IGenericService<EventosFolios, Integer> {

    @Inject
    private EventosFoliosRepository repository;

    @Override
    public HttpResponse<EventosFolios> findById(Integer param) {
        EventosFolios responseBody = repository.findById(param).orElse(null);
        return HttpResponse.ok(responseBody);
    }

    @Override
    public HttpResponse<List<EventosFolios>> getAll() {
        List<EventosFolios> responsBody = repository.findAll();
        return HttpResponse.ok(responsBody);
    }

    @Override
    public HttpResponse<EventosFolios> save(EventosFolios param) {
        EventosFolios responseBody = repository.save(param);
        return HttpResponse.created(responseBody);
    }

    @Override
    public HttpResponse<EventosFolios> update(EventosFolios param) {
        EventosFolios responseBody;
        Optional<EventosFolios> findById = repository.findById(param.getIdEvento());
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