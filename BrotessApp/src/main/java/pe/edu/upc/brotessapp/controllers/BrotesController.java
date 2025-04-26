package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.BrotesDTO;
import pe.edu.upc.brotessapp.entities.Brotes;
import pe.edu.upc.brotessapp.serviceinterfaces.IBrotesService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/brotes")
public class BrotesController {

    @Autowired
    private IBrotesService bS;

    @GetMapping("/lista")
    public List<BrotesDTO> listar() {
        return bS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,BrotesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    public void insertar(@RequestBody BrotesDTO dto) {
        ModelMapper m = new ModelMapper();
        Brotes u = m.map(dto,Brotes.class);
        bS.insert(u);
    }

    @GetMapping("/{id}")
    public BrotesDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        BrotesDTO dto = m.map(bS.listId(id), BrotesDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    public void modificar(@RequestBody BrotesDTO dto) {
        ModelMapper m = new ModelMapper();
        Brotes u = m.map(dto, Brotes.class);
        bS.update(u);
    }
}
