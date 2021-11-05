/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ec6.crud.jfx;

import br.com.business.ec6.crud.acesso.Acesso;
import br.com.comuns.crud.ec6.vos.acesso.Usuario;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gabriell
 */
public class FXMLLoginController implements Initializable {

    private Stage loginStage;
    
    private boolean loginRealizado;
    @FXML
    private TextField txtLogin;
    
    @FXML
    private PasswordField txtSenha;
    
    @FXML
    private Button btnOK;
    
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void btnOKAction(ActionEvent event) {
        Usuario user = new Usuario();
        user.setLogin(txtLogin.getText());
        user.setSenha(txtSenha.getText());
        Acesso acesso = new Acesso();
        loginRealizado =  acesso.validaUsuario(user);
        loginStage.close();
    }
    
    @FXML
    private void btnCancelAction(ActionEvent event) {
        System.exit(0);
    }

    
    
    boolean getLoginRealizado(){
        return loginRealizado;
    }


    void setLoginStage(Stage loginWindow) {
        loginStage = loginWindow;
    }
    
    public void initialize(String userName, LocalDateTime logDate, String log){
        System.out.println(logDate.toString() + " - "+ log);
        this.txtLogin.setText(userName);
    }
}
