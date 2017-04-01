/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.lolChampions;

/**
 *
 * @author Abc
 */
public class AddQuery {
    
    private Connection conn;
    
    public AddQuery(){
        
        try{
            Properties props = new Properties(); 
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, passwd);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        // lolCahmpions and champ object.... Freinds class and friend object ... but can't find object... see " https://www.youtube.com/watch?v=3ZmipkRPRRA" 10:26 if question
    // object is on AddServlet.jav  which is champ
    public void doAdd (lolChampions champ){
    
        try {
            String query = "INSERT INTO lolChampions (champName, champRole, price, skins) VALUES (?, ?, ?, ?)"; // said friends table but used lolChampions table of mine
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, champ.getChampName());
            ps.setString(2, champ.getChampRole());
            ps.setInt(3, champ.getPrice());
            ps.setInt(4, champ.getSkins());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
}
