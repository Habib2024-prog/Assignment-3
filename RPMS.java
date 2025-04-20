

import EmergencyAlertSystem.Emergency.EmergencyAlert;
import EmergencyAlertSystem.NotificationS.NotificationS.NotificationService;
import EmergencyAlertSystem.PanicB.PanicButton;
import ExceptionHandling.RpmsErrorHandling;
import NotificationandRemainder.Email.EmailNotification;
import NotificationandRemainder.Notifi.Notifiable;
import NotificationandRemainder.RemiderService.Reminder;
import NotificationandRemainder.SMS.SmsNotification;
import NotificationandRemainder.date.CustomDate;
import chatAndVideoConsultation.ChatServerPack.ChatServer;
import chatAndVideoConsultation.ClientSide.ChatClient;
import chatAndVideoConsultation.VideoConsultation.VideoCall;

public class RPMS {
    
    public static void main(String[] args) {
      // try catch block for handling Exception 
   try{ 
        // object Email sender and SMS sender 
        Notifiable emialNotifiable=new EmailNotification();
        Notifiable SMSNotification=new SmsNotification();
        // Email and Number of Hospital for Emergency Situation
        final String hospitalEmergencyEmail="emergencyteam112@hospital.com";
        final String hosptitalEmergencyNumber="1121-1121-22";
        // object of Notification Servive for Servicing notification 
        NotificationService notificationService=new NotificationService(emialNotifiable, SMSNotification);
        // object of Emergency alert 
        EmergencyAlert emergencyAlert=new EmergencyAlert(notificationService,
        hospitalEmergencyEmail,hosptitalEmergencyNumber);
        // Checking Vital 
        emergencyAlert.checkVitals(59, 150, 94, 39);

       // panic botton
        PanicButton panicButton=new PanicButton(notificationService,
        hospitalEmergencyEmail, hosptitalEmergencyNumber); 
        // press method of panicbatton for immediate alert
       panicButton.press();

         // sending Reminder to patient for appointment
         Reminder appointment=new Reminder("patient@gmail.com", 
         "Your appointment will Schedual on "
         , new CustomDate(2025, 4, 21, 10), emialNotifiable);
         appointment.sendReminder();

        // chat between docter and patient
      ChatServer chatserver=new ChatServer();
       ChatClient docter=new ChatClient(chatserver, "Docter");
       ChatClient patient=new ChatClient(chatserver, "Patient");
        // Start chating by handling chat server
       chatserver.startSession();
       // Sending massage by docter
       docter.sendMassege("Hello Mr.habib how is your feelling?");
       //replying by patient
       patient.sendMassege("Fine I'm feelling well today.");
       docter.sendMassege("Great! your health is back on normal situation.");
        // ending 
      chatserver.endSession();

        // viewing chat history of docter
       docter.displayChat();
        
        // video call consultation by Zoom ;
        VideoCall videoCall= new VideoCall("Zoom");
        videoCall.startConsultation();
        videoCall.endConsultation();
        //videoCall consulating by whats app but doesen't accecpt
        VideoCall videoCall2=new VideoCall("Whatsapp");
        videoCall2.startConsultation();


      
        }catch(RpmsErrorHandling e){
          System.err.println( e.getMessage());
        }
          
  }
}
      

    








