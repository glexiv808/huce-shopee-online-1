package com.huce.shopee_online.entities;

import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
@Document(collection = "orders")
public class Order {
    @Id
    private  Long id;

    @Transient
    public static final String
            SEQUENCE_NAME = "order_sequence";



    private String cusName;

    private String cusPhone;
    private String cusEmail;

    private String cusAddress;


    private double totalBill;

    private List<Product> productList;

    private Date createdDate;

    public Order() {
    }

    public Order(Long id, String cusName, String cusPhone, String cusEmail, String cusAddress, double totalBill, List<Product> productList, Date createdDate, int status) {
        this.id = id;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusEmail = cusEmail;
        this.cusAddress = cusAddress;
        this.totalBill = totalBill;
        this.productList = productList;
        this.createdDate = createdDate;
        this.status = status;
    }

    private int status ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
