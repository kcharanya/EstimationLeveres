package com.vanguard.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.vanguard.exception.SummaryAlreadyExistsException;
import com.vanguard.model.OutputSumsDTO;
import com.vanguard.model.PodAssumptions;
import com.vanguard.model.PodAssumptionsInput;
import com.vanguard.model.ProductFamily;
import com.vanguard.model.Summary;
import com.vanguard.model.Vanguard3A;
import com.vanguard.model.Vanguard3B;
import com.vanguard.model.Vanguard3C;
import com.vanguard.repository.PodRepository;
import com.vanguard.repository.ProductFamilyRepository;
import com.vanguard.repository.SummaryRepository;
import com.vanguard.repository.jpaRepository3A;
import com.vanguard.repository.jpaRepository3B;
import com.vanguard.repository.jpaRepository3C;

@Service
public class ServiceImpl {
	@Autowired
	private jpaRepository3A rep3A;
	@Autowired
	private SummaryRepository sumrepo;
	@Autowired
	private PodRepository podrepo;
	@Autowired
	private ProductFamilyRepository familyrepo;

	public List<Vanguard3A> get3ATable() {
		return rep3A.findAll();
	}

	public double IASum3A() {

		return rep3A.iAsum();

	}

	public double JobSum3A() {
		return rep3A.jobSum();

	}

	public double SRSum3A() {
		return rep3A.SRSum();
	}

	public double SPSum3A() {
		return rep3A.SPSum();
	}

	@Autowired
	private jpaRepository3B rep3B;

	public List<Vanguard3B> get3BTable() {
		return rep3B.findAll();

	}

	public double JobSum3B() {
		return rep3B.jobSum();
	}

	public double SRSum3B() {
		return rep3B.SRSum();
	}

	public double SPSum3B() {
		return rep3B.SPSum();
	}

	@Autowired
	private jpaRepository3C rep3C;

	public List<Vanguard3C> get3CTable() {
		return rep3C.findAll();
	}

	public double JobSum3C() {
		return rep3C.jobSum();
	}

	public double SRSum3C() {
		return rep3C.SRSum();
	}

	public double SPSum3C() {
		return rep3C.SPSum();
	}

	@Transactional
	public OutputSumsDTO updateAndFetchSums3A(Map<String, Integer> values) {
		for (Map.Entry<String, Integer> entry : values.entrySet()) {
			rep3A.updateValue(entry.getKey(), entry.getValue());
		}

		double iAsum = rep3A.iAsum();
		double jobSum = rep3A.jobSum();
		double SRSum = rep3A.SRSum();
		double SPSum = rep3A.SPSum();

		return new OutputSumsDTO(iAsum, jobSum, SRSum, SPSum);
	}

	@Transactional
	public OutputSumsDTO updateAndFetchSums3B(Map<String, Integer> values) {
		for (Map.Entry<String, Integer> entry : values.entrySet()) {
			rep3B.updateValue(entry.getKey(), entry.getValue());
		}

		double iAsum = 0.0;
		double jobSum = rep3B.jobSum();
		double SRSum = rep3B.SRSum();
		double SPSum = rep3B.SPSum();

		return new OutputSumsDTO(iAsum, jobSum, SRSum, SPSum);
	}

	@Transactional
	public OutputSumsDTO updateAndFetchSums3C(Map<String, Integer> values) {
		for (Map.Entry<String, Integer> entry : values.entrySet()) {
			rep3C.updateValue(entry.getKey(), entry.getValue());
		}

		double iAsum = 0.0;
		double jobSum = rep3C.jobSum();
		double SRSum = rep3C.SRSum();
		double SPSum = rep3C.SPSum();

		return new OutputSumsDTO(iAsum, jobSum, SRSum, SPSum);
	}
  
	
	public List<Summary> getSummaryList() {
		List<Summary> sList = sumrepo.findAll();
		return sList;
	}
	
	
	@Transactional
	public void saveSummary(Summary summary, boolean confirmUpdate) throws SummaryAlreadyExistsException {
		List<Summary> checkList = sumrepo.findByProductFamilyAndTableNameAndImpactAnlaysisAndJobsAndSrAndSp(summary.getProductFamily(), summary.getTableName(), summary.getImpactAnlaysis(), summary.getJobs(), summary.getSr(), summary.getSp());
		System.out.println(summary);
		System.out.println(checkList);
		if(checkList.isEmpty()) {
			sumrepo.save(summary);
			if(!confirmUpdate) {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
		}else {
			throw new SummaryAlreadyExistsException("Summary already Exists!!");
		}
		
		
				
	}
	
	public void savePodAssumptions(PodAssumptionsInput podAssumptionsInput) {
		podrepo.save(podAssumptionsInput);
	}
	
	
	public List<PodAssumptionsInput> getAssumptionsInputs(){
		List<PodAssumptionsInput> all = podrepo.findAll();
		return all;
		
	}
	
	public void saveProductFamily(ProductFamily prodFamily) {
		familyrepo.save(prodFamily);
	}
	
	
	public List<ProductFamily> getProductFamilies(){
		List<ProductFamily> all = familyrepo.findAll();
		return all;
		
	}
	

	
	public int fetchPodAssumption5() {
		return podrepo.fetchPodAssumption5().get(0);
	}
	
	
}
