package AJBusinessLogic;

import java.util.List;

import AJDataAccess.AJDataAccessObject.AJDAORegion;
import AJDataAccess.AJDataTransferObject.AJDTORegiones;

public class AJBLRegion {

    private AJDAORegion AJdao;

    public AJBLRegion() {
        AJdao = new AJDAORegion();
    }

    public Boolean AJCreate(AJDTORegiones entity) throws Exception {
        return AJdao.AJCreate(entity);
    }

    public Boolean AJDelete(Integer idEntity) throws Exception {
        return AJdao.AJDelete(idEntity);
    }

    public Boolean AJUpdate(AJDTORegiones entity) throws Exception {
        return AJdao.AJUpdate(entity);
    }

    public List<AJDTORegiones> AJReadAll() throws Exception {
        return AJdao.AJReadAll();
    }

    public AJDTORegiones AJReadBy(Integer idEntity) throws Exception {
        return AJdao.AJReadBy(idEntity);
    }
}
