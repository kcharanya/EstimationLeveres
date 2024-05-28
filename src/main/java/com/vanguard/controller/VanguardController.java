package com.vanguard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vanguard.exception.SummaryAlreadyExistsException;
import com.vanguard.model.OutputSumsDTO;
import com.vanguard.model.PodAssumptionsInput;
import com.vanguard.model.ProductFamily;
import com.vanguard.model.Summary;
import com.vanguard.model.Vanguard3A;
import com.vanguard.model.Vanguard3B;
import com.vanguard.model.Vanguard3C;
import com.vanguard.service.ServiceImpl;

@Controller
@RequestMapping("/vanguard")
public class VanguardController {

	@Autowired
	public ServiceImpl service;

	@GetMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	@GetMapping("/displaypodassumptions")
	public ModelAndView displayPodAssumptionsPage() {
		ModelAndView mView = new ModelAndView();
		PodAssumptionsInput podInput = service.getAssumptionsInputs().get(0);
		mView.addObject("podInput", podInput );
		mView.setViewName("displaypod");
		return mView;
		
	}

	@GetMapping("/podassumptions")
	public ModelAndView getPodAssumptionsPage() {
		 PodAssumptionsInput podvalues = service.getAssumptionsInputs().get(0);
		ModelAndView mView = new ModelAndView();
		mView.addObject("podvalues", podvalues);
		mView.setViewName("podassumptions");
		
		return mView ;
	}

	@PostMapping("/podassumptionsinput")
	public ModelAndView podassumptionsinput(

			@RequestParam(value = "firstName") Double firstName,

			@RequestParam(value = "secondName") Double secondName,

			@RequestParam(value = "thirdName") Double thirdName,

			@RequestParam(value = "fourthName") Double fourthName,

			@RequestParam(value = "fifthName") Double fifthName,

			@RequestParam(value = "sixthName") Double sixthName,

			@RequestParam(value = "seventhName") Double seventhName,

			@RequestParam(value = "eightName") Double eightName,

			@RequestParam(value = "ninthName") Double ninthName,

			@RequestParam(value = "tenName") Double tenName) {
		PodAssumptionsInput podInput = new PodAssumptionsInput("Shrs",firstName , secondName, thirdName, fourthName, fifthName, sixthName, seventhName, eightName, ninthName, tenName);
		
		service.savePodAssumptions(podInput);
		ModelAndView mView = new ModelAndView();
		mView.addObject("podInput", podInput );
		mView.setViewName("displaypod");
		
		
		return mView;
	}

	@GetMapping("/estimationlevers")
	public String getEstimationLevers() {
		return "estimationlevers";
	}
	
	public String productFamily;
	
	@PostMapping("/estimationleverinput")
	public ModelAndView postestimationleverinput(@RequestParam("prodfamily") String prodfamily) {
		ModelAndView mView = new ModelAndView();
		service.saveProductFamily(new ProductFamily(prodfamily));
		productFamily = prodfamily;
		List<ProductFamily> prodFamilies = service.getProductFamilies();
		mView.addObject("prodFamilies", prodFamilies);
		mView.setViewName("estimationleversdropdown");
		return mView;

	}
	
	
	
	@PostMapping("/productfamilyinput")
	public ModelAndView postProductFamilyChoice(@RequestParam("Choice") String Choice) {
		ModelAndView mView = new ModelAndView();
		productFamily = Choice;
		mView.setViewName("redirect:/vanguard/tables");
		return mView;
	}
	

	

	@GetMapping("/tables")
	public String getTables() {
		return "tables";
	}

	@PostMapping("/tablechoice")
	public String tableChoiceProcess(@RequestParam("Choice") String Choice) {
		switch (Choice) {
		case "3A":
			return "redirect:/vanguard/table3a";
		case "3B":
			return "redirect:/vanguard/table3b";
		case "3C":
			return "redirect:/vanguard/table3c";
		default:
			return "redirect:/vanguard/error";
		}
	}

	@GetMapping("/table3a")
	public String getTable3a() {
		return "table3a";
	}

	Summary gSummary = null;

