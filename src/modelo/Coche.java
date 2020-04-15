package modelo;
// Generated 15-dic-2019 17:47:27 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Coche generated by hbm2java
 */
public class Coche implements java.io.Serializable {

    private String matricula;
    private Cliente cliente;
    private String marca;
    private String modelo;
    private Set reparacions = new HashSet(0);

    public Coche() {
    }

    public Coche(String matricula, Cliente cliente, String marca, String modelo) {
        this.matricula = matricula;
        this.cliente = cliente;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Coche(String matricula, Cliente cliente, String marca, String modelo, Set reparacions) {
        this.matricula = matricula;
        this.cliente = cliente;
        this.marca = marca;
        this.modelo = modelo;
        this.reparacions = reparacions;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Set getReparacions() {
        return this.reparacions;
    }

    public void setReparacions(Set reparacions) {
        this.reparacions = reparacions;
    }

    @Override
    public String toString() {
        return matricula + " - " + marca;
    }

}
