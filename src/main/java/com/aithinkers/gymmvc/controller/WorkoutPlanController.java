package com.aithinkers.gymmvc.controller;





import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import com.aithinkers.gymmvc.model.WorkoutPlan;

import com.aithinkers.gymmvc.service.WorkoutPlanService;

@Controller
@RequestMapping("/workoutplans")
public class WorkoutPlanController {

	private WorkoutPlanService workoutPlanService;



	public WorkoutPlanController(WorkoutPlanService theWorkoutPlanService) {
		
		workoutPlanService = theWorkoutPlanService;
	}

	// add mapping for "/list"

	@GetMapping("/wlist")
	public String listWorkoutPlan(Model theModel) {

		// get the workoutplan from db
		List<WorkoutPlan> theWorkoutPlans = workoutPlanService.findAll();

		// add to the spring model
		theModel.addAttribute("workoutplans", theWorkoutPlans);

		return "WorkoutPlan/list-workoutplans";
	}

	@GetMapping("/wshowFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		WorkoutPlan theWorkoutPlan = new WorkoutPlan();

		theModel.addAttribute("workoutplan", theWorkoutPlan);

		return "WorkoutPlan/workoutplan-form";
	}
	
	


	@GetMapping("/wshowFormForUpdate")
	public String showFormForUpdate(@RequestParam("workoutplanId") int theId,
									Model theModel) {

		// get the workoutplan from the service
		WorkoutPlan theWorkoutPlan = workoutPlanService.findById(theId);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("workoutplan", theWorkoutPlan);

		// send over to our form
		return "WorkoutPlan/workoutplan-form";
	}

	@PostMapping("/wsave")
	public String saveWorkoutPlan(@ModelAttribute("workoutplan") WorkoutPlan theWorkoutPlan) {

		// save the employee
		workoutPlanService.save(theWorkoutPlan);

		// use a redirect to prevent duplicate submissions
		return "redirect:/workoutplans/wlist";
	}

	@GetMapping("/wdelete")
	public String delete(@RequestParam("workoutplanId") int theId) {

		// delete the employee
		workoutPlanService.deleteById(theId);

		// redirect to /workoutplans/wlist
		return "redirect:/workoutplans/wlist";

	}
}
