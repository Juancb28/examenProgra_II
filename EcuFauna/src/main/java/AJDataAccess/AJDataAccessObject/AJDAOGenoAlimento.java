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
import AJDataAccess.AJDataTransferObject.AJDTOGenoAlimento;
import AJFramework.AJExceptions.AJException;

public class AJDAOGenoAlimento extends AJSQLiteDataHelper implements AJIDAO<AJDTOGenoAlimento> {

    @Override
    public Boolean AJCreate(AJDTOGenoAlimento entity) throws Exception {
        String query = "INSERT INTO AJGenoAlimento" +
                "(NombreGenoAlimento) VALUES" +
                "(?)";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombreGenoAlimento());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public Boolean AJDelete(Integer idEntity) throws Exception {
        String query = "UPDATE AJGenoAlimento" +
                "SET Estado = ?" +
                "WHERE idAJGenoAlimento = ?";
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
    public Boolean AJUpdate(AJDTOGenoAlimento entity) throws Exception {
        String query = "UPDATE AJGenoAlimento" +
                "SET NombreGenoAlimento = ?" +
                "WHERE idAJGenoAlimento = ?";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombreGenoAlimento());
            AJpstmt.setInt(2, entity.getIdAJGenoAlimento());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJUpdate()");
        }
    }

    @Override
    public List<AJDTOGenoAlimento> AJReadAll() throws Exception {
        String query = "SELECT idAJGenoAlimento, NombreGenoAlimento,"
                + "FechaCreacion FROM AJGenoAlimento WHERE "
                + "Estado LIKE 'A' ";
        List<AJDTOGenoAlimento> AJList = new ArrayList<>();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);

            while (AJRs.next()) {
                AJDTOGenoAlimento AJdto = new AJDTOGenoAlimento(
                        AJRs.getInt(1),
                        AJRs.getString(2),
                        "A",
                        AJRs.getString(3));
                AJList.add(AJdto);
            }

        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJReadAll()");
        }
        return AJList;
    }

    @Override
    public AJDTOGenoAlimento AJReadBy(Integer idEntity) throws Exception {
        String query = "SELECT NombreGenoAlimento FROM AJGenoAlimento WHERE "
                + "idAJGenoAlimento = " + idEntity;
        AJDTOGenoAlimento AJDto = new AJDTOGenoAlimento();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);
            while (AJRs.next()) {
                AJDto = new AJDTOGenoAlimento(AJRs.getString(1));
            }
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJReadBy()");
        }
        return AJDto;
    }

}
