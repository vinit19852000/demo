package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.BankAccount;
import com.example.demo.Entity.PaymentMode;
import com.example.demo.Entity.Transaction;
import com.example.demo.Repo.BankAccountRepository;
import com.example.demo.Repo.PaymentModeRepository;
import com.example.demo.Repo.TransactionRepository;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private BankAccountRepository accountRepository;

    @Autowired
    private PaymentModeRepository paymentModeRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public BankAccount createAccount(BankAccount account) {
    	
        return accountRepository.save(account);
    }
    
    public List<BankAccount> alluser(){
    	
    	return accountRepository.findAll();
    }

    public PaymentMode addPaymentMode(Long accountId, PaymentMode paymentMode) {
        BankAccount account = accountRepository.findById(accountId).orElseThrow();
        paymentMode.setAccount(account);
        return paymentModeRepository.save(paymentMode);
    }

    public Transaction sendMoney(Long senderAccountId, Long receiverAccountId, double amount, String description) {
        BankAccount sender = accountRepository.findById(senderAccountId).orElseThrow();
        BankAccount receiver = accountRepository.findById(receiverAccountId).orElseThrow();

        if (sender.getBalance() >= amount) {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);

            accountRepository.save(sender);
            accountRepository.save(receiver);

            Transaction transaction = new Transaction();
            transaction.setTransactionId("TXN" + System.currentTimeMillis());
            transaction.setAmount(amount);
            transaction.setDescription(description);
            transaction.setAccount(sender);

            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Insufficient Balance");
        }
    }

    public double checkBalance(Long accountId) {
        BankAccount account = accountRepository.findById(accountId).orElseThrow();
        return account.getBalance();
    }

    public List<Transaction> getTransactionHistory(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
