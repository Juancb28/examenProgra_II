package AJDataAccess.AJDataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import AJDataAccess.AJIDAO;
import AJDataAccess.AJSQLiteDataHelper;
import AJDataAccess.AJDataTransferObject.AJDTOHormiga;
import AJDataAccess.AJDataTransferObject.AJDTOProvincia;
import AJFramework.AJExceptions.AJException;

public class AJDAOHormiga extends AJSQLiteDataHelper implements AJIDAO<AJDTOHormiga> {

    @Override
    public Boolean AJCreate(AJDTOHormiga entity) throws Exception {
        String query = "INSERT INTO AJHormigas" +
                "(TipoHormiga, idSexo, idProvincia, idGenoAlimento, idIngestaNativa) VALUES" +
                "(?, ?, ?, ?, ?)";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombreProvincia());
            AJpstmt.setInt(2, entity.getIdSexo());
            AJpstmt.setInt(3, entity.getIdProvincia());
            AJpstmt.setInt(4, entity.getIdGenoAlimento());
            AJpstmt.setInt(5, entity.getIdIngestaNativa());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJCreate()");
        }
    }

    @Override
    public Boolean AJDelete(Integer idEntity) throws Exception {
        String query = "UPDATE AJHormigas" +
                "SET Estado = ?" +
                "WHERE idAJHormiga = ?";
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
    public Boolean AJUpdate(AJDTOHormiga entity) throws Exception {
        String query = "UPDATE AJProvincias" +
                "SET NombreProvincia = ?" +
                "WHERE idAJProvincia = ?";
        try {
            Connection AJCon = AJOpenConnection();
            PreparedStatement AJpstmt = AJCon.prepareStatement(query);
            AJpstmt.setString(1, entity.getNombreProvincia());
            AJpstmt.setInt(2, entity.getIdAJHormiga());
            AJpstmt.executeQuery();
            return true;
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJUpdate()");
        }
    }

    @Override
    public List<AJDTOHormiga> AJReadAll() throws Exception {
        String query = "SELECT H.TipoHormiga, S.NombreSexo, P.NombreProvincia, G.NombreGenoAlimento, I.NombreIngestaNativa, H.FechaCreacion"
                +
                "        FROM AJHormigas H" +
                "        JOIN AJSexo S ON H.idSexo = S.idAJSexo" +
                "        JOIN AJProvincias P ON H.idProvincia = P.idAJProvincia" +
                "        JOIN AJGenoAlimento G ON H.idGenoAlimento = G.idAJGenoAlimento " +
                "        JOIN AJIngestaNativa I ON H.idIngestaNativa = I.idAJIngestaNativa " +
                "        WHERE H.Estado LIKE 'A' AND S.Estado  LIKE 'A' AND P.Estado LIKE 'A' AND G.Estado LIKE 'A' AND I.Estado LIKE 'A';";
        List<AJDTOHormiga> AJList = new ArrayList<>();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);

            while (AJRs.next()) {
                AJDTOHormiga AJdto = new AJDTOHormiga(
                        AJRs.getInt(1),
                        AJRs.getString(2),
                        AJRs.getString(3),
                        AJRs.getString(4),
                        AJRs.getString(5),
                        AJRs.getString(6),
                        "A",
                        AJRs.getString(7));
                AJList.add(AJdto);
            }

        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJReadAll()");
        }
        return AJList;
    }

    @Override
    public AJDTOHormiga AJReadBy(Integer idEntity) throws Exception {
        String query = "SELECT H.TipoHormiga, S.NombreSexo, P.NombreProvincia, G.NombreGenoAlimento, I.NombreIngestaNativa, H.FechaCreacion"
                +
                "        FROM AJHormigas H" +
                "        JOIN AJSexo S ON H.idSexo = S.idAJSexo" +
                "        JOIN AJProvincias P ON H.idProvincia = P.idAJProvincia" +
                "        JOIN AJGenoAlimento G ON H.idGenoAlimento = G.idAJGenoAlimento " +
                "        JOIN AJIngestaNativa I ON H.idIngestaNativa = I.idAJIngestaNativa " +
                "        WHERE H.Estado LIKE 'A' AND S.Estado  LIKE 'A' AND P.Estado LIKE 'A' AND G.Estado LIKE 'A' AND I.Estado LIKE 'A' AND idAJHormiga = "
                +
                idEntity + ";";

        AJDTOHormiga AJDto = new AJDTOHormiga();
        try {
            Connection AJcon = AJOpenConnection();
            Statement AJstmt = AJcon.createStatement();
            ResultSet AJRs = AJstmt.executeQuery(query);
            while (AJRs.next()) {
                AJDto = new AJDTOHormiga(
                        AJRs.getString(1),
                        AJRs.getString(2),
                        AJRs.getString(3),
                        AJRs.getString(4),
                        AJRs.getString(5),
                        "A",
                        AJRs.getString(6));
            }
        } catch (SQLException e) {
            throw new AJException(e.getMessage(), getClass().getName(), "AJReadBy()");
        }
        return AJDto;
    }

}
