module com.example.selfcheckoutsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.rocs.selfcheckout.application.app to javafx.fxml;

    exports com.rocs.selfcheckout.application.app;
    exports com.rocs.selfcheckout.application.app.data.connection;
    exports com.rocs.selfcheckout.application.app.data.dao;
    exports com.rocs.selfcheckout.application.app.data.model;
}
