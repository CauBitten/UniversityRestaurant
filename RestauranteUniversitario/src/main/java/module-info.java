module view {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    exports view;
    opens view to javafx.fxml;

    exports gui.vendedor;
    opens gui.vendedor to javafx.fxml;

    exports gui.login;
    opens gui.login to javafx.fxml;

    exports gui.cliente;
    opens gui.cliente to javafx.fxml;

    exports gui.gerente;
    opens gui.gerente to javafx.fxml;

    exports gui.refeicao;
    opens gui.refeicao to javafx.fxml;

    opens negocio.beans to javafx.base;
}