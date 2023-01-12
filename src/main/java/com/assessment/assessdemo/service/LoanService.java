package com.assessment.assessdemo.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.assessdemo.models.Book;
import com.assessment.assessdemo.models.Loan;
import com.assessment.assessdemo.models.LoanResult;
import com.assessment.assessdemo.models.Student;
import com.assessment.assessdemo.repo.BookRepo;
import com.assessment.assessdemo.repo.LoanRepo;
import com.assessment.assessdemo.repo.StudentRepo;

@Service
public class LoanService {

    @Autowired
    private LoanRepo oLoanRepo;

    @Autowired
    private BookRepo oBookRepo;

    @Autowired
    private StudentRepo oStudentRepo;
    
    @Autowired
    private Helper oHelper;
    
    private int credit = 0;
    final int rCredit = credit;

    public int getStudentCreditFromLoan(Student oStudent){
        // GET student loans in the YEAR
        ArrayList<Integer> statuses = new ArrayList<Integer>();
        statuses.add(LibStatus.Done.getStatus());
        statuses.add(LibStatus.Dued.getStatus());

        ArrayList<Integer> scores = new ArrayList<>();

        List<Loan> lLoans = oLoanRepo.getCreditsFromLoansByStudentId(oStudent.getId(), Year.now().getValue(), statuses);
        lLoans.stream().forEach(r -> {
            if(r.getStatus() == LibStatus.Done.getStatus()){
                scores.add(2);
            } else {
                scores.add(-1);
            }
        });
        
        return oHelper.countTotal(scores);
    }

    public int getStudentCreditFromLoanV2(Student oStudent){
        // GET student loans in the YEAR
        ArrayList<Integer> statuses = new ArrayList<Integer>();
        statuses.add(LibStatus.Done.getStatus());
        statuses.add(LibStatus.Dued.getStatus());

        List<Loan> lLoans = oLoanRepo.getCreditsFromLoansByStudentId(oStudent.getId(), Year.now().getValue(), statuses);
        lLoans.stream().forEach(r -> {
            if(r.getStatus() == LibStatus.Done.getStatus()){
                credit+=2;
            } else {
                credit-=1;
            }
        });
        return credit;
    }

    public List<Loan> getStudentLoans(Student oStudent){
        return oLoanRepo.getLoansByStudentId(oStudent.getId(), Year.now().getValue());
    }


    public List<LoanResult> populateLoanResultView (List<Loan> lLoans){
        ArrayList<LoanResult> lResultLoans = new ArrayList<>();
        List<Book> lBooks = oBookRepo.findAllById(lLoans.stream().map(r -> r.getBook_id()).collect(Collectors.toList()));
        List<Student> lStudents = oStudentRepo.findAllById(lLoans.stream().map(r -> r.getStudent_id()).collect(Collectors.toList()));

        for (Loan oLoan : lLoans) {
            LoanResult oLoanResult = new LoanResult();
            oLoanResult.setLoan_code(oLoan.getLoan_code());
            Book oBook = lBooks.stream().filter(r -> r.getId() == oLoan.getBook_id()).collect(Collectors.toList()).get(0);
            oLoanResult.setBookName(oBook.getName());
            Student oStudent = lStudents.stream().filter(r -> r.getId() == oLoan.getStudent_id()).collect(Collectors.toList()).get(0);
            oLoanResult.setBorrower(oStudent.getName());
            if(oLoan.getStatus() == LibStatus.Active.getStatus()){
                oLoanResult.setStatusName("Aktif");
            } else if (oLoan.getStatus() == LibStatus.Available.getStatus()) {
                oLoanResult.setStatusName("Aktif");
            } else if (oLoan.getStatus() == LibStatus.Done.getStatus()) {
                oLoanResult.setStatusName("Selesai");
            } else if (oLoan.getStatus() == LibStatus.Dued.getStatus()) {
                oLoanResult.setStatusName("Telat kembalikan");
            } else if (oLoan.getStatus() == LibStatus.Inactive.getStatus()) {
                oLoanResult.setStatusName("Tidak Aktif");
            } else if (oLoan.getStatus() == LibStatus.NonAvailable.getStatus()) {
                oLoanResult.setStatusName("Aktif");
            } else {
                oLoanResult.setStatusName("Dalam Proses");
            }
            Timestamp ts = oLoan.getDate_created();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM YYY, HH:mm");
            oLoanResult.setCreatedDate_view(dateFormat.format(ts));

            ts = oLoan.getDate_updated();
            dateFormat = new SimpleDateFormat("dd MMM YYY, HH:mm");
            oLoanResult.setUpdatedDate_view(dateFormat.format(ts));

            lResultLoans.add(oLoanResult);
        }
        return lResultLoans;
    }    
}
