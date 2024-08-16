package AJBusinessLogic;

import java.util.List;

import AJDataAccess.AJDataAccessObject.AJDAOPais;
import AJDataAccess.AJDataTransferObject.AJDTOPais;

public class AJBLPais {

    private AJDAOPais AJdao;

    public AJBLPais() {
        AJdao = new AJDAOPais();
    }

    public Boolean AJCreate(AJDTOPais entity) throws Exception {
        return AJdao.AJCreate(entity);
    }

    public Boolean AJDelete(Integer idEntity) throws Exception {
        return AJdao.AJDelete(idEntity);
    }

    public Boolean AJUpdate(AJDTOPais entity) throws Exception {
        return AJdao.AJUpdate(entity);
    }

    public List<AJDTOPais> AJReadAll() throws Exception {
        return AJdao.AJReadAll();
    }

    public AJDTOPais AJReadBy(Integer idEntity) throws Exception {
        return AJdao.AJReadBy(idEntity);
    }
}
