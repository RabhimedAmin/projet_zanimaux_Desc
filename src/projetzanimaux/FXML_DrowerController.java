/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetzanimaux;

import Entities.User;
import veterinaire.services.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import static projetzanimaux.FXML_indexContentController.register;

/**
 *
 * @author USER-PC
 */
public class FXML_DrowerController implements Initializable {
    
    private Label label;
    @FXML
    private JFXButton inscrire;
    
    @FXML
    private JFXButton cancel;
    @FXML
    private ChoiceBox<?> role;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXButton login;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO      
        inscrire.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
            System.out.println(nom.getText());
            UserService user=new UserService();
            User u=new User(0, nom.getText(), nom.getText(),email.getText(),email.getText(),1, password.getText(), "", "", "", role.getValue().toString(), "", 2311523,"", "");
        //User u = new User(200,"boulbeba","boulbeba","boulbeba.fouzai@esprit.tn","boulbeba.fouzai@esprit.tn",1,"motdpass","test","test","test","test","test",12121212,"test","test");
            UserService userservice=new UserService();
            try {
                        userservice.addUser(u);
                    } catch (SQLException ex) {
                        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                    }
            register.close();
        
        });
     
        
        
       
    }    
    
}
