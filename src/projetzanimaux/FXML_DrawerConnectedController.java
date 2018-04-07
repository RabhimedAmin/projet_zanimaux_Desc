/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetzanimaux;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static veterinaire.services.UserService.currentUser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import static projetzanimaux.FXML_indexContentController.AnchorDrower;

/**
 * FXML Controller class
 *
 * @author USER-PC
 */
public class FXML_DrawerConnectedController implements Initializable {


    @FXML
    private JFXButton exit;
    @FXML
    private JFXButton profile;
    @FXML
    private ImageView UserImage;
    @FXML
    private JFXButton disconnect;
    @FXML
    private Label nom;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nom.setText("Connected as :"+currentUser.getUsername());
        disconnect.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
            System.out.println("disconnect button");
            currentUser.setConfirmation_token("");
            currentUser.setEmail("");
            currentUser.setEnabled(0);
            currentUser.setVille("");
            currentUser.setId(0);
            currentUser.setLast_login("");
            currentUser.setSexe("");
            currentUser.getTel();
            currentUser.setPassword("");
            currentUser.setPassword_request_at("");
            
            currentUser.setRoles("");
            
            currentUser.setUsername("");

            try {
                AnchorDrower=FXMLLoader.load(getClass().getResource("FXML_DrawerConnected.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(FXML_DrawerConnectedController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(currentUser.toString());
        });
    }    
    
}
