package AJUserInterface;

import AJBusinessLogic.AJBLGenoAlimento;
import AJBusinessLogic.AJBLProvincia;
import AJBusinessLogic.AJBLSexo;
import AJDataAccess.AJDataTransferObject.AJDTOHormiga;
import AJHormiga.AJLarva;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class AntController {

    private final String AJCedulaAlumno = "1752176097";
    private final String AJNombresAlumno = "Arroyo Juan";

    public String getAJCedulaAlumno() {
        return AJCedulaAlumno;
    }

    public String getAJNombresAlumno() {
        return AJNombresAlumno;
    }

    private static AtomicInteger idAnt = new AtomicInteger(0);

    public AJDTOHormiga createAntPrototipe() throws Exception {
        AJDTOHormiga dto;
        int aux = (new Random().nextInt(new AJBLProvincia().AJReadAll().size()) + 1),
                idPro = new AJBLProvincia().AJReadBy(aux).getIdAJProvincia();
        dto = new AJDTOHormiga(new AJLarva().getClass().getSimpleName().substring(2),
                new AJBLSexo().AJReadAll().get(2).getIdAJSexo(), idPro, "VIVO");
        dto.setIdAJHormiga(idAnt.getAndIncrement() + 1);
        return dto;
    }

    public Integer addGenoAlimento(String nameGenoAlimento) throws Exception {
        return new AJBLGenoAlimento().AJReadAll().stream()
                .filter(e -> e.getNombreGenoAlimento().equals(nameGenoAlimento)).findFirst().get()
                .getIdAJGenoAlimento();
    }

}