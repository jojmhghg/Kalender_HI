/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientGUI;

import Server.ClientStub;
import Utilities.Anfrage;
import Utilities.BenutzerException;

import java.awt.*;
import Utilities.Teilnehmer;
import Utilities.TerminException;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author med
 */
public class EventDet extends javax.swing.JFrame {
    
    private final ClientStub stub;
    private final int sitzungsID;
    private final int index;
    String eventText;
    Hauptfenster hauptfenster;

    
    /**
     * Create new event
     * @param event
     * @param stub
     * @param sitzungsID
     * @param index
     * @param hauptfenster
     */
    public EventDet(String event, ClientStub stub, int sitzungsID, int index, Hauptfenster hauptfenster) {
        this.stub=stub;
        this.sitzungsID = sitzungsID;
        this.eventText = event;
        this.index = index;
        this.hauptfenster = hauptfenster;
        
        initComponents();
        eventLabel.setText(eventText);      
    }

    public void terminAblehnen() throws RemoteException, BenutzerException, TerminException, SQLException {
        stub.terminAblehnen(((Anfrage) stub.getMeldungen(sitzungsID).get(index)).getTermin().getID(), sitzungsID);
    }
    
    /**
     *methode zum schliessen von vorherige fenster
     */
    public void fensterClose(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        eventLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Benachrichtigung Event");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(29, 30, 66));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(46, 49, 117));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eventLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        eventLabel.setForeground(new java.awt.Color(240, 240, 240));
        jPanel3.add(eventLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 460, 160));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Nachricht");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 484, 220));

        jPanel5.setBackground(new java.awt.Color(46, 49, 117));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Annehmen");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 110, 30));

        jPanel6.setBackground(new java.awt.Color(46, 49, 117));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ablehnen");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 110, -1));

        jPanel7.setBackground(new java.awt.Color(46, 49, 117));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Löschen");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        try {
            Anfrage anfrage = (Anfrage) stub.getMeldungen(sitzungsID).get(index);
            boolean check = false;
            
            try{
                stub.getTermin(anfrage.getTermin().getID(), sitzungsID);
   
            } catch (RemoteException | BenutzerException | TerminException ex) {
                JOptionPane.showMessageDialog(null, "Termin wurde bereits abgelehnt");
                check = true;
            }
            if(!check){
               check = false;
               for(Teilnehmer teilnehmer : anfrage.getTermin().getTeilnehmerliste()){
                    if(teilnehmer.getUsername().equals(stub.getUsername(sitzungsID)) && teilnehmer.checkIstTeilnehmer()){
                        JOptionPane.showMessageDialog(null, "Termin wurde bereits angenommen");
                        check = true;
                    }
                }
                
                if(!check){
                    stub.terminAnnehmen(anfrage.getTermin().getID(), sitzungsID);
                    JOptionPane.showMessageDialog(null, "Einladung wurde Angennomen");
                } 
            }
            dispose();     
        } catch (TerminException | SQLException | RemoteException | BenutzerException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        try {
            Anfrage anfrage = (Anfrage) stub.getMeldungen(sitzungsID).get(index);
            boolean check = false;
            
            try{
                stub.getTermin(anfrage.getTermin().getID(), sitzungsID);     
            } catch (RemoteException | BenutzerException | TerminException ex) {
                JOptionPane.showMessageDialog(null, "Termin wurde bereits abgelehnt");
                check = true;
            }
            if(!check){
                check = false;
                for(Teilnehmer teilnehmer : anfrage.getTermin().getTeilnehmerliste()){
                    if(teilnehmer.getUsername().equals(stub.getUsername(sitzungsID)) && teilnehmer.checkIstTeilnehmer()){
                        JOptionPane.showMessageDialog(null, "Termin wurde bereits angenommen");
                        check = true;
                    }
                }
                
                if(!check){
                    terminAblehnen();
                    hauptfenster.displayDate();
                    JOptionPane.showMessageDialog(null, "Einladung wurde Abgelehnt");
                } 
            }
            dispose(); 
        } catch (SQLException | RemoteException | BenutzerException | TerminException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        try {
            Anfrage anfrage = (Anfrage) stub.getMeldungen(sitzungsID).get(index);
            boolean nochOffen = true;
            
            try{
                stub.getTermin(anfrage.getTermin().getID(), sitzungsID);  
                for(Teilnehmer teilnehmer : anfrage.getTermin().getTeilnehmerliste()){
                    if(teilnehmer.getUsername().equals(stub.getUsername(sitzungsID)) && teilnehmer.checkIstTeilnehmer()){
                        stub.deleteMeldung(index , sitzungsID);
                        hauptfenster.fillMeldList();
                        JOptionPane.showMessageDialog(null, "Deine Benachrichtigung Wurde gelöscht");
                        nochOffen = false;
                    }
                }   
            } catch (RemoteException | BenutzerException | TerminException ex) {
                stub.deleteMeldung(index , sitzungsID);
                hauptfenster.fillMeldList();
                JOptionPane.showMessageDialog(null, "Deine Benachrichtigung Wurde gelöscht");
                nochOffen = false;
            }
            
            if(nochOffen){
                JOptionPane.showMessageDialog(null, "Meldung kann erst gelöscht werden, nachdem der Termin angenommen oder abgelehnt wurde");
            } 
            dispose();
            
        } catch (RemoteException | BenutzerException | SQLException ex) {
            Logger.getLogger(EventDet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel7MouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            //new EventDet().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eventLabel;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}