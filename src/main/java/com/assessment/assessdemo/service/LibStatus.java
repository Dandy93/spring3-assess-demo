package com.assessment.assessdemo.service;

public enum LibStatus {
    Active(1), Inactive(2), Pending(3), Available(4), NonAvailable(5), Done(6), Dued(7);

    private int val;

    LibStatus(int val) {
        this.val = val;
    }

    public int getStatus(){
        return val;
    }
}