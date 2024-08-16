package AJDataAccess.AJDataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import AJDataAccess.AJIDAO;
import AJDataAccess.AJSQLiteDataHelper;
import AJDataAccess.AJDataTransferObject.AJDTOProvincia;
import AJFramework.AJException;

public class AJDAOProvincia extends AJSQLiteDataHelper implements AJIDAO<AJDTOProvincia> {

    @Override
    public Boolean AJCreate(AJDTOProvincia entity) throws Exception {
        String query = "INSERT INTO AJProvincias" +
                "(NombreProvincia, idRegion) VALUES" +
                "(?, ?)";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombreProvincia());
            AJpstmt.setInt(2, entity.getIdRegion());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJCreate()");
        }
    }

    @Override
    public Boolean AJDelete(Integer idEntity) throws Exception {
        String query = "UPDATE AJProvincias" +
                "SET Estado = ?" +
                "WHERE idAJProvincia = ?";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, "X");
            AJpstmt.setInt(2, idEntity);
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJDelete()");
        }
    }

    @Override
    public Boolean AJUpdate(AJDTOProvincia entity) throws Exception {
        String query = "UPDATE AJProvincias" +
                "SET NombreProvincia = ?" +
                "WHERE idAJProvincia = ?";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombreProvincia());
            AJpstmt.setInt(2, entity.getIdAJProvincia());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJUpdate()");
        }
    }

    @Override
    public List<AJDTOProvincia> AJReadAll() throws Exception {
        String query = "SELECT P.idAJProvincia, P.NombreProvincia, R.NombreRegion, PA.NombrePais FROM AJProvincias P " +
                "        JOIN AJRegiones R ON P.idRegion = R.idAJRegion" +
                "        JOIN AJPaises PA ON R.idPais = PA.idAJPais" +
                "        WHERE P.Estado LIKE 'A' AND R.Estado LIKE 'A' AND PA.Estado LIKE 'A';";
        List<AJDTOProvincia> AJList = new ArrayList<>();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);

            while (AJRs.next()) {
                AJDTOProvincia AJdto = new AJDTOProvincia(
                        AJRs.getInt(1),
                        AJRs.getString(2),
                        AJRs.getString(3),
                        AJRs.getString(4),
                        "A",
                        AJRs.getString(5));
                AJList.add(AJdto);
            }

        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJReadAll()");
        }
        return AJList;
    }

    @Override
    public AJDTOProvincia AJReadBy(Integer idEntity) throws Exception {
        String query = "SELECT P.NombreProvincia, R.NombreRegion, PA.NombrePais FROM AJProvincias P  " +
                "        JOIN AJRegiones R ON P.idRegion = R.idAJRegion " +
                "        JOIN AJPaises PA ON R.idPais = PA.idAJPais " +
                "        WHERE P.Estado LIKE 'A' AND R.Estado LIKE 'A' AND PA.Estado LIKE 'A' AND idAJProvincia =  "
                + idEntity + ";";

        AJDTOProvincia AJDto = new AJDTOProvincia();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);
            while (AJRs.next()) {
                AJDto = new AJDTOProvincia(
                        AJRs.getString(1),
                        AJRs.getString(2),
                        AJRs.getString(3),
                        "A",
                        AJRs.getString(4));
            }
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJReadBy()");
        }
        return AJDto;
    }

}
