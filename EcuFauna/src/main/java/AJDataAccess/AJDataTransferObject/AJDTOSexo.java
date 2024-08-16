package AJDataAccess.AJDataTransferObject;

public class AJDTOSexo {

    private Integer idAJSexo;
    private String NombreSexo;
    private String Estado;
    private String FechaCreacion;

    public AJDTOSexo() {
    }

    public AJDTOSexo(String nombreSexo) {
        NombreSexo = nombreSexo;
    }

    public AJDTOSexo(Integer idAJSexo, String nombreSexo, String estado, String fechaCreacion) {
        this.idAJSexo = idAJSexo;
        NombreSexo = nombreSexo;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }

    public Integer getIdAJSexo() {
        return idAJSexo;
    }

    public void setIdAJSexo(Integer idAJSexo) {
        this.idAJSexo = idAJSexo;
    }

    public String getNombreSexo() {
        return NombreSexo;
    }

    public void setNombreSexo(String nombreSexo) {
        NombreSexo = nombreSexo;
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
