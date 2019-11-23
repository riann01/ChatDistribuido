package sds;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class Cliente implements Serializable {
    
    
    public int atualizarNum(String host) {
        
        try {
            Registry reg = LocateRegistry.getRegistry(host);
            InterfaceChat stub = (InterfaceChat) reg.lookup("InterfaceChat");
            return stub.retornaQtdUsuarios();
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public void sairDoChat(String host, User usr) {
        
    }
    
}