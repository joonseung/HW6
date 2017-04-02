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

public class UpdateQuery {
    
    private Connection conn;
    
    public UpdateQuery() {

    try{
            Properties props = new Properties(); 
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, passwd);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
   
    }
    
    public void doUpdate (lolChampions champ){
    
        try {
            String query = "UPDATE lolChampions SET champName = ?, champRole = ?, price = ?, skins =? WHERE champID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, champ.getChampName());
            ps.setString(2, champ.getChampRole());
            ps.setInt(3, champ.getPrice());
            ps.setInt(4, champ.getSkins());
            ps.setInt(5, champ.getChampID());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
