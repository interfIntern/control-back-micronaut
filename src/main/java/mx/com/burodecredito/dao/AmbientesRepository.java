package mx.com.burodecredito.dao;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import mx.com.burodecredito.domain.Ambientes;

@Repository
public interface AmbientesRepository extends JpaRepository<Ambientes, Integer> {

}