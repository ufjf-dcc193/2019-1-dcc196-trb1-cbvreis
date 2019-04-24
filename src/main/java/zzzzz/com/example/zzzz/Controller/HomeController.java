package zzzzz.com.example.zzzz.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
    @RequestMapping("index.html")
    public String home(){
        return "home";
    }

    @RequestMapping("criar-sede.html")
    public String criarSede(){
        return "criar_sede";
    }

    @RequestMapping("membros-sede.html")
    public String membroSedes(){
        return "membros_sede";
    }

    @RequestMapping("membros.html")
    public String membros(){
        return "membros";
    }

    @RequestMapping("atividade-sede.html")
    public String atividadeSede(){
        return "atividades_sede";
    }

    @RequestMapping("atividades.html")
    public String atividades(){
        return "membros";
    }

}