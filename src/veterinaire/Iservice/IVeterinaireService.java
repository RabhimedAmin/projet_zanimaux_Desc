/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaire.Iservice;

import Entities.Veterinaire;
import java.util.List;

/**
 *
 * @author bhk
 */
public interface IVeterinaireService {

    public void createGateau(Veterinaire v);

    public List<Veterinaire> getAll();

    public void update(Veterinaire v );

    public void delete(int id);

}
