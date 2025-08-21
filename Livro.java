import java.sql.SQLOutput;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicado;

    public Livro(String titulo, String autor, int ano){ //this usa no atributo da classe, e recebe o parametro da função
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicado = ano;
    }

    public int getAnoPublicado() {
        return anoPublicado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAno(int ano) {
        int ano_atual = 2025;
        if ( ano > ano_atual){
            System.out.println("erro ano invalido");
        }else {
            this.anoPublicado= ano;
        }
    }

    public void setTitulo(String titulo) {
        if (titulo == ""){
            System.out.println("erro titulo invalido");
        }else {
            this.titulo = titulo;
        }

    }

    @Override //sobrecarga de metodo, escrevendo em cima no objeto endereço de memo
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicado=" + anoPublicado +
                '}';
    }
}

