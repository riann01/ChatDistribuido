package screens;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sds.User;

public class TelaEntrada extends javax.swing.JFrame implements ActionListener {

    private ImageIcon foto;
    private boolean escolheuFoto;
    
    public TelaEntrada() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        btnSair.addActionListener(this);
        btnEntrar.addActionListener(this);
        setDefaultPhoto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEntrar = new javax.swing.JButton();
        ipServidor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        quadro = new javax.swing.JLabel();
        fotoUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nickname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Entrar");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(229, 450));
        setPreferredSize(new java.awt.Dimension(229, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        btnEntrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEntrar.setText("Entrar");
        getContentPane().add(btnEntrar);
        btnEntrar.setBounds(30, 370, 80, 30);

        ipServidor.setText("localhost");
        getContentPane().add(ipServidor);
        ipServidor.setBounds(20, 330, 190, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("IP do Servidor");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 300, 150, 22);

        btnSair.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        getContentPane().add(btnSair);
        btnSair.setBounds(120, 370, 80, 30);

        quadro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quadro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quadroMouseClicked(evt);
            }
        });
        getContentPane().add(quadro);
        quadro.setBounds(10, 20, 210, 180);

        fotoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(fotoUsuario);
        fotoUsuario.setBounds(10, 20, 210, 180);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nome de Usuário");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 220, 150, 22);
        getContentPane().add(nickname);
        nickname.setBounds(20, 250, 190, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quadroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quadroMouseClicked
        JFileChooser fc;
        fc = new JFileChooser();
        File arquivo = new File(".");
        int retorno = fc.showOpenDialog(this);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            arquivo = fc.getSelectedFile();
            try {
                BufferedImage imag = ImageIO.read(arquivo);
                if (imag == null) {
                    fotoUsuario.setIcon(foto);
                } 
                else {
                    Image image = imag;                    
                    image = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(image);
                    fotoUsuario.setIcon(icon);
                    foto = icon;
                }
                escolheuFoto = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            if (retorno == JFileChooser.CANCEL_OPTION) {
                if (!escolheuFoto) {
                    fotoUsuario.setIcon(foto);
                }
                fc.setSelectedFile(arquivo);
            }
        }
    }//GEN-LAST:event_quadroMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEntrada().setVisible(true);
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSair) {
            this.dispose();
        }
        if (e.getSource() == btnEntrar) {
            boolean flag = true;
            if (nickname.getText().length() < 3) {
                JOptionPane.showMessageDialog(null, "Seu nickname deve conter no mínimo 3 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
                flag = false;
            }
            if (ipServidor.getText().equals("") || ipServidor.getText().equals(" ")) {
                JOptionPane.showMessageDialog(null, "O IP inserido não parece ser válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                flag = false;
            }
            if (flag) {
                this.dispose();
                new TelaChat(criarUser(foto, nickname.getText()), ipServidor.getText());
            }
        }
    }
    
    public User criarUser(ImageIcon foto, String nickname) {
        User usr = new User();
        usr.setFoto(foto);
        usr.setNickname(nickname);
        return usr;
    }
    
    public void setDefaultPhoto() {
        foto = new ImageIcon(this.getClass().getResource("/img/usr-icon.png"));
        Image image = foto.getImage();
        image = image.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        foto = new ImageIcon(image);
        fotoUsuario.setIcon(foto);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel fotoUsuario;
    private javax.swing.JTextField ipServidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nickname;
    private javax.swing.JLabel quadro;
    // End of variables declaration//GEN-END:variables
}
