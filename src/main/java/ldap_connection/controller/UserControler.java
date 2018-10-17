package ldap_connection.controller;

import com.fasterxml.jackson.databind.JsonNode;
import ldap_connection.domain.Person;
import ldap_connection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserControler {

    @Autowired
    private UserService defaultUserService;

    @PostMapping("/authentication")
    public ResponseEntity<String> authentication(@RequestBody JsonNode jsonNode) {
        String username = jsonNode.get("username").textValue();
        String password = jsonNode.get("password").textValue();

        if (defaultUserService.testConn(username, password)) {
            return ResponseEntity.ok().body("Authentication successful!");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username or password is incorrect!");
    }

    @GetMapping("/getPerson")
    public ResponseEntity<Person> getPerson(@RequestParam(value = "username",required = true) String username) {

        Person person = defaultUserService.getUser(username);

        if(person!=null) {
            return ResponseEntity.ok().body(person);
        }

        return ResponseEntity.badRequest().body(person);
    }



}
