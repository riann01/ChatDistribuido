package sds;

import java.io.Serializable;
import java.util.Objects;
import javax.swing.ImageIcon;

public class User implements Serializable {
    
    private ImageIcon foto;
    private String nickname;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.foto);
        hash = 83 * hash + Objects.hashCode(this.nickname);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!this.nickname.equals(other.nickname)) {
            return false;
        }
        /*if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }*/
        return true;
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
