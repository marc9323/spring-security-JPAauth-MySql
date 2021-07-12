package io.staticvoid.springsecurityjpa;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home() {
        return ("<h1>WELCOME ALL</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>WELCCOME USER</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>WELCOME ADMINISTRATOR</h1>");
    }
}
