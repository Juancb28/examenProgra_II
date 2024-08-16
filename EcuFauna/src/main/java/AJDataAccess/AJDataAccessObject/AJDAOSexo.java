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
import AJDataAccess.AJDataTransferObject.AJDTOSexo;
import AJFramework.AJException;

public class AJDAOSexo extends AJSQLiteDataHelper implements AJIDAO<AJDTOSexo> {

    @Override
    public Boolean AJCreate(AJDTOSexo entity) throws Exception {
        String query = "INSERT INTO AJSexo" +
                "(NombreSexo) VALUES" +
                "(?)";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombreSexo());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public Boolean AJDelete(Integer idEntity) throws Exception {
        String query = "UPDATE AJSexo" +
                "SET Estado = ?" +
                "WHERE idAJSexo = ?";
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
    public Boolean AJUpdate(AJDTOSexo entity) throws Exception {
        String query = "UPDATE AJSexo" +
                "SET NombreSexo = ?" +
                "WHERE idAJSexo = ?";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombreSexo());
            AJpstmt.setInt(2, entity.getIdAJSexo());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJUpdate()");
        }
    }

    @Override
    public List<AJDTOSexo> AJReadAll() throws Exception {
        String query = "SELECT idAJSexo, NombreSexo,"
                + "FechaCreacion FROM AJSexo WHERE "
                + "Estado LIKE 'A' ";
        List<AJDTOSexo> AJList = new ArrayList<>();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);

            while (AJRs.next()) {
                AJDTOSexo AJdto = new AJDTOSexo(
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
    public AJDTOSexo AJReadBy(Integer idEntity) throws Exception {
        String query = "SELECT NombreSexo FROM AJSexo WHERE "
                + "idAJSexo = " + idEntity;
        AJDTOSexo AJDto = new AJDTOSexo();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);
            while (AJRs.next()) {
                AJDto = new AJDTOSexo(AJRs.getString(1));
            }
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJReadBy()");
        }
        return AJDto;
    }

}
