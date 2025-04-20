package NotificationandRemainder.Email;

import ExceptionHandling.RpmsErrorHandling;
import NotificationandRemainder.Notifi.Notifiable;

public class EmailNotification implements Notifiable  {
    // implemented interface method
     @Override
     public void sendNotification(String receiver,String massege) throws RpmsErrorHandling{
        if( receiver==null||massege==null){ 
        throw new RpmsErrorHandling("Reciepent and message must  be correct");}
      System.out.println( "Email to "+receiver+": "+massege);
      
     }
      
  }
