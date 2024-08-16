package AJUserInterface.AJImageController;

import java.io.InputStream;
import java.util.Objects;

public class AJWarning implements AJImageDesign {

    @Override
    public InputStream AJGetPathImage() {
        return Objects.requireNonNull(getClass().getResourceAsStream("/Images/Warning.png"));
    }
    
}
