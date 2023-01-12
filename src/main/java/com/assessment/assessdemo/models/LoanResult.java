package com.assessment.assessdemo.models;

public class LoanResult extends Loan {
    
    private String borrower;

    private String bookName;

    private String statusName;

    private String createdDate_view;

    private String updatedDate_view;

    public String getCreatedDate_view() {
        return createdDate_view;
    }

    public void setCreatedDate_view(String createdDate_view) {
        this.createdDate_view = createdDate_view;
    }

    public String getUpdatedDate_view() {
        return updatedDate_view;
    }

    public void setUpdatedDate_view(String updatedDate_view) {
        this.updatedDate_view = updatedDate_view;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
