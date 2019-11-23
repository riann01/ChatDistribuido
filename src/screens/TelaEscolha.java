package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sds.Servidor;

public class TelaEscolha extends javax.swing.JFrame implements ActionListener {

    public TelaEscolha() {
        initComponents();
        radioGroup.add(radioCliente);
        radioGroup.add(radioServidor);
        radioGroup.add(radioAmbos);
        btnConfirma.addActionListener(this);
        btnCancelar.addActionListener(this);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroup = new javax.swing.ButtonGroup();
        radioCliente = new javax.swing.JRadioButton();
        radioServidor = new javax.swing.JRadioButton();
        radioAmbos = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btnConfirma = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        radioCliente.setText("Iniciar Cliente");

        radioServidor.setText("Iniciar Servidor");

        radioAmbos.setText("Iniciar Ambos");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Escolha uma opção");

        btnConfirma.setText("Confirmar");

        btnCancelar.setText("Cancelar");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Iniciar Chat Distribuído");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioAmbos)
                            .addComponent(radioServidor)
                            .addComponent(radioCliente)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnConfirma)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(radioCliente)
                .addGap(18, 18, 18)
                .addComponent(radioServidor)
                .addGap(18, 18, 18)
                .addComponent(radioAmbos)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirma)
                    .addComponent(btnCancelar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private Runnable IniciarServidor = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println("Iniciei Servidor");
                new Servidor();
            } catch (Exception e){}
       }
    };
    
    private Runnable IniciarCliente = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println("Iniciei Cliente");
                new TelaEntrada();
            }
            catch (Exception e) {}
        }
    };
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirma) {
            if (radioCliente.isEnabled()) {
                this.dispose();
                new Thread(IniciarCliente).start();
            }
            if (radioServidor.isEnabled()) {
                this.dispose();
                new Thread(IniciarServidor).start();
            }
            if (radioAmbos.isEnabled()) {
                this.dispose();
                new Thread(IniciarCliente).start();
                new Thread(IniciarServidor).start();
            }
        }
        if (e.getSource() == btnCancelar) {
            System.exit(0);
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEscolha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEscolha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEscolha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEscolha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEscolha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton radioAmbos;
    private javax.swing.JRadioButton radioCliente;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JRadioButton radioServidor;
    // End of variables declaration//GEN-END:variables
}
