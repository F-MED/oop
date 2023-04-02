import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;

    public Biblioteca(){
        livros = new ArrayList<>();
    }

    //metodos obrigatorios
    public boolean cadastraLivro(Livro livro){
        for(Livro livroAux:livros){
            if(livro.getIsbn().equals(livroAux.getIsbn()))return false;
        }
        return livros.add(livro);
    }

    public Livro pesquisaLivro(String isbn){
        for(Livro livro: livros){
            if(livro.getIsbn().equals(isbn))return livro;
        }
        return null;
    }

    //metodos extras
    public int quantideLivro(){
        return livros.size();
    }
    public boolean adicionaAutor(String isbn, Autor autor){
        int count=0;
        for(Livro livro:livros){
            if(livro.getIsbn().equals(isbn)) {
                ArrayList<Autor> aux = livro.getAutores();
                for (Autor autores : aux) {
                    if (autores.getCodigo() == autor.getCodigo()) count++;
                }
                if (count == 0) return livro.adicionaAutor(autor);
            }
        }
        return false;
    }

    public ArrayList<Livro> livroAutores(){
        ArrayList<Livro> aux = new ArrayList<>();
        for (Livro livro:livros){
            if(livro.getAutores().size()>1)aux.add(livro);
        }
        return aux;
    }

    public ArrayList<Livro> getLivrosAutor(int codigoAutor){
        ArrayList<Livro> aux = new ArrayList<>();
        for(Livro livro:livros){
            ArrayList<Autor> autores = livro.getAutores();
            for(Autor autor: autores){
                if(autor.getCodigo()==codigoAutor)aux.add(livro);
            }
        }
        return aux;
    }

    public ArrayList<Livro> procuraLivroAno(int ano){
        ArrayList<Livro> aux = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAno() == ano) aux.add(livro);
        }
        return aux;
    }

}
