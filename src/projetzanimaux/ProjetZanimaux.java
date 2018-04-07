/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetzanimaux;

import Entities.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import veterinaire.services.UserService;

/**
 *
 * @author Tritux
 */
public class ProjetZanimaux extends Application {
    
    @Override
    public void start(Stage stage) {
       
    
        try {
            Parent     root = FXMLLoader.load(getClass().getResource("FXML_login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProjetZanimaux.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      /*  UserService us = new UserService();
        //User u = new User(200,"boulbeba","boulbeba","boulbeba.fouzai@esprit.tn","boulbeba.fouzai@esprit.tn",1,"motdpass","test","test","test","test","test",12121212,"test","test");
        //try {
            us.addUser(u);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetZanimaux.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
 launch(args);
    }
    
}
