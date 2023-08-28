module view {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    exports view;
    opens view to javafx.fxml;

    exports GUI.vendedor;
    opens GUI.vendedor to javafx.fxml;

    exports GUI.login;
    opens GUI.login to javafx.fxml;

    exports GUI.cliente;
    opens GUI.cliente to javafx.fxml;

    exports GUI.gerente;
    opens GUI.gerente to javafx.fxml;

    exports GUI.catraca;
    opens GUI.catraca to javafx.fxml;

    opens negocio.beans to javafx.base;
}