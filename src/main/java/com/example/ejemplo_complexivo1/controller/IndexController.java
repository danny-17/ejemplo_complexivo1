package com.example.ejemplo_complexivo1.controller;

import com.example.ejemplo_complexivo1.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api")
public class IndexController {
    @GetMapping({ "/index", "/", "/home"})
    public String index(ModelMap model){
        model.addAttribute("titulo", "hola a todos");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();

        usuario.setNombre("Danny");
        usuario.setApellido("Tenemea");
        usuario.setEmail("dannyjavitenemea@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "HOLA A TODOS");
        return "perfil";
    }


    @RequestMapping("/listar")
    public String listar(Model model){
        model.addAttribute("titulo", "listado de usuarios");


        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuario(){
        List<Usuario> usuarios = Arrays.asList(new Usuario("Danny", "Tenemea", "dannyjavi@gmail.com"),
        new Usuario("Marlon", "Vélez", "marlonv@gmail.com"),
        new Usuario("Paola", "Criollo", "bebabCv@gmail.com"),
        new Usuario("William", "Tocto", "phytoman@gmail.com"),
        new Usuario("Jose", "Murisho", "chinoBTS@gmail.com")
        );
        return usuarios;
    }

}
