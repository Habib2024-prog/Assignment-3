package EmergencyAlertSystem.Threshold;

import ExceptionHandling.RpmsErrorHandling;

public class VitalSignThreshold {
    // vital with threshold unit
    private double Minimum;
    private double Maximum;
    private String  VitalName;
    //condtructor
    public VitalSignThreshold(double min,double max,String VitalName)throws RpmsErrorHandling{
        if(min>max)throw new RpmsErrorHandling("Minimum should be less than maximum");
        this.Maximum=max;
        this.Minimum =min;
        this.VitalName= VitalName;
    }
    // getter
    public double getMax(){return Maximum;}
    public double getMin(){return Minimum;}
    public String getVitalName(){return VitalName;}
    // method to check if threshold is cretical
    public boolean isCretical(double current){
            return current<Minimum||current>Maximum;
    }
}
