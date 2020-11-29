
package User_Backend.demo.Controllers;

import User_Backend.demo.bo.User;
import User_Backend.demo.bo.UsersEntity;
import User_Backend.demo.handler.UserHandler;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @CrossOrigin
    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody User newUser)
    {
        System.out.println("Adding user: " + newUser.getUsername());
        UserHandler.createUser(newUser.getUsername(), newUser.getPassword());
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        System.out.println("Logging in user: " + user.getUsername());
        if(UserHandler.login(user.getUsername(), user.getPassword())){
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @GetMapping("/getUser")
    public ResponseEntity<UsersEntity> getUser(@RequestParam String name){
        System.out.println("Finding user: " + name);
        return ResponseEntity.ok(UserHandler.getUser(name));
    }
}
