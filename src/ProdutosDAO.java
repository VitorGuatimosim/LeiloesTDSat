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
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
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
        }catch(Exception e){
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

