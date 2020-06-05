package mx.com.burodecredito.service;
import io.micronaut.http.HttpResponse;

import java.util.List;

public interface IGenericService<T, ID> {

    public HttpResponse<T> findById(ID param);

    public HttpResponse<List<T>> getAll();

    public HttpResponse<T> save(T param);

    public HttpResponse<T> update(T param);

    public HttpResponse delete (ID param);
}
