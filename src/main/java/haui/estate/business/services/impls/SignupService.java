package haui.estate.business.services.impls;

import haui.estate.business.models.bos.Response;
import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.models.entities.Customer;
import haui.estate.business.models.entities.Role;
import haui.estate.business.models.entities.Ward;
import haui.estate.business.models.requests.SignupRq;
import haui.estate.business.models.responses.AccountRp;
import haui.estate.business.repositories.AdminRepository;
import haui.estate.business.repositories.CustomerRepository;
import haui.estate.business.repositories.RoleRepository;
import haui.estate.business.repositories.WardRepository;
import haui.estate.business.services.ISignupService;
import haui.estate.business.services.mappers.AccountMapper;
import haui.estate.business.services.validators.AccountValidator;
import haui.estate.business.utils.Global;
import haui.estate.business.utils.StringRp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SignupService implements ISignupService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AccountValidator accountValidator;

    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public ResponseEntity<SystemResponse<Object>> signup(SignupRq signupRq) {
        ResponseEntity<SystemResponse<Object>> validate = accountValidator.validate(signupRq);
        if (!validate.getStatusCode().is2xxSuccessful()) {
            return validate;
        }
        Ward ward = wardRepository.findById(signupRq.getWardId()).orElse(null);
        if (Objects.isNull(ward)) {
            return Response.badRequest(StringRp.WARD_IS_FAKE);
        }

        boolean existAdmin = adminRepository.existsByAdminNameAndStatus(signupRq.getUserName(), Global.ACTIVE);
        if (existAdmin) {
            return Response.badRequest(StringRp.ACCOUNT_IS_EXIST);
        }
        boolean existCustomer = customerRepository.existsByCustomerNameAndStatus(signupRq.getUserName(), Global.ACTIVE);
        if (existCustomer) {
            return Response.badRequest(StringRp.ACCOUNT_IS_EXIST);
        }
        Role role = roleRepository.findByRoleName(Global.ROLE_USER);
        Customer customer = accountMapper.mapToCustomer(signupRq);
        customer.setRole(role);
        customer.setWard(ward);

        customer = customerRepository.save(customer);
        AccountRp accountRp = accountMapper.mapToAccountRp(customer);
        return Response.ok(accountRp);
    }
}
