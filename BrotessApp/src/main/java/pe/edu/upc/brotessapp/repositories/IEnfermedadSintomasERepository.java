package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.EnfermedadSintomasE;

import java.util.List;

@Repository
public interface IEnfermedadSintomasERepository extends JpaRepository<EnfermedadSintomasE, Integer> {

    @Query(value = "SELECT se.nombre_sintoma AS sintoma_comun, " +
            "COUNT(DISTINCT e.id_enfermedad) AS cantidad_enfermedades, " +
            "STRING_AGG(e.nombre, ', ') AS enfermedades_asociadas " +
            "FROM enfermedad_sintomase ese " +
            "INNER JOIN enfermedad e ON ese.id_enfermedad = e.id_enfermedad " +
            "INNER JOIN sintomas_enfermedad se ON ese.id_sintomase = se.id_sintomase " +
            "GROUP BY se.nombre_sintoma " +
            "ORDER BY cantidad_enfermedades DESC", nativeQuery = true)
    List<Object[]> obtenerEnfermedadesPorSintomaComun();

    @Query("SELECT ese.sintomasEnfermedad.nombreSintoma FROM EnfermedadSintomasE ese WHERE ese.enfermedad.idEnfermedad = :idEnfermedad")
    List<String> findSintomasByIdEnfermedad(@Param("idEnfermedad") int idEnfermedad);

    @Query(value = "SELECT se.nombre_sintoma " +
            "FROM enfermedad_sintomase ese " +
            "JOIN sintomas_enfermedad se ON ese.id_sintomase = se.id_sintomase " +
            "GROUP BY se.nombre_sintoma " +
            "HAVING COUNT(DISTINCT ese.id_enfermedad) = 1", nativeQuery = true)
    List<String> obtenerSintomasExclusivosPorEnfermedad();
}
