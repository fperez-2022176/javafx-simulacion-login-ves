package com.ferdyperez.system;

import com.ferdyperez.controller.SceneManager;
import com.ferdyperez.view.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClasePrincipal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenarioRaiz) {

        SceneManager
                .getInstanciaSceneManager()
                .setEscenarioPrincipal(escenarioRaiz);

        SceneManager
                .getInstanciaSceneManager()
                .ventanaLogin();

    }

}