	@PostMapping("/input3a")
	public ModelAndView input3aprocess(@RequestParam(value = "tablesValue") Integer tablesValue,
			@RequestParam(value = "producerJobsValue") Integer producerJobsValue,
			@RequestParam(value = "consumerJobsValue") Integer consumerJobsValue,
			@RequestParam(value = "producerSrValue") Integer producerSrValue,
			@RequestParam(value = "consumerSrValue") Integer consumerSrValue,
			@RequestParam(value = "producerSpValue") Integer producerSpValue,
			@RequestParam(value = "consumerSpValue") Integer consumerSpValue) {
		i=0;
		int fifthname = service.fetchPodAssumption5();
		
		Map<String, Integer> map = new HashMap<>();
		map.put("#Tables", tablesValue);
		map.put("#Jobs", producerJobsValue);
		map.put("#SP's", producerSpValue);
		map.put("#SR's", producerSrValue);
		OutputSumsDTO output3a = service.updateAndFetchSums3A(map);
		Summary summary3A = new Summary();
		summary3A.setImpactAnlaysis(output3a.getiAsum());
		summary3A.setJobs(output3a.getJobSum());
		summary3A.setProductFamily(productFamily);
		summary3A.setSp(output3a.getSPSum());
		summary3A.setSr(output3a.getSRSum());
		summary3A.setTableName("3A");
		summary3A.setTsp(output3a.getiAsum()+output3a.getJobSum()+output3a.getSPSum()+output3a.getSRSum());
		summary3A.setNps(summary3A.getTsp()/fifthname);
		gSummary = summary3A;
		ModelAndView mView = new ModelAndView();
		mView.addObject("output3a", output3a);
		OutputSumsDTO output3b = new OutputSumsDTO(0, 0, 0, 0);
		OutputSumsDTO output3c = new OutputSumsDTO(0, 0, 0, 0);
//		Summary summary3B = new Summary(0, productFamily, "3B", 0, 0, 0, 0);
//		Summary summary3C = new Summary(0, productFamily, "3C", 0, 0, 0, 0);
		/// Saving to summary repo
//		service.saveSummary(summary3A);

		mView.addObject("output3b", output3b);
		System.out.println(output3b);
		mView.addObject("output3c", output3c);
		System.out.println(output3b);
		List<Vanguard3A> list3A = service.get3ATable();
		System.out.println(list3A);
		mView.addObject("list3A", list3A);
		mView.setViewName("display3a");
		
		
		mView.addObject("fifthname", fifthname);
		System.out.println(fifthname);
	
		return mView;

	}

	@GetMapping("/table3b")
	public String getTable3b() {
		return "table3b";
	}

	@PostMapping("/input3b")
	public ModelAndView input3bprocess(@RequestParam(value = "tablesValue") Integer tablesValue,
			@RequestParam(value = "jobsValue") Integer jobsValue, @RequestParam(value = "srValue") Integer srValue,
			@RequestParam(value = "spValue") Integer spValue, @RequestParam(value = "joblocValue") Integer joblocValue,
			@RequestParam(value = "srcobolValue") Integer srcobolValue,
			@RequestParam(value = "srjavaValue") Integer srjavaValue,
			@RequestParam(value = "spjavaValue") Integer spjavaValue,
			@RequestParam(value = "spcobolValue") Integer spcobolValue,
			@RequestParam(value = "easytrieveValue") Integer easytrieveValue)

