module team {

    requires javafx.controls;
    requires javafx.graphics;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;

    opens UI;
    opens UI.admin;
}