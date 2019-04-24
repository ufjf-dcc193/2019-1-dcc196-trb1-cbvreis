package zzzzz.com.example.zzzz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zzzzz.com.example.zzzz.model.Sede;
import zzzzz.com.example.zzzz.persistence.SedeRepository;

@Controller
@RequestMapping("/sedes")

public class SedeController {

    @Autowired
    private SedeRepository sedeRespository;


    @RequestMapping(value = { "/", "", "/sedes" })
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        List<Sede> sedes = sedeRespository.findAll();
        mv.addObject("sedes", sedes);
        mv.setViewName("sedes");
        return mv;
    }

    @RequestMapping(value = { "/criar-sede" }, method = RequestMethod.GET)
    public ModelAndView criarSedeForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("criar_sede");
        return mv;
    }

    @RequestMapping(value = { "/criar-sede" }, method = RequestMethod.POST)
    public ModelAndView recebeForm(Sede sede) {
        sedeRespository.save(sede);
        ModelAndView mv = new ModelAndView();
        List<Sede> sedes = sedeRespository.findAll();
        mv.addObject("sedes", sedes);
        mv.setViewName("sedes");
        return mv;
    }

    @RequestMapping(value = { "/deletar/{id}" }, method = RequestMethod.GET)
    public ModelAndView deletaSede(@PathVariable(value = "id", required = true) Long id) {
        sedeRespository.deleteById(id);
        return new ModelAndView("redirect:/sedes/");
    }

    @RequestMapping(value = { "/editar/{id}" }, method = RequestMethod.GET)
    public ModelAndView carregaFormEditar(@PathVariable(value = "id", required = true) Long id) {
        Sede sede = sedeRespository.getOne(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("sede", sede);
        mv.setViewName("editar_sede");
        return mv;

    }

    @RequestMapping(value = { "/editar" }, method = RequestMethod.POST)
    public ModelAndView recebeEditar(@RequestParam(value = "id", required = true) Long id, Sede sede) {
        sede.setId(id);
        sedeRespository.save(sede);
        return new ModelAndView("redirect:/sedes/");
    }


}