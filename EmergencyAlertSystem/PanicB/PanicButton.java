
package EmergencyAlertSystem.PanicB;

import EmergencyAlertSystem.Emergency.EmergencyAlert;
import EmergencyAlertSystem.NotificationS.NotificationS.NotificationService;
import ExceptionHandling.RpmsErrorHandling;

public class PanicButton extends EmergencyAlert {
    
 public PanicButton(NotificationService notificationService,String emergencyemail,String emergencynumber) throws RpmsErrorHandling{
    super(notificationService, emergencyemail, emergencynumber);
 } 
 
 public boolean press() throws RpmsErrorHandling{
     
    String alert="PANIC BUTTON ACTIVATED! Immediate assistance required!";
      getnotificationService().sendEmailAlert(getEmergencyEmail(),alert);
      getnotificationService().sendSMSAlert(getEmergencyNumber(),alert );
      System.out.println("Panic Alert send at "+new java.util.Date().toString());
      return true;
}
}
