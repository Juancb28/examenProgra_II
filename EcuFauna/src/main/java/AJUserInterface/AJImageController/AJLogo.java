package AJUserInterface.AJImageController;

import java.io.InputStream;
import java.util.Objects;


public class AJLogo implements AJImageDesign {

    @Override
    public InputStream AJGetPathImage() {
        return Objects.requireNonNull(getClass().getResourceAsStream("/Images/LogoEcuFauna.png"));
    }



}
