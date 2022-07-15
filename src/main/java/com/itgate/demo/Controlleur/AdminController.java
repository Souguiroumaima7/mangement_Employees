package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.AdminRepository;
import com.itgate.demo.dao.IAuthority;
import com.itgate.demo.models.Admin;
import com.itgate.demo.models.Authority;
import com.itgate.demo.models.UserTokenState;
import com.itgate.demo.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "users/Admin")
public class AdminController {
    @Autowired
    private AdminRepository iad;
    @Autowired
    private IAuthority iAuthority;
    @Autowired
    private StorageService storage;

    @GetMapping("/all")
    public List<Admin> getall() {
        return iad.findAll();
    }

    @GetMapping("/getone/{Id}")
    public Admin getone(@PathVariable Long Id) {
        return iad.findOne(Id);
    }


    @PutMapping("/update/{Id}")
    public Admin update(@RequestBody Admin a, @PathVariable Long Id) {
        a.setId(Id);
        return iad.saveAndFlush(a);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap message = new HashMap();
        try {
            iad.delete(Id);
            message.put("etat", "admin deleted");
            return message;
        } catch (Exception e) {
            message.put("etat", "admin not deleted");
            return message;
        }
    }

    @RequestMapping("/register")
    public ResponseEntity<?> register(Admin user, @RequestParam("file") MultipartFile file) {
        Authority authority = new Authority();
        authority.setName("ADMIN");
        iAuthority.save(authority);

        user.setEnabled(true);
        user.setAuthorities(authority);
        user.setPassword(hash(user.getPassword()));
        storage.store(file);
        user.setImage(file.getOriginalFilename());

        iad.save(user);

        return ResponseEntity.ok(new UserTokenState(null, 0, user));

    }

    String hash(String password) {


        String hashedPassword = null;
        int i = 0;
        while (i < 5) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            hashedPassword = passwordEncoder.encode(password);
            i++;
        }

        return hashedPassword;
    }
}

