package day13workshop.day13wrkshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import day13workshop.day13wrkshop.models.Contact;
import day13workshop.day13wrkshop.services.DatabaseService;

@Controller
@RequestMapping(path = "/contact")
public class ContactController {

    @Autowired
    private DatabaseService dbSvc;

    @PostMapping(consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postContact(@RequestBody MultiValueMap<String, String> form, Model model) {

        Contact c = new Contact();
        c.setName(form.getFirst("name"));
        c.setEmail(form.getFirst("email"));
        c.setPhone(form.getFirst("phone"));
        dbSvc.save(c);
        model.addAttribute(c);

        return "showcontact";
    }

    @GetMapping(value = "/{id}", produces = "text/html")
    public String getContact(@PathVariable("id") String id, Model model) {
        Contact c = new Contact();
        // Send the file name to database service to read the file
        // Expects the contact back from the service
        c = dbSvc.read(id);
        model.addAttribute("contact", c);

        return "showcontact";
    }
}
