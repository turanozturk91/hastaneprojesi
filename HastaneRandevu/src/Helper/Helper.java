package Helper;

import javax.swing.JOptionPane;
import Model.*;

public class Helper {
   
    static private Calisan calisan;
    
    public static void  showMessage(String message){
    
        String rMessage;
        
        switch(message){
        
            case "fill":
                rMessage = "Lütfen tüm alanları doldurun!";
                break;
            default:
                rMessage = message;
                   
        }
        
        JOptionPane.showMessageDialog(null, rMessage, "Mesaj", JOptionPane.INFORMATION_MESSAGE );
        
    }

    public Calisan getCalisan() {
        return calisan;
    }

    public void setCalisan(Calisan calisan) {
        this.calisan = calisan;
    }
    
    
    
}
