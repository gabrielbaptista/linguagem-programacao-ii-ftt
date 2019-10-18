/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ec6.crud.jfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author gabriell
 */
public class FXMLDocumentController implements Initializable {
    private static boolean usuarioLogado = false;
    
    @FXML
    private MenuItem menuClose;
    
    @FXML
    private void menuCloseAction(ActionEvent event) {
        System.exit(0);
    }
    
    boolean showLogin() throws IOException {
        Stage loginWindow = new Stage();
        loginWindow.initModality(Modality.WINDOW_MODAL);
        Parent root;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLLoginController.class.getResource("FXMLLogin.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        loginWindow.setScene(scene);
        // Define a pessoa no controller.
        FXMLLoginController controller = loader.getController();
        controller.setLoginStage(loginWindow);        
        loginWindow.showAndWait();
        return controller.getLoginRealizado();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            while (!usuarioLogado){
                usuarioLogado = showLogin();
            }
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
