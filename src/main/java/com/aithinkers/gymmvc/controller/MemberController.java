package com.aithinkers.gymmvc.controller;
import com.aithinkers.gymmvc.model.*;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aithinkers.gymmvc.model.Member;
import com.aithinkers.gymmvc.model.Trainer;
import com.aithinkers.gymmvc.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {

	private MemberService memberService;



	public MemberController(MemberService theMemberService) {
		
		memberService = theMemberService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listMember(Model theModel) {

		// get the employees from db
		List<Member> theMembers = memberService.findAll();

		// add to the spring model
		theModel.addAttribute("members", theMembers);

		return "Member/list-members";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Member theMember = new Member();

		theModel.addAttribute("member", theMember);

		return "Member/member-form";
	}
	@GetMapping("/addTrainers")
	public String showTrainersForm(Model theModel) {

		// create model attribute to bind form data
		Trainer theTrainer = new Trainer();

		theModel.addAttribute("trainer", theTrainer);

		return "Trainer/list-trainers";
	}
	
	@GetMapping("/waddTrainers")
	public String showWorkoutPlanForm(Model theModel) {

		// create model attribute to bind form data
		WorkoutPlan theWorkoutPlan = new WorkoutPlan();

		theModel.addAttribute("workoutplan", theWorkoutPlan);

		return "WorkoutPlan/list-workoutplans";
	}
	
	/*@GetMapping("/addTrainers")
	public String showWorkoutForm(Model theModel) {

		// create model attribute to bind form data
		WorkoutPlan theWorkoutPlan = new WorloutPlan();

		theModel.addAttribute("workoutPlan", theWorkoutPlan);

		return "Member/list-trainers";
	}*/


	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("memberId") int theId,
									Model theModel) {

		// get the employee from the service
		Member theMember = memberService.findById(theId);

		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("member", theMember);

		// send over to our form
		return "Member/member-form";
	}

	@PostMapping("/save")
	public String saveMember(@ModelAttribute("member") Member theMember) {

		// save the employee
		memberService.save(theMember);

		// use a redirect to prevent duplicate submissions
		return "redirect:/members/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("memberId") int theId) {

		// delete the employee
		memberService.deleteById(theId);

		// redirect to /employees/list
		return "redirect:/members/list";

	}
	
	
	
	
	
	

    @GetMapping("/contact")
    public String showContactPage() {
        return "Member/contact";
    }

    @GetMapping("/about")
    public String showAboutPage() {
        return "Member/about";
    }

    @GetMapping("/career")
    public String showCareerPage() {
        return "Member/career";
    }

    @GetMapping("/help")
    public String showHelpPage() {
        return "Member/help";
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}