package pe.edu.upc.brotessapp.serviceinterfaces;

import pe.edu.upc.brotessapp.entities.EnfermedadSintomasE;

import java.util.List;

public interface IEnfermedadSintomasEService {
    public List<EnfermedadSintomasE> list();
    public void insert(EnfermedadSintomasE x);
    public EnfermedadSintomasE listId(int id);
    public void update(EnfermedadSintomasE x);
    public void delete(int id);
    public List<String[]> listarSintomasPorEnfermedad();
    // Q_M3DTO - Declaración del metodo para listar enfermedades que comparten un mismo síntoma
    public List<Object[]> enfermedadesQueCompartenSintoma();
    // Q_M4DTO - Declaración del metodo para obtener enfermedades con total de síntomas
    public List<Object[]> cantidadSintomasPorEnfermedad();

}
