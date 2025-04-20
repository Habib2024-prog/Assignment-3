package NotificationandRemainder.Notifi;

import ExceptionHandling.RpmsErrorHandling;

public interface Notifiable {
    // method send Notifaction
    void sendNotification(String receiver,String massage) throws RpmsErrorHandling;
}

