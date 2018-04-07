/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetzanimaux;

import Entities.Veterinaire;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import veterinaire.services.VeterinaireService;

/**
 * FXML Controller class
 *
 * @author Tritux
 */
public class FXML_modifVeterinaireController implements Initializable {

    @FXML
    private TextField nomBtn;
    @FXML
    private TextField prenomBtn;
    @FXML
    private TextField mailBtn;
    @FXML
    private TextField telBtn;
    @FXML
    private TextField lieuxBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierVeterinaire(ActionEvent event) {
        VeterinaireService vs =new VeterinaireService();
        Veterinaire v = new Veterinaire();
    }
    
}
