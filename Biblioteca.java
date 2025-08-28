import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Biblioteca {
    private List<Livro> acervo; // declaraçao do acervo
    private List<usuario> user;
    private List<Emprestimo> registroDeEmprestimos; // sao os atributos da class biblioteca

    public Biblioteca () {
        this.acervo = new ArrayList<>();//instanciação
        this.user = new ArrayList<>();
        this.registroDeEmprestimos = new ArrayList<>();
    }
    public void realizarEmpestimos (String nome, String livro) {

    }
    public usuario pesquisarUsuarioPornome(String nome){
            for (usuario usuario : this.user) {
                if (usuario.getNome().equals(nome)) {
                    return nome;
                }

                public Livro pesquisarLivroPorTitulo (String titulo){
                    for (Livro livro : this.acervo) { // laço p percorrer a lista de livros : acervo
                        // if(livro.getTitulo().toLowerCase().equals(titulo.toLowerCase())) // colocar tudo minusculo
                        if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                            return livro;
                        }
                    }
                    return null;
                }
                //2- validar se ta disp o nao
                //3- realizar o registro
            }
    }
    public List<Livro> pesquisarLivroPorTermo(String termo){
        List<Livro>listaDeLivros = new ArrayList<>();
        for(var livro : acervo){
            if(livro.getTitulo().toLowerCase().contains(termo.toLowerCase())){
                listaDeLivros.add(livro);
            }
        }
    }
    public void listarAcervo(){
        System.out.println("Livros no Acervo");
        for (Livro livro: acervo){
            System.out.println(livro);
        }
    }



    public void cadastrarLivro (Livro livro){ // metodos = funçoes
        this.acervo.add(livro);
        System.out.println("livro cadastrado");
    }
    public void cadastrarusuario (usuario usuario ){
        this.user.add(usuario);
        System.out.println("o usuario" + usuario.getnome() + "foi cadastrado");
    }
    public usuario pesquisarUsuarioPorEmail(String email){
        for(usuario user: this.user){
            if(user.getEmail().equalsIgnoreCase(email)){
                return user;
            }
        }
        return null;
    }
    public void realizarEmprestimo( String tituloLivro, String emailUsuario){ // p buscar o livro e o usuario
        Livro livro = pesquisarLivroPorTitulo(tituloLivro);
        usuario user = pesquisarUsuarioPorEmail(emailUsuario);

    if(livro == null){
        System.out.println("erro, este livro nao foi encontrado");
        return;
    }
    if (user == null){
        System.out.println("erro, esse usuario nao foi encontrado");
    }
    if(livro.isDisponivel()){ // p verificar se o livro esta disponivel no acervo
        livro.emprestimo();
        user.adicionarLivro(livro);
        System.out.println("empréstimo realizado com sucesso");
        System.out.println("o livro" +livro.getTitulo()+ "foi emprestado para:" +user.getnome());
    }else{
        System.out.println("erro, este livro nao esta disponivel para emprestimo");
    }
    }

    public static void main(String [] args){
       Livro livroJavaComoProgramar = new Livro("java como programar", "Ane Aile",2025);
       Livro livroJavaPOO = new Livro("java,programação orientada a objetos","carol",2000);//Livro l1 representa o objeto l1 que vai ser criado na class Livro
       usuario meuUsuario =  new usuario("ane", "aailless", "123"); // identifica a classe(usuario) define o nome do obj (meuUsuario)
       Biblioteca minhabiblioteca = new Biblioteca();

       minhabiblioteca.cadastrarLivro(livroJavaComoProgramar);
       minhabiblioteca.cadastrarLivro(livroJavaPOO);
       minhabiblioteca.cadastrarusuario(meuUsuario);
       List<Livro> resultado = minhabiblioteca.pesquisarLivroPorTermo("Java");
       for(var livro : resultado){
           System.out.println("livros encontrados");
           System.out.println(livro);
       }

       usuario user1 = new usuario("ryan", "rryann", "231");
       usuario user2 = new usuario("pedro", "pedrro", "321");
       System.out.println("o usuario1 e o usuario2 sao iguais?" +user1.equals(user2));
    }
}
