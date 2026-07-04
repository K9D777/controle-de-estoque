package br.com.example.controller;

import br.com.example.dao.UsuarioDAO;
import br.com.example.model.Usuario;

public class UsuarioController {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean cadastrarUsuario(String login, String senha) {
        if (login.isEmpty() || senha.isEmpty()) return false;
        Usuario u = new Usuario();
        u.setLogin(login);
        u.setSenha(senha);
        return usuarioDAO.cadastrar(u);
    }

    public Usuario autenticar(String login, String senha) {
        if (login.isEmpty() || senha.isEmpty()) return null;
        return usuarioDAO.login(login, senha);
    }
}