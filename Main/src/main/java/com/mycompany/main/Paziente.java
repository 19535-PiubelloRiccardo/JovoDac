/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 19535
 */
public class Paziente {
    private long                        id;
    private String                      nome;
    private String                      cognome;
    private String                      codice_fiscale;
    private int                         domicilio;
    private long                        id_medico;
    private static Map<Long, Paziente>  map_pazienti = new HashMap<>();

    public Paziente(long id, String nome, String cognome, String codice_fiscale, int domicilio) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice_fiscale;
        this.domicilio = domicilio;
        this.map_pazienti.put(this.id, this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    public void setCodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }

    public int getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(int domicilio) {
        this.domicilio = domicilio;
    }
    
    public static Paziente getPazienteById(long id){
        return map_pazienti.get(id);
    }
    
    public void setMedicoById(long id_medico){
        this.id_medico = id_medico;
    }
    
    public long getMedicoById(){
        return id_medico;
    }
    
    public String toStringTrump() {
        return "Paziente{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codice_fiscale=" + codice_fiscale + ", domicilio=" + domicilio + ", id_medico=\n" + Medico.getMedicoById(id_medico) + '}';
    }

    @Override
    public String toString() {
        return "Paziente{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codice_fiscale=" + codice_fiscale + ", domicilio=" + domicilio + '}';
    }
}
