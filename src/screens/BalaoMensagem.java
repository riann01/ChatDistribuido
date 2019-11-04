package screens;

import java.awt.Image;
import javax.swing.ImageIcon;

public class BalaoMensagem extends javax.swing.JPanel {

    public BalaoMensagem(ImageIcon foto, String nickname, String msg) {
        initComponents();
        desenharComponente(foto, nickname);
        labelMsg.setText(solicitarHTML(msg));
        this.setVisible(true);
    }

    public String solicitarHTML(String mensagem) {
        String msgComHTML = "";
        if (mensagem.length() > 40) {
            for (int i = 0; i < mensagem.length(); i+=40) {
                if (i >= mensagem.length()) {
                    break;
                }
                else {
                    if (i + 40 >= mensagem.length()) {
                        break;
                    }
                    else {
                        msgComHTML = mensagem.substring(i, i+40);
                    } 
                }
            }
        }
        else {
            msgComHTML = mensagem;
        }
        return (
            "<html>"
            + "<body>"
            + "<style>"
            + "p {text-align: justify;}"
            + "</style>"
            + "<p text-align: justify>" + msgComHTML + "</p>"
            + "</body>"
            + "</html>"
        );
    }
    
    public void desenharComponente(ImageIcon foto, String nickname) {
        Image image = foto.getImage();
        image = image.getScaledInstance(98, 98, Image.SCALE_SMOOTH);
        foto = new ImageIcon(image);
        fotoUsuario.setIcon(foto);
        labelNickname.setText(nickname);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNickname = new javax.swing.JLabel();
        fotoUsuario = new javax.swing.JLabel();
        labelMsg = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(400, 135));
        setMinimumSize(new java.awt.Dimension(400, 135));

        labelNickname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNickname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNickname.setText("Usuário");

        labelMsg.setText("<html> <center>kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk</center> </html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNickname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fotoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labelMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fotoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNickname))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelMsg)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fotoUsuario;
    private javax.swing.JLabel labelMsg;
    private javax.swing.JLabel labelNickname;
    // End of variables declaration//GEN-END:variables
}
