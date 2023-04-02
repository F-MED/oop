import java.util.ArrayList;

public class Livro {
    private String isbn;
    private String titulo;
    private int ano;

    private ArrayList<Autor> autores;

    public Livro(String isbn) {
        this.isbn = isbn;
        autores = new ArrayList<>();
    }

    public Livro(String isbn, String titulo, int ano) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.ano = ano;
        autores = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Livro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", ano=" + ano +
                '}';
    }

    public boolean adicionaAutor(Autor autor){
        return autores.add(autor);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }
}
