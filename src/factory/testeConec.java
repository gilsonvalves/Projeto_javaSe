/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factory;
import java.sql.Connection;

import java.sql.SQLException;
import javax.swing.JOptionPane;
public class testeConec {
    
    
    public static void main(String[] args) throws SQLException{
        
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conectado");
        connection.close();
        JOptionPane.showMessageDialog(null,"Conectado ao Sistema aguarde!!!!!!");
        JOptionPane.showMessageDialog(null, "Conectado com Sucesso");
                
    }
    
}
