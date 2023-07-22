package uni.edu.pe.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uni.edu.pe.backend.service.AppService;

@RestController
@CrossOrigin(origins = {"*"})
public class AppController {
    @Autowired
    private AppService service;

    @RequestMapping(
            value="/",
            method = RequestMethod.POST
    )

    @RequestMapping(
            value="/",
            method = RequestMethod.POST
    )

    @RequestMapping(
            value="/",
            method = RequestMethod.POST
    )



}
