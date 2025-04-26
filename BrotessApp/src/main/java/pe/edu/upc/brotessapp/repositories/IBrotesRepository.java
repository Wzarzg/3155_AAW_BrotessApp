package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.Brotes;

@Repository
public interface IBrotesRepository extends JpaRepository<Brotes, Integer> {


}
