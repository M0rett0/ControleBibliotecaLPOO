import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.InputMismatchException;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //leitura e print de AUtores ta certo kkkk
        System.out.println("Digite o nome do autor:");
        String nomeAutor = scanner.nextLine();

        System.out.println("Digite o email do autor:");
        String emailAutor = scanner.nextLine();

        System.out.println("Digite a instituição do autor:");
        String instituicaoAutor = scanner.nextLine();
        System.out.println();

        Autor autor = new Autor("Colleen Hoover", emailAutor, instituicaoAutor);
        Autor autor2 = new Autor("Agatha Christie", emailAutor, instituicaoAutor);
        Autor autor3 = new Autor("Dan Brown", emailAutor, instituicaoAutor);
        Autor autor4 = new Autor("Stephen King", emailAutor, instituicaoAutor);
        Autor autor5 = new Autor("John Green", emailAutor, instituicaoAutor);
        Autor autor6 = new Autor("Ali Hazelwood", emailAutor, instituicaoAutor);
        Autor autor7 = new Autor("Emily Henry", emailAutor, instituicaoAutor);
        Autor autor8 = new Autor("Julia Quinn", emailAutor, instituicaoAutor);
        Autor autor9 = new Autor("Kiera Cass", emailAutor, instituicaoAutor);
        Autor autor10 = new Autor("Matt Haig", emailAutor, instituicaoAutor);
        Autor autor11 = new Autor("Daniel Kahneman", emailAutor, instituicaoAutor);
        Autor autor12 = new Autor("Rachel Renée Russell", emailAutor, instituicaoAutor);
        
        //leitura do livro fisico
        System.out.println("Digite o título do livro:");
        String tituloLivro = scanner.nextLine();

        System.out.println("Digite o ISBN do livro:");
        String isbnLivro = scanner.nextLine();

        double precoLivro = 0.0;
        boolean precoValido = false;

        // Leitura do preço do livro com validação
        while (!precoValido) {
            try {
                System.out.println("Digite o preço do livro:");
                precoLivro = scanner.nextDouble();
                scanner.nextLine(); // Consumir a quebra de linha
                precoValido = true;
            } catch (Exception e) {
                System.out.println("Formato inválido. Digite um número válido para o preço.");
                scanner.nextLine(); // Consumir a entrada inválida
            }
        }

        LivroFisico livro = new LivroFisico("Diário de uma garota nada popular", "442568", 60);
        LivroFisico livro2 = new LivroFisico("Diário de um banana" , "0098765", 65);
        LivroFisico livro3 = new LivroFisico("O mistério do capiongo" , "5552627", 30.98);
        LivroFisico livro4 = new LivroFisico("Rápido e devagar" , "5421599", 40.44);
        LivroFisico livro5 = new LivroFisico("Capitães de areia" , "00021333", 65);
        LivroFisico livro6 = new LivroFisico("O diário de Anne Frank" , "0098765", 23.05);
        System.out.println();


        // Leitura dos dados do ebook
        System.out.println("Digite o título do ebook:");
        String tituloEbook = scanner.nextLine();

        System.out.println("Digite o ISBN do ebook:");
        String isbnEbook = scanner.nextLine();
        
        precoValido = false;
        while (!precoValido) {
            try {
                System.out.println("Digite o preço do ebook:");
                precoLivro = scanner.nextDouble();
                scanner.nextLine(); // Consumir a quebra de linha
                precoValido = true;
            } catch (Exception e) {
                System.out.println("Formato inválido. Digite um número válido para o preço.");
                scanner.nextLine(); // Consumir a entrada inválida
            }
        }

        Ebook ebook = new Ebook("Quente como o inferno", "973244343", 15.01);
        Ebook ebook2 = new Ebook("A luz por trás da escuridão", "44326561", 25);
        Ebook ebook3 = new Ebook("Croissant de chocolate", "55552323", 31.20);
        Ebook ebook4 = new Ebook("Aurora e o fim de tarde", "71736512", 29.99);
        Ebook ebook5 = new Ebook("The Crown", "009712", 19.98);
        Ebook ebook6 = new Ebook("Pecados capitais", "127847343", 16.87);
        System.out.println();



        Orcamento pedido = new Orcamento();
        pedido.adicionarLivro(livro);
        pedido.adicionarLivro(ebook);

        

        //criando objeto biblioteca
        Biblioteca biblio = new Biblioteca();
        biblio.adicionarLivro(livro);
        biblio.adicionarLivro(livro2);
        biblio.adicionarLivro(livro3);
        biblio.adicionarLivro(livro4);
        biblio.adicionarLivro(livro5);
        biblio.adicionarLivro(livro6);

        biblio.adicionarLivro(ebook);
        biblio.adicionarLivro(ebook2);
        biblio.adicionarLivro(ebook3);
        biblio.adicionarLivro(ebook4);
        biblio.adicionarLivro(ebook5);
        biblio.adicionarLivro(ebook6);

        biblio.emprestarLivro(ebook);
        biblio.emprestarLivro(ebook2);
        biblio.emprestarLivro(ebook3);
        biblio.emprestarLivro(ebook4);
        biblio.emprestarLivro(ebook5);
        biblio.emprestarLivro(ebook6);

        biblio.emprestarLivro(livro);
        biblio.emprestarLivro(livro2);
        biblio.emprestarLivro(livro3);
        biblio.emprestarLivro(livro4);
        biblio.emprestarLivro(livro5);
        biblio.emprestarLivro(livro6);

        biblio.devolverLivro(ebook);
        biblio.devolverLivro(ebook2);
        biblio.devolverLivro(ebook3);
        biblio.devolverLivro(ebook4);
        biblio.devolverLivro(ebook5);
        biblio.devolverLivro(ebook6);

        //System.out.println(autor);
        //System.out.println(livro);
        //System.out.println(ebook);

        //Listando todos os livros da biblioteca + os emprestados
        biblio.imprimirLivros();
        
        //Listando lista de pedido + preço total final
        pedido.listarPedidos();

        //Fim do uso do Scanner
        scanner.close();
    }
        // usar laco for pros inputs da silva
        // 12 autores
        // 6 livros
        // 6 ebooks
        // 3 pedidos de compras

}


