package sds;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InterfaceChat extends Remote {
    
    public List<Evento> retornarEventos() throws RemoteException;
    public void incluirEvento(Evento evt) throws RemoteException;
    public int retornaQtdUsuarios() throws RemoteException;
    public List<User> retornaUsuarios() throws RemoteException;
    public void incluirUsuario(User usr) throws RemoteException;
    public void removerUsuario(User usr) throws RemoteException;
}
