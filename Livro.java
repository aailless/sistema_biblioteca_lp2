import java.sql.SQLOutput;

public class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private StatusLivro status;

    public Livro(String titulo, String autor, int ano){ //this usa no atributo da classe, e recebe o parametro da função
        setTitulo(titulo);
        setAutor(autor);
        setAno(ano);
        this.status= StatusLivro.DISPONIVEL;
    }

    public StatusLivro getStatus() {
        return status;
    }

    public void setStatus (StatusLivro status) {
        this.status = status;
    }

    public int getAno() {

        return ano;
    }
    public void setAno(int ano) {
        int ano_atual = 2025;
        if ( ano > ano_atual){
            System.out.println("erro ano invalido");
        }else {
            this.ano= ano;
        }
    }
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {

        if (autor == ""){
            System.out.println("erro autor invalido");
        }else {
            this.autor = autor;
        }

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == ""){
            System.out.println("erro titulo invalido");
        }else {
            this.titulo = titulo.trim();
        }

    }

    @Override //sobrecarga de metodo, escrevendo em cima no objeto endereço de memo
    public String toString() {
        return "Livro'" + titulo + "', de" + autor + "(" + ano +") - Status:" +  status;

    }
}


