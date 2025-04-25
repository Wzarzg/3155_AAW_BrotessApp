package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.Prevenciones;


@Repository
public interface IPrevencionesRepository extends JpaRepository<Prevenciones, Integer> {


}
