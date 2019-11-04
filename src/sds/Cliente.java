package sds;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class Cliente {
    
    public InterfaceChat realizarAcao(String host) {
        try {
            Registry reg = LocateRegistry.getRegistry(host);
            InterfaceChat stub = (InterfaceChat) reg.lookup("InterfaceChat");
            return stub;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
}