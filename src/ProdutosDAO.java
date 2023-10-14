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
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutosDAO {

    conectaDAO conexao = new conectaDAO();
    Connection conn = conexao.connectDB();
    PreparedStatement st;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {
        try {
            String sql = "insert into produtosdto (nome,valor,status) values (?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, produto.getNome());
            st.setDouble(2, produto.getValor());
            st.setString(3, produto.getStatus());
            st.executeUpdate();
        } catch (SQLException erro) {
            System.out.println("Erro tentar  salvar " + erro);
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        try {
            String sql = " select*from produtosdto";
            st = conn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();

                produto.setId(rs.getInt("id"));
                produto.setValor(rs.getDouble("valor"));
                produto.setNome(rs.getString("nome"));
                produto.setStatus(rs.getString("status"));

                listagem.add(produto);
                
            }
        } catch (SQLException ex) {
            System.out.println("Erro em tentar listar ");
        }
        return listagem;
    }

    void venderProduto(int id) {
        
        try {
            String sql = " update produtosdto set status = ? where id = ?";
            st= conn.prepareStatement(sql);
            st.setString(1,"vendido");
            st.setInt(2, id);
            st.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"venda realizada com sucesso");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
