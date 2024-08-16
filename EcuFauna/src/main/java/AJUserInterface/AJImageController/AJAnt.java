package AJUserInterface.AJImageController;

import java.io.InputStream;
import java.util.Objects;

public class AJAnt implements AJImageDesign {

    @Override
    public InputStream AJGetPathImage() {
        return Objects.requireNonNull(getClass().getResourceAsStream("/Images/HormigueroVirtual.png"));
    }

}
