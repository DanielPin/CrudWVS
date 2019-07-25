package br.com.wvs.model;

import javax.persistence.*;

@Entity
public class SenhaAntiga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String senhaAntiga;

    @ManyToOne
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenhaAntiga() {
        return senhaAntiga;
    }

    public void setSenhaAntiga(String senhaAntiga) {
        this.senhaAntiga = senhaAntiga;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
