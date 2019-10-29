package sds;

import javax.swing.ImageIcon;

public class User {
    private ImageIcon foto;
    private String nickname;
    
    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }
    
    public ImageIcon getFoto() {
        return this.foto;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public String getNickname() {
        return this.nickname;
    }
}
