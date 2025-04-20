package chatAndVideoConsultation.VideoConsultation;
import java.util.UUID;

import ExceptionHandling.RpmsErrorHandling;

public class VideoCall {
    private String platform;
    private String currentMetinglink;
    public VideoCall(String platform)throws RpmsErrorHandling{
        if(!platform.equalsIgnoreCase("GoogleMeet")&&!platform.equalsIgnoreCase("Zoom")){
            throw new RpmsErrorHandling ("Unsupported platform!");
        }
        this.platform=platform;
        
    }
    public String startConsultation() throws RpmsErrorHandling{
        if(currentMetinglink!=null){
            endConsultation();
        }
        String Id=UUID.randomUUID().toString().substring(0, 8);
        currentMetinglink=generatePlatformlink(Id);
          System.out.println(platform+" Consultation starte with this Link:"+currentMetinglink);
          return platform+" Consultation starte with this Link:"+currentMetinglink;
        
    }

    

    private String generatePlatformlink(String meetingId){
        return platform.equalsIgnoreCase("GoogleMeet")?"http://meet.google.com/"+meetingId:"http://zoom.us/j/"+meetingId;
    }
    public void endConsultation() throws RpmsErrorHandling{
        if(currentMetinglink==null)throw new RpmsErrorHandling("no Active cosultation");
        System.out.println("Ended"+platform+"Meeting "+currentMetinglink);
        currentMetinglink=null;
    }


 
}
