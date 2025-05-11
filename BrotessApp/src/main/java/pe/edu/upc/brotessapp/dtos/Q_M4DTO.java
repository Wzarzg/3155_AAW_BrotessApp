package pe.edu.upc.brotessapp.dtos;

public class Q_M4DTO {
    private String nombreEnfermedad;
    private int totalSintomas;

    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public int getTotalSintomas() {
        return totalSintomas;
    }

    public void setTotalSintomas(int totalSintomas) {
        this.totalSintomas = totalSintomas;
    }
}
