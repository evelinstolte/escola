/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.EscolaDao;
import javax.swing.JOptionPane;
import modelo.Escola;
import tela.manutencao.ManutencaoEscola;

/**
 *
 * @author Administrador
 */
public class ControladorEscola {

    public static void inserir(ManutencaoEscola man){
        Escola objeto = new Escola();
        objeto.setSigla(man.jtfSigla.getText());
        objeto.setNome(man.jtfNome.getText());
        objeto.setEndereco(man.jtfEndereco.getText());
        objeto.setArea(Double.parseDouble(man.jtfArea.getText()));
        objeto.setNr_de_alunos(Integer.parseInt(man.jtfNr_de_alunos.getText()));

        
        
        boolean resultado = EscolaDao.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
    
    public static void alterar(ManutencaoEscola man){
        Escola objeto = new Escola();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome(man.jtfNome.getText());
        objeto.setSigla(man.jtfSigla.getText());
        objeto.setEndereco(man.jtfEndereco.getText());
        objeto.setArea(Double.parseDouble(man.jtfArea.getText()));
        objeto.setNr_de_alunos(Integer.parseInt(man.jtfNr_de_alunos.getText()));
        
        boolean resultado = EscolaDao.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
     public static void excluir(ManutencaoEscola man){
        Escola objeto = new Escola();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = EscolaDao.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
   
}
