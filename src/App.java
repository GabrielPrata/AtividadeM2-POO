import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Models.Author;
import Models.Book;
import Models.Disk;
import Models.Loan;
import Models.Magazine;
import Models.PublishingCompany;
import Models.User;
import Models.Recorder;
import Enums.Gender;

public class App {
    // Como não possuo nenhuma base de dados para salvar as informações, irei salvar
    // os dados em listas
    static List<User> Users = new ArrayList<>();
    static List<Author> Authors = new ArrayList<>();
    static List<Recorder> Recorders = new ArrayList();
    static List<PublishingCompany> Publishers = new ArrayList<>();
    static List<Book> Books = new ArrayList<>();
    static List<Magazine> Magazines = new ArrayList<>();
    static List<Disk> Disks = new ArrayList<>();
    static List<Loan> Loans = new ArrayList();

    // Variáveis de controle do sistema
    static Scanner scanner = new Scanner(System.in);
    static boolean error = false;

    static boolean menuCollection = true;
    static boolean menuUser = true;
    static boolean menuParams = true;
    static boolean menuLoan = true;

    public static void main(String[] args) throws Exception {
        System.out.println("Bem vindo ao gerenciamento da biblioteca!");
        System.out.println("Faça a autenticação no sistema para prosseguir, digite seu nome:");

        String userName = scanner.nextLine();

        System.out.println("Olá " + userName + "! O que deseja fazer agora?");

        boolean menu = true;

        while (menu) {
            System.out.println("1 - Acessar o acervo da biblioteca.");
            System.out.println("2 - Acessar os usuários do sistema.");
            System.out.println("3 - Acessar empréstimos");
            System.out.println("4 - Gerenciar demais parâmetros do sistema.");
            System.out.println("5 - Sair");
            System.out.print("Digite um número referente a uma das opções acima: ");
            int menuOption = scanner.nextInt();

            if (menuOption == 1) {
                menuCollection = true;
                collectionFunctions();
            } else if (menuOption == 2) {
                menuUser = true;
                userFunctions();
            } else if (menuOption == 3) {
                menuLoan = true;
                loanFunctions();
            } else if (menuOption == 4) {
                menuParams = true;
                paramsFunctions();
            } else if (menuOption == 5) {
                menu = false;
            } else {
                System.out.println("Opção inválida!");
            }
        }

    }

