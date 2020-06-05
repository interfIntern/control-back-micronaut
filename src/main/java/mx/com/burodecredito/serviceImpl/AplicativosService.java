package mx.com.burodecredito.serviceImpl;

import io.micronaut.http.HttpResponse;
import mx.com.burodecredito.dao.AmbientesRepository;
import mx.com.burodecredito.dao.AplicativosRepository;
import mx.com.burodecredito.domain.Ambientes;
import mx.com.burodecredito.domain.Aplicativos;
import mx.com.burodecredito.service.IGenericService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class AplicativosService implements IGenericService<Aplicativos, Integer> {

    @Inject
    private AplicativosRepository repository;

    @Override
    public HttpResponse<Aplicativos> findById(Integer param) {
        Aplicativos responseBody = repository.findById(param).orElse(null);
        return HttpResponse.ok(responseBody);
    }

    @Override
    public HttpResponse<List<Aplicativos>> getAll() {
        List<Aplicativos> responsBody = repository.findAll();
        return HttpResponse.ok(responsBody);
    }

    @Override
    public HttpResponse<Aplicativos> save(Aplicativos param) {
        Aplicativos responseBody = repository.save(param);
        return HttpResponse.created(responseBody);
    }

    @Override
    public HttpResponse<Aplicativos> update(Aplicativos param) {
        Aplicativos responseBody;
        Optional<Aplicativos> findById = repository.findById(param.getIdAplicativo());
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