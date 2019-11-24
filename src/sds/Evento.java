package sds;

import java.io.Serializable;
import java.util.Objects;

public class Evento implements Serializable {

    private String tipoEvento;
    private String conteudoEvento;
    private User usr;
    private int base;

    @Override
    public int hashCode() {
        int hash = this.getBase();
        hash = 79 * hash + Objects.hashCode(this.tipoEvento);
        hash = 79 * hash + Objects.hashCode(this.conteudoEvento);
        hash = 79 * hash + Objects.hashCode(this.usr);
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
        final Evento other = (Evento) obj;
        if (!this.tipoEvento.equals(other.tipoEvento)) {
            return false;
        }
        if (!this.conteudoEvento.equals(other.conteudoEvento)) {
            return false;
        }
        if (!this.usr.equals(other.usr)) {
            return false;
        }        
        if (this.base != other.base) {
            return false;
        }
        
        return true;
    }
    
    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getConteudoEvento() {
        return conteudoEvento;
    }

    public void setConteudoEvento(String conteudoEvento) {
        this.conteudoEvento = conteudoEvento;
    }

    public User getUsr() {
        return usr;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }
    
    public int getBase() {
        return this.base;
    }
    
    public void setBase(int base) {
        this.base = base;
    }
    
}
