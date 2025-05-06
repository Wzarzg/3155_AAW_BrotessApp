package pe.edu.upc.brotessapp.serviceinterfaces;


import pe.edu.upc.brotessapp.entities.Brotes;

import java.util.List;

public interface IBrotesService {
    public List<Brotes> list();
    public void insert(Brotes x);
    public Brotes listId(int id);
    public void update(Brotes x);
}
