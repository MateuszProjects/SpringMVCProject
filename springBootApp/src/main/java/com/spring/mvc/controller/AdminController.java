package com.spring.mvc.controller;

import java.util.HashMap;
import java.util.Map;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.mvc.entities.TblShip;
import com.spring.mvc.form.ShipForm;
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
	
	@ModelAttribute("shipForm")
	ShipForm shipForm() {
		return new ShipForm();
	}
	
	// *********************** LOGIN PAGE **********************************
	@GetMapping("/login")
	public ModelAndView login() {
		    ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("custom-login");
		    return modelAndView;
    }
	
	// login page
	@GetMapping("/secure/list-details")
	public ModelAndView getAccount() {
		   ModelAndView modelAndView = new ModelAndView();
		   modelAndView.addObject("useraccounts", accountService.getAllAccount());
		   modelAndView.setViewName("application");
		   return modelAndView;
	}
	
	// ************************ ADRES ************************************
	@GetMapping("/secure/address")
	public ModelAndView getAddress(@RequestParam(defaultValue="0") int page) {
		   ModelAndView modelAndView = new ModelAndView();
		   modelAndView.addObject("address", addressService
				   .findAll(PageRequest.of(page,4)));
		   modelAndView.setViewName("admin/address");
		   return modelAndView;
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
	
	// ************************ CARGO ************************************
	@GetMapping("/secure/cargo")
	public ModelAndView getCargo(@RequestParam(defaultValue="0") int page) {
		   ModelAndView modelAndView = new ModelAndView();
		 //  modelAndView.addObject("cargoAdmin", cargoService
				 //  .findAll(PageRequest.of(page,4)));
		   modelAndView.setViewName("admin/cargo"); 
		   return modelAndView;
	}
	
	// ********************* ACCOUNT ***************************************
	@GetMapping("/secure/account")
	public ModelAndView getAccountDetails(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("address", addressService
					   .findAll(PageRequest.of(page,4)));
			modelAndView.setViewName("admin/account");
			return modelAndView;
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
	
	// ********************* COMPANY ***************************************
	@GetMapping("/secure/company")
	public ModelAndView getCompany(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("companyAdmin", companyService
					   .findAll(PageRequest.of(page,4)));
			modelAndView.setViewName("admin/company");
			return modelAndView;
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
	
	// *********************** FLIGHT *************************************
	@GetMapping("/secure/flight")
	public ModelAndView getFlight(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("flightAdmin", flightService
					   .findAll(PageRequest.of(page,4)));	
			modelAndView.setViewName("admin/flight");
			return modelAndView;
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
	@GetMapping("/secure/findOne")
	@ResponseBody
	public Optional<TblShip> findOne(Integer id) {
		return shipService.findById(id);
	}
	
	@GetMapping("/secure/ship/info")
	@ResponseBody
	public String getDataInfo() {
		Map<String, String> map = new HashMap<>();
		map.put("asdf", "@{/user/secure/saveShip}");
	
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = null;
		try {
			jsonResult = mapper.writerWithDefaultPrettyPrinter()
					  .writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonResult;
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
	
	// *********************** BILL OF LOADING *************************************
	@GetMapping("/secure/billofloading")
	public ModelAndView getBillOfLoading(@RequestParam(defaultValue="0") int page) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("billOfLoadingAdmin", billOfLoadingService
					   .findAll(PageRequest.of(page,4)));
			modelAndView.setViewName("admin/billofloading");
			return modelAndView;
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
