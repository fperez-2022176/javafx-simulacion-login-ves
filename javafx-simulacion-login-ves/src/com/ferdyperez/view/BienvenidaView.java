package com.ferdyperez.view;

import javafx.scene.layout.VBox;


public class BienvenidaView extends VBox {

    private static BienvenidaView instanciaBIenvenidaVIew;
    
    public void BienvenidaView(){
        
    }

    public static BienvenidaView getInstanciaBIenvenidaVIew() {
        return instanciaBIenvenidaVIew;
    }

    public static void setInstanciaBIenvenidaVIew(BienvenidaView instanciaBIenvenidaVIew) {
        BienvenidaView.instanciaBIenvenidaVIew = instanciaBIenvenidaVIew;
    }
    
    
    
}
