package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.ContagiosDTO;
import pe.edu.upc.brotessapp.entities.Contagios;
import pe.edu.upc.brotessapp.serviceinterfaces.IContagiosService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contagios")
public class ContagiosController {

    @Autowired
    private IContagiosService cS;

    @GetMapping("/lista")
    public List<ContagiosDTO> listar() {
        return cS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,ContagiosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    public void insertar(@RequestBody ContagiosDTO dto) {
        ModelMapper m = new ModelMapper();
        Contagios c = m.map(dto,Contagios.class);
        cS.insert(c);
    }

    @GetMapping("/{id}")
    public ContagiosDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ContagiosDTO dto = m.map(cS.listId(id), ContagiosDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    public void modificar(@RequestBody ContagiosDTO dto) {
        ModelMapper m = new ModelMapper();
        Contagios c = m.map(dto, Contagios.class);
        cS.update(c);
    }
}
