package AJDataAccess.AJDataTransferObject;

public class AJDTOGenoAlimento {

    private Integer idAJGenoAlimento;
    private String NombreGenoAlimento;
    private String Estado;
    private String FechaCreacion;

    public AJDTOGenoAlimento() {
    }

    public AJDTOGenoAlimento(String nombreGenoAlimento) {
        NombreGenoAlimento = nombreGenoAlimento;
    }

    public AJDTOGenoAlimento(Integer idAJGenoAlimento, String nombreGenoAlimento, String estado, String fechaCreacion) {
        this.idAJGenoAlimento = idAJGenoAlimento;
        NombreGenoAlimento = nombreGenoAlimento;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }

    public String getNombreGenoAlimento() {
        return NombreGenoAlimento;
    }

    public void setNombreGenoAlimento(String nombreGenoAlimento) {
        NombreGenoAlimento = nombreGenoAlimento;
    }

    public Integer getIdAJGenoAlimento() {
        return idAJGenoAlimento;
    }

    public void setIdAJGenoAlimento(Integer idAJGenoAlimento) {
        this.idAJGenoAlimento = idAJGenoAlimento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    

}
