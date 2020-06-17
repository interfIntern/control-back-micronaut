package mx.com.burodecredito.serviceImpl;

import io.micronaut.data.model.Sort;
import io.micronaut.http.HttpResponse;
import mx.com.burodecredito.dao.AmbientesVersionesRepository;
import mx.com.burodecredito.domain.AmbientesVersiones;
import mx.com.burodecredito.service.IGenericService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class AmbientesVersionesService implements IGenericService<AmbientesVersiones, Integer> {

    @Inject
    private AmbientesVersionesRepository repository;

    @Override
    public HttpResponse<AmbientesVersiones> findById(Integer param) {
        AmbientesVersiones responseBody = repository.findById(param).orElse(null);
        return HttpResponse.ok(responseBody);
    }

    @Override
    public HttpResponse<List<AmbientesVersiones>> getAll() {
        List<AmbientesVersiones> responsBody = repository.findAll(Sort.of(Sort.Order.asc("idAmbienteVersion")));
        return HttpResponse.ok(responsBody);
    }

    @Override
    public HttpResponse<AmbientesVersiones> save(AmbientesVersiones param) {
        AmbientesVersiones responseBody = repository.save(param);
        return HttpResponse.created(responseBody);
    }

    @Override
    public HttpResponse<AmbientesVersiones> update(AmbientesVersiones param) {
        AmbientesVersiones responseBody;
        Optional<AmbientesVersiones> findById = repository.findById(param.getIdAmbienteVersion());
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