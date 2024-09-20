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
import AJDataAccess.AJDataTransferObject.AJDTORegiones;
import AJFramework.AJExceptions.AJException;

public class AJDAORegion extends AJSQLiteDataHelper implements AJIDAO<AJDTORegiones> {

    @Override
    public Boolean AJCreate(AJDTORegiones entity) throws Exception {
        String query = "INSERT INTO AJRegiones" +
                "(NombreRegion, idPais) VALUES" +
                "(?, ?)";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombreRegion());
            AJpstmt.setInt(2, entity.getIdPais());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public Boolean AJDelete(Integer idEntity) throws Exception {
        String query = "UPDATE AJRegiones" +
                "SET Estado = ?" +
                "WHERE idAJRegion = ?";
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
    public Boolean AJUpdate(AJDTORegiones entity) throws Exception {
        String query = "UPDATE AJRegiones" +
                "SET NombreRegion = ?" +
                "WHERE idAJRegion = ?";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombreRegion());
            AJpstmt.setInt(2, entity.getIdAJRegion());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJUpdate()");
        }
    }

    @Override
    public List<AJDTORegiones> AJReadAll() throws Exception {
        String query = "SELECT idAJRegion, NombreRegion, idPais,"
                + "FechaCreacion FROM AJRegiones WHERE "
                + "Estado LIKE 'VIVO' ";
        List<AJDTORegiones> AJList = new ArrayList<>();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);

            while (AJRs.next()) {
                AJDTORegiones AJdto = new AJDTORegiones(
                        AJRs.getInt(1),
                        AJRs.getString(2),
                        AJRs.getInt(3),
                        "VIVO",
                        AJRs.getString(4));
                AJList.add(AJdto);
            }

        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJReadAll()");
        }
        return AJList;
    }

    @Override
    public AJDTORegiones AJReadBy(Integer idEntity) throws Exception {
        String query = "SELECT NombreRegion FROM AJRegiones WHERE "
                + "idAJRegion = " + idEntity;
        AJDTORegiones AJDto = new AJDTORegiones();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);
            while (AJRs.next()) {
                AJDto = new AJDTORegiones(AJRs.getString(1));
            }
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJReadBy()");
        }
        return AJDto;
    }

}
