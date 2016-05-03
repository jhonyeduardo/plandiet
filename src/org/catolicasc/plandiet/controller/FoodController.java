package org.catolicasc.plandiet.controller;

import java.util.List;

import org.catolicasc.plandiet.dao.FoodDAO;
import org.catolicasc.plandiet.modelo.Food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/food")
public class FoodController {

	private FoodDAO dao;
	private List<Food> foods;

	public FoodController() {
		this.dao = new FoodDAO();
	}

	@RequestMapping("/add")
	public String adiciona(Food food) {

		if (food.getId() != 0) {
			this.dao.merge(food);
		} else {
			this.dao.persist(food);
		}
		return "redirect:list";
	}

	@RequestMapping("/remove")
	public String remove(Food food) {
		this.dao.remove(food);

		return "redirect:list";
	}

	@RequestMapping("/update")
	public ModelAndView update(Food food) {
		Food foodEdit = null;
		double amount = 0.0;

		ModelAndView mv = new ModelAndView("food/list-food");

		this.foods = this.dao.findAll();
		foodEdit = this.dao.getById(food.getId());
		amount = this.calculateAmount(this.foods);

		mv.addObject("foodEdit", foodEdit);
		mv.addObject("foods", this.foods);
		mv.addObject("amountCalories", amount);

		return mv;
	}

	@RequestMapping("/list")
	public ModelAndView lista() {
		double amount;
		ModelAndView mv = new ModelAndView("food/list-food");

		this.foods = this.dao.findAll();
		amount = this.calculateAmount(this.foods);
		mv.addObject("foods", this.foods);
		mv.addObject("amountCalories", amount);

		return mv;

	}

	private double calculateAmount(List<Food> foods) {
		double amount = 0.0;

		if (foods != null) {
			for (Food f : foods) {
				amount += f.getCalorie();
			}
		}

		return amount;
	}
}
