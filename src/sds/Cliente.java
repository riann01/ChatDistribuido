package sds;

import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Cliente implements Serializable {
    
    private String host;
    private List<Evento> eventos = new ArrayList<Evento>();
    
    public int atualizarNum(String host) {
        
        try {
            Registry reg = LocateRegistry.getRegistry(host);
            InterfaceChat stub = (InterfaceChat) reg.lookup("InterfaceChat");
            return stub.retornaQtdUsuarios();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro1: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        return -1;
    }
    
    public void entrarNoChat(String host, User usr) {
        try {
            Registry reg = LocateRegistry.getRegistry(host);
            InterfaceChat stub = (InterfaceChat) reg.lookup("InterfaceChat");
            stub.incluirUsuario(usr);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao entrar na sala de chat: " + e.getMessage() + "\n O programa será fechado.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public void sairDoChat(String host, User usr) {
        try {
            Registry reg = LocateRegistry.getRegistry(host);
            InterfaceChat stub = (InterfaceChat) reg.lookup("InterfaceChat");
            stub.removerUsuario(usr);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro2: " + e.getMessage() + "\n O programa será fechado.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public List<Evento> retornarEventos() {
        try {
            Registry reg = LocateRegistry.getRegistry(host);
            InterfaceChat stub = (InterfaceChat) reg.lookup("InterfaceChat");
            return stub.retornarEventos();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro3: " + e.getMessage() + "\n O programa será fechado.", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return null;
    }
    
    public void incluirEvento(Evento evt) {
         try {
            Registry reg = LocateRegistry.getRegistry(host);
            InterfaceChat stub = (InterfaceChat) reg.lookup("InterfaceChat");
            stub.incluirEvento(evt);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro4: " + e.getMessage() + "\n O programa será fechado.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public void setHost(String host) {
        this.host = host;
    }
    
    public List<Evento> getLocalEvents() {
        return this.eventos;
    }
    
    public Runnable verificaAtualizacaoEvento = new Runnable() {
        @Override
        public void run() {
            try {
                if (eventos.isEmpty()) {
                    eventos = retornarEventos();
                }
                else {
                    if (!(eventos.get(eventos.size()-1).equals(retornarEventos().get(retornarEventos().size()-1)))) {
                        eventos = retornarEventos();
                    }
                }
                
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro5:\n" + e.getMessage() + "\nO Chat será fechado.");
                e.printStackTrace();
                System.exit(0);
            }
        }
    };
    
}