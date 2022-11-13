package org.senai.prj.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api/usuario")
public class UsuarioController 
{
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PostMapping("/addUsuario") // Map ONLY POST Requests
    public @ResponseBody String addUsuario (@RequestParam String nome, @RequestParam String email) 
    {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuarioRepositorio.save(usuario);
        return "O Usuário foi salvo!";
  }
     @GetMapping("/all")
    public @ResponseBody Iterable<Usuario> buscarUsuarios() 
    {
        // This returns a JSON or XML with the users
        return usuarioRepositorio.findAll();
    }
}
