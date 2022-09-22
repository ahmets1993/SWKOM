package org.openapitools.Service;

import org.openapitools.Model.Customer;
import org.openapitools.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository usersRepository) {
        this.customerRepository = usersRepository;
    }

    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    public void addNewUser(Customer user) {

        Optional<Customer> usersOptional=
                customerRepository.findCustomerByID(user.getUsername());
        if(usersOptional.isPresent()){
            throw new IllegalStateException("This username has been taken.");
        }else {
            customerRepository.save(user);
            System.out.println(user);
        }


    }

    public void deleteUser(Long customerID) {
        boolean exist = customerRepository.existsById(customerID);
        if(!exist){
            throw new IllegalStateException("User with id " + customerID +" does not exist.");
        }
        else{
            customerRepository.deleteById(customerID);
        }
    }
    @Transactional
    public void updateUser(Long userID, String username, String name, String surname, String email, String password) {
        Customer user = customerRepository.findById(userID).orElseThrow(() -> new IllegalStateException("User with " + userID + "does not exist"));

        if(username != null  && username.length() > 0 && !Objects.equals(user.getUsername(), username)){
            user.setUsername(username);
        }
        if(name != null  && name.length() > 0 && !Objects.equals(user.getName(), name)){
            user.setName(name);
        }
        if(surname != null  && surname.length() > 0 && !Objects.equals(user.getSurname(), surname)){
            user.setSurname(surname);
        }

        if(email != null  && email.length() > 0 && !Objects.equals(user.getEmail(), email)){
            user.setEmail(email);
        }
        if(password != null  && password.length() > 0 && !Objects.equals(user.getPassword(), password)){
            user.setPassword(password);
        }

    }
}
