/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Telas;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;
import modelo.fa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;

public class Estudos extends JFrame {
    private String fa;
     JLabel label;
public int x;
    private javax.swing.JButton novo;
   private javax.swing.JButton sair;
   private javax.swing.JButton atualizar;
   
    

    public  Estudos(){
    super("JTable");
		
    final DefaultTableModel modelo = new DefaultTableModel();
    
    // constrói a tabela
    JTable tabela = new JTable(modelo);
    
    // Cria duas colunas
    modelo.addColumn("ITEM");
    modelo.addColumn("FA");
    modelo.addColumn("NOME");
    modelo.addColumn("DATA");
    modelo.addColumn("TECNICO");
    modelo.addColumn("HORA");
    modelo.addColumn("OBSERVAÇÃO");
    
    // exibe os dados da tabela MySQL
    try{
    
      Connection conn = DriverManager.getConnection("jdbc:mysql://10.42.1.151:3307/retorno","root","aldenora");
           
      // procedimentos para obter os dados de uma tabela
      Statement stmt = conn.createStatement();
      String query = "SELECT * FROM FA_1 ";
      ResultSet rs = stmt.executeQuery(query);
      
     while(rs.next()){ 
        String item = rs.getString("item");
        String fa = rs.getString("fa");
        String nome = rs.getString("nome");
        String data = rs.getString("data");
        String tecnicotriagem = rs.getString("tecnicotriagem");
        String hora = rs.getString("hora");
       String obs = rs.getString("Obs");  
        
      modelo.addRow(new Object[]{new String(item), fa,nome, data, tecnicotriagem, hora,obs, new String(item)});
      
      }
           
      // fim procedimento para obter os dados
      } 
      catch(SQLException ex){
           System.out.println("SQLException: " + ex.getMessage());
           System.out.println("SQLState: " + ex.getSQLState());
           System.out.println("VendorError: " + ex.getErrorCode());
      }
      catch(Exception e){
        System.out.println("Problemas ao tentar conectar com o banco de dados");	
    }
    
    // fim MySQL
    
    int x;
    tabela.setPreferredScrollableViewportSize(new Dimension(1100, 500));
    tabela.getRowCount();
    
    x = tabela.getRowCount();
   
   
    label = new JLabel();   
   
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
			
    JScrollPane scrollPane = new JScrollPane(tabela);
    c.add(scrollPane);
     c.add(new JLabel ("Ja foi atendito um total de "+x));
    
    setSize(1900, 1500);
    setTitle("Consulta sistema");
    setVisible(true);
    setBackground(Color.WHITE);
    
        
    
  sair = new javax.swing.JButton("sair");
  novo = new javax.swing.JButton("Cadrastrar FA");
  atualizar = new javax.swing.JButton("Atualizar");
   add(sair);
   add(novo);
   add(atualizar);
   sair.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           new Principal().setVisible(true);
           dispose();
       }});
   novo.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           new cadastro().setVisible(true);
           dispose();
       }});
   
   atualizar.addActionListener(new ActionListener(){
        private int JLabel;
       public void actionPerformed(ActionEvent e){
          JTable tabela = new JTable(modelo);
           modelo.setRowCount(0);
        try{
    
      Connection conn = DriverManager.getConnection("jdbc:mysql://10.42.1.151:3307/retorno","root","aldenora");
           
      // procedimentos para obter os dados de uma tabela
      Statement stmt = conn.createStatement();
      String query = "SELECT * FROM FA_1 ";
      ResultSet rs = stmt.executeQuery(query);
      
   while(rs.next()){ 
          String item = rs.getString("item");
        String fa = rs.getString("fa");
        String nome = rs.getString("nome");
        String data = rs.getString("data");
        String tecnicotriagem = rs.getString("tecnicotriagem");
        String hora = rs.getString("hora");
       String obs = rs.getString("Obs");  
        
      modelo.addRow(new Object[]{new String(item), fa,nome, data, tecnicotriagem, hora,obs, new String(item)});
      
            }
           
      // fim procedimento para obter os dados
      } 
      catch(SQLException ex){
           System.out.println("SQLException: " + ex.getMessage());
           System.out.println("SQLState: " + ex.getSQLState());
           System.out.println("VendorError: " + ex.getErrorCode());
      }
    
           
       }});
                        
              

    // Cria um botão contendo uma imagem
    
              }
  public static void main(String args[]){
    Estudos app = new Estudos();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  

}     
            


    
    
    
