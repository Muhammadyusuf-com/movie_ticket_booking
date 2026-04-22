module team {

    requires javafx.controls;
    requires javafx.graphics;
    requires java.desktop;

    opens UI;
    opens UI.admin;
}