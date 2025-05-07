package pe.edu.upc.brotessapp.dtos;

public class Q_M3DTO {
    private String sintomaComun;
    private int cantidadEnfermedades;
    private String enfermedadesAsociadas;

    public Q_M3DTO() {}

    public Q_M3DTO(String sintomaComun, int cantidadEnfermedades, String enfermedadesAsociadas) {
        this.sintomaComun = sintomaComun;
        this.cantidadEnfermedades = cantidadEnfermedades;
        this.enfermedadesAsociadas = enfermedadesAsociadas;
    }

    public String getSintomaComun() {
        return sintomaComun;
    }

    public void setSintomaComun(String sintomaComun) {
        this.sintomaComun = sintomaComun;
    }

    public int getCantidadEnfermedades() {
        return cantidadEnfermedades;
    }

    public void setCantidadEnfermedades(int cantidadEnfermedades) {
        this.cantidadEnfermedades = cantidadEnfermedades;
    }

    public String getEnfermedadesAsociadas() {
        return enfermedadesAsociadas;
    }

    public void setEnfermedadesAsociadas(String enfermedadesAsociadas) {
        this.enfermedadesAsociadas = enfermedadesAsociadas;
    }
}
