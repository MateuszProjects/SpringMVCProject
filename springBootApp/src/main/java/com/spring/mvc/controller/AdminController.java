package com.spring.mvc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.entities.TblAddress;
import com.spring.mvc.entities.TblBillofloading;
import com.spring.mvc.entities.TblCargo;
import com.spring.mvc.entities.TblCargotype;
import com.spring.mvc.entities.TblCompany;
import com.spring.mvc.entities.TblEmployee;
import com.spring.mvc.entities.TblFlight;
import com.spring.mvc.entities.TblLuggage;
import com.spring.mvc.entities.TblPerson;
import com.spring.mvc.entities.TblShip;
import com.spring.mvc.entities.TblTrain;
import com.spring.mvc.entities.TblUserapplication;
import com.spring.mvc.form.AccountForm;
import com.spring.mvc.form.AddressForm;
import com.spring.mvc.form.BillOfLoadingForm;
import com.spring.mvc.form.CargoForm;
import com.spring.mvc.form.CargoTypeForm;
import com.spring.mvc.form.CompanyForm;
import com.spring.mvc.form.CustomerForm;
import com.spring.mvc.form.EmployeeForm;
import com.spring.mvc.form.FlightForm;
import com.spring.mvc.form.LuggageForm;
import com.spring.mvc.form.PersonForm;
import com.spring.mvc.form.ShipForm;
import com.spring.mvc.form.TrainForm;
import com.spring.mvc.service.AccountService;
import com.spring.mvc.service.AddressService;
import com.spring.mvc.service.BillOfLoadingService;
import com.spring.mvc.service.CargoService;
import com.spring.mvc.service.CargoTypeService;
import com.spring.mvc.service.CompanyService;
import com.spring.mvc.service.EmployeeService;
import com.spring.mvc.service.FlightService;
import com.spring.mvc.service.LuggageService;
import com.spring.mvc.service.PersonService;
import com.spring.mvc.service.ShipService;
import com.spring.mvc.service.TrainService;
import com.spring.mvc.service.TypeService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ShipService shipService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private BillOfLoadingService billOfLoadingService;
	
	@Autowired
	private CargoTypeService cargoTypeServis;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private FlightService flightService;

	@Autowired
	private LuggageService luggageService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private TrainService trainService;
	
	@Autowired
	private TypeService typeService;
	
	@Autowired
	private CargoService cargoService;
	
	// Model atriubtes:
	@ModelAttribute("shipForm")
	ShipForm shipForm() {
		return new ShipForm();
	}
	
	@ModelAttribute("cargoForm")
	CargoForm cargoForm() {
		return new CargoForm();
	}
	
	@ModelAttribute("addresForm")
	AddressForm addressForm() {
		return new AddressForm();
	}
	
	@ModelAttribute("billofloadingForm")
	BillOfLoadingForm billOfLoadingForm() {
		return new BillOfLoadingForm();
	}
	
	@ModelAttribute("cargotypeForm")
	CargoTypeForm cargoTypeForm() {
		return new CargoTypeForm();
	}
	
	@ModelAttribute("companyForm")
	CompanyForm companyForm() {
		return new CompanyForm();
	}
	
	@ModelAttribute("customerForm")
	CustomerForm customerForm() {
		return new CustomerForm();
	}
	
	@ModelAttribute("flightForm")
	FlightForm flightForm() {
		return new FlightForm();
	}
	
	@ModelAttribute("luggageForm")
	LuggageForm luggageForm() {
		return new LuggageForm();
	}
	
	@ModelAttribute("personForm")
	PersonForm personForm() {
		return new PersonForm();
	}
	
	@ModelAttribute("trainForm")
	TrainForm trainForm() {
		return new TrainForm();
	}
	
	@ModelAttribute("accountForm")
	AccountForm accountForm() {
		return new AccountForm();
	}
	
	@ModelAttribute("employeeForm")
	EmployeeForm employeeForm() {
		return new EmployeeForm();
	}
	// *********************** LOGIN PAGE **********************************
	/*@GetMapping("/login")
	public ModelAndView login() {
		    ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("custom-login");
		    return modelAndView;
    }*/
	
	// login page
	@GetMapping("/secure/list-details")
	public ModelAndView getAccount() {
		   ModelAndView modelAndView = new ModelAndView();
		   modelAndView.addObject("useraccounts", accountService.findAll());
		   modelAndView.setViewName("admin/indexadmin");
		   return modelAndView;
	}
	
	// ************************ ADRES ************************************
	@GetMapping("/secure/address")
	public ModelAndView getAddress(@RequestParam(defaultValue="0") int page) {
		   ModelAndView modelAndView = new ModelAndView();
		   modelAndView.addObject("addressAdmin", addressService
				   .findAll(PageRequest.of(page,4)));
		   modelAndView.setViewName("admin/address");
		   return modelAndView;
	}
	
	@GetMapping("/secure/deleteAddress")
	public @ResponseBody ModelAndView getDeleteAddress(@RequestParam int id){
		ModelAndView modelAndView = new ModelAndView();
		  addressService.deleteById(id);
		  modelAndView.addObject("addressAdmin", addressService.
				  findAll(PageRequest.of(0,4)));
		  
		 modelAndView.setViewName("admin/address");
		 return modelAndView;
	}
	
	@RequestMapping(
			value="/secure/addressNewUpdate",
			method=RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded;charset=UTF-8"} )
	public  ModelAndView saveUpdatAddress(@ModelAttribute("addressForm") AddressForm addressForm) {
		ModelAndView modelAndView = new ModelAndView();
		  modelAndView.addObject("addressAdmin", addressService.
				  findAll(PageRequest.of(0,4)));  
		  
		modelAndView.setViewName("admin/ship");
		TblAddress tblAddress = new TblAddress();
		
		if(addressForm.getId() != null)
			tblAddress.setAddressid(1); 
	
		
		try {
			addressService.save(tblAddress);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	// metoda AJAX
	@GetMapping("/secure/findAddress")
	@ResponseBody
	public Optional<TblAddress> findAddress(Integer id) {
		return addressService.findById(id);
	}
	
	// *********************** LUGGAGE *********************************
	@GetMapping("/secure/luggage")
	public ModelAndView getLuggage(@RequestParam(defaultValue="0") int page) {
		   ModelAndView modelAndView = new ModelAndView();
		   modelAndView.addObject("luggageAdmin", luggageService
				   .findAll(PageRequest.of(page,4)));
		   modelAndView.setViewName("admin/luggage");
		   return modelAndView;
	}
	
	@GetMapping("/secure/deleteLuggage")
	public @ResponseBody ModelAndView getDeleteLuggage(@RequestParam int id){
		ModelAndView modelAndView = new ModelAndView();
		  luggageService.deleteById(id);
		  modelAndView.addObject("luggageAdmin", luggageService.
				  findAll(PageRequest.of(0,4)));
		  
		 modelAndView.setViewName("admin/luggage");
		 return modelAndView;
	}
	
	@RequestMapping(
			value="/secure/luggageNewUpdate",
			method=RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded;charset=UTF-8"} )
	public  ModelAndView saveUpdateLuggage(@ModelAttribute("luggageForm") LuggageForm luggageForm) {
		ModelAndView modelAndView = new ModelAndView();
		  modelAndView.addObject("luggageAdmin", luggageService.
				  findAll(PageRequest.of(0,4)));  
		  
		modelAndView.setViewName("admin/ship");
		TblLuggage tblLuggage = new TblLuggage();
		
		if(luggageForm.getId() != null)
			tblLuggage.setLuggageid(luggageForm.getId());

		try {
			luggageService.save(tblLuggage);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	// metoda AJAX
	@GetMapping("/secure/findOneLuggage")
	@ResponseBody
	public Optional<TblLuggage> findOneLuggage(Integer id) {
		return luggageService.findById(id);
	}
	
	// ************************ CARGO ************************************
	@GetMapping("/secure/cargo")
	public ModelAndView getCargo(@RequestParam(defaultValue="0") int page) {
		   ModelAndView modelAndView = new ModelAndView();
		   modelAndView.addObject("cargoAdmin", cargoService
				       .findAll(PageRequest.of(page,4)));
		   modelAndView.setViewName("admin/cargo"); 
		   return modelAndView;
	}
	
	@RequestMapping(
			value = "/secure/cargoNewUpdate",
			method=RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded;charset=UTF-8"} )
	public  ModelAndView saveUpdateCargo(@ModelAttribute("cargoForm") CargoForm cargoForm) {
		ModelAndView modelAndView = new ModelAndView();
		 modelAndView.addObject("data", cargoService.
				  findAll(PageRequest.of(0,4)));  
		  
		modelAndView.setViewName("admin/cargo");
		TblCargo tblCargo = new TblCargo();
		
		if(cargoForm.getId() != null)
			tblCargo.setCargoid(cargoForm.getId());
		
		
		try {
			cargoService.save(tblCargo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}

	
	@GetMapping("/secure/findOneCargo")
	@ResponseBody
	public Optional<TblCargo> findOneCargo(Integer id) {
		return cargoService.findById(id);
	}
	
	// ********************* ACCOUNT ***************************************
	@GetMapping("/secure/account")
	public ModelAndView getAccountDetails(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("account", accountService
					   .findAll(PageRequest.of(page,4)));
			modelAndView.setViewName("admin/account");
			return modelAndView;
	}
	
	@GetMapping("/secure/deleteAccount")
	public @ResponseBody ModelAndView getDeleteAccount(@RequestParam int id){
		ModelAndView modelAndView = new ModelAndView();
		accountService.deleteById(id);
		modelAndView.addObject("accountAdmin", accountService.
				  findAll(PageRequest.of(0,4)));
		  
		 modelAndView.setViewName("admin/account");
		 return modelAndView;
	}
	
	@RequestMapping(
			value="/secure/accountNewUpdate",
			method=RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded;charset=UTF-8"} )
	public  ModelAndView saveUpdateAccount(@ModelAttribute("accountForm") AccountForm accountForm) {
		ModelAndView modelAndView = new ModelAndView();
		  modelAndView.addObject("accountAdmin", accountService.
				  findAll(PageRequest.of(0,4)));  
		  
		modelAndView.setViewName("admin/account");
		TblUserapplication tblUserapplication = new TblUserapplication();
		
		if(accountForm.getId() != null)
			tblUserapplication.setUserApplicationid(accountForm.getId());
		
		
		try {
			accountService.save(tblUserapplication);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	// metoda AJAX
	@GetMapping("/secure/findOne")
	@ResponseBody
	public Optional<TblUserapplication> findOneAccount(Integer id) {
		return accountService.findById(id);
	}
	
	
	// *************************** CARGO TYPE *********************************
	@GetMapping("/secure/cargotype")
	public ModelAndView getCargoType(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("cargotypeAdmin", cargoTypeServis
					   .findAll(PageRequest.of(page,4)));
			modelAndView.setViewName("admin/cargotype");
			return modelAndView;
	}
	
	@GetMapping("/secure/deleteType")
	public @ResponseBody ModelAndView getDeleteCargoType(@RequestParam int id){
		ModelAndView modelAndView = new ModelAndView();
		  cargoTypeServis.deleteById(id);
		  modelAndView.addObject("cargotypeAdmin", cargoTypeServis.
				  findAll(PageRequest.of(0,4)));
		  
		 modelAndView.setViewName("admin/cargotype");
		 return modelAndView;
	}
	
	@RequestMapping(
			value="/secure/cargoTypeNewUpdate",
			method=RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded;charset=UTF-8"} )
	public  ModelAndView saveUpdateCargoType(@ModelAttribute("cargotypeForm") CargoTypeForm cargoTypeForm) {
		ModelAndView modelAndView = new ModelAndView();
		  modelAndView.addObject("cargotypeAdmin", cargoTypeServis.
				  findAll(PageRequest.of(0,4)));  
		  
		modelAndView.setViewName("admin/cargotype");
		TblCargotype tblCargoType = new TblCargotype();
		
		if(cargoTypeForm.getId() != null)
			tblCargoType.setCargotypeid(cargoTypeForm.getId());

		
		try {
			cargoTypeServis.save(tblCargoType);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	// metoda AJAX
	@GetMapping("/secure/findOneCargoType")
	@ResponseBody
	public Optional<TblCargotype> findOneCargoType(Integer id) {
		return cargoTypeServis.findById(id);
	}
	
	// ********************* COMPANY ***************************************
	@GetMapping("/secure/company")
	public ModelAndView getCompany(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("companyAdmin", companyService
					   .findAll(PageRequest.of(page,4)));
			modelAndView.setViewName("admin/company");
			return modelAndView;
	}
	
	@GetMapping("/secure/deleteCompany")
	public @ResponseBody ModelAndView getDeleteCompany(@RequestParam int id){
		ModelAndView modelAndView = new ModelAndView();
		  companyService.deleteById(id);
		  modelAndView.addObject("companyAdmin", companyService.
				  findAll(PageRequest.of(0,4)));
		  
		 modelAndView.setViewName("admin/company");
		 return modelAndView;
	}
	
	@RequestMapping(
			value="/secure/companyNewUpdate",
			method=RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded;charset=UTF-8"} )
	public  ModelAndView saveUpdateCompany(@ModelAttribute("companyForm") CompanyForm companyForm) {
		ModelAndView modelAndView = new ModelAndView();
		  modelAndView.addObject("companyAdmin", companyService.
				  findAll(PageRequest.of(0,4)));  
		  
		modelAndView.setViewName("admin/company");
		TblCompany tblCompany = new TblCompany();
		
		if(companyForm.getId() != null)
			tblCompany.setCompanyid(companyForm.getId());
		
		try {
			companyService.save(tblCompany);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	// metoda AJAX
	@GetMapping("/secure/findOneCompany")
	@ResponseBody
	public Optional<TblCompany> findOneCompany(Integer id) {
		return companyService.findById(id);
	}
	// ************************** EMPLOYEE **********************************
	@GetMapping("/secure/employee")
	public ModelAndView getEmployee(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("employeeAdmin", employeeService
					   .findAll(PageRequest.of(page,4)));
			modelAndView.setViewName("admin/employee");
			return modelAndView;
	}
	
	@GetMapping("/secure/deleteEmployee")
	public @ResponseBody ModelAndView getDeleteEmployee(@RequestParam int id){
		ModelAndView modelAndView = new ModelAndView();
		  employeeService.deleteById(id);
		  modelAndView.addObject("employeeAdmin", employeeService.
				  findAll(PageRequest.of(0,4)));
		  
		 modelAndView.setViewName("admin/ship");
		 return modelAndView;
	}
	
	@RequestMapping(
			method=RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded;charset=UTF-8"} )
	public  ModelAndView saveUpdateEmployee(@ModelAttribute("employeeForm") EmployeeForm employeeForm) {
		ModelAndView modelAndView = new ModelAndView();
		  modelAndView.addObject("employeeAdmin", employeeService.
				  findAll(PageRequest.of(0,4)));  
		  
		modelAndView.setViewName("admin/ship");
		TblEmployee tblEmployee = new TblEmployee();
		
		if(employeeForm.getId() != null)
		    tblEmployee.setEmplid(employeeForm.getId());
	
		
		try {
			employeeService.save(tblEmployee);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	// metoda AJAX
	@GetMapping("/secure/findOneEmployee")
	@ResponseBody
	public Optional<TblEmployee> findOneEmployee(Integer id) {
		return employeeService.findById(id);
	}
	
	// *********************** FLIGHT *************************************
	@GetMapping("/secure/flight")
	public ModelAndView getFlight(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("flightAdmin", flightService
					   .findAll(PageRequest.of(page,4)));	
			modelAndView.setViewName("admin/flight");
			return modelAndView;
	}
	
	@GetMapping("/secure/deleteflight")
	public @ResponseBody ModelAndView getDeleteFlight(@RequestParam int id){
		ModelAndView modelAndView = new ModelAndView();
		  flightService.deleteById(id);
		  modelAndView.addObject("flightAdmin", flightService.
				  findAll(PageRequest.of(0,4)));
		  
		 modelAndView.setViewName("admin/flight");
		 return modelAndView;
	}
	
	@RequestMapping(
			value="/secure/flightNewUpdate",
			method=RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded;charset=UTF-8"} )
	public  ModelAndView saveUpdateFlight(@ModelAttribute("flightForm") FlightForm flightForm) {
		ModelAndView modelAndView = new ModelAndView();
		  modelAndView.addObject("flightAdmin", flightService.
				  findAll(PageRequest.of(0,4)));  
		  
		modelAndView.setViewName("admin/flight");
		TblFlight tblFlight = new TblFlight();
		
		if(flightForm.getId() != null)
			tblFlight.setFlightid(flightForm.getId());
		
		try {
			flightService.save(tblFlight);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	// metoda AJAX
	@GetMapping("/secure/findOneFlight")
	@ResponseBody
	public Optional<TblFlight> findOneFlight(Integer id) {
		return flightService.findById(id);
	}
	
	// ************************ TRAIN ************************************
	@GetMapping("/secure/train")
	public ModelAndView getTrain(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("trainAdmin", trainService
					   .findAll(PageRequest.of(page,4)));
			modelAndView.setViewName("admin/train");
			return modelAndView;
	}
	
	@GetMapping("/secure/deleteTrain")
	public @ResponseBody ModelAndView getDeleteTrain(@RequestParam int id){
		ModelAndView modelAndView = new ModelAndView();
		  trainService.deleteById(id);
		  modelAndView.addObject("trainAdmin", trainService.
				  findAll(PageRequest.of(0,4)));
		  
		 modelAndView.setViewName("admin/train");
		 return modelAndView;
	}
	
	@RequestMapping(
			value="/secure/trainNewUpdate",
			method=RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded;charset=UTF-8"} )
	public  ModelAndView saveUpdateTrain(@ModelAttribute("trainForm") TrainForm trainForm) {
		ModelAndView modelAndView = new ModelAndView();
		  modelAndView.addObject("trainAdmin", trainService.
				  findAll(PageRequest.of(0,4)));  
		  
		modelAndView.setViewName("admin/train");
		TblTrain tblTrain = new TblTrain();
		
		if(trainForm.getId() != null)
		   tblTrain.setTrainid(trainForm.getId());
		
		
		try {
			trainService.save(tblTrain);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	// metoda AJAX
	@GetMapping("/secure/findOneTrain")
	@ResponseBody
	public Optional<TblTrain> findOneTrain(Integer id) {
		return trainService.findById(id);
	}
	
	// ****************************** SHIP **************************************
	@GetMapping("/secure/ship")
	public ModelAndView getShip(@RequestParam(defaultValue="0") int page) {
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.addObject("data", shipService.
				  findAll(PageRequest.of(page,4)));
		  
		  modelAndView.addObject("currentPage", page);
		  modelAndView.setViewName("admin/ship");
		  return modelAndView;
	}
	
	
	@GetMapping("/secure/deleteShip")
	public @ResponseBody ModelAndView getDeleteShip(@RequestParam int id){
		ModelAndView modelAndView = new ModelAndView();
		  shipService.deleteById(id);
		  modelAndView.addObject("data", shipService.
				  findAll(PageRequest.of(0,4)));
		  
		 modelAndView.setViewName("admin/ship");
		 return modelAndView;
	}
	
	@RequestMapping(
			value="/secure/shipNewUpdate",
			method=RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded;charset=UTF-8"} )
	public  ModelAndView saveUpdateShip(@ModelAttribute("shipForm") ShipForm shipForm) {
		ModelAndView modelAndView = new ModelAndView();
		  modelAndView.addObject("data", shipService.
				  findAll(PageRequest.of(0,4)));  
		  
		modelAndView.setViewName("admin/ship");
		TblShip tblShip = new TblShip();
		
		if(shipForm.getId() != null)
			tblShip.setShipid(shipForm.getId());
		
		tblShip.setSource(shipForm.getSource());
		tblShip.setDestination(shipForm.getDestination());
		
		try {
			shipService.save(tblShip);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	// metoda AJAX
	@GetMapping("/secure/findOneShip")
	@ResponseBody
	public Optional<TblShip> findOneShip(Integer id) {
		return shipService.findById(id);
	}

	@GetMapping("/secure/type")
	public ModelAndView getType(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("typeAdmin", typeService
					   .findAll(PageRequest.of(page,4)));
			modelAndView.setViewName("admin/type");
			return modelAndView;
	}
	
	// **************************** PERSON ********************************
	@GetMapping("/secure/person")
	public ModelAndView getPerson(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("personAdmin", personService
					   .findAll(PageRequest.of(page,4)));
			modelAndView.setViewName("admin/person");
			return modelAndView;
	}
	
	@GetMapping("/secure/deletePerson")
	public @ResponseBody ModelAndView getDeletePerson(@RequestParam int id){
		ModelAndView modelAndView = new ModelAndView();
		  personService.deleteById(id);
		  modelAndView.addObject("personAdmin", personService.
				  findAll(PageRequest.of(0,4)));
		  
		 modelAndView.setViewName("admin/person");
		 return modelAndView;
	}
	
	@RequestMapping(
			value="/secure/personNewUpdate",
			method=RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded;charset=UTF-8"} )
	public  ModelAndView saveUpdatePerson(@ModelAttribute("personForm") PersonForm personForm) {
		ModelAndView modelAndView = new ModelAndView();
		  modelAndView.addObject("personAdmin", personService.
				  findAll(PageRequest.of(0,4)));  
		  
		modelAndView.setViewName("admin/ship");
		TblPerson tblPerson = new TblPerson();
		
		if(personForm.getId() != null)
			tblPerson.setCustomerid(personForm.getId());
		// do przetestowania
		
		try {
			personService.save(tblPerson);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	// metoda AJAX
	@GetMapping("/secure/findOnePerson")
	@ResponseBody
	public Optional<TblPerson> findOnePerson(Integer id) {
		return personService.findById(id);
	}
	
	// *********************** BILL OF LOADING *************************************
	@GetMapping("/secure/billofloading")
	public ModelAndView getBillOfLoading(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("billOfLoadingAdmin", billOfLoadingService
					   .findAll(PageRequest.of(page,4)));
			modelAndView.setViewName("admin/billofloading");
			return modelAndView;
	}

	@GetMapping("/secure/deleteBillOfLoading")
	public @ResponseBody ModelAndView getDeleteBillOfLoading(@RequestParam int id){
		ModelAndView modelAndView = new ModelAndView();
		  billOfLoadingService.deleteById(id);
		  modelAndView.addObject("bilOfLoadingAdmin", billOfLoadingService.
				  findAll(PageRequest.of(0,4)));
		  
		 modelAndView.setViewName("admin/billofloading");
		 return modelAndView;
	}
	
	@RequestMapping(
			value="/secure/billOfLoadingNewUpdate",
			method=RequestMethod.POST,
			consumes = {"application/x-www-form-urlencoded;charset=UTF-8"} )
	public  ModelAndView saveUpdateBillOfLoading(@ModelAttribute("billofloadingForm") BillOfLoadingForm billOfLoadingForm) {
		ModelAndView modelAndView = new ModelAndView();
		  modelAndView.addObject("personAdmin", billOfLoadingService.
				  findAll(PageRequest.of(0,4)));  
		  
		modelAndView.setViewName("admin/ship");
		TblBillofloading tblBillofloading = new TblBillofloading();
		
		if(billOfLoadingForm.getId() != null)
			//tblPerson.set);(personForm.getId());
		
		
		try {
			billOfLoadingService.save(tblBillofloading);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	// metoda AJAX
	@GetMapping("/secure/findOneBillOfLoading")
	@ResponseBody
	public Optional<TblBillofloading> findOneBillOfLoading(Integer id) {
		return billOfLoadingService.findById(id);
	}
	
	@GetMapping("/error")
	public ModelAndView error() {
		    ModelAndView modelAndView = new ModelAndView();
		    String errorMessage= "You are not authorized for the requested data.";
		    modelAndView.addObject("errorMsg", errorMessage);
		    modelAndView.setViewName("error");
		    return modelAndView;
    }
	
}