	{
		i=0;
		int fifthname = service.fetchPodAssumption5();
		Map<String, Integer> map = new HashMap<>();
		map.put("#Tables", tablesValue);
		map.put("#Jobs", jobsValue);
		map.put("#LOC", spValue);
		map.put("#LOCCSR", srcobolValue);
		map.put("#LOCJSR", srjavaValue);
		map.put("#LOCCSP", spcobolValue);
		map.put("#LOCJSP", spjavaValue);
		OutputSumsDTO output3b = service.updateAndFetchSums3B(map);
		Summary summary3B = new Summary();
		summary3B.setImpactAnlaysis(output3b.getiAsum());
		summary3B.setJobs(output3b.getJobSum());
		summary3B.setProductFamily(productFamily);
		summary3B.setSp(output3b.getSPSum());
		summary3B.setSr(output3b.getSRSum());
		summary3B.setTableName("3B");
		summary3B.setTsp(output3b.getJobSum()+output3b.getSPSum()+output3b.getSRSum());
		summary3B.setNps(summary3B.getTsp()/fifthname);
		gSummary = summary3B;
		// service.saveSummary(summary3B);

		ModelAndView mView = new ModelAndView();
		mView.addObject("output3b", output3b);

		OutputSumsDTO output3a = new OutputSumsDTO(0, 0, 0, 0);
		OutputSumsDTO output3c = new OutputSumsDTO(0, 0, 0, 0);
		mView.addObject("output3a", output3a);
		mView.addObject("output3c", output3c);

		List<Vanguard3B> list3B = service.get3BTable();
		mView.addObject("list3B", list3B);
		mView.setViewName("display3b");
		
		mView.addObject("fifthname", fifthname);
		return mView;
	}

	@GetMapping("/table3c")
	public String getTable3c() {
		return "table3c";
	}
int i;
	@PostMapping("/input3c")
	public ModelAndView input3cprocess(@RequestParam(value = "tablesValue") Integer tablesValue,
			@RequestParam(value = "totaljobsValue") Integer totaljobsValue,
			@RequestParam(value = "srValue") Integer srValue, @RequestParam(value = "spValue") Integer spValue,
			@RequestParam(value = "cjobsValue") Integer cjobsValue)

	{
		
		i=0;
		int fifthname = service.fetchPodAssumption5();
		Map<String, Integer> map = new HashMap<>();
		map.put("#Tables", tablesValue);
		map.put("#C Jobs", cjobsValue);
		map.put("#Total Jobs", totaljobsValue);
		map.put("#SP's", spValue);
		map.put("#SR's", srValue);

		OutputSumsDTO output3c = service.updateAndFetchSums3C(map);
		Summary summary3C = new Summary();
		summary3C.setImpactAnlaysis(output3c.getiAsum());
		summary3C.setJobs(output3c.getJobSum());
		summary3C.setProductFamily(productFamily);
		summary3C.setSp(output3c.getSPSum());
		summary3C.setSr(output3c.getSRSum());
		summary3C.setTableName("3C");
		summary3C.setTsp(output3c.getJobSum()+output3c.getSPSum()+output3c.getSRSum());
		summary3C.setNps(summary3C.getTsp()/fifthname);
		gSummary = summary3C;
//		service.saveSummary(summary3C);
		ModelAndView mView = new ModelAndView();
		mView.addObject("output3c", output3c);

		OutputSumsDTO output3a = new OutputSumsDTO(0, 0, 0, 0);
		OutputSumsDTO output3b = new OutputSumsDTO(0, 0, 0, 0);

		mView.addObject("output3a", output3a);
		mView.addObject("output3b", output3b);
		

		List<Vanguard3C> list3C = service.get3CTable();
		mView.addObject("list3C", list3C);
		mView.setViewName("display3c");
		
		mView.addObject("fifthname", fifthname);
		return mView;
	}

	@GetMapping("/summary")
	public ModelAndView getSummaryPage(@RequestParam Map<String, String> formData) {
		ModelAndView mView = new ModelAndView();
		boolean confirmUpdate = Boolean.parseBoolean(formData.get("confirmUpdate"));

//		System.out.println("***************************************************************");
//		System.out.println(confirmUpdate);
//		System.out.println(gSummary);
		
		if(i==0) {
			try {
				service.saveSummary(gSummary, Boolean.TRUE.equals(confirmUpdate));
			} catch (SummaryAlreadyExistsException e) {
				mView.addObject("message", e);
				System.out.println(e);
				System.out.println("Exception raised");
			}
			gSummary = null;
			i++;
		}
		

		
		mView.setViewName("summary");
		List<Summary> summaryList = service.getSummaryList();
		mView.addObject("summaryList", summaryList);
		return mView;

	}
}
