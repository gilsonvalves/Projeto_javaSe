

package modelo;

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author gilson.alves
 */
public class le_data {
    
    String dia,ano,hora;
    SimpleDateFormat horaformatada = new SimpleDateFormat("HH:mm");
    
    public void lerhora(){
        Date horaAtual = new Date();
        hora = horaformatada.format(horaAtual);
    }
    
    public void data(){
        
        Date data = new Date();
        dia = ""+data.getDate();
        ano = ""+data.getYear();
        
    }  

    
}
