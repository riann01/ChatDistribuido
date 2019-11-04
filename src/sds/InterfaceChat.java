package sds;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceChat extends Remote {
    
    public void enviarMensagemParaUsuarios() throws RemoteException;
    public void escutar() throws RemoteException;
    public void enviarDadosUsuario() throws RemoteException;
    public String broadcastUsuarioES(User usr,int es) throws RemoteException;
    public int retornaQtdUsuarios() throws RemoteException;
}
