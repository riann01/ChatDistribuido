package screens;
import sds.User;

public class BroadcastMensagem extends javax.swing.JPanel {

    public BroadcastMensagem(String msg) {
        initComponents();
        labelBroadcast.setText(processarBroadcast(msg));
        this.setVisible(true);
    }
    
    public String processarBroadcast(String msg) {
        return msg;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelBroadcast = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        labelBroadcast.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelBroadcast.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBroadcast.setText("O usuário user acabou de entrar na sala, divirtam-se!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBroadcast, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelBroadcast, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelBroadcast;
    // End of variables declaration//GEN-END:variables
}
