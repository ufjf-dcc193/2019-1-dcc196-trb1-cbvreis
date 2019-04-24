package zzzzz.com.example.zzzz.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import zzzzz.com.example.zzzz.model.Membro;
import zzzzz.com.example.zzzz.model.Sede;
import zzzzz.com.example.zzzz.persistence.MembroRepository;
import zzzzz.com.example.zzzz.persistence.SedeRepository;


@Controller


@RequestMapping("/membros")

public class MembroController{
   
    @Autowired
    private MembroRepository membroRepository;
    @Autowired
    private SedeRepository sedeRepository;

    @RequestMapping(value = { "" }, method = RequestMethod.GET)
    public ModelAndView carregaAllMembros() {
        List<Membro> membros = membroRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("membros", membros);
        mv.setViewName("all-membros");
        return mv;

    }
    
    @RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
    public ModelAndView carregaMembros(@PathVariable(value = "id", required = true) Long id) {
        List<Membro> membros_sede = new ArrayList<>();
        Optional<Sede> sede = sedeRepository.findById(id);

        List<Membro> membros = membroRepository.findAll();
        for (Membro membro : membros) {
            if (membro.getSede() == sede.get()) {
                membros_sede.add(membro);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("membros", membros_sede);
        mv.addObject("sede", sede.get());
        mv.setViewName("membros");
        return mv;
    }

    @RequestMapping(value = { "/criar/{id}" }, method = RequestMethod.GET)
    public ModelAndView criarAtividade(@PathVariable(value = "id", required = true) Long id) {
        Sede sede = sedeRepository.getOne(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("sede", sede);
        mv.setViewName("criar-membro");
        return mv;
    }

    @RequestMapping(value = { "/criar" }, method = RequestMethod.POST)
    public ModelAndView criarPost(Membro membro, Long sedeAtividade) {
        Sede sede = sedeRepository.getOne(sedeAtividade);
        membro.setSede(sede);
        membroRepository.save(membro);
        return new ModelAndView("redirect:/atividades/" + Long.toString(sede.getId()));

    }
    
    @RequestMapping(value = { "/deletar/{id_sede}/{id}" }, method = RequestMethod.GET)
    public ModelAndView deletaSede(@PathVariable("id_sede") Long id_sede,
         @PathVariable(value = "id", required = true) Long id) {
        Sede sede = sedeRepository.getOne(id_sede);
        membroRepository.deleteById(id);
        return new ModelAndView("redirect:/membros/" + Long.toString(sede.getId()));
    }

    
    @RequestMapping(value = { "/editar/{id_sede}/{id}" }, method = RequestMethod.GET)
    public ModelAndView editarMembro(@PathVariable("id_sede") Long id_sede,
            @PathVariable(value = "id", required = true) Long id) {
        Sede sede = sedeRepository.getOne(id_sede);
        Membro membro = membroRepository.getOne(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("membro", membro);
        mv.addObject("sede", sede);
        mv.setViewName("editar-membro");
        return mv;

    }


    @RequestMapping(value = { "/editar" }, method = RequestMethod.POST)
    public ModelAndView editarMembroPost(@RequestParam(value = "id", required = true) Long id,
            @RequestParam(value = "id_sede", required = true) Long id_sede, Membro membro) {
        Sede sede = sedeRepository.getOne(id_sede);
        membro.setSede(sede);
        membroRepository.save(membro);
        return new ModelAndView("redirect:/membros/" + Long.toString(sede.getId()));
    }

    @RequestMapping(value = { "/deletar-by-membro/{id}" }, method = RequestMethod.GET)
    public ModelAndView deletaMembroByMembros(@PathVariable(value = "id", required = true) Long id) {
        membroRepository.deleteById(id);
        return new ModelAndView("redirect:/membros");
    }
}