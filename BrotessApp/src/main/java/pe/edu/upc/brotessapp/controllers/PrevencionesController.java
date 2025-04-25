package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.PrevencionesDTO;
import pe.edu.upc.brotessapp.entities.Prevenciones;
import pe.edu.upc.brotessapp.serviceinterfaces.IPrevencionesService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prevenciones")
public class PrevencionesController {

    @Autowired
    private IPrevencionesService pS;

    @GetMapping("/lista")
    public List<PrevencionesDTO> listar() {
        return pS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,PrevencionesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    public void insertar(@RequestBody PrevencionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Prevenciones u = m.map(dto,Prevenciones.class);
        pS.insert(u);
    }

    @GetMapping("/{id}")
    public PrevencionesDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PrevencionesDTO dto = m.map(pS.listId(id), PrevencionesDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    public void modificar(@RequestBody PrevencionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Prevenciones u = m.map(dto, Prevenciones.class);
        pS.update(u);
    }
}
