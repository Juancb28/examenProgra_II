package AJDataAccess;

import java.util.List;

public interface AJIDAO<T> {

    public Boolean AJCreate(T entity);

    public Boolean AJDelete(Integer idEntity);

    public Boolean AJUpdate(Integer idEntity);

    public List<T> AJReadAll();

    public T AJReadBy(Integer idEntity);

}
