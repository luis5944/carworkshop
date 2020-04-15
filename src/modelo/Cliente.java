package modelo;
// Generated 15-dic-2019 17:47:27 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente implements java.io.Serializable {

    private int codcli;
    private String nomcli;
    private String direccion;
    private String email;
    private String tfno;
    private Set coches = new HashSet(0);

    public Cliente() {
    }

    public Cliente(int codcli, String nomcli, String direccion) {
        this.codcli = codcli;
        this.nomcli = nomcli;
        this.direccion = direccion;
    }

    public Cliente(int codcli, String nomcli, String direccion, String email, String tfno, Set coches) {
        this.codcli = codcli;
        this.nomcli = nomcli;
        this.direccion = direccion;
        this.email = email;
        this.tfno = tfno;
        this.coches = coches;
    }

    public int getCodcli() {
        return this.codcli;
    }

    public void setCodcli(int codcli) {
        this.codcli = codcli;
    }

    public String getNomcli() {
        return this.nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTfno() {
        return this.tfno;
    }

    public void setTfno(String tfno) {
        this.tfno = tfno;
    }

    public Set getCoches() {
        return this.coches;
    }

    public void setCoches(Set coches) {
        this.coches = coches;
    }

    @Override
    public String toString() {
        return codcli + " - " + nomcli;
    }

}