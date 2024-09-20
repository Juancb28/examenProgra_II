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
import AJDataAccess.AJDataTransferObject.AJDTOIngestaNativa;
import AJFramework.AJExceptions.AJException;

public class AJDAOIngestaNativa extends AJSQLiteDataHelper implements AJIDAO<AJDTOIngestaNativa> {

    @Override
    public Boolean AJCreate(AJDTOIngestaNativa entity) throws Exception {
        String query = "INSERT INTO AJIngestaNativa" +
                "(NombreIngestaNativa) VALUES" +
                "(?)";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombreIngestaNativa());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public Boolean AJDelete(Integer idEntity) throws Exception {
        String query = "UPDATE AJIngestaNativa" +
                "SET Estado = ?" +
                "WHERE idAJIngestaNativa = ?";
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
    public Boolean AJUpdate(AJDTOIngestaNativa entity) throws Exception {
        String query = "UPDATE AJIngestaNativa" +
                "SET NombreIngestaNativa = ?" +
                "WHERE idAJIngestaNativa = ?";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombreIngestaNativa());
            AJpstmt.setInt(2, entity.getIdAJIngestaNativa());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJUpdate()");
        }
    }

    @Override
    public List<AJDTOIngestaNativa> AJReadAll() throws Exception {
        String query = "SELECT idAJIngestaNativa, NombreIngestaNativa,"
                + "FechaCreacion FROM AJIngestaNativa WHERE "
                + "Estado LIKE 'VIVO' ";
        List<AJDTOIngestaNativa> AJList = new ArrayList<>();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);

            while (AJRs.next()) {
                AJDTOIngestaNativa AJdto = new AJDTOIngestaNativa(
                        AJRs.getInt(1),
                        AJRs.getString(2),
                        "VIVO",
                        AJRs.getString(3));
                AJList.add(AJdto);
            }

        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJReadAll()");
        }
        return AJList;
    }

    @Override
    public AJDTOIngestaNativa AJReadBy(Integer idEntity) throws Exception {
        String query = "SELECT NombreIngestaNativa FROM AJIngestaNativa WHERE "
                + "idAJIngestaNativa = " + idEntity;
        AJDTOIngestaNativa AJDto = new AJDTOIngestaNativa();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);
            while (AJRs.next()) {
                AJDto = new AJDTOIngestaNativa(AJRs.getString(1));
            }
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJReadBy()");

        }
        return AJDto;
    }

}
