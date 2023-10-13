/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    conectaDAO conexao = new conectaDAO();
    Connection conn = conexao.connectDB();
    PreparedStatement st;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto) {
        try{
        String sql = "insert into produtosdto (nome,valor,status) values (?,?,?)" ; 
        st = conn.prepareStatement(sql);
        st.setString (1, produto.getNome());
        st.setDouble(2,produto.getValor());
        st.setString(3, produto.getStatus());
        st.executeUpdate();
        }catch(SQLException erro){
            System.out.println("Erro tentar  salvar "+ erro);
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

