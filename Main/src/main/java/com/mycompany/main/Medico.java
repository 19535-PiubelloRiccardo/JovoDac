/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 19535
 */
public class Medico {
    private long                        id;
    private String                      nome;
    private String                      cognome;
    private String                      codice_fiscale;
    private String                      seconda_specializzazione;
    private List<Long>                  pazienti = new ArrayList<>();
    private static Map<Long, Medico>    map_medici = new HashMap<>();

    public Medico(long id, String nome, String cognome, String codice_fiscale, String seconda_specializzazione) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice_fiscale;
        this.seconda_specializzazione = seconda_specializzazione;
        this.map_medici.put(this.id, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getSeconda_specializzazione() {
        return seconda_specializzazione;
    }

    public void setSeconda_specializzazione(String seconda_specializzazione) {
        this.seconda_specializzazione = seconda_specializzazione;
    }
    
    public static Medico getMedicoById(long id){
        return map_medici.get(id);
    }
    
    public void add_IdPaziente(long id_paziente){
        pazienti.add(id_paziente);
    }

    public String toStringObama() {
        String Fin = "";
        for (Long i : pazienti){
            Fin += Paziente.getPazienteById(i) + "\n";
        }
        return "Medico{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codice_fiscale=" + codice_fiscale + ", seconda_specializzazione=" + seconda_specializzazione + ", pazienti=\n" + Fin + '}';
    }

    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codice_fiscale=" + codice_fiscale + ", seconda_specializzazione=" + seconda_specializzazione + '}';
    }
    
}
