/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author 2180607502_NguyenTrungHieu
 */
public class ServerThread implements Runnable{
    private Socket socket;
    private PrintWriter out=null;
    private Scanner in=null;
    private String name;
    
    public ServerThread(Socket socket, String name) throws IOException{
        this.socket=socket;
        this.name=name;
        this.in=new Scanner(this.socket.getInputStream());
        this.out=new PrintWriter(this.socket.getOutputStream(), true);
        new Thread(this).start();
    }
    public static final int DANGNHAP=1;
    public static final int DOWNLOAD=2;
    public static final int NOCMD=-1;
    public static final int UPLOAD=3;
    public int lenh(String strcmd){
        if(strcmd.equals("dangnhap"))
            return DANGNHAP;
        if(strcmd.equals("upload"))
            return UPLOAD;
        if(strcmd.equals("download"))
            return DOWNLOAD;
        return NOCMD;
    }
    private void traThuMucClient(String path, PrintWriter out) {
        try{
            File dir=new File(path);
            File dsFile[];
            try{
                dsFile = dir.listFiles();
                if(dsFile==null)
                    out.println(0);
                else{
                    out.println(dsFile.length);
                    for(int i=0;i<dsFile.length;i++){
                        String filename=dsFile[i].getName();
                        out.println(filename);
                    }
                }
                out.flush();
            }catch(Exception e){JOptionPane.showMessageDialog(null,e.toString());}
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public void run(){
        Scanner sc=null;
        DBAccess acc=null;
        String filename;
        String path;
        File f;
        byte[] mybytearray;
        try{
            while(true){
                String s=in.nextLine().trim();
                sc=null;
                String cmd="";
                String data="";
                try{
                    sc=new Scanner(s);
                    sc.useDelimiter("@");
                    cmd=sc.next();
                    data=sc.next();
                }catch(Exception e){}
                switch(lenh(cmd)){
                    case DANGNHAP:
                        acc=new DBAccess();
                        ResultSet rs=acc.Query(data);
                        if(rs.next()){
                            out.println("OK");
                            path=rs.getString("path");
                            this.traThuMucClient(path,out);
                        }else
                            out.println("NOTOK");
                        break;
                    case UPLOAD:
                        int bytesRead;
                        int current=0;
                        int doDaiFile=0;
                        rs=acc.Query(data);
                        filename=sc.next();
                        doDaiFile=Integer.parseInt(sc.next());
                        rs.next();
                        path=rs.getString("path");
                        f=new File(path+"/"+filename);
                        if(!f.exists())
                            f.createNewFile();
                        mybytearray = new byte[doDaiFile];
                        InputStream is = socket.getInputStream();
                        FileOutputStream fos = new FileOutputStream(f);
                        BufferedOutputStream bos;
                        bos = new BufferedOutputStream(fos);
                        bytesRead = is.read(mybytearray,0,mybytearray.length);
                        current = bytesRead;
                        while(current!=doDaiFile){
                            bytesRead = is.read(mybytearray, current, mybytearray.length-current);
                            if(bytesRead>=0) current+=bytesRead;
                        }
                        bos.write(mybytearray, 0, current);
                        bos.flush();
                        bos.close();
                        this.traThuMucClient(path,out);
                        break;
                    case DOWNLOAD:
                        rs=acc.Query(data);
                        filename=sc.next();
                        rs.next();
                        path=rs.getString("path");
                        f=new File(path+"/"+filename);
                        out.println(f.length());//truyen do dai file
                        mybytearray = new byte[(int) f.length()];
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
                        bis.read(mybytearray, 0, mybytearray.length);
                        OutputStream os = socket.getOutputStream();
                        os.write(mybytearray, 0, mybytearray.length);
                        os.flush();
                        bis.close();
                }
            }
        }catch(Exception e){
            System.out.println(name+" has departed");
        }finally{
            try{socket.close();}catch(IOException e){}
            if(sc!=null)sc.close();
        }
    }
}
