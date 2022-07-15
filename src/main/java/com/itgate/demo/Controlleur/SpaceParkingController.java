package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.EmployeeRepository;
import com.itgate.demo.dao.SpaceParkingRepository;
import com.itgate.demo.models.Employee;
import com.itgate.demo.models.SpaceParking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/users/SpaceParking")
public class SpaceParkingController {

    @Autowired
    private SpaceParkingRepository  ISP;
    @Autowired
    private EmployeeRepository iemp ;



    @GetMapping("/all")
    public List<SpaceParking> getall(){
        return ISP.findAll();
    }
    @GetMapping("/getone/{Id}")
    public SpaceParking getone(@PathVariable Long Id){
        return ISP.findOne(Id);
    }

    @PostMapping("/save/{id_emp}")
    public SpaceParking save(SpaceParking sp ,@PathVariable Long id_emp ) {

     Employee e = iemp.findOne(id_emp) ;
       sp.setEmployee(e);

        return ISP.save(sp);
    }

    @PutMapping("/update/{Id}")
    public SpaceParking update(@RequestBody SpaceParking sp, @PathVariable Long Id){
        sp.setId(Id);
        return ISP.saveAndFlush(sp);
    }
    @DeleteMapping("/delete/{Id}")
    public HashMap<String,String> deletespecialiste(@PathVariable Long Id) {
        HashMap message=new HashMap();
        try{
            ISP.delete(Id);
            message.put("etat","product deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","product not deleted");
            return message;
        }
    }




}
