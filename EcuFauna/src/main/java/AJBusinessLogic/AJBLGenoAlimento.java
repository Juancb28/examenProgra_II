package AJBusinessLogic;

import java.util.List;

import AJDataAccess.AJDataAccessObject.AJDAOGenoAlimento;
import AJDataAccess.AJDataTransferObject.AJDTOGenoAlimento;

public class AJBLGenoAlimento {

    private AJDAOGenoAlimento AJdao;

    public AJBLGenoAlimento() {
        AJdao = new AJDAOGenoAlimento();
    }

    public Boolean AJCreate(AJDTOGenoAlimento entity) throws Exception {
        return AJdao.AJCreate(entity);
    }

    public Boolean AJDelete(Integer idEntity) throws Exception {
        return AJdao.AJDelete(idEntity);
    }

    public Boolean AJUpdate(AJDTOGenoAlimento entity) throws Exception {
        return AJdao.AJUpdate(entity);
    }

    public List<AJDTOGenoAlimento> AJReadAll() throws Exception {
        return AJdao.AJReadAll();
    }

    public AJDTOGenoAlimento AJReadBy(Integer idEntity) throws Exception {
        return AJdao.AJReadBy(idEntity);
    }

}
