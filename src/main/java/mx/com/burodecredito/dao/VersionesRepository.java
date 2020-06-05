package mx.com.burodecredito.dao;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import mx.com.burodecredito.domain.Versiones;

@Repository
public interface VersionesRepository extends JpaRepository<Versiones, Integer> {

}