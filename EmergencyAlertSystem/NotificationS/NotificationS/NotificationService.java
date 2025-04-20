
package EmergencyAlertSystem.NotificationS.NotificationS;
import ExceptionHandling.RpmsErrorHandling;
import NotificationandRemainder.Notifi.Notifiable;


public class NotificationService {
    Notifiable EmailNotification;
    Notifiable SMSNotification;
    // constructor
    public NotificationService(Notifiable email,Notifiable sms) throws RpmsErrorHandling{
        if (email==null||sms==null){throw new RpmsErrorHandling("SMS and Email must have a value");}
        this.EmailNotification= email;
        this.SMSNotification= sms;
        
    }
    // method to send Alert via email/sms
    public void  sendSMSAlert(String number,String Alert){
        try{SMSNotification.sendNotification(number, Alert);
        }catch(RpmsErrorHandling e){
            System.err.println("Error!"+e.getMessage());
        }
    }
    public void  sendEmailAlert(String Email,String Alert){
       try{
        EmailNotification.sendNotification(Email, Alert);
       } catch(RpmsErrorHandling e){
        System.err.println("Error!"+e.getMessage());
       }
    }

    
    

}