interface Valida { //declarando interface Valida
    boolean validarEmail (String email);
}

interface Compra { // declarando interface Compra
    double calcularPreco();
}

class Autor implements Valida {

    Scanner scanner = new Scanner(System.in);

    private static final String EMAIL_PATTERN =
    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    private String nome;
    private String email;
    private String instituicao;

    // Construtor de Autor
    public Autor(String nome, String email, String instituicao) {
        this.nome = nome;
        this.instituicao = instituicao;

        // Validar o email fornecido inicialmente
        if (validarEmail(email)) {
            this.email = email;
        } else {
            System.out.println("Email inválido. Por favor, forneça um novo email:");
            String novoEmail = scanner.next();

            // Loop para solicitar um novo email até que seja válido
            while (!validarEmail(novoEmail)) {
                System.out.println("Email inválido. Por favor, forneça um novo email:");
                novoEmail = scanner.next();
            }

            this.email = novoEmail;
        }

    }

    // Método para validar email (implementação da interface Valida)
    @Override
    public boolean validarEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Método toString da classe Autor
    @Override
    public String toString() {
        return "Autor:\nNome: " + nome + "\nEmail: " + email + "\nInstituição: " + instituicao;
    }
}

abstract class Livro implements Comparable<Object> {

    //declarando os atributos de Livro
    protected String titulo;
    protected String isbn;
    protected ArrayList<Autor> autores;

    // metodo construtor de Livro
    public Livro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autores = new ArrayList<>(); // iniciando a arraylist
    }

    //metodo para adicionar autor na array autores
    public void adicionarAutor(Autor autor) {
        this.autores.add(autor);
    }

    public abstract double getPreco();

    @Override
    public int compareTo(Livro outroLivro) {
        return this.titulo.compareTo(outroLivro.titulo);
    }

    public String getTitulo() {
        return titulo;
    }

}

