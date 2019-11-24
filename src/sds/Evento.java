package sds;

import java.io.Serializable;
import java.util.Comparator;

public class Evento implements Comparator<Evento>, Serializable {

    private String tipoEvento;
    private String conteudoEvento;
    private User usr;
    
    @Override
    public int compare(Evento ev1, Evento ev2) {
        if(ev1.getTipoEvento().equals(ev2.getTipoEvento())) {
            if (ev1.getConteudoEvento().equals(ev2.getConteudoEvento())) {
                if (ev1.getUsr().equals(ev2.getUsr())) {
                    return 1;
                }
            }
        }
        return -1;
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
    
}
