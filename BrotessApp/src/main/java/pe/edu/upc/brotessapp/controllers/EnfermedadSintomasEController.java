package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.EnfermedadSintomasEDTO;
import pe.edu.upc.brotessapp.dtos.Q_M1DTO;
import pe.edu.upc.brotessapp.dtos.Q_M3DTO;
import pe.edu.upc.brotessapp.dtos.Q_M4DTO;
import pe.edu.upc.brotessapp.entities.EnfermedadSintomasE;
import pe.edu.upc.brotessapp.serviceinterfaces.IEnfermedadSintomasEService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/EnfermedadSintomasE")
public class EnfermedadSintomasEController {

    @Autowired
    private IEnfermedadSintomasEService eS;

    @GetMapping("/lista")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<EnfermedadSintomasEDTO> listar() {
        return eS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,EnfermedadSintomasEDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void insertar(@RequestBody EnfermedadSintomasEDTO dto) {
        ModelMapper m = new ModelMapper();
        EnfermedadSintomasE u = m.map(dto,EnfermedadSintomasE.class);
        eS.insert(u);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public EnfermedadSintomasEDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        EnfermedadSintomasEDTO dto = m.map(eS.listId(id), EnfermedadSintomasEDTO.class);
        return dto;
    }

    @PutMapping("/modifica")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public void modificar(@RequestBody EnfermedadSintomasEDTO dto) {
        ModelMapper m = new ModelMapper();
        EnfermedadSintomasE u = m.map(dto, EnfermedadSintomasE.class);
        eS.update(u);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        eS.delete(id);
    }

    @GetMapping("/listarSintomasPorEnfermedad")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<Q_M1DTO> listarSintomasPorEnfermedad() {
        return eS.listarSintomasPorEnfermedad().stream().map(x -> {
            Q_M1DTO dto = new Q_M1DTO();
            dto.setNombreEnfermedad(x[0]);
            dto.setNombreSintoma(x[1]);
            return dto;
        }).collect(Collectors.toList());
    }

    // Q_M3DTO - Endpoint para obtener síntomas comunes y las enfermedades asociadas a ellos
    @GetMapping("/enfermedades-por-sintoma")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<Q_M3DTO> listarEnfermedadesPorSintoma() {
        return eS.enfermedadesQueCompartenSintoma().stream().map(x -> {
            Q_M3DTO dto = new Q_M3DTO();
            dto.setNombreSintoma((String) x[0]);
            dto.setCantidadEnfermedades((Long) x[1]);
            dto.setEnfermedadesAsociadas((String) x[2]);
            return dto;
        }).collect(Collectors.toList());
    }

    // Q_M4DTO - Endpoint para mostrar enfermedades con el total de síntomas asociados
    @GetMapping("/enfermedades-con-cantidad-sintomas")
    @PreAuthorize("hasAuthority('AUTORIDAD')or hasAuthority('ADMIN')")
    public List<Q_M4DTO> listarCantidadSintomasPorEnfermedad() {
        return eS.cantidadSintomasPorEnfermedad().stream().map(x -> {
            Q_M4DTO dto = new Q_M4DTO();
            dto.setNombreEnfermedad((String) x[0]);
            dto.setTotalSintomas(((Number) x[1]).intValue());
            return dto;
        }).collect(Collectors.toList());
    }

}
