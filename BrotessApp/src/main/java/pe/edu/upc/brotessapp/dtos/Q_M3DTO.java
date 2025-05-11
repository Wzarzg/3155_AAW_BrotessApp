package pe.edu.upc.brotessapp.dtos;

public class Q_M3DTO {
    private String nombreSintoma;
    private Long cantidadEnfermedades;
    private String enfermedadesAsociadas;

    public String getNombreSintoma() {
        return nombreSintoma;
    }

    public void setNombreSintoma(String nombreSintoma) {
        this.nombreSintoma = nombreSintoma;
    }

    public Long getCantidadEnfermedades() {
        return cantidadEnfermedades;
    }

    public void setCantidadEnfermedades(Long cantidadEnfermedades) {
        this.cantidadEnfermedades = cantidadEnfermedades;
    }

    public String getEnfermedadesAsociadas() {
        return enfermedadesAsociadas;
    }

    public void setEnfermedadesAsociadas(String enfermedadesAsociadas) {
        this.enfermedadesAsociadas = enfermedadesAsociadas;
    }
}
