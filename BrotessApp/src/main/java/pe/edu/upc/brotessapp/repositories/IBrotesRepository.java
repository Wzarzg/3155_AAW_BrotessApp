package pe.edu.upc.brotessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.brotessapp.entities.Brotes;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBrotesRepository extends JpaRepository<Brotes, Integer> {
    public List<Brotes> findByFechaInicio(LocalDate fechaInicio);

    //Cantidad de Brotes Registrados por Zona en un Mes y Año Específicos
    @Query(value = "SELECT " +
            "    EXTRACT(YEAR FROM b.fecha_inicio) AS anio, " +
            "    EXTRACT(MONTH FROM b.fecha_inicio) AS mes, " +
            "    z.provincia, " +
            "    COUNT(b.id_brote) AS cantidad_brotes " +
            "FROM brotes b " +
            "JOIN contagios c ON b.id_contagio = c.id_contagio " +
            "JOIN zona z ON c.id_zona = z.id_zona " +
            "WHERE EXTRACT(YEAR FROM b.fecha_inicio) = :anio " +
            "AND EXTRACT(MONTH FROM b.fecha_inicio) = :mes " +
            "GROUP BY anio, mes, z.provincia " +
            "ORDER BY z.provincia", nativeQuery = true)
    List<String[]> quantityBrotesTotalesPorZona(@Param("anio") int anio, @Param("mes") int mes);

    //automat
    @Query(value = "SELECT COUNT(*) FROM contagios c " +
            "JOIN zona z ON c.id_zona = z.id_zona " +
            "WHERE c.id_enfermedad = :idEnfermedad " +
            "AND z.provincia = :provincia " +
            "AND z.distrito = :distrito", nativeQuery = true)
    public Integer contagiosporzonayenfermedad(@Param("idEnfermedad") int idEnfermedad, @Param("provincia") String provincia, @Param("distrito") String distrito);

    @Query(value = "SELECT COUNT(*) FROM brotes b " +
            "JOIN contagios c ON b.id_contagio = c.id_contagio " +
            "JOIN zona z ON c.id_zona = z.id_zona " +
            "WHERE c.id_enfermedad = :idEnfermedad " +
            "AND z.provincia = :provincia " +
            "AND z.distrito = :distrito", nativeQuery = true)
    public Integer existeBroteEnZona(@Param("idEnfermedad") int idEnfermedad, @Param("provincia") String provincia, @Param("distrito") String distrito);



}
