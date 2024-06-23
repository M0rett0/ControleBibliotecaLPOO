import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.InputMismatchException;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    //vamo fgazer essa porra desse trabalho
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

        Autor autor = new Autor(nomeAutor, emailAutor, instituicaoAutor);
        
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

        LivroFisico livro = new LivroFisico(tituloLivro, isbnLivro, precoLivro);
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

        Ebook ebook = new Ebook(tituloEbook, isbnEbook, precoLivro);
        System.out.println();

        Orcamento pedido = new Orcamento();
        pedido.adicionarLivro(livro);
        pedido.adicionarLivro(ebook);

        

        //criando objeto biblioteca
        Biblioteca biblio = new Biblioteca();
        biblio.adicionarLivro(livro);
        biblio.adicionarLivro(ebook);
        biblio.emprestarLivro(ebook);
        biblio.emprestarLivro(livro);
        biblio.devolverLivro(ebook);

        //System.out.println(autor);
        //System.out.println(livro);
        //System.out.println(ebook);

        //funcoes q a prof pediu
        biblio.imprimirLivros();
        
        //listando todos os pedidos
        pedido.listarPedidos();


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

    public LivroFisico(String titulo, String isbn, double preco) {
        super(titulo, isbn);
        this.preco = preco;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public double getPreco() {
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

    public Ebook(String titulo, String isbn, double preco) {
        super(titulo, isbn);
        this.preco = preco;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public double getPreco() {
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

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.emprestados = new ArrayList<>();
    }

    public void adicionarLivro(Livro novoLivro) {
        this.livros.add(novoLivro);
        // adicionar livro na array de livro
    }

    public void emprestarLivro(Livro livro) {
        if (this.livros.contains(livro)) {
            if (!this.emprestados.contains(livro)) {
                this.emprestados.add(livro);
                System.out.println("Livro emprestado com sucesso!");
                System.out.println();
            } else {
                System.out.println("Livro já está emprestado!");
                System.out.println();
            }
        } else {
            System.out.println("Livro não encontrado na biblioteca.");
            System.out.println();
        }
        // Se o livro a ser emprestado existe no ArrayList livros
        //  e o livro ainda não foi adicionado ao ArrayList emprestados,
        //  então adicione o livro no ArrayList emprestados.
    }

    public void devolverLivro(Livro livro) {

        if (this.emprestados.contains(livro)) {
            emprestados.remove(livro);
            System.out.println("Livro devolvido com sucesso!");
            System.out.println();
        } else {
            System.out.println("Livro não foi emprestado, portanto não pode ser devolvido.");
            System.out.println();
        }
        // Se o livro a ser devolvido existe no ArrayList emprestados,
        //  então remova o livro do ArrayList emprestados.
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
            System.out.println("Livros já emprestados:");
            for (Livro livro : emprestados) {
                System.out.println(livro);
            }
            System.out.println();
        }
    }


}

class Orcamento implements Compra {

    private ArrayList<Livro> pedido;

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
        System.out.println("Lista de livros no pedido:");
        for(Livro livro : pedido) {
            System.out.println(livro);
        }
        System.out.println("Preco total do pedido: "+ calcularPreco());
        System.out.println();
        // Lista todos os livros do Pedido e imprime o valor 
        // total do pedido com a chamada do método calcularPreco().
    }
}