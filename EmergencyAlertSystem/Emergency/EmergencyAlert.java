package EmergencyAlertSystem.Emergency;
import java.util.ArrayList;
import EmergencyAlertSystem.NotificationS.NotificationS.NotificationService;
import EmergencyAlertSystem.Threshold.VitalSignThreshold;
import ExceptionHandling.RpmsErrorHandling;
public class EmergencyAlert {

  private final NotificationService notification;
  private  final ArrayList<VitalSignThreshold>thresholds;
  private  final String emergencyNumber;
  private  final String emergencyEmail;
  
   //constructor
  public EmergencyAlert( NotificationService notificationService,
  String emergencyEmail,String emergencyNumber) throws RpmsErrorHandling{
    if (notificationService==null||emergencyEmail==null||emergencyNumber==null)
    {throw new RpmsErrorHandling("Notification service and contact  not be null");}
    this.notification=notificationService;
    this.thresholds=new ArrayList<>();
    this.emergencyEmail=emergencyEmail;
    this.emergencyNumber=emergencyNumber;
    intializeDefaultThresohld();
  }
  //getter method
  public NotificationService getnotificationService(){return notification;}
  public String getEmergencyNumber(){return emergencyNumber;}
  public String getEmergencyEmail(){return emergencyEmail;}
  public ArrayList<VitalSignThreshold> getThreshold(){return thresholds;}

  // method for intialize Default vital sign for checking threshold
   public void intializeDefaultThresohld(){
    try{
    thresholds.add(new VitalSignThreshold(60, 100, "HeartRate"));
    thresholds.add(new VitalSignThreshold(60, 140, "BloodPressure"));
    thresholds.add(new VitalSignThreshold(95, 100, "Oxygenlevel"));
    thresholds.add(new VitalSignThreshold(35, 38.5, "Temperature"));
    }catch(RpmsErrorHandling e){
      System.err.println("Errore in setting up default vital sign;");
    }
   }
   // method for adding Default vital sign
   public void addDefaultvital(VitalSignThreshold threshold){
    thresholds.add(threshold);
   }
   //  checking vital and send alert to emergency 
   public void checkVitals(double heartRate,double bloodPressure,double oxygenlevel,double temperature)throws RpmsErrorHandling{
    try{
     for(VitalSignThreshold threshold:thresholds){
          switch (threshold.getVitalName()) {
            case "HeartRate":
                 if (threshold.isCretical(heartRate)){
                  TrigerAlert(threshold,heartRate);
                 }
              break;
            case"BloodPressure":
                   if(threshold.isCretical(bloodPressure)){
                    TrigerAlert(threshold, bloodPressure);
                   }
              break;
            case"Oxygenlevel":
                  if(threshold.isCretical(oxygenlevel)){
                    TrigerAlert(threshold, oxygenlevel);
                  }
              break;
            case"Temperature":
                if(threshold.isCretical(temperature)){
                  TrigerAlert(threshold, temperature);
                }
              break;
            default:
              System.err.println("unknown vitals signe;"+threshold.getVitalName());;
              
          }
     }
    } catch (RpmsErrorHandling e) {
      System.err.println("Error cheking vital;"+ e.getMessage());  
    }
    
   }

   public void TrigerAlert(VitalSignThreshold threshold,double currentValue)throws RpmsErrorHandling{
    // alert massage
    String alertmassege="ALERT:Critical "+ threshold.getVitalName() +" detected! Value: "
    +currentValue  +"(safe Range:"+threshold.getMin()+"-"+threshold.getMax()+")";
    // sending notification alert
    notification.sendEmailAlert(emergencyEmail, alertmassege);
    notification.sendSMSAlert(emergencyNumber, alertmassege);
   }
    
}
