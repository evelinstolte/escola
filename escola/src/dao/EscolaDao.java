/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Escola;
/**
 *
 * @author Administrador
 */
public class EscolaDao {
    
     public static boolean inserir(Escola objeto) {
        String sql = "INSERT INTO escola (sigla, nome, endereco, nr_de_alunos, area) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSigla());
            ps.setString(2, objeto.getNome());
            ps.setString(3, objeto.getEndereco());
            ps.setDouble(4, objeto.getArea());
            ps.setInt(5, objeto.getNr_de_alunos());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     public static void main(String[] args) {
        Escola objeto = new Escola();
        objeto.setSigla("BR");
        objeto.setNome("Brasil");
        objeto.setEndereco("Av. Castelo Branco");
        objeto.setArea(300.00);
        objeto.setNr_de_alunos(20);
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
       public static boolean alterar(Escola objeto) {
        String sql = "UPDATE escola SET nome = ?, sigla = ?, endereco = ?, area = ?, nr_de_alunos =? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome()); 
            ps.setString(2, objeto.getSigla());
            ps.setString(3, objeto.getEndereco());
            ps.setInt(4, objeto.getCodigo());
            ps.setDouble(5, objeto.getArea());
            ps.setInt(6, objeto.getNr_de_alunos());
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
       
        public static boolean excluir(Escola objeto) {
        String sql = "DELETE FROM produto WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
