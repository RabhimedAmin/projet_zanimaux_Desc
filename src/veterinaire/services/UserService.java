/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaire.services;

import Entities.User;
import com.zanimaux.technique.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author USER-PC
 */
public class UserService {
    Connection cnx=DataSource.getInstance().getConnection();
    Statement ste;
    ResultSet rs;
    public static User currentUser=new User();
    public UserService()
    {   
        try {
            ste=cnx.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void addUser(User u) throws SQLException
    {
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String req="INSERT INTO `fos_user`("	
        + "`username`,`email`, `email_canonical`,"
                + " `enabled`,`password`, `last_login`,"
                + "`roles`,`sexe`, `telephone`,`image`,`ville`,`username_canonical`) "
                + "VALUES (?,?,?,?,?,?,"
                + "?,?,?,?,?,?)";
                
        PreparedStatement pre=cnx.prepareStatement(req);
        pre.setString(1,u.getUsername());
        pre.setString(2,u.getEmail());
        pre.setString(3,u.getEmail());
        pre.setInt(4,1);
        pre.setString(5,u.getPassword());
        if (u.getRoles().toString()=="Utilisateur")
            u.setRoles("a:0:{}");
        else
            u.setRoles("a:1:{i:0;s:12:\"ROLE_Admin\";}");
        pre.setString(6,timeStamp);
        pre.setString(7,u.getRoles());
        System.out.println("role :");
        System.out.println(u.getRoles());
        pre.setString(8,u.getSexe());
        pre.setInt(9,u.getTel());
        pre.setString(10,"Null");
        pre.setString(11,u.getVille());
                pre.setString(12,u.getUsername());
       
        try {
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Boolean Autentifier(String u,String p) throws SQLException
    {
        String req = "SELECT * FROM `fos_user` WHERE email =\'"+u+"\' and password=\'"+p+"\'";
        System.out.println(req);
        
        
        try {
             rs= ste.executeQuery(req);
            System.out.println(rs);
            if (rs!=null)
            {
                        while (rs.next())
                        {
                            System.out.println(rs.getInt(1));
                            System.out.println(rs.getString(2));
                            System.out.println(rs.getString(3));
                            System.out.println(rs.getString(4));
                            System.out.println(rs.getString(5));
                            System.out.println(rs.getString(6));
                            System.out.println(rs.getString(7));
                            System.out.println(rs.getString(8));
                            System.out.println(rs.getString(9));
                            System.out.println(rs.getString(10));
                            System.out.println(rs.getString(11));
                            System.out.println(rs.getString(12));
                            System.out.println(rs.getInt(13));
                            System.out.println(rs.getString(14));
                            System.out.println(rs.getString(15));
                            currentUser.setId(rs.getInt(1));
                            currentUser.setUsername(rs.getString(2));
                            currentUser.setUsername_canonical(rs.getString(3));

                                                        currentUser.setEmail(rs.getString(4));
                            currentUser.setEmail_canonical(rs.getString(5));
                            currentUser.setEnabled(rs.getInt(6));
                            currentUser.setPassword(rs.getString(7));
                            currentUser.setLast_login(rs.getString(8));
                            currentUser.setConfirmation_token(rs.getString(9));
                            currentUser.setPassword_request_at(rs.getString(10));
                            currentUser.setRoles(rs.getString(11));
                            currentUser.setSexe(rs.getString(12));
                            currentUser.setTel(rs.getInt(13));
                            currentUser.setVille(rs.getString(14));
                            currentUser.setImage(rs.getString(15));


                            System.out.println(currentUser.toString());
                            return true;
                        }
            }
            
                
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static boolean isLogedIn(User user)
    {
        if ((user.getEmail()=="" && user.getUsername()=="")||(user.getEmail()==null && user.getUsername()==null))
             return false;
        else 
            return true;
    }
    public boolean isValidUser(String Email)
    {
        String req = "SELECT * FROM `user` WHERE email =\'"+Email+"\'";
        try {
             rs= ste.executeQuery(req);
            System.out.println(rs);
            if (rs!=null)
            {
                        while (rs.next())
                        {
                            System.out.println(rs.toString());
                            return true;
                        }
            }
            
                
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void addToken(int token,String email) throws SQLException
    {
            //
        String req = "UPDATE `user` SET `confirmation_token`="+token+",`password_requested_at`=SYSDATE() WHERE email=\""+email+"\"";
        
        try {
             int i= ste.executeUpdate(req);
      
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public boolean isValidToken(String get, String text) {
        String token = null;
        String date = null;
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String req = "SELECT * FROM `user` WHERE email =\'"+text+"\'";
                try {
                         rs= ste.executeQuery(req);
                        System.out.println(rs);
                        if (rs!=null)
                        {
                                    while (rs.next())
                                    {
                                        token=rs.getString(10);
                                        date=rs.getString(11);
                                        System.out.println(rs.toString());
                                        
                                    }
                        }


                    } catch (SQLException ex) {
                        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                    }
                if (date==null || token == null)
                {System.out.println("null vale"+date+" token"+token);
                    return false;
                }
                else
                {
                    String jj,mm,yy,dd,hh,m;
                    //vale2018-03-21 19:32:38.05877
                    yy=date.substring(2, 4);
                    mm=date.substring(5, 7);
                    dd=date.substring(8, 10);
                    hh=date.substring(11, 13);
                    m=date.substring(14, 16);
                    System.out.println("year"+yy+"month"+mm+"day"+dd+"hour"+hh+"minut"+m);
                    
                    String jj1,mm1,yy1,dd1,hh1,m1,hh2;
                    //vale2018-03-21 19:32:38.05877
                    yy1=timeStamp.substring(2, 4);
                    mm1=timeStamp.substring(5, 7);
                    dd1=timeStamp.substring(8, 10);
                    hh1=timeStamp.substring(11, 13);
                    m1=timeStamp.substring(14, 16);
                    hh2=hh+1;
                    System.out.println("year"+yy1+"month"+mm1+"day"+dd1+"hour"+hh1+"minut"+m1);
                    
                    System.out.println("vale "+date+token);
                    if (get.equals(token) && yy.equals(yy1) && mm.equals(mm1)&& dd.equals(dd1) && (hh.equals(hh1)||hh2.equals(hh1)))
                    return true;
                }
    return false;
    }

   public User findUser(int id) throws SQLException
    { User a=null;
       ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery("Select * from user where id="+"'"+id+"'");
           while(rs.next())
           {   a=new User(
                         
                        rs.getInt(1),
                            rs.getString(2),
                   rs.getString(3),
                   rs.getString(4),
                   rs.getString(5),
                            rs.getInt(6),
                           rs.getString(7),
                            rs.getString(8),
                           rs.getString(9),
                            rs.getString(10),
                         rs.getString(11),
                            rs.getString(12),
                           rs.getInt(13),
                            rs.getString(14),
                            rs.getString(15)
                                   
                                
                      
              
                              );
            
           } ste.close();
        
        return a;
    }

    
            
            
}