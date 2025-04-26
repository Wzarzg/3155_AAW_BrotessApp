package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.EnfermedadSintomasEDTO;
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
    public List<EnfermedadSintomasEDTO> listar() {
        return eS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,EnfermedadSintomasEDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    public void insertar(@RequestBody EnfermedadSintomasEDTO dto) {
        ModelMapper m = new ModelMapper();
        EnfermedadSintomasE u = m.map(dto,EnfermedadSintomasE.class);
        eS.insert(u);
    }

    @GetMapping("/{id}")
    public EnfermedadSintomasEDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        EnfermedadSintomasEDTO dto = m.map(eS.listId(id), EnfermedadSintomasEDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    public void modificar(@RequestBody EnfermedadSintomasEDTO dto) {
        ModelMapper m = new ModelMapper();
        EnfermedadSintomasE u = m.map(dto, EnfermedadSintomasE.class);
        eS.update(u);
    }
}
