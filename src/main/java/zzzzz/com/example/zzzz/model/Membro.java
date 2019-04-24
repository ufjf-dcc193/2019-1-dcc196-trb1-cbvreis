package zzzzz.com.example.zzzz.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String funcao;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataDeEntrada;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataDeSaida;
    @ManyToOne
    @JoinColumn
    private Sede sedeMembro;

    public Membro() {

    }

    public Membro(String nome, String funcao, String email, Date dataDeEntrada, Date dataDeSaida)
    {
        this.nome = nome;
        this.funcao = funcao;
        this.email = email;
        this.dataDeEntrada = dataDeEntrada;
        this.dataDeSaida = dataDeSaida;
    }

    /**
     * @param dataDeEntrada the dataDeEntrada to set
     */
    public void setDataDeEntrada(Date dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    /**
     * @param dataDeSaida the dataDeSaida to set
     */
    public void setDataDeSaida(Date dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param nome the nome to set
     */
    public void setnome(String nome) {
        this.nome = nome;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(Sede sede) {
        this.sedeMembro = sede;
    }

    /**
     * @return the dataDeEntrada
     */
    public Date getDataDeEntrada() {
        return dataDeEntrada;
    }

    /**
     * @return the dataDeSaida
     */
    public Date getDataDeSaida() {
        return dataDeSaida;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getnome() {
        return nome;
    }

    /**
     * @return the sede
     */
    public Sede getSede() {
        return sedeMembro;
    }
    
}