/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package musicclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author 2180607502_NguyenTrungHieu
 */
public class frmHienThi extends javax.swing.JInternalFrame {
    private Socket socket=null;
    private PrintWriter out=null;
    private Scanner in=null;
    private String username="";
    private String password="";
    private String path="";
    /**
     * Creates new form frmHienThi
     */
    public frmHienThi() {
        initComponents();
    }
    public frmHienThi(Socket s, String username, String password){
        initComponents();
        this.socket=s;
        this.setTitle("Xin chào "+username);
        this.username=username;
        this.password=password;
        loadlist();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fchClient = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstClientFolder = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstUserFolder = new javax.swing.JList<>();
        btnUpload = new javax.swing.JButton();
        btnDownload = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPlayServer = new javax.swing.JButton();

        setTitle("FTP Client");

        jLabel1.setText("Thư mục bên Client");

        btnBrowse.setText("Chọn");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstClientFolder);

        jLabel2.setText("Thư mục bên Server");

        jScrollPane2.setViewportView(lstUserFolder);

        btnUpload.setText("Đăng lên");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnDownload.setText("Tải xuống");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Chưa chọn thư mục!");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Thư mục rỗng!");

        btnPlayServer.setText("Phát Nhạc");
        btnPlayServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBrowse)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDownload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPlayServer))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnBrowse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(btnPlayServer))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnUpload)
                                .addGap(18, 18, 18)
                                .addComponent(btnDownload)
                                .addGap(18, 18, 18)
                                .addComponent(btnExit))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        this.fchClient.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(this.fchClient.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            try{
                path=this.fchClient.getSelectedFile().getCanonicalPath();
                File dir=new File(path);
                File dsFile[]=dir.listFiles();
                if(dsFile==null){
                    JOptionPane.showMessageDialog(null, "Đường dẫn không đúng hoặc không phải thư mục!");
                }else{
                    String[] supportedExtensions = {".mp3", ".wav", ".ogg", ".aac", ".flac", ".m4a"};
                    DefaultListModel dm=new DefaultListModel();
                    for (File file : dsFile) {
                        String filename = file.getName();
                        for (String ext : supportedExtensions) {
                            if (filename.endsWith(ext)) {
                                dm.addElement(filename);
                                break;
                            }
                        }
                    }
                    if(dm.getSize()>0){
                        this.lstClientFolder.setModel(dm);
                        lstClientFolder.setSelectedIndex(0);
                        jLabel3.setVisible(false);
                    }else
                        jLabel3.setText("Thư mục rỗng!");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        String str="upload@"+"select * from taikhoan where username='"+username+"'@";
        String filename;
        if(!path.equals("")){
            try{
                filename=lstClientFolder.getSelectedValue().toString();
                File f=new File(path+"\\"+filename);
                str=str+filename;
                out=new PrintWriter(socket.getOutputStream(),true);
                out.println(str+"@"+(int) f.length());
                byte[] mybytearray = new byte[(int) f.length()];
                BufferedInputStream bis=new BufferedInputStream(new FileInputStream(f));
                bis.read(mybytearray, 0, mybytearray.length);
                OutputStream os = socket.getOutputStream();
                os.write(mybytearray, 0, mybytearray.length);
                os.flush();
                bis.close();
                loadlist();
            } catch (Exception e){
                try{if(socket!=null)socket.close(); } catch (Exception ex) {e.printStackTrace();}
                e.printStackTrace();
            }
        }else
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn file", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        String str="download@"+"select * from taikhoan where username='"+username+"'@";
        String filename;
        try{
            filename=lstUserFolder.getSelectedValue().toString();
            str=str+filename;
            out=new PrintWriter(socket.getOutputStream(),true);
            out.println(str);
            BufferedInputStream bi=new BufferedInputStream(socket.getInputStream());
            in=new Scanner(bi);
            int doDaiFile=in.nextInt();
            if(path.equals("")){
                this.fchClient.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if(this.fchClient.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
                path=this.fchClient.getSelectedFile().getCanonicalPath();
            }
            int bytesRead;
            int current=0;
            File f=new File(path+"\\"+filename);
            byte[] mybytearray = new byte[doDaiFile];
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream(f);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bytesRead = is.read(mybytearray,0,mybytearray.length);
            current = bytesRead;
            while(current!=doDaiFile){
                bytesRead = is.read(mybytearray, current, mybytearray.length-current);
                if(bytesRead>=0) current+=bytesRead;
            }
            bos.write(mybytearray, 0, current);
            bos.flush();
            bos.close();
            File dir=new File(path);
            File dsFile[]=dir.listFiles();
            DefaultListModel dm=new DefaultListModel();
            for(int i=0;i<dsFile.length;i++){
                String name=dsFile[i].getName();
                dm.addElement(name);
            }
            this.lstClientFolder.setModel(dm);
            lstClientFolder.setSelectedIndex(0);
        }catch (Exception e){
                try{if(socket!=null)socket.close(); } catch (Exception ex) {e.printStackTrace();}
                e.printStackTrace();
        }
    }//GEN-LAST:event_btnDownloadActionPerformed

    private void btnPlayServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayServerActionPerformed
        DefaultListModel<String> model = (DefaultListModel<String>) lstUserFolder.getModel();
        Map<String, String> files = new HashMap<>();
        for (int i = 0; i < model.getSize(); i++) {
            String filePath = model.getElementAt(i);
            File file = new File(filePath);
            files.put(file.getName(), file.getAbsolutePath());
        }
        for(String filePath : files.values()){
            System.out.println(filePath);
        }
        frmMusic musicForm = new frmMusic();
        musicForm.setMusicFiles(files);
        musicForm.setVisible(true);
        JDesktopPane desktopPane = (JDesktopPane) this.getParent();
        desktopPane.add(musicForm);
    }//GEN-LAST:event_btnPlayServerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPlayServer;
    private javax.swing.JButton btnUpload;
    private javax.swing.JFileChooser fchClient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstClientFolder;
    private javax.swing.JList<String> lstUserFolder;
    // End of variables declaration//GEN-END:variables

    public void loadlist() {
        try{
            BufferedInputStream bi=new BufferedInputStream(socket.getInputStream());
            in=new Scanner(bi);
            String[] supportedExtensions = {".mp3", ".wav", ".ogg", ".aac", ".flac", ".m4a"};
            DefaultListModel dm=new DefaultListModel();
            int n=in.nextInt();
            for(int i=0;i<=n;i++){
                String filename=in.nextLine();
                for (String ext : supportedExtensions) {
                    if (filename.endsWith(ext)) {
                        dm.addElement(filename);
                        break;
                    }
                }
            }
            if (dm.getSize() > 0) {
                this.lstUserFolder.setModel(dm);
                lstUserFolder.setSelectedIndex(0);
                jLabel4.setVisible(false);
            }else
                jLabel4.setVisible(true);
            this.validate();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Loi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
