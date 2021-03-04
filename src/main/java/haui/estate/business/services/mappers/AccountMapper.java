package haui.estate.business.services.mappers;

import haui.estate.business.models.entities.Customer;
import haui.estate.business.models.requests.SignupRq;
import haui.estate.business.models.responses.AccountRp;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Customer mapToCustomer(SignupRq signupRq){
        Customer customer = new Customer();
        customer.setCustomerName(signupRq.getUserName());
        customer.setAddress(signupRq.getAddress());
        customer.setEmail(signupRq.getEmail());
        customer.setPhone(signupRq.getPhone());
        customer.setFullName(signupRq.getFullName());
        customer.setPassword(signupRq.getPassword());
        return customer;
    }

    public AccountRp mapToAccountRp(Customer customer){
        AccountRp accountRp = new AccountRp();
        accountRp.setAccountName(customer.getCustomerName());
        accountRp.setPassword(customer.getPassword());
        accountRp.setId(customer.getId());
        return accountRp;
    }
}
