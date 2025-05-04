package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.EnfermedadDTO;
import pe.edu.upc.brotessapp.entities.Enfermedad;
import pe.edu.upc.brotessapp.serviceinterfaces.IEnfermedadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enfermedades")
public class EnfermedadController {
    @Autowired
    private IEnfermedadService eS;

    @GetMapping("/lista")
    public List<EnfermedadDTO> listar() {
        return eS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,EnfermedadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    public void insertar(@RequestBody EnfermedadDTO dto) {
        ModelMapper m = new ModelMapper();
        Enfermedad e = m.map(dto,Enfermedad.class);
        eS.insert(e);
    }

    @GetMapping("/{id}")
    public EnfermedadDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        //aqui se quiere mostrar lo que se puso en el DTO
        EnfermedadDTO dto = m.map(eS.listId(id), EnfermedadDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    public void modificar(@RequestBody EnfermedadDTO dto) {
        ModelMapper m = new ModelMapper();
        Enfermedad u = m.map(dto, Enfermedad.class);
        eS.update(u);
    }
}
