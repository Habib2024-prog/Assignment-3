package NotificationandRemainder.SMS;
import ExceptionHandling.RpmsErrorHandling;
import NotificationandRemainder.Notifi.Notifiable;
public class SmsNotification implements Notifiable{
  
  // implemented interface method
  @Override
  public void sendNotification(String receiver,String massege)throws RpmsErrorHandling{
    if( receiver==null||massege==null){ 
    throw new RpmsErrorHandling("Reciepent and message must  be Correct");}

   System.out.println( "SMS to "+receiver+": "+massege);

  }
}

