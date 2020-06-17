package mx.com.burodecredito.serviceImpl;

import io.micronaut.data.model.Sort;
import io.micronaut.http.HttpResponse;
import mx.com.burodecredito.dao.DependenciasAplicativosRepository;
import mx.com.burodecredito.domain.DependenciasAplicativos;
import mx.com.burodecredito.service.IGenericService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class DependenciasAplicativosService implements IGenericService<DependenciasAplicativos, Integer> {

    @Inject
    private DependenciasAplicativosRepository repository;

    @Override
    public HttpResponse<DependenciasAplicativos> findById(Integer param) {
        DependenciasAplicativos responseBody = repository.findById(param).orElse(null);
        return HttpResponse.ok(responseBody);
    }

    @Override
    public HttpResponse<List<DependenciasAplicativos>> getAll() {
        List<DependenciasAplicativos> responsBody = repository.findAll(Sort.of(Sort.Order.asc("idDependencia")));
        return HttpResponse.ok(responsBody);
    }

    @Override
    public HttpResponse<DependenciasAplicativos> save(DependenciasAplicativos param) {
        DependenciasAplicativos responseBody = repository.save(param);
        return HttpResponse.created(responseBody);
    }

    @Override
    public HttpResponse<DependenciasAplicativos> update(DependenciasAplicativos param) {
        DependenciasAplicativos responseBody;
        Optional<DependenciasAplicativos> findById = repository.findById(param.getIdDependencia());
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