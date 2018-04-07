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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import veterinaire.services.VeterinaireService;

/**
 * FXML Controller class
 *
 * @author Tritux
 */
public class FXML_VeterinController implements Initializable {

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
    @FXML
    private Button insertImgBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutVeterinaire(ActionEvent event) {

        Veterinaire v =new Veterinaire(1,nomBtn.getText(),prenomBtn.getText(),mailBtn.getText(),Integer.valueOf( telBtn.getText()),lieuxBtn.getText(),0, insertImgBtn.getText() );
        VeterinaireService vs = new VeterinaireService();
        vs.createGateau(v);
    }
    
}
