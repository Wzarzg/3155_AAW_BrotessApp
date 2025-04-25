package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.ZonaDTO;
import pe.edu.upc.brotessapp.entities.Zona;
import pe.edu.upc.brotessapp.serviceinterfaces.IZonaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zonas")
public class ZonaController {

    @Autowired
    private IZonaService zS;

    @GetMapping("/lista")
    public List<ZonaDTO> listarZonas() {
        return zS.list().stream().map(z-> {//expresion lambda para cada elemento - transformacion
            ModelMapper m = new ModelMapper();
            return m.map(z, ZonaDTO.class);
        }).collect(Collectors.toList()); //al final hace que toda la coleccion se tome como un tolist
    }

    @PostMapping("/inserta")
    public void insertar(@RequestBody ZonaDTO dto) {
        ModelMapper m = new ModelMapper();
        Zona z = m.map(dto, Zona.class);
        zS.insert(z);
    }
    @GetMapping("/{id}")
    public ZonaDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        //aqui se quiere mostrar lo que se puso en el DTO
        ZonaDTO dto = m.map(zS.listId(id), ZonaDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    public void modificar(@RequestBody ZonaDTO dto) {
        ModelMapper m = new ModelMapper();
        Zona z = m.map(dto, Zona.class);
        zS.update(z);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        zS.delete(id);
    }


}
