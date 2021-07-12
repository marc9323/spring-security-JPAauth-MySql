package io.staticvoid.springsecurityjpa;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/") // public access
    public String home() {
        return ("<h1>WELCOME ALL</h1>");
    }

    @GetMapping("/user") // hide behind auth wall user and admin can see
    public String user() {
        return ("<h1>WELCCOME USER</h1>");
    }

    @GetMapping("/admin") // admin can see, user cannot, stranger cannot
    public String admin() {
        return ("<h1>WELCOME ADMINISTRATOR</h1>");
    }
}
