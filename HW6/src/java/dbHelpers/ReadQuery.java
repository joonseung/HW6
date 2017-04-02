package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.lolChampions;
/**
 *
 * @author Abc
 */
public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery() {
        
    try{
            Properties props = new Properties(); 
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            try {
                props.load(instr);
            } catch (IOException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                instr.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, passwd);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    
    public void doRead(){
        
        String query = "Select *from lolChampions ORDER BY champID ASC";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLTable(){
        
        String table = "";
        
        table += "<table>";
        
        try {
            
            table += "<thead>";
                    table += "<th>";
                    table += "ID";
                    table += "</th>";
                    
                    table += "<th>";
                    table += "Name";
                    table += "</th>";
                    
                    table += "<th>";
                    table += "Role";
                    table += "</th>";
                    
                    table += "<th>";
                    table += "Price";
                    table += "</th>";
                    
                    table += "<th>";
                    table += "Skins";
                    table += "</th>";
                    
                    table += "<th>";
                    table += "Action";
                    table += "</th>";
                    
                table += "</thead>";
                
            while(this.results.next()){
                
                lolChampions champ = new lolChampions();
                champ.setChampID(this.results.getInt("champID"));
                champ.setChampName(this.results.getString("champName"));
                champ.setChampRole(this.results.getString("champRole"));
                champ.setPrice(this.results.getInt("price"));
                champ.setSkins(this.results.getInt("skins"));
                
                
                
                table += "<tr>";
                
                    table += "<td>";
                    table += champ.getChampID();
                    table += "</td>";

                    table += "<td>";
                    table += champ.getChampName();
                    table += "</td>";

                    table += "<td>";
                    table += champ.getChampRole();
                    table += "</td>";

                    table += "<td>";
                    table += champ.getPrice();
                    table += "</td>";

                    table += "<td>";
                    table += champ.getSkins();
                    table += "</td>";
                    
                    table += "<td>";
                    table += "<a href = update?champID=" + champ.getChampID() +"> Update </a>" + "<a href = delete?champID=" + champ.getChampID() +"> Delete </a>";
                    table += "</td>";
                    
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        table += "</table>";
        
                    return table;
    }
}
