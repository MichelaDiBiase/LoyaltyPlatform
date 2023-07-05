package it.unicam.cs.ids.loyaltyplatform.service;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.*;
import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.FidelityCard;
import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.Product;
import it.unicam.cs.ids.loyaltyplatform.entity.registration.RegistrationLoyaltyPlan;
import it.unicam.cs.ids.loyaltyplatform.entity.registration.RegistrationLoyaltyPlanMembership;
import it.unicam.cs.ids.loyaltyplatform.entity.registration.RegistrationLoyaltyPlanPoints;
import it.unicam.cs.ids.loyaltyplatform.entity.users.Customer;
import it.unicam.cs.ids.loyaltyplatform.repository.RegistrationLoyaltyPlanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationLoyaltyPlanService {
    private final RegistrationLoyaltyPlanRepository registrationRepository;
    private final LoyaltyPlanService loyaltyPlanService;
    private final CustomerService customerService;
    private final FidelityCardService fidelityCardService;
    private final ProductService productService;

    public RegistrationLoyaltyPlanService(RegistrationLoyaltyPlanRepository registrationRepository, LoyaltyPlanService loyaltyPlanService, CustomerService customerService, FidelityCardService fidelityCardService, ProductService productService) {
        this.registrationRepository = registrationRepository;
        this.loyaltyPlanService = loyaltyPlanService;
        this.customerService = customerService;
        this.fidelityCardService = fidelityCardService;
        this.productService = productService;
    }

    public FidelityCard createFidelityCard(RegistrationLoyaltyPlanMembership registration) {
        FidelityCard fidelityCard = new FidelityCard(registration.getIdCustomer());
        this.fidelityCardService.addFidelityCard(fidelityCard);
        return fidelityCard;
    }

    public void redeemProduct(Integer idProduct, Integer idRegistration) {
        RegistrationLoyaltyPlan registration = getRegistrationById(idRegistration);
        Customer customer = this.customerService.getCustomerById(registration.getIdCustomer());
        Product product = this.productService.getProductById(idProduct);
        if(!(registration instanceof RegistrationLoyaltyPlanPoints registrationPoints)) {
            throw new IllegalArgumentException("the id of the registration does not correspond to a registration of loyalty plan points");
        }
        if(!this.loyaltyPlanService.getLoyaltyPlanById(registration.getIdLoyaltyPlan()).getIdAgency().equals(this.productService.getProductById(idProduct).getIdAgency())) {
            throw new IllegalArgumentException("The product to redeem belongs to another loyalty plan of another agency");
        }
        if(customer.getPoints() < product.getPoints()) {
            throw new IllegalArgumentException("The customer has not enough points to redeem the product");
        }
        customer.subtractPoints(product.getPoints());
        registrationPoints.addRedeemedProduct(product);
        updateRegistration(registrationPoints);
    }

    public void addRegistration(RegistrationLoyaltyPlan registration) {
        if(this.customerService.getAllCustomers().parallelStream().noneMatch(x -> x.getId().equals(registration.getIdCustomer()))) {
            throw new EntityNotFoundException("The id(" + registration.getIdCustomer() + ") of the customer does not exist");
        }
        LoyaltyPlan loyaltyPlan = this.loyaltyPlanService.getLoyaltyPlanById((registration.getIdLoyaltyPlan()));
        if(registration instanceof RegistrationLoyaltyPlanMembership registrationMembership) {
            registrationMembership.setFidelityCard(createFidelityCard(registrationMembership));
        }
        loyaltyPlan.incrementRegistrationCount();
        this.loyaltyPlanService.updateLoyaltyPlan(loyaltyPlan);
        this.customerService.updateRegistrationOfCustomer(registration.getIdCustomer(), registration);
        this.registrationRepository.save(registration);
    }

    public void deleteRegistrationById(Integer id) {
        RegistrationLoyaltyPlan registration = getRegistrationById(id);
        this.customerService.downgradeRegistrationOfCustomer(registration.getIdCustomer(), registration);
        if(registration instanceof RegistrationLoyaltyPlanMembership) {
            this.fidelityCardService.deleteFidelityCardById(((RegistrationLoyaltyPlanMembership) registration).getFidelityCard().getId());
        }
        LoyaltyPlan loyaltyPlan = this.loyaltyPlanService.getLoyaltyPlanById((registration.getIdLoyaltyPlan()));
        loyaltyPlan.decreaseRegistrationCount();
        this.loyaltyPlanService.updateLoyaltyPlan(loyaltyPlan);
        this.registrationRepository.deleteById(id);
    }

    public void updateRegistration(RegistrationLoyaltyPlan registration) {
        if(this.registrationRepository.findById(registration.getId()).isEmpty()) {
            throw new EntityNotFoundException("The registration(id:" + registration.getId() + ") does not exist");
        }
        this.registrationRepository.saveAndFlush(registration);
    }

    public RegistrationLoyaltyPlan getRegistrationById(Integer id){
        return this.registrationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The registration with id " + id + " does not exist"));
    }

    public List<RegistrationLoyaltyPlan> getRegistrationsByIdCustomer(Integer idCustomer){
        return this.registrationRepository.findByIdCustomer(idCustomer);
    }

    public List<RegistrationLoyaltyPlan> getAllRegistrations(){
        return this.registrationRepository.findAll();
    }

}
