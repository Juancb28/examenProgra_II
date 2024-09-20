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
import AJDataAccess.AJDataTransferObject.AJDTOPais;
import AJFramework.AJExceptions.AJException;

public class AJDAOPais extends AJSQLiteDataHelper implements AJIDAO<AJDTOPais> {

    @Override
    public Boolean AJCreate(AJDTOPais entity) throws Exception {
        String query = "INSERT INTO AJPaises" +
                "(NombrePais) VALUES" +
                "(?)";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombrePais());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public Boolean AJDelete(Integer idEntity) throws Exception {
        String query = "UPDATE AJPaises" +
                "SET Estado = ?" +
                "WHERE idAJPais = ?";
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
    public Boolean AJUpdate(AJDTOPais entity) throws Exception {
        String query = "UPDATE AJPaises" +
                "SET NombrePais = ?" +
                "WHERE idAJPais = ?";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombrePais());
            AJpstmt.setInt(2, entity.getIdAJPais());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJUpdate()");
        }
    }

    @Override
    public List<AJDTOPais> AJReadAll() throws Exception {
        String query = "SELECT idAJPais, NombrePais,"
                + "FechaCreacion FROM AJPaises WHERE "
                + "Estado LIKE 'VIVO' ";
        List<AJDTOPais> AJList = new ArrayList<>();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);

            while (AJRs.next()) {
                AJDTOPais AJdto = new AJDTOPais(
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
    public AJDTOPais AJReadBy(Integer idEntity) throws Exception {
        String query = "SELECT NombrePais FROM AJPaises WHERE "
                + "idAJPais = " + idEntity;
        AJDTOPais AJDto = new AJDTOPais();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);
            while (AJRs.next()) {
                AJDto = new AJDTOPais(AJRs.getString(1));
            }
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJReadBy()");
        }
        return AJDto;
    }

}
