/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.crudspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Engineer_Account
 */
@Entity
@Table(name = "student_details")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name="first_name")
    private String firstName;

    @Column(name = "branch")
    private String branch;

    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "email_id", nullable = false, length = 100)
    private String emailId;

    @Override
    public String toString() {
        return "StudentEntity [id=" + id + ", firstName=" + firstName + ", branch=\" + branch +\", lastName=" + lastName
                + ", emailId=" + emailId + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    
}
