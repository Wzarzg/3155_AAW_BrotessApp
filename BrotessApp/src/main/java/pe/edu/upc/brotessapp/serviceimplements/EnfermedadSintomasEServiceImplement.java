package pe.edu.upc.brotessapp.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.brotessapp.entities.EnfermedadSintomasE;
import pe.edu.upc.brotessapp.repositories.IEnfermedadSintomasERepository;
import pe.edu.upc.brotessapp.serviceinterfaces.IEnfermedadSintomasEService;

import java.util.List;

@Service
public class EnfermedadSintomasEServiceImplement implements IEnfermedadSintomasEService {

    @Autowired
    private IEnfermedadSintomasERepository eeR;

    @Override
    public List<EnfermedadSintomasE> list() {
        return eeR.findAll();
    }

    @Override
    public void insert(EnfermedadSintomasE u) {
        eeR.save(u);
    }

    @Override
    public EnfermedadSintomasE listId(int id) {
        return eeR.findById(id).orElse(new EnfermedadSintomasE());
    }

    @Override
    public void update(EnfermedadSintomasE u) {
        eeR.save(u);
    }

    @Override
    public List<Object[]> obtenerEnfermedadesPorSintomaComun() {
        return eeR.obtenerEnfermedadesPorSintomaComun();
    }

    @Override
    public List<String> listarSintomasPorIdEnfermedad(int idEnfermedad) {
        return eeR.findSintomasByIdEnfermedad(idEnfermedad);
    }

    @Override
    public List<String> obtenerSintomasExclusivosPorEnfermedad() {
        return eeR.obtenerSintomasExclusivosPorEnfermedad();
    }
}
