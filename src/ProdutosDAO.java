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
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    
    public ProdutosDAO(){
        conn = new conectaDAO().connectDB();
    }
    
    public void cadastrarProduto (ProdutosDTO produto){
        String sql = "INSERT INTO produto (nome, valor, status) VALUES (?,?,?)";
        try{
            PreparedStatement st = this.conn.prepareStatement(sql);
            st.setString(1, produto.getNome());
            st.setString(2, produto.getValor().toString());
            st.setString(3, produto.getStatus());
            st.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,
                "Erro ao inserir! Por favor verifique os valores informados!",
                "Mensagem de Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        String sql = "SELECT * FROM produto"; 

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();            
            
            ArrayList<ProdutosDTO> listagem = new ArrayList<>();
            
            while(rs.next()){
                
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                listagem.add(produto);
            }
            return listagem;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Erro! Não foi encontrado nenhum produto!",
                "Mensagem de Erro",
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
    
        
}

