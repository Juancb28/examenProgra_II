package AJDataAccess.AJDataTransferObject;

public class AJDTOProvincia {

    private Integer idAJProvincia;
    private String NombreProvincia;
    private String NombreRegion;
    private String NombrePais;
    private Integer idRegion;
    private String Estado;
    private String FechaCreacion;

    public AJDTOProvincia() {
    }

    public AJDTOProvincia(String nombreProvincia) {
        NombreProvincia = nombreProvincia;
    }

    public AJDTOProvincia(String nombreProvincia, String nombreRegion, String nombrePais,
            String estado, String fechaCreacion) {
        NombreProvincia = nombreProvincia;
        NombreRegion = nombreRegion;
        NombrePais = nombrePais;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }

    public AJDTOProvincia(Integer idAJProvincia, String nombreProvincia, String nombreRegion, String nombrePais,
            String estado, String fechaCreacion) {
        this.idAJProvincia = idAJProvincia;
        NombreProvincia = nombreProvincia;
        NombreRegion = nombreRegion;
        NombrePais = nombrePais;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }

    public AJDTOProvincia(Integer idAJProvincia, String nombreProvincia, Integer idRegion, String estado,
            String fechaCreacion) {
        this.idAJProvincia = idAJProvincia;
        NombreProvincia = nombreProvincia;
        this.idRegion = idRegion;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }

    public Integer getIdAJProvincia() {
        return idAJProvincia;
    }

    public void setIdAJProvincia(Integer idAJProvincia) {
        this.idAJProvincia = idAJProvincia;
    }

    public String getNombreProvincia() {
        return NombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        NombreProvincia = nombreProvincia;
    }

    public String getNombreRegion() {
        return NombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        NombreRegion = nombreRegion;
    }

    public String getNombrePais() {
        return NombrePais;
    }

    public void setNombrePais(String nombrePais) {
        NombrePais = nombrePais;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
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
