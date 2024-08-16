package AJDataAccess.AJDataTransferObject;

public class AJDTOHormiga {

    private Integer idAJHormiga;
    private String TipoHormiga;
    private Integer idSexo;
    private String NombreSexo;
    private Integer idProvincia;
    private String NombreProvincia;
    private Integer idGenoAlimento;
    private String NombreGenoAlimento;
    private Integer idIngestaNativa;
    private String NombreIngestaNativa;
    private String Estado;
    private String FechaCreacion;

    public AJDTOHormiga() {
    }

    public AJDTOHormiga(Integer idAJHormiga, String tipoHormiga, Integer idSexo, Integer idProvincia,
            Integer idGenoAlimento, Integer idIngestaNativa, String estado, String fechaCreacion) {
        this.idAJHormiga = idAJHormiga;
        TipoHormiga = tipoHormiga;
        this.idSexo = idSexo;
        this.idProvincia = idProvincia;
        this.idGenoAlimento = idGenoAlimento;
        this.idIngestaNativa = idIngestaNativa;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }

    /**
     * Constructor que permite leer informacion cuando se extraiga una lista.
     * 
     * @param idAJHormiga
     * @param tipoHormiga
     * @param nombreSexo
     * @param nombreProvincia
     * @param nombreGenoAlimento
     * @param nombreIngestaNativa
     * @param estado
     * @param fechaCreacion
     */
    public AJDTOHormiga(Integer idAJHormiga, String tipoHormiga, String nombreSexo, String nombreProvincia,
            String nombreGenoAlimento, String nombreIngestaNativa, String estado, String fechaCreacion) {
        this.idAJHormiga = idAJHormiga;
        TipoHormiga = tipoHormiga;
        NombreSexo = nombreSexo;
        NombreProvincia = nombreProvincia;
        NombreGenoAlimento = nombreGenoAlimento;
        NombreIngestaNativa = nombreIngestaNativa;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }

    /**
     * Constructor que permite leer informacion cuando se lea un objeto en
     * especifico.
     * 
     * @param tipoHormiga
     * @param nombreSexo
     * @param nombreProvincia
     * @param nombreGenoAlimento
     * @param nombreIngestaNativa
     * @param estado
     * @param fechaCreacion
     */
    public AJDTOHormiga(String tipoHormiga, String nombreSexo, String nombreProvincia, String nombreGenoAlimento,
            String nombreIngestaNativa, String estado, String fechaCreacion) {
        TipoHormiga = tipoHormiga;
        NombreSexo = nombreSexo;
        NombreProvincia = nombreProvincia;
        NombreGenoAlimento = nombreGenoAlimento;
        NombreIngestaNativa = nombreIngestaNativa;
        Estado = estado;
        FechaCreacion = fechaCreacion;
    }

    public Integer getIdAJHormiga() {
        return idAJHormiga;
    }

    public void setIdAJHormiga(Integer idAJHormiga) {
        this.idAJHormiga = idAJHormiga;
    }

    public String getTipoHormiga() {
        return TipoHormiga;
    }

    public void setTipoHormiga(String tipoHormiga) {
        TipoHormiga = tipoHormiga;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public String getNombreSexo() {
        return NombreSexo;
    }

    public void setNombreSexo(String nombreSexo) {
        NombreSexo = nombreSexo;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombreProvincia() {
        return NombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        NombreProvincia = nombreProvincia;
    }

    public Integer getIdGenoAlimento() {
        return idGenoAlimento;
    }

    public void setIdGenoAlimento(Integer idGenoAlimento) {
        this.idGenoAlimento = idGenoAlimento;
    }

    public String getNombreGenoAlimento() {
        return NombreGenoAlimento;
    }

    public void setNombreGenoAlimento(String nombreGenoAlimento) {
        NombreGenoAlimento = nombreGenoAlimento;
    }

    public Integer getIdIngestaNativa() {
        return idIngestaNativa;
    }

    public void setIdIngestaNativa(Integer idIngestaNativa) {
        this.idIngestaNativa = idIngestaNativa;
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
