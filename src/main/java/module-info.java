module com.fastandflavorous.projetsep {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires mysql.connector.java;
    requires java.sql;
    requires junit;
    requires org.junit.jupiter.api;

    // opens to FXML
    opens com.fastandflavorous.projetsep to javafx.fxml;

    // exports main package and tests
    exports com.fastandflavorous.projetsep;
    exports com.fastandflavorous.projetsep.tests.login;

    // exports for login and users
    exports com.fastandflavorous.projetsep.dao.users;
    exports com.fastandflavorous.projetsep.model.users;
    exports com.fastandflavorous.projetsep.factory.users;
    exports com.fastandflavorous.projetsep.facade.login;

    // exports for menus
    exports com.fastandflavorous.projetsep.dao.menus;
    exports com.fastandflavorous.projetsep.model.menus;
    exports com.fastandflavorous.projetsep.factory.menus;
    exports com.fastandflavorous.projetsep.facade.menus;
}