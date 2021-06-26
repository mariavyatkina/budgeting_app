package org.perscholas.budgeting.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.perscholas.budgeting.entity.Transaction;
import org.perscholas.budgeting.entity.TransactionCategory;
import org.perscholas.budgeting.entity.User;
import org.perscholas.budgeting.service.TransactionCategoryService;
import org.perscholas.budgeting.service.TransactionService;
import org.perscholas.budgeting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/*AccountController class controls the flow of data for user's action within the account, a part of MVC pattern*/
@Controller
@SessionAttributes({"command"})
@RequestMapping("/account")
public class AccountController {
	
	@Autowired UserService userService;
	@Autowired TransactionCategoryService transCatService;
	@Autowired TransactionService transService;
	
	@RequestMapping("/")
	public ModelAndView mainAccountPage(@SessionAttribute("command") User user)
	{
		ModelAndView mav = new ModelAndView("account_main");
		user = userService.getByEmail(user.getEmail());
		mav.addObject("command", user);
		
		Double sumInvestment = userService.getAmountByCategoryType(user.getUserId(), "investment").stream().mapToDouble(f -> f.doubleValue()).sum();
		mav.addObject("sumInvestment", sumInvestment);
		Double sumIncome = userService.getAmountByCategoryType(user.getUserId(), "income").stream().mapToDouble(f -> f.doubleValue()).sum();
		mav.addObject("sumIncome", sumIncome);
		Double sumExpense = userService.getAmountByCategoryType(user.getUserId(), "expense").stream().mapToDouble(f -> f.doubleValue()).sum();
		mav.addObject("sumExpense", sumExpense);
		
		List<Object[]> categorySumExp = userService.getCategoryAndSumAmount(user.getUserId(), "expense");
		mav.addObject("categorySumExp",categorySumExp);

		List<Object[]>categorySumInv = userService.getCategoryAndSumAmount(user.getUserId(), "investment");
		mav.addObject("categorySumInv",categorySumInv);

		List<Object[]> categorySumInc = userService.getCategoryAndSumAmount(user.getUserId(), "income");
		mav.addObject("categorySumInc",categorySumInc);

		return mav;
		
	}
	@GetMapping("add-investment")
	public ModelAndView addInvestment(@SessionAttribute("command") User user, @ModelAttribute("transaction") Transaction transaction)
	{
		ModelAndView mav = new ModelAndView("add_investment");
		List<TransactionCategory> listInvestmentCategory = transCatService.findAllByCategoryType("investment");
		mav.addObject("listInvestmentCategory", listInvestmentCategory);
		return mav;
	}
	@GetMapping("add-income")
	public ModelAndView addIncome(@SessionAttribute("command") User user, @ModelAttribute("transaction") Transaction transaction)
	{
		ModelAndView mav = new ModelAndView("add_income");
		List<TransactionCategory> listIncomeCategory = transCatService.findAllByCategoryType("income");
		mav.addObject("listIncomeCategory", listIncomeCategory);
		
		return mav;
	}
	@GetMapping("add-expense")
	public ModelAndView addExpense(@SessionAttribute("command") User user, @ModelAttribute("transaction") Transaction transaction)
	{
		ModelAndView mav = new ModelAndView("add_expense");
		List<TransactionCategory> listExpenseCategory = transCatService.findAllByCategoryType("expense");
		mav.addObject("listExpenseCategory", listExpenseCategory);
		
		return mav;
	}
	@PostMapping("add-transaction")
	public String addTransaction(@SessionAttribute("command") User user, @ModelAttribute("transaction") Transaction transaction)
	{
		transaction.setCategory(transCatService.findByCategoryName(transaction.getCategory().getCategoryName()));
		transService.save(transaction);
		user.getTransaction().add(transaction);
		userService.save(user);
		return "redirect:/account/";
	}
	@GetMapping("/transactions-overview")
	public ModelAndView transactionsOverview(@SessionAttribute("command") User user, @RequestParam String categoryType)
	{
		ModelAndView mav = new ModelAndView("transactions_overview");
		List<Object[]> transactions = userService.getTransactionsForCategoryName(user.getUserId(), categoryType);
		mav.addObject("categoryType", categoryType);
		mav.addObject("transactions", transactions);

		return mav;
	}
	@RequestMapping("/delete")
	public String deleteTransaction(@SessionAttribute("command") User user, @RequestParam int id) {
		userService.get(user.getUserId()).getTransaction().remove(transService.get(id));
	    transService.delete(id);
	    return "redirect:/account/";       
	}
	@RequestMapping("/edit")
	public ModelAndView updateTransaction(@SessionAttribute("command") User user, @RequestParam int id)
	{
		ModelAndView mav = new ModelAndView("edit_transaction");
		Transaction transaction = transService.get(id);
		List<TransactionCategory> listCategoryNames = transCatService.findAllByCategoryType(transaction.getCategory().getCategoryType());
		mav.addObject("listCategoryNames", listCategoryNames);
		mav.addObject("command", user);
		mav.addObject("transaction", transaction);
		return mav;
	}
	@PostMapping("save-transaction")
	public String saveTrasaction(@SessionAttribute("command") User user, @ModelAttribute("transaction") Transaction transaction)
	{
		transaction.setCategory(transCatService.findByCategoryName(transaction.getCategory().getCategoryName()));
		transService.save(transaction);
		return "redirect:/account/";
	}
	@GetMapping("redirect")
	public String redirectToMainAccountPage(@SessionAttribute("command") User user)
	{
		return "redirect:/account/";
	}
	@GetMapping("logout")
	public String logout(HttpSession session)
	{
		session.setAttribute("command", null);
		return "redirect:/";
	}
	@GetMapping("/whole-summary")
	public ModelAndView allTransactions(@SessionAttribute("command") User user)
	{
		ModelAndView mav = new ModelAndView("whole_summary");
		List<Object[]> expenses = userService.getAllTransactionsForCategoryName(user.getUserId(), "expense");
		mav.addObject("expenses", expenses);

		List<Object[]> investments = userService.getAllTransactionsForCategoryName(user.getUserId(), "investment");
		mav.addObject("investments", investments);

		List<Object[]> income = userService.getAllTransactionsForCategoryName(user.getUserId(), "income");
		mav.addObject("income", income);
		
		return mav;
		
	}
}
