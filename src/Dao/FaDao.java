

package Dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import factory.ConnectionFactory;
import modelo.fa;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class FaDao {
    
        private Connection connection; 
        
        
  public FaDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
  
  public void adcionar(fa Fa){
      String sql = "INSERT INTO fa VALUES(?,?,?,?,?,?,?,?,?)";
      try { 
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.setInt(1,Fa.getItem());
            stmt.setString(2, Fa.getFa());
            stmt.setString(3, Fa.getNome());
            stmt.setString(4,Fa.getData());
            stmt.setString(5,Fa.getTecnicotriagem());
            stmt.setString(6,Fa.getHora());
            stmt.setString(7,Fa.getObs());
            stmt.setString(8,Fa.getTecnicoretorno());
            stmt.setString(9,Fa.getStatus());
           
            stmt.execute();
            stmt.close();
                 
      }catch(SQLException p) { 
             throw new RuntimeException(p);
             
        } 
     
  }   
      public void excluir(fa Fa){
          
            String sql = "DELETE FROM fa where fa ='"+Fa.getFa()+"'";
            
           try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        
           }catch(SQLException u){
            
            throw new RuntimeException("erro ao excluir: "+u.getMessage());
        }
      }
    
        public void alterar(fa Fa){
        
   String sql = "update fa set  fa=?, nome=?, data=?, tecnicotriagem=?, hora= ?, obs= ?, tecnicoretorno=?, status=? where item=? ";            
  try { 
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.setString(1, Fa.getFa());
            stmt.setString(2, Fa.getNome());
            stmt.setString(3,Fa.getData());
            stmt.setString(4,Fa.getTecnicotriagem());
            stmt.setString(5,Fa.getHora());
            stmt.setString(6,Fa.getObs());
            stmt.setString(7,Fa.getTecnicoretorno());
            stmt.setString(8,Fa.getStatus());
            stmt.setInt(9, Fa.getItem());
            stmt.executeUpdate();
            stmt.close();
                 
      }catch(SQLException p) { 
             JOptionPane.showMessageDialog(null,"Erro ao alterar"+p);
             System.out.print(p);
             
        } 
      
    }
      
      
      
                
  
 }