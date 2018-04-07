/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetzanimaux;

import Entities.Veterinaire;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import veterinaire.services.VeterinaireService;

/**
 * FXML Controller class
 *
 * @author Tritux
 */
public class FXML_ListVeterinaireController implements Initializable {

              
    @FXML
    private TableColumn<?, ?> nomVet;
    @FXML
    private TableColumn<?, ?> prenomVet;
    @FXML
    private TableColumn<?, ?> mailVet;
    @FXML
    private TableColumn<?, ?> telVet;
    @FXML
    private TableColumn<?, ?> AvisVet;
    @FXML
    private TableView<?> tabVets;
    @FXML
    private TableColumn<?, ?> lieuxVet;
    @FXML
    private TableColumn<?, ?> idVet;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
                VeterinaireService vs =new VeterinaireService();
ObservableList  data = FXCollections.observableArrayList(vs.getAll());
            tabVets.setItems( data);
           
            
            nomVet.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenomVet.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            mailVet.setCellValueFactory(new PropertyValueFactory<>("mail"));
            telVet.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            lieuxVet.setCellValueFactory(new PropertyValueFactory<>("lieux"));
            AvisVet.setCellValueFactory(new PropertyValueFactory<>("note"));
            idVet.setCellValueFactory(new PropertyValueFactory<>("id"));
                      

        // TODO
    }    
    
}
