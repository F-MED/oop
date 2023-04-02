import java.util.ArrayList;

public class Grupo {
    private ArrayList<Autor> autores;

    public Grupo(){
        autores = new ArrayList<>();
    }

    //metodods obrigatorios
    public boolean cadastraAutor(Autor autor){
        for(Autor autorAux: autores){
            if(autor.getCodigo()==autorAux.getCodigo()) return false;
        }
        return autores.add(autor);
    }

    public Autor pesquisaAutor(int codigo){
        for(Autor autor: autores){
            if(autor.getCodigo()==codigo)return autor;
        }
        return null;
    }

    //metodos extras
    public int quantidadeAutores(){
        return autores.size();
    }

    public ArrayList<Autor> autorLivros(){
        ArrayList<Autor> aux=new ArrayList<>();
        for(Autor autor:autores){
            if(autor.getLivro().size()>1)aux.add(autor);
        }
        return aux;
    }
}
