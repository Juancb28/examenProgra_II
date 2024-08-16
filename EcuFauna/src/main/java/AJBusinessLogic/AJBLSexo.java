package AJBusinessLogic;

import java.util.List;

import AJDataAccess.AJDataAccessObject.AJDAOSexo;
import AJDataAccess.AJDataTransferObject.AJDTOSexo;

public class AJBLSexo {

    private AJDAOSexo AJdao;

    public AJBLSexo() {
        AJdao = new AJDAOSexo();
    }

    public Boolean AJCreate(AJDTOSexo entity) throws Exception {
        return AJdao.AJCreate(entity);
    }

    public Boolean AJDelete(Integer idEntity) throws Exception {
        return AJdao.AJDelete(idEntity);
    }

    public Boolean AJUpdate(AJDTOSexo entity) throws Exception {
        return AJdao.AJUpdate(entity);
    }

    public List<AJDTOSexo> AJReadAll() throws Exception {
        return AJdao.AJReadAll();
    }

    public AJDTOSexo AJReadBy(Integer idEntity) throws Exception {
        return AJdao.AJReadBy(idEntity);
    }
}
