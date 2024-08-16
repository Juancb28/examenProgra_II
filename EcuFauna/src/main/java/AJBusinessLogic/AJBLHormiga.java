package AJBusinessLogic;

import AJDataAccess.AJDataAccessObject.AJDAOHormiga;
import AJDataAccess.AJDataTransferObject.AJDTOHormiga;

import java.util.*;

public class AJBLHormiga {

    private AJDAOHormiga AJdao;

    public AJBLHormiga() {
        AJdao = new AJDAOHormiga();
    }

    public Boolean AJCreate(AJDTOHormiga entity) throws Exception {
        return AJdao.AJCreate(entity);
    }

    public Boolean AJDelete(Integer idEntity) throws Exception {
        return AJdao.AJDelete(idEntity);
    }

    public Boolean AJUpdate(AJDTOHormiga entity) throws Exception {
        return AJdao.AJUpdate(entity);
    }

    public List<AJDTOHormiga> AJReadAll() throws Exception {
        return AJdao.AJReadAll();
    }

    public AJDTOHormiga AJReadBy(Integer idEntity) throws Exception {
        return AJdao.AJReadBy(idEntity);
    }

}