    private static void collectionFunctions() {
        System.out.println("------------------------------------------");
        while (menuCollection) {
            System.out.println("1 - Listar itens do acervo");
            System.out.println("2 - Cadastrar um novo item");
            System.out.println("3 - Excluir um item");
            System.out.println("4 - Voltar");

            int collectionOption = scanner.nextInt();
            if (collectionOption == 1) {
                listCollection();
            } else if (collectionOption == 2) {
                registerItem();
            } else if (collectionOption == 3) {
                deleteItem();
            } else if (collectionOption == 4) {
                menuCollection = false;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    private static void listCollection() {
        if (!Books.isEmpty()) {
            System.out.println("Livros do acervo:");
            for (Book book : Books) {
                System.out.println("Id: " + book.getId());
                System.out.println("Nome: " + book.getName());
                System.out.println("Data de publicação: " + book.getPublishedBy());

                System.out.println("Gênero: ");
                verifyGender(book.getGender());

                System.out.println("Data de cadastro no sistema: " + book.getDateSystemInput());
                System.out.println("Número de páginas" + book.getPages());
            }
        } else {
            System.out.println("Não há livros cadastrados no sistema.");
        }

        if (!Magazines.isEmpty()) {
            System.out.println("Revistas do acervo:");
            for (Magazine magazine : Magazines) {
                System.out.println("Id: " + magazine.getId());
                System.out.println("Nome: " + magazine.getName());
                System.out.println("Data de publicação: " + magazine.getPublishedBy());

                System.out.println("Gênero: ");
                verifyGender(magazine.getGender());

                System.out.println("Data de cadastro no sistema: " + magazine.getDateSystemInput());
                System.out.println("Número de páginas" + magazine.getPages());
                System.out.println("Número da edição: " + magazine.getEdition());
            }
        } else {
            System.out.println("Não há revistas cadastrados no sistema.");
        }

        if (!Disks.isEmpty()) {
            System.out.println("Discos do acervo:");
            for (Disk disk : Disks) {
                System.out.println("Id: " + disk.getId());
                System.out.println("Nome: " + disk.getName());

                System.out.println("Gênero: ");
                verifyGender(disk.getGender());

                System.out.println("Data de cadastro no sistema: " + disk.getDateSystemInput());
                System.out.println("Duração em minutos: " + disk.getDuration());
                System.out.println("Gravadora: " + disk.getRecorder());
            }
        } else {
            System.out.println("Não há discos cadastrados no sistema.");
        }

        System.out.println("------------------------------------------");
    }

    private static void registerItem() {
        System.out.println("O que você deseja adicionar ao acervo da biblioteca?");
        System.out.println("1 - Livro");
        System.out.println("2 - Revista");
        System.out.println("3 - Disco");
        System.out.println("4 - Menu anterior");
        System.out.print("Digite um número referente a uma das opções acima: ");
        int optionRegisterItem = scanner.nextInt();

        Date entryDate = new Date(System.currentTimeMillis());

        System.out.print("Nome: ");
        String name = scanner.next();

        System.out.print("Data de publicação (MM-dd-yyyy): ");
        String dateString = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

        Date publishDate = null;
        try {
            publishDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Certifique-se de usar o formato MM-dd-yyyy.");
            error = true;
        }

        System.out.println("Gênero:");
        Gender gender = null;
        boolean genderControl = true;

        while (genderControl) {
            System.out.println("1 - Comédia");
            System.out.println("2 - Romance");
            System.out.println("3 - Terror");
            System.out.println("4 - Drama");
            System.out.println("5 - Aventura");
            System.out.println("6 - Acao");
            System.out.println("7 - Sci-Fi");

            System.out.print("Digite um número referente a uma das opções acima: ");
            int value = scanner.nextInt();

            if (value > 7 || value < 1) {
                System.out.println("Escolha uma opção válida!");
            } else {
                gender = numberToGender(value);
                genderControl = false;
            }
        }

        if (optionRegisterItem == 1 && error == false) {
            System.out.print("Quantidade de páginas: ");
            int pages = scanner.nextInt();

            System.out.println("Autor:");
            Author author = null;
            if (!Authors.isEmpty()) {
                author = setAuthor();
            } else {
                System.out.println("Não há autores cadastrados no sistema.\nCadastre ao menos um para prosseguir.");
                error = true;
            }

            PublishingCompany publisher = null;
            if (!error) {
                System.out.println("Editora:");
                if (!Publishers.isEmpty()) {
                    publisher = setPublisher();

                } else {
                    System.out
                            .println("Não há editoras cadastradas no sistema.\nCadastre ao menos uma para prosseguir.");
                    error = true;
                }
            }
            int id = Books.size() + 1;
            if (!error) {
                Books.add(new Book(pages, author, publisher, id, name, entryDate, publishDate, gender));
                System.out.println("Livro cadastrado com sucesso!");
            } else {
                System.out.println("Ocorreu algum erro ao cadastrar o livro, verifique o log.");
            }
        } else if (optionRegisterItem == 2 && error == false) {
            System.out.print("Quantidade de páginas: ");
            int pages = scanner.nextInt();

            System.out.print("Número da edição: ");
            int edition = scanner.nextInt();

            System.out.println("Editora:");
            PublishingCompany publisher = null;

            if (!Publishers.isEmpty()) {
                publisher = setPublisher();
            } else {
                System.out
                        .println("Não há editoras cadastradas no sistema.\nCadastre ao menos uma para prosseguir.");
                error = true;
            }

            int id = Magazines.size() + 1;
            if (!error) {
                Magazines.add(new Magazine(pages, edition, publisher, id, name, entryDate, publishDate, gender));
                System.out.println("Revista cadastrada com sucesso!");
            } else {
                System.out.println("Ocorreu algum erro ao cadastrar a revista, verifique o log.");
            }
        } else if (optionRegisterItem == 3 && error == false) {
            System.out.print("Duração (em minutos): ");
            int duration = scanner.nextInt();

            System.out.println("Gravadora:");
            Recorder recorder = null;

            if (!Recorders.isEmpty()) {
                recorder = setRecorder();
            } else {
                System.out
                        .println("Não há gravadoras cadastradas no sistema.\nCadastre ao menos uma para prosseguir.");
                error = true;
            }

            int id = Disks.size() + 1;
            if (!error) {
                Disks.add(new Disk(duration, recorder, id, name, entryDate, publishDate, gender));
                System.out.println("Disco cadastrado com sucesso!");
            } else {
                System.out.println("Ocorreu algum erro ao cadastrar o disco, verifique o log.");
            }
        } else if (optionRegisterItem == 4) {
            menuCollection = false;
        } else {
            System.out.println("Opção inválida");
        }
        System.out.println("------------------------------------------------------");

    }

    private static void deleteItem() {
        System.out.println("O que você deseja deletar do acervo da biblioteca?");
        System.out.println("1 - Livro");
        System.out.println("2 - Revista");
        System.out.println("3 - Disco");
        System.out.print("Digite um número referente a uma das opções acima: ");
        int optionDeleteItem = scanner.nextInt();

        if (optionDeleteItem == 1) {
            if (!Books.isEmpty()) {
                listBooks();
                System.out.print("Digite o número referente ao livro que deseja deletar: ");
                int idBook = scanner.nextInt();

                Book book = searchBook(idBook);

                if (book != null) {
                    Books.remove(book);
                } else {
                    System.out.println("Livro inválido!");
                }
            } else {
                System.out.println("Não há livros cadastrados no sistema!");
            }
            System.out.println("-----------------------------------------------");
        } else if (optionDeleteItem == 2) {
            if (!Magazines.isEmpty()) {
                listMagazines();
                System.out.print("Digite o número referente a revista que deseja deletar: ");
                int idMagazine = scanner.nextInt();

                Magazine magazine = searchMagazine(idMagazine);

                if (magazine != null) {
                    Magazines.remove(magazine);
                } else {
                    System.out.println("Revista inválido!");
                }
            } else {
                System.out.println("Não há revistas cadastradas no sistema!");
            }
            System.out.println("-----------------------------------------------");
        } else if (optionDeleteItem == 3) {
            if (!Disks.isEmpty()) {
                listDisks();
                System.out.print("Digite o número referente a revista que deseja deletar: ");
                int idDisk = scanner.nextInt();

                Disk disk = searchDisk(idDisk);

                if (disk != null) {
                    Disks.remove(disk);
                } else {
                    System.out.println("Disco inválido!");
                }
            } else {
                System.out.println("Não há discos cadastrados no sistema!");
            }
            System.out.println("-----------------------------------------------");
        } else if (optionDeleteItem == 4) {
            menuCollection = false;
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void userFunctions() {
        System.out.println("------------------------------------------");
        while (menuUser) {
            System.out.println("1 - Listar usuários");
            System.out.println("2 - Cadastrar novo usuário");
            System.out.println("3 - Voltar");
            int userOption = scanner.nextInt();

            if (userOption == 1) {
                listUsers();
            } else if (userOption == 2) {
                registerNewUser();
            } else if (userOption == 3) {
                menuUser = false;
            } else {
                System.out.println("Opção inválida!");
            }
        }

    }

    private static void paramsFunctions() {
        System.out.println("------------------------------------------");
        while (menuParams) {
            System.out.println("1 - Cadastrar Autor");
            System.out.println("2 - Cadastrar Editora");
            System.out.println("3 - Cadastrar gravadora");
            System.out.println("4 - Voltar");
            if (scanner.hasNextInt()) {
                int paramsOption = scanner.nextInt();

                if (paramsOption == 1) {
                    registerAuthor();
                } else if (paramsOption == 2) {
                    registerPublishCompany();
                } else if (paramsOption == 3) {
                    registerRecorder();
                } else if (paramsOption == 4) {
                    menuParams = false;
                } else {
                    System.out.println("Opção inválida!");
                }
            } else {
                // Consume the invalid input to avoid an infinite loop
                scanner.next();
                System.out.println("Entrada inválida. Digite um número.");
            }
        }
    }

    private static void loanFunctions() {
        System.out.println("------------------------------------------");
        while (menuLoan) {
            System.out.println("1 - Novo empréstimo");
            System.out.println("2 - Listar todos os empréstimos");
            System.out.println("3 - Estender prazo");
            System.out.println("4 - Finalizar empréstimo");
            System.out.println("5 - Voltar");
            int paramsOption = scanner.nextInt();

            if (paramsOption == 1) {
                registerNewLoan();
            } else if (paramsOption == 2) {
                listLoans();
            } else if (paramsOption == 3) {
                extendLimit();
            } else if (paramsOption == 4) {
                changeLoanStatus();
            } else if (paramsOption == 5) {
                menuLoan = false;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    // Funções diversas
    private static void changeLoanStatus() {
        System.out.println("Escolha o empréstimo que deseja finalizar: ");
        listLoans();

        System.out.println("Digite o ID do empréstimo: ");
        int idLoan = scanner.nextInt();
        Loan loan = searchLoan(idLoan);

        if (loan != null) {
            loan.setActive(false);
            System.out.println("Empréstimo finalizafo!");
        } else {
            System.out.println("Empréstimo não encontrado!");
        }
    }

    private static void extendLimit() {
        System.out.println("Escolha o empréstimo que deseja extender o prazo: ");
        listLoans();

        System.out.println("Digite o ID do empréstimo: ");
        int idLoan = scanner.nextInt();
        Loan loan = searchLoan(idLoan);

        if (loan != null) {
            System.out.print("Nova Data: ");
            Date loanDate = new Date(System.currentTimeMillis());

            System.out.print("Data de devolução do empréstimo (MM-dd-yyyy): ");
            String dateString = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            Date limitDate = null;

            try {
                limitDate = dateFormat.parse(dateString);
                loan.extendDeadLine(limitDate);
                System.out.println("Prazo alterado com sucesso!");
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Certifique-se de usar o formato MM-dd-yyyy.");
                error = true;
            }
        } else {
            System.out.println("Empréstimo não encontrado!");
        }

    }

    // Funções para percorrer a "memória" do sistema
    private static void listAuthors() {
        for (Author author : Authors) {
            System.out.println(author.getId() + " - " + author.getName());
        }
    }

    private static void listPublishComp() {
        for (PublishingCompany publish : Publishers) {
            System.out.println(publish.getId() + " - " + publish.getName());
        }
    }

    private static void listRecorders() {
        for (Recorder recorder : Recorders) {
            System.out.println(recorder.getId() + " - " + recorder.getName());
        }
    }

    private static void listBooks() {
        for (Book book : Books) {
            System.out.println(book.getId() + " - " + book.getName());
        }
    }

    private static void listMagazines() {
        for (Magazine magazine : Magazines) {
            System.out.println(magazine.getId() + " - " + magazine.getName());
        }
    }

    private static void listDisks() {
        for (Disk disk : Disks) {
            System.out.println(disk.getId() + " - " + disk.getName());
        }
    }

    private static void listLoans() {
        for (Loan loan : Loans) {
            System.out
                    .println(loan.getId() + " - " + loan.getUser().getName() + "(Id: " + loan.getUser().getId() + ")");
            System.out.println("Data do empréstimo: " + loan.getLoanDate());
            System.out.println("Data de devolução: " + loan.getLoanDevolution());

            if (loan.isActive()) {
                System.out.println("Empréstimo ativo");
            } else {
                System.out.println("Empréstimo finalizado");
            }
            loan.verifyDeadLine();
            System.out.println("Itens do empréstimo:");
            loan.listLoanBooks();
            loan.listLoanMagazines();
            loan.listLoanDisks();
        }
    }

    private static void listUsers() {
        if (!Users.isEmpty()) {
            for (User user : Users) {
                System.out.println("Id - " + user.getId());
                System.out.println("CPF - " + user.getCPF());
                System.out.println("Nome - " + user.getName());
                if (user.getActiveLoan()) {
                    Loan activeLoan = user.searchActiveLoan();
                    user.listActiveLoan();
                    System.out.println("Itens do Empréstimo - ");
                    activeLoan.listLoanBooks();
                    activeLoan.listLoanMagazines();
                    activeLoan.listLoanDisks();
                    activeLoan.verifyDeadLine();
                } else {
                    System.out.println("Não há empréstimos ativos para este usuário");
                }
                if (user.getLoanHistory() != null) {
                    System.out.println("Histórico de empréstimos: ");
                    user.listLoanHistory();
                } else {
                    System.out.println("Este usuário ainda não fez nenhum empréstimo");
                }
            }
        }else {
            System.out.println("Não há usuários cadastrados no sistema");
        }

    }

    public static void registerNewUser() {
        System.out.print("Insira o nome do usuário: ");
        String name = scanner.next();

        System.out.print("Insira CPF nome do usuário: ");
        String cpf = scanner.next();

        int id = Users.size() + 1;

        Users.add(new User(id, cpf, name));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public static void registerAuthor() {
        System.out.println("Insira o nome do autor: ");
        String name = scanner.next();

        int id = Authors.size() + 1;

        Authors.add(new Author(id, name));
        System.out.println("Autor cadastrado com sucesso!");
    }

    public static void registerPublishCompany() {
        System.out.println("Insira o nome da editora: ");
        String name = scanner.next();

        int id = Publishers.size() + 1;

        Publishers.add(new PublishingCompany(id, name));
        System.out.println("Editora cadastrado com sucesso!");
    }

    public static void registerRecorder() {
        System.out.println("Insira o nome da gravadora: ");
        String name = scanner.next();

        int id = Recorders.size() + 1;

        Recorders.add(new Recorder(id, name));
        System.out.println("Gravadora cadastrado com sucesso!");
    }

    public static void registerNewLoan() {
        System.out.println("Escolha o usuário que irá fazer o empréstimo: ");
        listUsers();

        System.out.print("Insira o ID do usuário: ");
        int userId = scanner.nextInt();

        User loanUser = searchUser(userId);

        boolean insertControl = true;
        List<Book> loanBooks = new ArrayList<>();
        List<Magazine> loanMags = new ArrayList<>();
        List<Disk> loanDisks = new ArrayList<>();

        while (insertControl) {
            System.out.println("O que deseja adicionar ao empéstimo?");
            System.out.println("1 - Livro");
            System.out.println("2 - Revista");
            System.out.println("3 - Disco");
            System.out.println("4 - Finalizar");

            int controlOption = scanner.nextInt();

            if (controlOption == 1) {
                System.out.println("Escolha o livro que deseja adicionar: ");
                listBooks();
                System.out.print("Digite o ID do livro que deseja adicionar: ");

                int bookId = scanner.nextInt();
                Book insertBook = searchBook(bookId);

                if (insertBook != null) {
                    loanBooks.add(insertBook);
                    System.out.println("Livro adicionado ao empréstimo!");
                } else {
                    System.out.println("Livro não encontrado!");
                }

            } else if (controlOption == 2) {
                System.out.println("Escolha a revista que deseja adicionar: ");
                listMagazines();
                System.out.print("Digite o ID da revista que deseja adicionar: ");

                int magId = scanner.nextInt();
                Magazine insertMag = searchMagazine(magId);

                if (insertMag != null) {
                    loanMags.add(insertMag);
                    System.out.println("Revista adicionada ao empréstimo!");
                } else {
                    System.out.println("Revista não encontrada!");
                }

            } else if (controlOption == 3) {
                System.out.println("Escolha o disco que deseja adicionar: ");
                listDisks();
                System.out.print("Digite o ID do disco que deseja adicionar: ");

                int diskId = scanner.nextInt();
                Disk insertDisk = searchDisk(diskId);

                if (insertDisk != null) {
                    loanDisks.add(insertDisk);
                    System.out.println("Disco adicionado ao empréstimo!");
                } else {
                    System.out.println("Disco não encontrado!");
                }

            } else if (controlOption == 4) {
                insertControl = false;
            } else {
                System.out.print("Opção Inválida!");
            }
        }

        Date loanDate = new Date(System.currentTimeMillis());

        System.out.print("Data de devolução do empréstimo (MM-dd-yyyy): ");
        String dateString = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date limitDate = null;

        try {
            limitDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Certifique-se de usar o formato MM-dd-yyyy.");
            error = true;
        }
        int loanId = Loans.size() + 1;
        Loans.add(new Loan(loanId, loanDate, limitDate, true, loanUser, loanBooks, loanMags, loanDisks));
        System.out.println("Empréstimo finalizado com sucesso!");
    }

    // Busca por autores, editoras e gravadoras
    private static Author searchAuthor(int id) {
        for (Author author : Authors) {
            if (author.getId() == id)
                return author;
        }
        return null;
    }

    private static PublishingCompany searchPublisher(int id) {
        for (PublishingCompany publish : Publishers) {
            if (publish.getId() == id)
                return publish;
        }
        return null;
    }

    private static Recorder searchRecorder(int id) {
        for (Recorder rec : Recorders) {
            if (rec.getId() == id)
                return rec;
        }
        return null;
    }

    private static Book searchBook(int id) {
        for (Book book : Books) {
            if (book.getId() == id)
                return book;
        }
        return null;
    }

    private static Magazine searchMagazine(int id) {
        for (Magazine magazine : Magazines) {
            if (magazine.getId() == id)
                return magazine;
        }
        return null;
    }

    private static Disk searchDisk(int id) {
        for (Disk disk : Disks) {
            if (disk.getId() == id)
                return disk;
        }
        return null;
    }

    private static User searchUser(int id) {
        for (User user : Users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    private static Loan searchLoan(int id) {
        for (Loan loan : Loans) {
            if (loan.getId() == id)
                return loan;
        }
        return null;
    }

    // Funções para instanciar os objetos Author, PublisherCompany e Recorder com
    // base em um objeto já existente
    private static Author setAuthor() {
        boolean control = true;
        Author author = null;
        while (control) {
            listAuthors();
            int id = scanner.nextInt();
            author = searchAuthor(id);
            if (author != null) {
                control = false;
            } else {
                System.out.println("Autor inválido!");
            }
        }
        return author;
    }

    private static PublishingCompany setPublisher() {
        boolean control = true;
        PublishingCompany publisher = null;
        while (control) {
            listPublishComp();
            int id = scanner.nextInt();
            publisher = searchPublisher(id);
            if (publisher != null) {
                control = false;
            } else {
                System.out.println("Editora inválida!");
            }
        }
        return publisher;
    }

    private static Recorder setRecorder() {
        boolean control = true;
        Recorder recorder = null;
        while (control) {
            listRecorders();
            int id = scanner.nextInt();
            recorder = searchRecorder(id);
            if (recorder != null) {
                control = false;
            } else {
                System.out.println("Gravadora inválida!");
            }
        }
        return recorder;
    }

    private static Gender numberToGender(int value) {
        switch (value) {
            case 1:
                return Gender.COMEDIA;

            case 2:
                return Gender.ROMANCE;

            case 3:
                return Gender.TERROR;

            case 4:
                return Gender.DRAMA;

            case 5:
                return Gender.AVENTURA;

            case 6:
                return Gender.ACAO;

            case 7:
                return Gender.SCIFI;
        }
        return null;
    }

    private static void verifyGender(Gender gender) {
        switch (gender) {
            case COMEDIA:
                System.out.println("Comédia");
                break;

            case ROMANCE:
                System.out.println("Romance");
                break;

            case TERROR:
                System.out.println("Terror");
                break;

            case DRAMA:
                System.out.println("Drama");
                break;

            case AVENTURA:
                System.out.println("Aventura");
                break;

            case ACAO:
                System.out.println("Ação");
                break;

            case SCIFI:
                System.out.println("Sci-Fi");
                break;

            default:
                System.out.println("Gênero não definido (Livro não binarie)");
        }
    }
}
