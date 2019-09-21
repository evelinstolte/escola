/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Administrador
 */
public class Escola {
    
    private Integer codigo;
    private String sigla;
    private String nome;
    private String endereco;
    private Double area;
    private Integer nr_de_alunos;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getNr_de_alunos() {
        return nr_de_alunos;
    }

    public void setNr_de_alunos(Integer nr_de_alunos) {
        this.nr_de_alunos = nr_de_alunos;
    }

    @Override
    public String toString() {
        return  nome;
    }

 
  
}
