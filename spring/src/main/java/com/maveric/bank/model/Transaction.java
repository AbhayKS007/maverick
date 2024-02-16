package com.maveric.bank.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int transactionId;

    private String type;

    private int amount;

    private String createdAt;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = Instant.now().toString();
    }
}
