package pe.edu.upc.brotessapp.dtos;

public class EnfermedadSintomasEDTO {

    private int idEnfermedadSE;
    private SintomasEnfermedad sintomasEnfermedad;
    private Enfermedad enfermedad;

    public int getIdEnfermedadSE() {
        return idEnfermedadSE;
    }

    public void setIdEnfermedadSE(int idEnfermedadSE) {
        this.idEnfermedadSE = idEnfermedadSE;
    }

    public SintomasEnfermedad getSintomasEnfermedad() {
        return sintomasEnfermedad;
    }

    public void setSintomasEnfermedad(SintomasEnfermedad sintomasEnfermedad) {
        this.sintomasEnfermedad = sintomasEnfermedad;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }
}
