package com.nexp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.nexp.beans.Emp;
import com.nexp.dao.EmpDao;

@Controller
public class EmpController {
	@Autowired
	EmpDao dao;
	
	@RequestMapping(value="/viewemp/{pageid}")  
    public String editt(@PathVariable int pageid,Model m){  
        int total=5;  
        if(pageid==1){}  
        else{  
            pageid=(pageid-1)*total+1;  
        }  
        System.out.println(pageid);
        List<Emp> list=dao.getEmployeesByPage(pageid,total);  
          m.addAttribute("list", list);
        return "viewemp";  
    }  

	@RequestMapping("/empform")
	public String showform(Model m) {
		m.addAttribute("command", new Emp());
		return "empform";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") Emp emp) {
		dao.save(emp);
		return "redirect:/viewemp/1";
	}

	@RequestMapping("/viewemp")
	public String viewemp(Model m) {
		List<Emp> list = dao.getEmployees();
		m.addAttribute("list", list);
		return "viewemp";
	}

	@RequestMapping(value = "/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {
		Emp emp = dao.getEmpById(id);
		m.addAttribute("command", emp);
		return "empeditform";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("emp") Emp emp) {
		dao.update(emp);
		return "redirect:/viewemp";
	}

	@RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/viewemp";
	}

	@ModelAttribute("roleList")
	public Map<String, String> getRoleList() {
		Map<String, String> roleList = new HashMap<String, String>();
		roleList.put("admin", "Admin");
		roleList.put("manager", "Manager");
		roleList.put("TL", "Team Leader");
		roleList.put("user", "User");
		return roleList;
	}

	@ModelAttribute("communication_languagesList")
	public Map<String, String> getSkillsList() {
		Map<String, String> communication_languagesList = new HashMap<String, String>();
		communication_languagesList.put("English", "English");
		communication_languagesList.put("Spain", "Spain");
		communication_languagesList.put("Gujarati", "Gujarati");
		communication_languagesList.put("Swedish", "Swedish");
		communication_languagesList.put("Hindi", "Hindi");
		return communication_languagesList;
	}

}
