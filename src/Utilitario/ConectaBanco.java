/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilitario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectaBanco {
     public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/teste";
    private String usuario = "root";
    private String senha = "aldenora";
    public Connection conn;
    
    public void conexao(){
        System.setProperty("jdbc.Driver", driver);
        try {
            conn = DriverManager.getConnection(caminho,usuario,senha);
           
        } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"erro");

        }
        
    }
    
    public void executaSQL(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            
                        JOptionPane.showMessageDialog(null,"erro sql "+ex);
        }
        
    }
    
    
    public void desconecta(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
    

