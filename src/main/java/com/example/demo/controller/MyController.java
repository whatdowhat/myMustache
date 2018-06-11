package com.example.demo.controller;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Member;
import com.example.demo.domain.repository.DataTable;
import com.example.demo.domain.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MyController {

	@Autowired
	MemberRepository repository;
	
	
	
	@GetMapping("/")
	ModelAndView page() {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(MessageFormat.format("-----------{0}-------", "here!"));
		modelAndView.setViewName("welcome");
		Map<String, String> map = new HashMap<>();
		
		map.put("name", "Chris");
		map.put("company", "<b>Githug</b>");
//		
//		
		modelAndView.addObject("data",map);
		map = new HashMap<>();
		map.put("name", "Rose");
		map.put("company", "<b>Google</b>");
//		
//		
		modelAndView.addObject("data2",map);
		
		
		modelAndView.addObject("name","Chris");
		modelAndView.addObject("company","<b>Githug</b>");
		modelAndView.addObject("myList",repository.findAll());
		
		System.out.println(modelAndView.getModelMap().toString()+MessageFormat.format("-----------{0}-------", "here!"));

		//memberR.findAll().forEach(System.out::println);
		
		return modelAndView;
	}
	@RequestMapping("/reg")
	String goPage() {
		
		System.out.println("here come ");
		return "/reg/reg";
	}
	
	@RequestMapping("/create")
	String createResponse(String userId,String userPassword) {
		
		System.out.println(MessageFormat.format("-------userId----{0}---------", userId));
		System.out.println(MessageFormat.format("-------userPassword----{0}---------", userPassword));
		
		return "welcome";
	}
	
	
	@RequestMapping("/dataTable/myAjaxTable4")
	@ResponseBody 
	Map goAjax4(DataTable dataDO) throws JsonProcessingException {
		
		System.out.println("11111111111111111111111111111111");
		ObjectMapper mapper =  new ObjectMapper();
		System.out.println("11111111111111111111111111111111");
//		int param1 = (int) request.getAttribute("iDisplayStart");
//
//		System.out.println("param1 : "+param1);
		
		System.out.println("getiDisplayStart" + dataDO.getiDisplayStart());
		System.out.println("getiDisplayLength" + dataDO.getiDisplayLength());
		System.out.println("##########################################################################################");
		
		Member member = new Member();
//		System.out.println("member::"+member.toString());
		Page<Member> myPage =null;
		Optional<Member> myOptional = Optional.ofNullable(member);
		
		if(!dataDO.getsSearch().equals("")) {
			System.out.println("here");
			System.out.println("datado:"+dataDO.toString());
			System.out.println("dataDO:"+dataDO.getsSearch());
			
			System.out.println("member "+myOptional.isPresent());
			myOptional.get().setUserName(dataDO.getsSearch());
			System.out.println("memberUserName::"+myOptional.get().getUserName());
			myPage = repository.findByUserNameContaining(myOptional.get().getUserName(),(PageRequest.of(dataDO.getiDisplayStart()/dataDO.getiDisplayLength(), dataDO.getiDisplayLength())));
//			myPage = repository.findAll(PageRequest.of(dataDO.getiDisplayStart()/dataDO.getiDisplayLength(), dataDO.getiDisplayLength()));
			
		}else {
			System.out.println("else");
			myPage = repository.findAll(PageRequest.of(dataDO.getiDisplayStart()/dataDO.getiDisplayLength(), dataDO.getiDisplayLength()));
			System.out.println("here ");
		}
//		member.setUserName(dataDO.getsSearch());
		
		
		Map<String, Object> mymap = new HashMap<>(); 
		System.out.println("myData size "+myPage.getContent().size());
		List<Member> myData = myPage.getContent();
		
		long iTotalRecords  = myPage.getTotalElements();
		myData.stream().forEach(System.out::println);
		
		mymap.put("data",  myData);
		mymap.put("recordsTotal",  iTotalRecords);
		mymap.put("recordsFiltered",  iTotalRecords);
		
		
		System.out.println(mymap);

		
	return mymap;
	}
	
}
