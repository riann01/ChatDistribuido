package sds;

import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import screens.TelaServidor;

public class Servidor implements InterfaceChat, Serializable {

    private List<User> usuarios = new ArrayList<User>();;
    private List<Evento> eventos = new ArrayList<Evento>();
    private static TelaServidor tServ = new TelaServidor();
    
    public Servidor () {
    }
    
    public static void main(String[] args) {
        
        Servidor serv = new Servidor();
        try {
            InterfaceChat stub = (InterfaceChat) UnicastRemoteObject.exportObject(serv, 0);
            Registry reg = LocateRegistry.getRegistry();
            reg.bind("InterfaceChat", stub);
        }
        catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            tServ.getStatusLabel().setText("ERRO DO SERVIDOR");
            tServ.getStatusLabel().setForeground(new java.awt.Color(255, 255, 255));
            tServ.getStatusLabel().setText(tServ.getTxtArea().getText() + "\n" + "ERRO:\n" + e.getMessage());
        }
        tServ.getStatusLabel().setText("PRONTO");
        tServ.getStatusLabel().setForeground(new java.awt.Color(50, 205, 50));
    }
    
    @Override
    public int retornaQtdUsuarios() {
        return this.usuarios.size();
    }
    
    @Override
    public void incluirEvento(Evento evt) {
        eventos.add(evt);
        tServ.getTxtArea().setText(tServ.getTxtArea().getText() + 
        "\nEVENTO RECEBIDO:\n" + "USER:\n" + evt.getUsr() + "\nEVT_TYPE:\n"
        + evt.getTipoEvento() + "\nEVT_CONTENT:\n" + evt.getConteudoEvento());
    }
    
    @Override
    public List<Evento> retornarEventos() {
        return this.eventos;
    }
    
    @Override
    public void enviarDadosUsuario() {
        
    }
    
    @Override
    public String broadcastUsuarioES(User usr,int es) {
        if (es == 0) {
            return "O usuário " + usr.getNickname() + " entrou no chat, divirtam-se!";
        }
        else {
            if (es == 1) {
                return "O usuário " + usr.getNickname() + "saiu do chat.";
            }
            else {
                return null;
            }
        }
    }
    
    @Override
    public List<User> retornaUsuarios() {
        return usuarios;
    }
    
    @Override
    public void incluirUsuario(User usr) {
        usuarios.add(usr);
    }
    
    @Override
    public void removerUsuario(User usr) {
        usuarios.remove(usr);
    }
   
}
