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
import com.spring.mvc.service.ShipService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ShipService shipService;
	

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
	// *************************************************************************
	
	// ************************ ADRES ************************************
	@GetMapping("/secure/address")
	public ModelAndView getAddress() {
		   ModelAndView modelAndView = new ModelAndView();
		   // modelAndView.addObject("useraccounts", accountService.getAllAccount());
		   modelAndView.setViewName("admin/address");
		   return modelAndView;
	}
	// ************************************************************
	
	// *********************** LUGGAGE *********************************
	@GetMapping("/secure/luggage")
	public ModelAndView getLuggage() {
		   ModelAndView modelAndView = new ModelAndView();
		   // modelAndView.addObject("useraccounts", accountService.getAllAccount());
		   modelAndView.setViewName("admin/luggage");
		   return modelAndView;
	}
	// ************************************************************
	
	// ************************ CARGO ************************************
	@GetMapping("/secure/cargo")
	public ModelAndView getCargo() {
		   ModelAndView modelAndView = new ModelAndView();
		   modelAndView.addObject("useraccounts", accountService.getAllAccount());
		   modelAndView.setViewName("admin/cargo"); 
		   return modelAndView;
	}
	// ************************************************************
	
	// ********************* ACCOUNT ***************************************
	@GetMapping("/secure/account")
	public ModelAndView getAccountDetails() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/account");
			return modelAndView;
	}
	// ************************************************************
	
	// *************************** CARGO TYPE *********************************
	@GetMapping("/secure/cargotype")
	public ModelAndView getCargoType() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/cargotype");
			return modelAndView;
	}
	// ************************************************************
	
	// ********************* COMPANY ***************************************
	@GetMapping("/secure/company")
	public ModelAndView getCompany() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/company");
			return modelAndView;
	}
	// ************************************************************
	
	// ************************** EMPLOYEE **********************************
	@GetMapping("/secure/employee")
	public ModelAndView getEmployee() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/employee");
			return modelAndView;
	}
	// ************************************************************
	
	// *********************** FLIGHT *************************************
	@GetMapping("/secure/flight")
	public ModelAndView getFlight() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/flight");
			return modelAndView;
	}
	// ************************************************************
	
	// ************************ TRAIN ************************************
	@GetMapping("/secure/train")
	public ModelAndView getTrain() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/train");
			return modelAndView;
	}
	// ************************************************************
	
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
		  
		 modelAndView.setViewName("_table");
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
	public ModelAndView getType() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("_table");
			return modelAndView;
	}
	// ********************************************************************
	
	// **************************** PERSON ********************************
	@GetMapping("/secure/person")
	public ModelAndView getPerson() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/person");
			return modelAndView;
	}
	// ************************************************************
	
	// *********************** BILL OF LOADING *************************************
	@GetMapping("/secure/billofloading")
	public ModelAndView getBillOfLoading() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/billofloading");
			return modelAndView;
	}
	// ************************************************************
	
	// ************************** USERS **********************************
	@GetMapping("/secure/users")
	public ModelAndView getUsers() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin/users");
			return modelAndView;
	}
	// ************************************************************
	
	@GetMapping("/error")
	public ModelAndView error() {
		    ModelAndView modelAndView = new ModelAndView();
		    String errorMessage= "You are not authorized for the requested data.";
		    modelAndView.addObject("errorMsg", errorMessage);
		    modelAndView.setViewName("error");
		    return modelAndView;
    }
	


}
