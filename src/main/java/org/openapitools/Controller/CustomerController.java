package org.openapitools.Controller;


import org.openapitools.Model.Customer;
import org.openapitools.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Customer")
public class CustomerController {

    private final CustomerService userService;

    @Autowired
    public CustomerController(CustomerService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Customer> getCustomer(){
    return userService.getCustomer();
    }

    //
    @PostMapping(name = "Create")
    public void registerUser(@RequestBody Customer customer){
        userService.addNewUser(customer);
    }

    @DeleteMapping(path = "{customerID}")
    public  void deleteUser(@PathVariable("customerID") Long customerId){
        userService.deleteUser(customerId);
    }

    @PutMapping(path = "{customerID}")
    public void updateUser(
            @PathVariable("customerID") Long customerID,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password){
        userService.updateUser(customerID, username, name, surname,email, password);
    }
}
