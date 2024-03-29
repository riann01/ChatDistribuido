package screens;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import sds.User;
import sds.Cliente;
import sds.Evento;

public class TelaChat extends javax.swing.JFrame implements ActionListener, Runnable {

    private ImageIcon fotoUsuarioI;
    private String host;
    private User usr;
    private Cliente cliente = new Cliente();
    private List<Evento> eventos = new ArrayList<Evento>();
    private List<Evento> renderizados = new ArrayList<Evento>();
    
    public TelaChat(User usr, String host) {
        super("Sala de Chat em " + host);
        initComponents();
        desenharTela(usr.getFoto(), usr.getNickname());
        fotoUsuarioI = usr.getFoto();
        this.host = host;
        this.usr = usr;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        btnEnviar.addActionListener(this);
        btnSair.addActionListener(this);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(50);
        entrarNoChat(host,usr);
        atualizarNum(host);
        enviarBdc("Entrar");
        new Thread(this).start();
        txtAreaMsg.setText("");
    }
    
        
    public void desenharTela(ImageIcon foto, String nickname) {
        Image image = foto.getImage();
        image = image.getScaledInstance(102, 102, Image.SCALE_SMOOTH);
        foto = new ImageIcon(image);
        fotoUsuario.setIcon(foto);
        labelNickname.setText(nickname);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEnviar) {
            if (!txtAreaMsg.getText().equals("")) {
                enviarMensagem(txtAreaMsg.getText());
                painelMsgs.updateUI();
                txtAreaMsg.setText("");
                txtAreaMsg.requestFocus();
            }
        }
        if (e.getSource() == btnSair) {
            sairDoChat(host, this.usr);
            atualizarNum(host);
            enviarBdc("Sair");
            this.dispose();
        }
    }
    
    public void inserirComponente(Component comp) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        painelMsgs.add(retornaMargem(), gbc);
        painelMsgs.add(comp, gbc);
        painelMsgs.repaint();
        painelMsgs.updateUI();
    }
    
    public void enviarMensagem(String msg) {
        Evento evtMsg = new Evento();
        evtMsg.setConteudoEvento(msg);
        evtMsg.setTipoEvento("MSG");
        evtMsg.setUsr(usr);
        int base;
        Random ran = new Random();
        base = ran.nextInt((99 - 1) + 1);
        base = base * 7 * Calendar.MILLISECOND;
        evtMsg.setBase(base);
        cliente.incluirEvento(host, evtMsg);
    }
    
    public void enviarBdc(String tipoBdc) {
        Evento evtBdc = new Evento();
        if (tipoBdc.equalsIgnoreCase("Entrar")) {
            evtBdc.setConteudoEvento("O usuário " + usr.getNickname() + " entrou no chat, divirtam-se!");
        }
        else {
            if (tipoBdc.equalsIgnoreCase("Sair")) {
                evtBdc.setConteudoEvento("O usuário " + usr.getNickname() + " saiu do chat, volte logo!");
            }
        }
        evtBdc.setTipoEvento("BDC");
        evtBdc.setUsr(usr);
        int base;
        Random ran = new Random();
        base = ran.nextInt((99 - 1) + 1);
        base = base * 7 * Calendar.MILLISECOND;
        evtBdc.setBase(base);
        cliente.incluirEvento(host, evtBdc);
    }
    
    public void atualizarNum(String host) {
        int usrOnline = cliente.atualizarNum(host);
        numUsers.setText("Há " + usrOnline + " usuário" + (usrOnline > 1 ? "s " : " ") + "online");
    }
    
    public void entrarNoChat(String host, User usr) {
        cliente.entrarNoChat(host, usr);
    }
    
    public void sairDoChat(String host, User usr) {
       enviarBdc("Sair");
       cliente.sairDoChat(host, usr);
       System.exit(0);
    }
    
    public void desenhaEventos() {
        if (!eventos.isEmpty()) {
            for (int i = 0; i < eventos.size(); i++) {
                if (!(renderizados.contains(eventos.get(i)))) {
                    if (eventos.get(i).getTipoEvento().equals("BDC")) {
                        BroadcastMensagem bmsg = new BroadcastMensagem(eventos.get(i).getConteudoEvento());
                        inserirComponente(bmsg);
                        renderizados.add(eventos.get(i));
                        atualizarNum(host);
                    }
                    else {
                        if (eventos.get(i).getTipoEvento().equals("MSG")) {
                            BalaoMensagem bmsg = new BalaoMensagem(eventos.get(i).getUsr(), eventos.get(i).getConteudoEvento());
                            inserirComponente(bmsg);
                            renderizados.add(eventos.get(i));
                        }
                    }
                    jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getMaximum());
                }
            }
        }
        
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(TelaChat.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (renderizados.isEmpty()) {
                eventos = cliente.retornarEventos(host);
                desenhaEventos();
            }
            else {
                List <Evento> eventosServTemp = cliente.retornarEventos(host);
                if (!(eventosServTemp == null)) {
                    if (renderizados.size() != eventosServTemp.size()) {
                        eventos = eventosServTemp;
                        desenhaEventos();
                    }
                }
            }
                
        }
    }
    
    public JPanel retornaMargem() {
        JPanel margem = new JPanel();
        margem.setSize(50, 50);
        return margem;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        painelMsgs = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaMsg = new javax.swing.JTextArea();
        fotoUsuario = new javax.swing.JLabel();
        labelNickname = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        numUsers = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        painelMsgs.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(painelMsgs);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtAreaMsg.setColumns(20);
        txtAreaMsg.setFont(new java.awt.Font("Nirmala UI", 0, 20)); // NOI18N
        txtAreaMsg.setLineWrap(true);
        txtAreaMsg.setRows(5);
        txtAreaMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAreaMsgKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtAreaMsg);

        fotoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        labelNickname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNickname.setText("jLabel2");

        btnEnviar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEnviar.setText("Enviar");

        btnSair.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSair.setText("Sair");

        numUsers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numUsers.setText("Há x usuário(s) online no momento.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fotoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNickname, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelNickname)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAreaMsgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaMsgKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String n = txtAreaMsg.getText();
            if (!(txtAreaMsg.getText().equals(""))) {
                enviarMensagem(txtAreaMsg.getText());
                painelMsgs.updateUI();
                txtAreaMsg.setText("");
                txtAreaMsg.requestFocus();
            }
        }
    }//GEN-LAST:event_txtAreaMsgKeyReleased

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel fotoUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelNickname;
    private javax.swing.JLabel numUsers;
    private javax.swing.JPanel painelMsgs;
    private javax.swing.JTextArea txtAreaMsg;
    // End of variables declaration//GEN-END:variables
}
