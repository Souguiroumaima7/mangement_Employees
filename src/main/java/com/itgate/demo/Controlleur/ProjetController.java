package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ProjetRepository;
import com.itgate.demo.models.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/users/Projet")
public class ProjetController {

    @Autowired
    private ProjetRepository IPr;

    @GetMapping("/all")
    public List<Projet> getall(){
        return IPr.findAll();
    }
    @GetMapping("/getone/{Id}")
    public Projet getone(@PathVariable Long Id){
        return IPr.findOne(Id);
    }

    @PostMapping("/save")
    public Projet save(Projet p) {

        return IPr.save(p);
    }
    @PutMapping("/update/{Id}")
    public Projet update(@RequestBody Projet p , @PathVariable Long Id){
        p.setId(Id);
        return IPr.saveAndFlush(p);
    }
    @DeleteMapping("/delete/{Id}")
    public HashMap<String,String> deletespecialiste(@PathVariable Long Id) {
        HashMap message=new HashMap();
        try{
            IPr.delete(Id);
            message.put("etat","product deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","product not deleted");
            return message;
        }
    }

}
