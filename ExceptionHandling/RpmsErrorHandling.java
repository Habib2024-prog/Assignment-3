package ExceptionHandling;

 public class RpmsErrorHandling extends Exception {
    String massege;
    public RpmsErrorHandling(String massege){
        super(massege);
    }
}
