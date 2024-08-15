package AJDataAccess;

import java.util.List;

public interface AJIDAO<T> {

    public Boolean AJCreate(T entity) throws Exception;

    public Boolean AJDelete(Integer idEntity) throws Exception;

    public Boolean AJUpdate(T entity) throws Exception;

    public List<T> AJReadAll() throws Exception;

    public T AJReadBy(Integer idEntity) throws Exception;

}
