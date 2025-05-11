package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.EnfermedadSintomasE;

import java.util.List;


@Repository
public interface IEnfermedadSintomasERepository extends JpaRepository<EnfermedadSintomasE, Integer> {
    //Síntomas más comunes por enfermedad, para tener una lista con los sintomas que hay por enfermedad.
    @Query(value = "SELECT e.nombre AS nombreenfermedad, s.nombre_sintoma AS nombresintoma\n" +
            "FROM enfermedad_sintomase ese\n" +
            "INNER JOIN enfermedad e ON ese.id_enfermedad = e.id_enfermedad\n" +
            "INNER JOIN sintomas_enfermedad s ON ese.id_sintomase = s.id_sintomase\n" +
            "ORDER BY e.nombre;", nativeQuery = true)
    List<String[]> listarSintomasPorEnfermedad();
    // Q_M3DTO - Consulta para listar los síntomas comunes con sus enfermedades asociadas.
    @Query(value = "SELECT se.nombre_sintoma AS nombreSintoma, " +
            "COUNT(DISTINCT e.id_enfermedad) AS cantidadEnfermedades, " +
            "STRING_AGG(e.nombre, ', ') AS enfermedadesAsociadas " +
            "FROM enfermedad_sintomase ese " +
            "INNER JOIN enfermedad e ON ese.id_enfermedad = e.id_enfermedad " +
            "INNER JOIN sintomas_enfermedad se ON ese.id_sintomase = se.id_sintomase " +
            "GROUP BY se.nombre_sintoma " +
            "ORDER BY cantidadEnfermedades DESC", nativeQuery = true)
    List<Object[]> enfermedadesQueCompartenSintoma();
    // Q_M4DTO - Consulta para obtener enfermedades y el número total de síntomas registrados por cada una
    @Query(value = "SELECT e.nombre AS nombreEnfermedad, COUNT(se.id_sintomase) AS totalSintomas " +
            "FROM enfermedad_sintomase ese " +
            "INNER JOIN enfermedad e ON ese.id_enfermedad = e.id_enfermedad " +
            "INNER JOIN sintomas_enfermedad se ON ese.id_sintomase = se.id_sintomase " +
            "GROUP BY e.nombre " +
            "ORDER BY totalSintomas DESC", nativeQuery = true)
    List<Object[]> cantidadSintomasPorEnfermedad();


}
