package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.TipoTransmisionDTO;
import pe.edu.upc.brotessapp.entities.TipoTransmision;
import pe.edu.upc.brotessapp.serviceinterfaces.ITipoTransmisionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiposT")
public class TipoTransmisionController {

    @Autowired
    private ITipoTransmisionService tS;

    @GetMapping("/lista")
    public List<TipoTransmisionDTO> listartiposE() {
        return tS.list().stream().map(t-> {//expresion lambda para cada elemento - transformacion
            ModelMapper m = new ModelMapper();
            return m.map(t, TipoTransmisionDTO.class);
        }).collect(Collectors.toList()); //al final hace que toda la coleccion se tome como un tolist
    }

    @PostMapping("/inserta")
    public void insertar(@RequestBody TipoTransmisionDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoTransmision t = m.map(dto, TipoTransmision.class);
        tS.insert(t);
    }
    @GetMapping("/{id}")
    public TipoTransmisionDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        //aqui se quiere mostrar lo que se puso en el DTO
        TipoTransmisionDTO dto = m.map(tS.listId(id), TipoTransmisionDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    public void modificar(@RequestBody TipoTransmisionDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoTransmision z = m.map(dto, TipoTransmision.class);
        tS.update(z);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        tS.delete(id);
    }


}
