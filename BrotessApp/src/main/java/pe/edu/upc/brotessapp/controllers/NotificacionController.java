package pe.edu.upc.brotessapp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.brotessapp.dtos.NotificacionDTO;
import pe.edu.upc.brotessapp.entities.Notificacion;
import pe.edu.upc.brotessapp.serviceinterfaces.INotificacionService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService nS;

    @GetMapping("/lista")
    public List<NotificacionDTO> listar() {
        return nS.list().stream().map(u->{
            ModelMapper m = new ModelMapper();
            return m.map(u,NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/inserta")
    public void insertar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion u = m.map(dto,Notificacion.class);
        nS.insert(u);
    }

    @GetMapping("/{id}")
    public NotificacionDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        NotificacionDTO dto = m.map(nS.listId(id), NotificacionDTO.class);
        return dto;
    }
    @PutMapping("/modifica")
    public void modificar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion u = m.map(dto, Notificacion.class);
        nS.update(u);
    }
}
