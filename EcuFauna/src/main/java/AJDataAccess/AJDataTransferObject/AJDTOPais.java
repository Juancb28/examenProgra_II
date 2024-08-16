package AJDataAccess.AJDataTransferObject;

public class AJDTOPais {

    private Integer idAJPais;
    private String NombrePais;
    private String Estado;
    private String FechaCreacion;

    public AJDTOPais() {
    }

    public AJDTOPais(String nombrePais) {
        NombrePais = nombrePais;
    }

    public AJDTOPais(Integer idAJPais, String nombrePais, String estado, String fechaCreacion) {
        this.idAJPais = idAJPais;
        NombrePais = nombrePais;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }

    public Integer getIdAJPais() {
        return idAJPais;
    }

    public void setIdAJPais(Integer idAJPais) {
        this.idAJPais = idAJPais;
    }

    public String getNombrePais() {
        return NombrePais;
    }

    public void setNombrePais(String nombrePais) {
        NombrePais = nombrePais;
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
