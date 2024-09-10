package com.capg.payment_wallet_application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.payment_wallet_application.beans.BeneficiaryDetails;
import com.capg.payment_wallet_application.dto.BeneficiaryDetailsDTO;
import com.capg.payment_wallet_application.service.IBeneficiaryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pwa/BenifiaciaryDetails")
public class BeneficiaryDetailsController {

	@Autowired
	private IBeneficiaryService beneficiaryService;

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	/* Author       : Madhuri
	*  Description  : This method add beneficiary 
	*  Input Params : Beneficiary Details
	*  Return value : BeneficiaryDTO object
	*/
	@PostMapping(value = "/add", consumes = "application/json")
	public BeneficiaryDetailsDTO addBeneficiary(@RequestBody BeneficiaryDetails bd) {
		logger.info("Beneficiary details added sucessfully");
		return beneficiaryService.addBeneficiary(bd);
	}

	/* Author       : Madhuri
	*  Description  : This method update beneficiary 
	*  Input Params : Beneficiary Details
	*  Return value : BeneficiaryDTO object
	*/
	@PutMapping("/updateAccount")
	public BeneficiaryDetailsDTO updateBeneficiary(@RequestBody BeneficiaryDetails bd) {
		logger.info("Beneficiary Details Updated sucessfully");
		return beneficiaryService.updateBeneficiary(bd);
	}

	/* Author       : Madhuri
	*  Description  : This method delete beneficiary 
	*  Input Params : Beneficiary Details
	*  Return value : BeneficiaryDTO object
	*/
	@DeleteMapping("/delete")
	public ResponseEntity<String>  deleteBeneficiary(@RequestBody BeneficiaryDetails bd) {
		 logger.info("Beneficiary Details deleted sucessfully");
		 String response =beneficiaryService.deleteBeneficiary(bd);
		 return new ResponseEntity<>(response, HttpStatus.OK);
	}
	/* Author       : Madhuri
	*  Description  : This method is used to view beneficiary through mobile number 
	*  Input Params : String 
	*  Return value : BeneficiaryDTO object
	*/
	@GetMapping("/viewbeneficiary/{mobileNo}")
	public BeneficiaryDetailsDTO viewBeneficiary(@PathVariable String mobileNo) {
		logger.info("Details Of particular beneficary is displayed sucessfully");
		return beneficiaryService.viewBeneficiary(mobileNo);		
	}
	/* Author       : Madhuri
	*  Description  : This method used to viewall Beneficiary of particular WalletID 
	*  Input Params : int WalletID
	*  Return value : BeneficiaryDTO List
	*/
	@GetMapping("/view-all-beneficiary/{walletId}")
	public List<BeneficiaryDetailsDTO> viewAllBeneficiary(@PathVariable int walletId) {
		logger.info("Beneficiary of particular wallet is displayed sucessfully");
		return beneficiaryService.viewAllBeneficiary(walletId);
	}

}
