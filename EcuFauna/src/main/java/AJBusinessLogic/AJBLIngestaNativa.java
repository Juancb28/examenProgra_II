package AJBusinessLogic;

import java.util.List;

import AJDataAccess.AJDataAccessObject.AJDAOIngestaNativa;
import AJDataAccess.AJDataTransferObject.AJDTOIngestaNativa;

public class AJBLIngestaNativa {
    
    private AJDAOIngestaNativa AJdao;

    public AJBLIngestaNativa() {
        AJdao = new AJDAOIngestaNativa();
    }

    public Boolean AJCreate(AJDTOIngestaNativa entity) throws Exception {
        return AJdao.AJCreate(entity);
    }

    public Boolean AJDelete(Integer idEntity) throws Exception {
        return AJdao.AJDelete(idEntity);
    }

    public Boolean AJUpdate(AJDTOIngestaNativa entity) throws Exception {
        return AJdao.AJUpdate(entity);
    }

    public List<AJDTOIngestaNativa> AJReadAll() throws Exception {
        return AJdao.AJReadAll();
    }

    public AJDTOIngestaNativa AJReadBy(Integer idEntity) throws Exception {
        return AJdao.AJReadBy(idEntity);
    }

}
