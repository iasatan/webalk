package hu.uni.miskolc.iit.webalk.library.controller;

import hu.uni.miskolc.iit.webalk.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class LibraryController {

    @Autowired
    LibraryService service;

    @RequestMapping("getAuthors")
    @ResponseBody
    public Collection<String> getAuthors() {
        return service.getAllAuthor();
    }


}
