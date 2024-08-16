package AJFramework.AJVerificacion;


public class AJVerificarCredenciales {

    private static final String AJUsuario = "patmic";
    private static final String AJContra = "1234";

    public static Boolean AJVerificarCuenta(String usuario, String contra){
        if (AJUsuario.equals(usuario) && AJContra.equals(contra)) {
            return true;
        }
        return false;
    }
}
