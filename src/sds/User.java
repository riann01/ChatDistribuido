package sds;

import java.io.Serializable;
import java.util.Comparator;
import javax.swing.ImageIcon;

public class User implements Comparator<User>, Serializable {
    
    private ImageIcon foto;
    private String nickname;
    
    @Override
    public int compare(User user1, User user2) {
        if (user1.getNickname().equals(user2.getNickname())) {
            if (user1.getFoto().equals(user2.getFoto())) {
                return 1;
            }
        }
        return -1;
    }
    
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
