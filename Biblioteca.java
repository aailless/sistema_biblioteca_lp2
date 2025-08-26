import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Biblioteca {
    private List<Livro> acervo; // declaraçao do acervo
    private List<usuario> user;

    public Livro pesquisarLivroPorTitulo (String titulo){
        for (Livro livro: this.acervo) { // laço p percorrwer a listade livros : acervo
           // if(livro.getTitulo().toLowerCase().equals(titulo.toLowerCase())) // colocar tudo minusculo
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                return livro;
            }
        }
        return null;
    }
    public Biblioteca (){
        this.acervo = new ArrayList<>();//instanciação
        this.user = new ArrayList<>();
    }
    public void cadastrarLivro (Livro livro){
        this.acervo.add(livro);
        System.out.println("livro cadastrado");
    }
    public void cadastrarusuario (usuario usuario ){
        System.out.println("o usuario" +usuario.getnome()"foi cadastrado");
    }


    public static void main(String [] args){
       Livro L1 = new Livro("LPII", "Ane Aile",2025);
       usuario meuUsuario =  new usuario("ane", "aailless", "123");
       Biblioteca minhabiblioteca = new Biblioteca();
       minhabiblioteca.cadastrarLivro(L1);
       Livro livroEncontrado = minhabiblioteca.pesquisarLivroPorTitulo("l1");
       System.out.println(livroEncontrado);

       usuario user1 = new usuario("ane", "aailless", "123");
       usuario user2 = new usuario("ane", "aailless", "123");
       System.out.println();
    }
}
