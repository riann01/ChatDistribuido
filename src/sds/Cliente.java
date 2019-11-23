package sds;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class Cliente {
    
    /*public InterfaceChat realizarAcao(String host) {
        try {
            Registry reg = LocateRegistry.getRegistry(host);
            InterfaceChat stub = (InterfaceChat) reg.lookup("InterfaceChat");
            return stub;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }*/
    
    public int atualizarNum(String host) {
        
        try {
             Registry reg = LocateRegistry.getRegistry(host);
            InterfaceChat stub = (InterfaceChat) reg.lookup("InterfaceChat");
             return stub.retornaQtdUsuarios();
        }
        catch (Exception e) {
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
    
}