package AJDataAccess.AJDataTransferObject;

public class AJDTOIngestaNativa {
   
    private Integer idAJIngestaNativa;
    private String NombreIngestaNativa;
    private String Estado;
    private String FechaCreacion;
   
    public AJDTOIngestaNativa() {
    }
   
    public AJDTOIngestaNativa(String nombreIngestaNativa) {
        NombreIngestaNativa = nombreIngestaNativa;
    }
   
    public AJDTOIngestaNativa(Integer idAJIngestaNativa, String nombreIngestaNativa, String estado,
            String fechaCreacion) {
        this.idAJIngestaNativa = idAJIngestaNativa;
        NombreIngestaNativa = nombreIngestaNativa;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }

    public Integer getIdAJIngestaNativa() {
        return idAJIngestaNativa;
    }

    public void setIdAJIngestaNativa(Integer idAJIngestaNativa) {
        this.idAJIngestaNativa = idAJIngestaNativa;
    }

    public String getNombreIngestaNativa() {
        return NombreIngestaNativa;
    }

    public void setNombreIngestaNativa(String nombreIngestaNativa) {
        NombreIngestaNativa = nombreIngestaNativa;
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
