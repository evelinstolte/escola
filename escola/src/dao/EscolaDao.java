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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
        public static List<Escola> consultar() {
        List<Escola> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT nome,sigla,endereco,codigo,area, nr_de_alunos FROM escola";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Escola objeto = new Escola();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setNome(rs.getString("nome"));
                objeto.setSigla(rs.getString("sigla"));
                objeto.setEndereco(rs.getString("endereco"));
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setArea(rs.getDouble("area"));
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNr_de_alunos(rs.getInt("numero_de_alunos"));
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
}
