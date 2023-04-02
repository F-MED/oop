import java.util.ArrayList;

public class Autor {
    private int codigo;
    private String nome;
    private ArrayList<Livro> livro;

    public Autor(int codigo, String nome, Livro livro){
        this.codigo=codigo;
        this.nome=nome;
        this.livro = new ArrayList<>();
        this.livro.add(livro);
    }

    public boolean adicionaLivro(Livro livro){
        return this.livro.add(livro);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }


    public ArrayList<Livro> getLivro() {
        return livro;
    }
}
