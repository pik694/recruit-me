package pik.pw.recruitme.app.model.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pik.pw.recruitme.app.model.users.domain.UserFacade;
import pik.pw.recruitme.app.model.users.dto.UserDTO;

import java.util.List;

@RestController
public class UserController {

    private UserFacade userFacade;

    String hello = "Hello World";

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }


    @GetMapping("/users")
    List<UserDTO> getRecruiters() {
        return userFacade.findAll();
    }

    @GetMapping("/users/{id}")
    UserDTO getRecruiter(@PathVariable int id) {
        return userFacade.show(id);
    }


    @DeleteMapping("/users/{id}")
    ResponseEntity<?> deleteUser(@PathVariable int id){

        userFacade.delete(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
    UserDTO updateUser(@PathVariable("id") int id, @RequestBody UserDTO userDTO){

      return userFacade.add(userDTO);

    }




}
