module com.fastandflavorous.projetsep {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.fastandflavorous.projetsep to javafx.fxml;
    exports com.fastandflavorous.projetsep;
}