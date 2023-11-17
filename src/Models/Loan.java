package Models;

import java.time.LocalDate;
import java.util.List;

public class Loan {
    private int Id;
    private LocalDate LoanDate;
    private LocalDate LoanDevolution;
    private List<Item> Itens;

    //Construtores
    public Loan(int id, LocalDate loanDate, LocalDate loanDevolution) {
        Id = id;
        LoanDate = loanDate;
        LoanDevolution = loanDevolution;
    }
    
    //Getters and Setters
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public LocalDate getLoanDate() {
        return LoanDate;
    }
    public void setLoanDate(LocalDate loanDate) {
        LoanDate = loanDate;
    }
    public LocalDate getLoanDevolution() {
        return LoanDevolution;
    }
    public void setLoanDevolution(LocalDate loanDevolution) {
        LoanDevolution = loanDevolution;
    }

    
}
