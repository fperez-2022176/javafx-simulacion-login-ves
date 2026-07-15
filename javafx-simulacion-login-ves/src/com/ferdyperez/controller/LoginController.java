package com.ferdyperez.controller;

import com.ferdyperez.model.Usuario;
import com.ferdyperez.view.LoginView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController {

    private final LoginView LOGIN_VIEW;
    private double ejeX = 0;
    private double ejeY = 0;

    private AuthSistema authSistema = new AuthSistema();

    public LoginController(LoginView loginView) {
        this.LOGIN_VIEW = loginView;

        construirAcciones();
    }

    private Stage escenarioPrincipal = SceneManager
            .getInstanciaSceneManager()
            .getEscenarioPrincipal();

    public void iniciarSesion() {
        String nombreUsuario = this.LOGIN_VIEW.getTxtNombreUsuario().getText().trim();
        String clave = this.LOGIN_VIEW.getPwdClave().getText().trim();

        if (nombreUsuario.isEmpty()) {
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().remove("empty");
            this.LOGIN_VIEW.getPwdClave().getStyleClass().add("empty");
            JOptionPane.showMessageDialog(null, "No dejes vacio el nombre de usuario");
        } else if (clave.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Coloca una contraseña");
        } else {
            this.LOGIN_VIEW.getPwdClave().getStyleClass().remove("empty");

            //METODO LOGIN
            Usuario usuario = authSistema.login(nombreUsuario, clave);

            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Verifica tus credenciales");

            } else {
                JOptionPane.showMessageDialog(null, "HOLA");
            }
        }
    }

    public void construirAcciones() {

        this.LOGIN_VIEW.getBtnIniciarSecion().setOnMouseClicked(
                (evento) -> {
                    iniciarSesion();
                }
        );

        this.LOGIN_VIEW.getBtnCerrarVentana().setOnMouseClicked(
                (evento) -> {
                    System.exit(0);
                }
        );

        this.LOGIN_VIEW.setOnMouseClicked(
                (evento) -> {
                    ejeX = evento.getSceneX();
                    ejeY = evento.getSceneY();

                }
        );

        this.LOGIN_VIEW.setOnMouseDragged(
                (evento) -> {
                    double ejeXDesplazamientoVentana = evento.getScreenX();
                    double ejeYDesplazamientoVentana = evento.getScreenY();

                    escenarioPrincipal.setX(ejeXDesplazamientoVentana - ejeX);
                    escenarioPrincipal.setY(ejeYDesplazamientoVentana - ejeY);
                }
        );

    }

}
