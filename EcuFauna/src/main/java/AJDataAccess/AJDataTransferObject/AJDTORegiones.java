package AJDataAccess.AJDataTransferObject;

public class AJDTORegiones {

    private Integer idAJRegion;
    private String NombreRegion;
    private Integer idPais;
    private String Estado;
    private String FechaCreacion;

    public AJDTORegiones() {
    }

    public AJDTORegiones(String nombreRegion) {
        NombreRegion = nombreRegion;
    }

    public AJDTORegiones(Integer idAJRegion, String nombreRegion, Integer idPais, String estado, String fechaCreacion) {
        this.idAJRegion = idAJRegion;
        NombreRegion = nombreRegion;
        this.idPais = idPais;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }

    public Integer getIdAJRegion() {
        return idAJRegion;
    }

    public void setIdAJRegion(Integer idAJRegion) {
        this.idAJRegion = idAJRegion;
    }

    public String getNombreRegion() {
        return NombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        NombreRegion = nombreRegion;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
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
