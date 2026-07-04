package br.com.example.controller;

import java.util.List;

import br.com.example.dao.ProdutoDAO;
import br.com.example.model.Produto;
import br.com.example.model.Usuario;

public class ProdutoController {
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public boolean cadastrarProduto(String nome, int qtd, double preco, Usuario logado) {
        if (nome.isEmpty() || qtd < 0 || preco <= 0 || logado == null) return false;
        
        Produto p = new Produto();
        p.setNome(nome);
        p.setQuantidade(qtd);
        p.setPreco(preco);
        p.setUsuario(logado);
        
        return produtoDAO.salvar(p);
    }

    public List<Produto> listar() {
        return produtoDAO.listarTodos();
    }

    public boolean atualizarProduto(int id, String nome, int qtd, double preco) {
        Produto p = new Produto();
        p.setId(id);
        p.setNome(nome);
        p.setQuantidade(qtd);
        p.setPreco(preco);
        return produtoDAO.atualizar(p);
    }

    public boolean excluirProduto(int id) {
        return produtoDAO.excluir(id);
    }
}