package chatAndVideoConsultation.ClientSide;

import ExceptionHandling.RpmsErrorHandling;
import chatAndVideoConsultation.ChatServerPack.ChatServer;


public class ChatClient {
    private final String userRole;
    private final ChatServer server;
    public ChatClient(ChatServer server,String userRole){
        this.server=server;
        this.userRole=userRole;
    }

    public void sendMassege(String Massage)throws RpmsErrorHandling {
        if (Massage==null||Massage.trim().isEmpty()) {
            throw new RpmsErrorHandling ("Massege can't be empity");
        }
        server.routMassage(userRole, Massage);
    }
    public void displayChat(){
        System.out.println("\n---Chat History---");
        for (String chat:server.getSessionTranscripted()){
            System.out.println(chat);
        }
    }
        
    }


    

