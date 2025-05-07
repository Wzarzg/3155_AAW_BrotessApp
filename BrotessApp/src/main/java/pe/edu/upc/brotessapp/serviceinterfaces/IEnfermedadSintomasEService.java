package pe.edu.upc.brotessapp.serviceinterfaces;

import pe.edu.upc.brotessapp.entities.EnfermedadSintomasE;

import java.util.List;

public interface IEnfermedadSintomasEService {
    List<EnfermedadSintomasE> list();
    void insert(EnfermedadSintomasE x);
    EnfermedadSintomasE listId(int id);
    void update(EnfermedadSintomasE x);

    List<Object[]> obtenerEnfermedadesPorSintomaComun();
    List<String> listarSintomasPorIdEnfermedad(int idEnfermedad);

    List<String> obtenerSintomasExclusivosPorEnfermedad();
}
