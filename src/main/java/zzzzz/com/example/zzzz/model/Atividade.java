package zzzzz.com.example.zzzz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descricao;
    private String categoria;
    private Double horasDeAtividade;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataDeInicio = null;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataDeFim = null;
    @ManyToOne
    @JoinColumn
    private Sede sedeAtividade;

    public Atividade() {

    }

    public Atividade(String titulo, String descricao, String categoria, Double horasDeAtividade, Date dataDeInicio, Date dataDeFim) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.horasDeAtividade = horasDeAtividade;
        this.dataDeInicio = dataDeInicio;
        this.dataDeFim = dataDeFim;
    }

    /**
     * @return the dataDeFim
     */
    public Date getDataDeFim() {
        return dataDeFim;
    }

    /**
     * @return the dataDeInicio
     */
    public Date getDataDeInicio() {
        return dataDeInicio;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the sede
     */
    public Sede getSede() {
        return sedeAtividade;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return the horasDeAtividade
     */
    public Double getHorasDeAtividade() {
        return horasDeAtividade;
    }

    /**
     * @return the sedeAtividade
     */
    public Sede getSedeAtividade() {
        return sedeAtividade;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param dataDeFim the dataDeFim to set
     */
    public void setDataDeFim(Date dataDeFim) {
        this.dataDeFim = dataDeFim;
    }

    /**
     * @param dataDeInicio the dataDeInicio to set
     */
    public void setDataDeInicio(Date dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(Sede sede) {
        this.sedeAtividade = sede;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param sedeAtividade the sedeAtividade to set
     */
    public void setSedeAtividade(Sede sedeAtividade) {
        this.sedeAtividade = sedeAtividade;
    }

    /**
     * @param horasDeAtividade the horasDeAtividade to set
     */
    public void setHorasDeAtividade(Double horasDeAtividade) {
        this.horasDeAtividade = horasDeAtividade;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}