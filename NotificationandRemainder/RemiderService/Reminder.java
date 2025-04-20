package NotificationandRemainder.RemiderService;


import ExceptionHandling.RpmsErrorHandling;
import NotificationandRemainder.Notifi.Notifiable;
import NotificationandRemainder.date.CustomDate;

public class Reminder {
    private Notifiable email_notifier;
    private String reminderMassage;
    private String receiver;
    private CustomDate dueDate;
    // constructor
    public Reminder(String reciever,String reminderMassage,CustomDate dueDate,Notifiable email){
        this.email_notifier=email;
        this.dueDate=dueDate;
        this.reminderMassage=reminderMassage;
        this.receiver=reciever;
    }

    public void sendReminder(){
        // creating Reminder massage with date 
        String massage=String.format("REMIDER: %s |DueDate: %s",reminderMassage,dueDate.toString());
        // Sending Reminder via email 
        try{
        email_notifier.sendNotification(receiver, massage);
        }catch(RpmsErrorHandling e){
            System.err.println(RpmsErrorHandling.class.getName()+"Reminder Faild to send !"+e.getMessage());
        }

        
    }
   
    
    
}
