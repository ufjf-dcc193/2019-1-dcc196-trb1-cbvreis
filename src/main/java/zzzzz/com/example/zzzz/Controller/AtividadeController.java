package zzzzz.com.example.zzzz.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import zzzzz.com.example.zzzz.model.Sede;

import zzzzz.com.example.zzzz.persistence.SedeRepository;
import zzzzz.com.example.zzzz.model.Atividade;
import zzzzz.com.example.zzzz.persistence.AtividadeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Controller
@RequestMapping("/atividades")

public class AtividadeController {

    @Autowired
    private SedeRepository sedeRespository;

    @Autowired
    private AtividadeRepository atividadeRespository;

    @RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
    public ModelAndView carregaEditar(@PathVariable(value = "id", required = true) Long id) {
        List<Atividade> atividades_sede = new ArrayList<>();
        Optional<Sede> sede = sedeRespository.findById(id);

        List<Atividade> atividades = atividadeRespository.findAll();
        for (Atividade atividade : atividades) {
            if (atividade.getSede() == sede.get()) {
                atividades_sede.add(atividade);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("atividades", atividades_sede);
        mv.addObject("sede", sede.get());
        mv.setViewName("atividades");
        return mv;
    }

    @RequestMapping(value = { "/criar-atividade/{id}" }, method = RequestMethod.GET)
    public ModelAndView criarAtividade(@PathVariable(value = "id", required = true) Long id) {
        Sede sede = sedeRespository.getOne(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("sede", sede);
        mv.setViewName("criar-atividade");
        return mv;
    }

    @RequestMapping(value = { "/criar-atividade/criar-atividade" }, method = RequestMethod.POST)
    public ModelAndView recebeForm(Atividade atividade, Long sedeAtividade) {
        Sede sede = sedeRespository.getOne(sedeAtividade);
        atividade.setSede(sede);
        atividadeRespository.save(atividade);
        return new ModelAndView("redirect:/atividades/" + Long.toString(sede.getId()));

    }

    @RequestMapping(value = { "/deletar/{id_sede}/{id}" }, method = RequestMethod.GET)
    public ModelAndView deletaSede(@PathVariable("id_sede") Long id_sede,
            @PathVariable(value = "id", required = true) Long id) {
        Sede sede = sedeRespository.getOne(id_sede);
        atividadeRespository.deleteById(id);
        return new ModelAndView("redirect:/atividades/" + Long.toString(sede.getId()));
    }

    @RequestMapping(value = { "/editar/{id_sede}/{id}" }, method = RequestMethod.GET)
    public ModelAndView carregaFormEditar(@PathVariable("id_sede") Long id_sede,
            @PathVariable(value = "id", required = true) Long id) {
        Sede sede = sedeRespository.getOne(id_sede);
        Atividade atividade = atividadeRespository.getOne(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("atividade", atividade);
        mv.addObject("sede", sede);
        mv.setViewName("editar_atividade");
        return mv;

    }

    @RequestMapping(value = { "/editar" }, method = RequestMethod.POST)
    public ModelAndView recebeEditar(@RequestParam(value = "id", required = true) Long id,
            @RequestParam(value = "id_sede", required = true) Long id_sede, Atividade atividade) {
        Sede sede = sedeRespository.getOne(id_sede);
        atividade.setSede(sede);
        atividadeRespository.save(atividade);
        return new ModelAndView("redirect:/atividades/" + Long.toString(sede.getId()));
    }

    @RequestMapping(value = { "/relatorios" }, method = RequestMethod.GET)
    public ModelAndView relatorios() {
        Double horas = 0.0;
        HashMap< Sede, Double> horas_totais = new HashMap<Sede, Double>();
        List<Sede> sedes = sedeRespository.findAll();
        List<Atividade> atividades = atividadeRespository.findAll();
        List<Sede> nome_sedes = new ArrayList<>();
        List<String> horas_sedes = new ArrayList<>();

        for (int i=0;i<(sedes.size());i++) {
            if(sedes.get(i)==null){
                sedes.remove(i);
            }
        }
        for (int i=0;i<(atividades.size());i++) {
            if(atividades.get(i)==null){
                atividades.remove(i);
            }
        }
        for (Sede sede : sedes) {
            if(sede==null){}else{
        
            for (Atividade atividade : atividades) {
                if (atividade.getSede() == null) {
                } else if (atividade.getSede() != null && atividade.getSede() == sede) {
                    horas = horas + atividade.getHorasDeAtividade();

                }
            }
            sede.setHoras_totais(horas.toString());
            horas_totais.put(sede, horas);
            horas = 0.0;
        }
        }
        Set set = horas_totais.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext()) {
                        Map.Entry m = (Map.Entry) it.next();
                        System.out.println(m.getKey().toString() + ":" + m.getValue());
                        nome_sedes.add((Sede) m.getKey());
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("sedes", nome_sedes);
    

        mv.setViewName("/relatorios");

        return mv;
    }

}