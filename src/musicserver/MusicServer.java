/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicserver;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 2180607502_NguyenTrungHieu
 */
public class MusicServer {
    static final int PORT=1234;
    private ServerSocket server=null;
    public MusicServer () {
        try{
            server=new ServerSocket(PORT);
        }catch (Exception e) {e.printStackTrace();}
    }
    public void action(){
        Socket socket=null;
        int i=0;
        System.out.println("Server listening...");
        try{
            while((socket=server.accept())!=null){
                new ServerThread(socket,"Client#"+i);
                System.out.printf("Thread for Client#%d generating...%n",i++);
            }
        }catch (Exception e) {e.printStackTrace();}
    }
    public static void main(String[]args){
        new MusicServer().action();
    }
}
