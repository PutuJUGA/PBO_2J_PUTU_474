package com.praktikum.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import com.praktikum.data.DataStore;
import com.praktikum.users.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class LoginPane extends VBox {
    private ComboBox<String> roleCombo;
    private TextField namaField;
    private PasswordField passwordField;
    private Label messageLabel;
    private Stage primaryStage;

    public LoginPane(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.setStyle("-fx-background-color: rgba(128, 0, 0, 0.8);");
        setSpacing(10);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        Image logoImg = new Image(getClass().getResourceAsStream("/gambar/logo.png"));
        ImageView logoView = new ImageView(logoImg);
        logoView.setFitWidth(300);
        logoView.setPreserveRatio(true);

        Label title = new Label("Login Sistem Lost & Found");
        title.setStyle("-fx-font-color: WHITE;");
        roleCombo = new ComboBox<>();
        roleCombo.getItems().addAll("Mahasiswa", "Admin");
        roleCombo.setValue("Mahasiswa");

        namaField = new TextField();
        namaField.setPromptText("Username");
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginBtn = new Button("Login");
        messageLabel = new Label();

        loginBtn.setOnAction(e -> handleLogin());

        getChildren().addAll(logoView,title, roleCombo, namaField, passwordField, loginBtn, messageLabel);
    }

    private void handleLogin() {
        String role = roleCombo.getValue();
        String nama = namaField.getText();
        String pass = passwordField.getText();
        if (role.equals("Admin")) {
            for (var u : DataStore.userList) {
                if (u instanceof Admin) {
                    Admin a = (Admin) u;
                    if (a.username.equals(nama) && a.password.equals(pass)) {
                        AdminDashboard dash = new AdminDashboard(primaryStage, a);
                        primaryStage.getScene().setRoot(dash);
                        return;
                    }
                }
            }
            messageLabel.setText("Login gagal, periksa kredensial.");
        } else {
            for (var u : DataStore.userList) {
                if (u instanceof Mahasiswa) {
                    Mahasiswa m = (Mahasiswa) u;
                    if (m.getNama().equals(nama) && m.getNim().equals(pass)) {
                        MahasiswaDashboard dash = new MahasiswaDashboard(primaryStage, m);
                        primaryStage.getScene().setRoot(dash);
                        return;
                    }
                }
            }
            messageLabel.setText("Login gagal, periksa kredensial.");
        }
    }
}