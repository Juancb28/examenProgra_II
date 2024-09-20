module ec.edu.epn {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens AJDataAccess.AJDataTransferObject to javafx.base;
    opens ec.edu.epn to javafx.fxml;
    exports ec.edu.epn;
    exports AJBusinessLogic;
    exports AJDataAccess.AJDataTransferObject;
}
