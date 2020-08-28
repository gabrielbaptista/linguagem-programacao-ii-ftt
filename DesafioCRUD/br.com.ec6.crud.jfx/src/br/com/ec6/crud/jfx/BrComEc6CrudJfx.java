/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ec6.crud.jfx;

import br.com.business.ec6.crud.config.Config;
import br.com.comuns.crud.ec6.enums.TipoRepositorio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author gabriell
 */
public class BrComEc6CrudJfx extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Config.getInstance().setDatabase(TipoRepositorio.TEXTO);
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
