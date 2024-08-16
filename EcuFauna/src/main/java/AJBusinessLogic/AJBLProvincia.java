package AJBusinessLogic;

import java.util.List;

import AJDataAccess.AJDataAccessObject.AJDAOProvincia;
import AJDataAccess.AJDataTransferObject.AJDTOProvincia;

public class AJBLProvincia {

    private AJDAOProvincia AJdao;

    public AJBLProvincia() {
        AJdao = new AJDAOProvincia();
    }

    public Boolean AJCreate(AJDTOProvincia entity) throws Exception {
        return AJdao.AJCreate(entity);
    }

    public Boolean AJDelete(Integer idEntity) throws Exception {
        return AJdao.AJDelete(idEntity);
    }

    public Boolean AJUpdate(AJDTOProvincia entity) throws Exception {
        return AJdao.AJUpdate(entity);
    }

    public List<AJDTOProvincia> AJReadAll() throws Exception {
        return AJdao.AJReadAll();
    }

    public AJDTOProvincia AJReadBy(Integer idEntity) throws Exception {
        return AJdao.AJReadBy(idEntity);
    }
}
