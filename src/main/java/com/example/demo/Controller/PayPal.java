package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.BankAccount;
import com.example.demo.Entity.PaymentMode;
import com.example.demo.Entity.Transaction;
import com.example.demo.Service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/paypal")
public class PayPal {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/all-active-user-list")
    public ResponseEntity<List<BankAccount>> all(){
    	
    	return ResponseEntity.ok(paymentService.alluser());
    }
    
    @GetMapping("read-about-project")
	@Order(1)
	public ResponseEntity<Object> readme(){
		
		String document="";
		
		document=document+"     STEPS    "+"\n\n\n";
		document=document+"1.I have Created Bank Operation api's For Account opening,view,update functionality"+"\n";
		document=document+"2.Then Created Docker Image for this springboot application"+"\n";
		document=document+"3.Upload the code on github"+"\n";
		document=document+"4.Deploy On render which is opensource cloud Application Hosting"+"\n";
		document=document+"5.Set Up CI-CD pipeline for automation";
		
		return ResponseEntity.ok(document);
		
	}
	
    @PostMapping("/create-account")
    public BankAccount createAccount(@RequestBody BankAccount account) {
        return paymentService.createAccount(account);
    }

    @PostMapping("/payment-mode/{accountId}")
    public PaymentMode addPaymentMode(@PathVariable Long accountId, @RequestBody PaymentMode paymentMode) {
        return paymentService.addPaymentMode(accountId, paymentMode);
    }

    @PostMapping("/send-money")
    public Transaction sendMoney(@RequestParam Long senderAccountId, @RequestParam Long receiverAccountId,
                                 @RequestParam double amount, @RequestParam String description) {
        return paymentService.sendMoney(senderAccountId, receiverAccountId, amount, description);
    }

    @GetMapping("/check-balance/{accountId}")
    public double checkBalance(@PathVariable Long accountId) {
        return paymentService.checkBalance(accountId);
    }

    @GetMapping("/transaction-history/{accountId}")
    public List<Transaction> getTransactionHistory(@PathVariable Long accountId) {
        return paymentService.getTransactionHistory(accountId);
    }
}
