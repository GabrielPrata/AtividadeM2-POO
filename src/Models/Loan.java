package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Loan<T extends Item> {
    private int Id;
    private Date LoanDate;
    private Date LoanDevolution;
    private List<Book> Books = new ArrayList<>();
    private List<Magazine> Magazines = new ArrayList<>();
    private List<Disk> Disks = new ArrayList<>();
    private boolean Active;
    private User User;

    // Construtores
    public Loan(int id, Date loanDate, Date loanDevolution, boolean active, User user, List<Book> books, List<Magazine> magazines, List<Disk> disk) {
        Id = id;
        LoanDate = loanDate;
        LoanDevolution = loanDevolution;
        Active = active;
        User = user;
        Disks = disk;
        Books = books;
        Magazines = magazines;
    }

    // Outros métodos
    public void addBook(Book book) {
        Books.add(book);
    }

    public void removeBook(Book book){
        Books.remove(book);
    }

     public void addMagazine(Magazine magazine) {
        Magazines.add(magazine);
    }

    public void removeMagazine(Magazine magazine){
        Magazines.remove(magazine);
    }

     public void addDisk(Disk disk) {
        Disks.add(disk);
    }

    public void removeBook(Disk disk){
        Disks.remove(disk);
    }

    public void listLoanBooks(){
        for(Book book : Books){
            System.out.println("Livros:");
            System.out.println("Nome - " + book.getName());
        }
    }

    public void listLoanMagazines(){
        for(Magazine magazine : Magazines){
            System.out.println("Revistas:");
            System.out.println("Nome - " + magazine.getName());
        }
    }

    public void listLoanDisks(){
        for(Disk disk : Disks){
            System.out.println("Discos:");
            System.out.println("Nome - " + disk.getName());
        }
    }

    public void extendDeadLine(Date date){
        LoanDevolution = date;
    }

    public void verifyDeadLine(){
        Date actualDate = new Date(System.currentTimeMillis());
        if (LoanDevolution == actualDate) {
            System.out.println("Este empréstimo irá vencer hoje!");
        }
    }


    // Getters and Setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getLoanDate() {
        return LoanDate;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public void setLoanDate(Date loanDate) {
        LoanDate = loanDate;
    }

    public Date getLoanDevolution() {
        return LoanDevolution;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public void setLoanDevolution(Date loanDevolution) {
        LoanDevolution = loanDevolution;
    }

}
