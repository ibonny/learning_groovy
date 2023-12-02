package personal.bonnycasi.webdemo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
public class MainController {
    @GetMapping("/")
    public String rootFunc() {
        return "This is a test."
    }
}