class LivroFisico extends Livro {

    private double preco;

    // metodo construtor de LivroFisico
    public LivroFisico(String titulo, String isbn, double preco) {
        super(titulo, isbn);
        this.preco = preco;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    protected double getPreco() {
        return this.preco;
    }

    @Override
    public int compareTo(Livro outroLivro) {
        return this.titulo.compareTo(outroLivro.titulo);
    }
    
    @Override
    public String toString() {
        return "Livro fisico\nTitulo: "+this.titulo+"\nISBN: "+this.isbn+"\nPreco: "+this.getPreco()+"\n";
    }
}

class Ebook extends Livro {

    private double preco;

    // metodo construtor de Ebook
    public Ebook(String titulo, String isbn, double preco) {
        super(titulo, isbn);
        this.preco = preco;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    protected double getPreco() {
        return this.preco;
    }

    @Override
    public int compareTo(Ebook outroLivro) {
        return this.titulo.compareTo(outroLivro.titulo);
    }

    @Override
    public String toString() {
        return "Livro digital (Ebook)\nTitulo: "+this.titulo+"\nISBN: "+this.isbn+"\nPreco: "+this.getPreco()+"\n";
    }
}

class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Livro> emprestados;

    // metodo construtor Biblioteca
    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.emprestados = new ArrayList<>();
    }

    public void adicionarLivro(Livro novoLivro) {
        this.livros.add(novoLivro);
        // adicionar livro na array de livro
    }

    public void emprestarLivro(Livro livro) {
        // Se o livro a ser emprestado existe no ArrayList livros
        //  e o livro ainda não foi adicionado ao ArrayList emprestados,
        //  então adicione o livro no ArrayList emprestados.
        if (this.livros.contains(livro)) {
            if (!this.emprestados.contains(livro)) {
                this.emprestados.add(livro);
                System.out.println("Livro emprestado com sucesso!\n");
            } else {
                System.out.println("Livro já está emprestado!\n");
            }
        } else {
            System.out.println("Livro não encontrado na biblioteca.\n");
        }
    }

    public void devolverLivro(Livro livro) {
        // Se o livro a ser devolvido existe no ArrayList emprestados,
        //  então remova o livro do ArrayList emprestados.
        if (this.emprestados.contains(livro)) {
            emprestados.remove(livro);
            System.out.println("Livro devolvido com sucesso!\n");
        } else {
            System.out.println("Livro não foi emprestado, portanto não pode ser devolvido.\n");
        }
    }

    public void imprimirLivros() {

        Collections.sort(livros, Comparator.comparing(Livro::getTitulo));

        
        if (livros.isEmpty()) {
            System.out.println("Não há livros disponíveis.");
        } else {
            System.out.println("Livros disponiveis na biblioteca:");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
            System.out.println();
        }
        if (emprestados.isEmpty()) {
            System.out.println("Não há livros emprestados!");
            System.out.println();
        } else {
            System.out.println("Livros emprestados:");
            for (Livro livro : emprestados) {
                System.out.println(livro);
            }
            System.out.println();
        }
    }


}

class Orcamento implements Compra {

    private ArrayList<Livro> pedido;

    // metodo construtor Orçamento
    public Orcamento() {
        this.pedido = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        pedido.add(livro);
        // permite adicionar livros no ArrayList pedido
    }

    public double calcularPreco() {
        // Calcula o valor total dos livros do Pedido        
        double precoTotal = 0.0;
        for (Livro livro : pedido) {
            precoTotal += livro.getPreco();
        }
        return precoTotal;
    }

    public void listarPedidos() {
        // Lista todos os livros do Pedido e imprime o valor 
        System.out.println("Lista de pedido de livros:");
        for(Livro livro : pedido) {
            System.out.println(livro);
        }
        // total do pedido com a chamada do método calcularPreco().
        System.out.println("Preco total do pedido: "+ calcularPreco());
        System.out.println();
    }
}