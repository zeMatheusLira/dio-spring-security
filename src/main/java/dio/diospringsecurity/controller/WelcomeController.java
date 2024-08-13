package dio.diospringsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome() {
        return "Welcome to Spring Security";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGERS', 'ROLE_USERS')")
    public String users() {
        return "Authorized user";
    }

    @GetMapping("/managers")
    @PreAuthorize("hasAnyAuthority('ROLE_MANAGERS')")
    public String managers() {
        return "Authorized manager";
    }



}
