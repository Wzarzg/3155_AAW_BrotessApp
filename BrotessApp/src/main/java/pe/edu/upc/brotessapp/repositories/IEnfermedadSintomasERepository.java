package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.EnfermedadSintomasE;


@Repository
public interface IEnfermedadSintomasERepository extends JpaRepository<EnfermedadSintomasE, Integer> {


}
