package Models;

import java.util.List;

public class User {
    private int Id;
    private String CPF;
    private String Name;
    private Boolean ActiveLoan;
    private List<Loan> LoanHistory;

    // Contrutores
    public User(int id, String cpf, String name) {
        Id = id;
        CPF = cpf;
        Name = name;
        ActiveLoan = false;
    }

    // Outros métodos
    public void addToHistory(Loan loanItem) {
        LoanHistory.add(loanItem);
    }

    public Loan searchActiveLoan() {
        for (Loan loan : LoanHistory) {
            if (loan.isActive() == true)
                return loan;
        }
        return null;
    }

    public void listLoanHistory() {
        for (Loan loan : LoanHistory) {
            System.out.println("Empréstimo ativo:");
            System.out.println("Id - " + loan.getId());
            System.out.println("Data do empréstimo - " + loan.getLoanDate());
            System.out.println("Data de devolução - " + loan.getLoanDevolution());
        }
    }
    public void listActiveLoan() {
            System.out.println("Empréstimo ativo:");
            System.out.println("Id - " + searchActiveLoan().getId());
            System.out.println("Data do empréstimo - " + searchActiveLoan().getLoanDate());
            System.out.println("Data de devolução - " + searchActiveLoan().getLoanDevolution());
    }
    // Getters and Setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getName() {
        return Name;
    }

    public List<Loan> getLoanHistory() {
        return LoanHistory;
    }

    public void setLoanHistory(List<Loan> loanHistory) {
        LoanHistory = loanHistory;
    }

    public void setName(String name) {
        Name = name;
    }

    public Boolean getActiveLoan() {
        return ActiveLoan;
    }

    public void setActiveLoan(Boolean activeLoan) {
        ActiveLoan = activeLoan;
    }

}
