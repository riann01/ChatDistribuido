package sds;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.swing.JOptionPane;

public class Servidor implements InterfaceChat {

    private List<User> usuarios;
    private List<Evento> eventos;
    
    public static void main(String[] args) {
        Servidor serv = new Servidor();
        try {
            InterfaceChat stub = (InterfaceChat) UnicastRemoteObject.exportObject(serv, 0);
            Registry reg = LocateRegistry.getRegistry();
            reg.bind("InterfaceChat", stub);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public int retornaQtdUsuarios() {
        return this.usuarios.size();
    }
    
    @Override
    public void incluirEvento(Evento evt) {
        eventos.add(evt);
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
