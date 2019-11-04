package sds;

public class Servidor implements InterfaceChat {
    
    private int qtdUsuarios = 0;
    
    public void alteraNumUsr(int op) {
        if (op == 0) {
            ++qtdUsuarios;
        }
        else {
            --qtdUsuarios;
        }
    }
    
    @Override
    public int retornaQtdUsuarios() {
        return this.qtdUsuarios;
    }
    
    @Override
    public void escutar () {
        
    }
    
    @Override
    public void enviarMensagemParaUsuarios() {
        
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
}
