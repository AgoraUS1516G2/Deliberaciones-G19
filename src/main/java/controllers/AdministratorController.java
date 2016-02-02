/* AdministratorController.java
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import repositories.UserRepository;
import services.UserService;

import com.mchange.v2.c3p0.stmt.GooGooStatementCache;

import domain.User;



@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {

	//Services------------------------------------------------
	
	@Autowired
	private UserService userService;
	
	
	// Constructors -----------------------------------------------------------
	
	public AdministratorController() {
		super();
	}
		
	// Action-1 ---------------------------------------------------------------		

	@RequestMapping("/action-1")
	public ModelAndView action1() {
		ModelAndView result;
				
		result = new ModelAndView("administrator/action-1");
		
		return result;
	}
	
	// Action-2 ---------------------------------------------------------------
	
	@RequestMapping("/action-2")
	public ModelAndView action2() {
		ModelAndView result;
				
		result = new ModelAndView("administrator/action-2");
		
		return result;
	}

	//Listing ----------------------------------------------
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;

		Collection<User> users;

		users = userService.findAll();

		result = new ModelAndView("administrator/list");
		result.addObject("requestURI", "administrator/list.do");
		result.addObject("users", users);

		return result;
	}
	
	//Edition ----------------------------------------------------------
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int userId) {
		ModelAndView result;
		User user;

		user = userService.findOne(userId);
		result = createEditModelAndView(user);

		return result;
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid User user, BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(user);
		} else {
			try {
				userService.save(user);
				result = new ModelAndView(
						"redirect:/administrator/list.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(user, "user.commit.error");
			}
		}
		return result;
	}
	
	
	
	// Ancillary methods------------------------------

		protected ModelAndView createEditModelAndView(User user) {
			ModelAndView result;

			result = createEditModelAndView(user, null);
			return result;
		}
	
		
		protected ModelAndView createEditModelAndView(User user, String message) {
			ModelAndView result;
			

			result = new ModelAndView("administrator/edit");
			result.addObject("user", user);
			result.addObject("message", message);

			return result;
		}
	//DISPLAY A DASHBOARD WITH NUMER OF CABBAGES SYSTEM STORED AND THE LIST OF CUSTOMERS WHOE HAVE POSTED MORE CABBAGES
	//YO JOSE MARIA CABALLERO ALBA ENTIENDO QUE DEBO DE MOSTRAR EL NUMERO DE ANUNCIOs Y LA LISTA DE CUSTOMER QUE TIENEN ANUNCIOS
	
	
	

	
	
	
	
}