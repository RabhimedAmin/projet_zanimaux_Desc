/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaire.services;

import Entities.Veterinaire;
import com.zanimaux.technique.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import veterinaire.Iservice.IVeterinaireService;

/**
 *
 * @author bhk
 */
public class VeterinaireService implements IVeterinaireService {

    Connection conn = DataSource.getInstance().getConnection();
    Statement stmt;

    @Override
    public void createGateau(Veterinaire v) {
        try {
            String req = "INSERT INTO veterinaire (nom,prenom,mail,telephone,lieux,note,image) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(req);
            st.setString(1, v.getNom());
            st.setString(2, v.getPrenom());
            st.setString(3,v.getMail());
            st.setInt(4, v.getTel());
            st.setString(5, v.getLieux());
            st.setInt(6, v.getNote());
            st.setString(7,v.getImage());
            st.executeUpdate();
            System.out.println("Ajout effectué avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(VeterinaireService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Veterinaire> getAll() {
        ArrayList<Veterinaire> listvets = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from veterinaire");
            while (rs.next()) {
                listvets.add(new Veterinaire(rs.getInt(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),
                        rs.getInt(7),rs.getString(8)));
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(VeterinaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listvets;
    }

    @Override
    public void update(Veterinaire v) {
        try {
            String req = "UPDATE `veterinaire` SET `nom` = ?, `prenom`= ?,`tel`=?,`lieux`=?,`note`=? WHERE `id` = ?";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, v.getId());
            st.setString(2, v.getNom());
            st.setString(3, v.getPrenom());
            st.setInt(4,v.getTel());
            st.setString(5, v.getLieux());
            st.setInt(6, v.getNote());
           
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VeterinaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            String req= "DELETE FROM `veterinaire` WHERE `veterinaire`.`id` = ? ";
            PreparedStatement st = conn.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VeterinaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
