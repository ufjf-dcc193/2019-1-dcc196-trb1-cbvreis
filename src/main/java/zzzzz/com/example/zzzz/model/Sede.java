package zzzzz.com.example.zzzz.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import zzzzz.com.example.zzzz.model.Atividade;
import zzzzz.com.example.zzzz.model.Membro;



@Entity
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome_fantasia;
    private String estado_federacao;
    private String cidade;
    private String bairro;
    private String telefone;
    private String web;
    private String horas_totais;
    
    @OneToMany(mappedBy = "sedeMembro", cascade = CascadeType.ALL)
    private Set<Membro> membros;
    @OneToMany(mappedBy = "sedeAtividade", cascade = CascadeType.ALL)
    private Set<Atividade> atividades;

   
    public Sede() {
    };

    public Sede(String nome_fantasia, String estado_federacao, String cidade, String bairro, String telefone,
            String web) {
        this.nome_fantasia = nome_fantasia;
        this.estado_federacao = estado_federacao;
        this.cidade = cidade;
        this.bairro = bairro;
        this.telefone = telefone;
        this.web = web;
    }

    /**
     * @param nome the nome to set
     */

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    /**
     * @return the nome_fantasia
     */
    public String getNome_fantasia() {
        return nome_fantasia;
    }

    /**
     * @param nome_fantasia the nome_fantasia to set
     */
    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    /**
     * @return the estado_federacao
     */
    public String getEstado_federacao() {
        return estado_federacao;
    }

    /**
     * @param estado_federacao the estado_federacao to set
     */
    public void setEstado_federacao(String estado_federacao) {
        this.estado_federacao = estado_federacao;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the web
     */
    public String getWeb() {
        return web;
    }

    /**
     * @param web the web to set
     */
    public void setWeb(String web) {
        this.web = web;
    }

    /**
     * @return the horas_totais
     */
    public String getHoras_totais() {
        return horas_totais;
    }

    /**
     * @param horas_totais the horas_totais to set
     */
    public void setHoras_totais(String horas_totais) {
        this.horas_totais = horas_totais;
    }
}