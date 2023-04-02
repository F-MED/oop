import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ACMEpublishing {
    private Scanner in;

    public ACMEpublishing() {
        in = new Scanner(System.in);
        try {
            BufferedReader streamIn = new BufferedReader(new FileReader("dados.txt"));
            in = new Scanner(streamIn);
            PrintStream streamSaida = new PrintStream(new File("saida.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);
        } catch (Exception e) {
            System.out.println(e);
        }
        in.useLocale(Locale.ENGLISH);

    }

    public void executar(){
        String isbn;
        Biblioteca biblioteca = new Biblioteca();
        Grupo grupo = new Grupo();
        do{
            isbn = in.next();
            in.nextLine();
            if(isbn.equals("-1"))break;
            String titulo = in.nextLine();
            int ano = in.nextInt();
            Livro aux = new Livro(isbn,titulo,ano);

            boolean adicionaLivro = biblioteca.cadastraLivro(aux);
            if(adicionaLivro) System.out.println("1;"+aux.getIsbn()+';'+aux.getTitulo()+';'+aux.getAno());
        }while (true);

        System.out.println("2;"+biblioteca.quantideLivro());

        int codigo;
        do{
            codigo = in.nextInt();
            if(codigo==-1)break;
            in.nextLine();
            String nome = in.nextLine();
            String isbn2 = in.nextLine();
            Livro aux = new Livro(isbn2);
            biblioteca.cadastraLivro(aux);
            Autor autorAux = new Autor(codigo,nome,aux);
            boolean adicionaAutor = grupo.cadastraAutor(autorAux);
            if(adicionaAutor){
                biblioteca.adicionaAutor(isbn2,autorAux);
                System.out.println("3;" + codigo + ';' + nome + ';' + isbn2);
            }
        }while(true);

        System.out.println("4;"+grupo.quantidadeAutores());

        do{
            codigo = in.nextInt();
            in.nextLine();
            if(codigo==-1)break;
            isbn = in.nextLine();
            Autor autor = grupo.pesquisaAutor(codigo);
            if(autor!=null) {
                boolean adicionaAutor = biblioteca.adicionaAutor(isbn, autor);
                if (adicionaAutor)
                    autor.adicionaLivro(biblioteca.pesquisaLivro(isbn));
                System.out.println("5;" + autor.getCodigo() + ';' + autor.getNome() + ';' + isbn + ';' + biblioteca.pesquisaLivro(isbn).getTitulo());
            }
        }while(true);

        codigo = in.nextInt();
        ArrayList<Livro> livro = biblioteca.getLivrosAutor(codigo);

        for (Livro livroAux : livro) {
            System.out.println("6;" + codigo + ';' + grupo.pesquisaAutor(codigo).getNome() + ';' + livroAux.getIsbn() + ';' + livroAux.getTitulo() + ';' + livroAux.getAno());
        }
        in.nextLine();
        isbn = in.nextLine();
        ArrayList<Autor> autores = biblioteca.pesquisaLivro(isbn).getAutores();
        System.out.print("7;"+isbn+';');
        for (Autor autore : autores) {
            System.out.print(';' + autore.getNome());
        }
        System.out.println();
        livro = biblioteca.livroAutores();
        for (Livro value : livro) {
            System.out.println("8;" + value.getIsbn() + ';' + value.getTitulo());
        }

        ArrayList<Autor> aux = grupo.autorLivros();
        for(Autor autor: aux){
            System.out.print("9;" + autor.getNome());
            ArrayList<Livro> livros = autor.getLivro();
            for(Livro livroAux:livros){
                System.out.print(';' + livroAux.getIsbn());
            }
        }
        System.out.println();
        int ano = in.nextInt();
        livro = biblioteca.procuraLivroAno(ano);
        for (Livro livroAux : livro) {
            System.out.println("10;" + livroAux.getIsbn() + ';' + livroAux.getTitulo() + ';' + livroAux.getAno());
        }

    }
}