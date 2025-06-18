package com.praktikum.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.praktikum.data.DataStore;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Inisialisasi user default jika belum ada
        if (DataStore.userList.isEmpty()) {
            DataStore.userList.add(new Admin("Admin UMM", "ADM474"));
            DataStore.userList.add(new Mahasiswa("Givrant Januarta", "202410370110474"));
        }
        LoginPane loginPane = new LoginPane(primaryStage);
        loginPane.setStyle("-fx-background-color: rgba(128, 0, 0, 0.8);");
        Scene scene = new Scene(loginPane, 400, 250);
        primaryStage.setTitle("Lost & Found Kampus UMM");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}