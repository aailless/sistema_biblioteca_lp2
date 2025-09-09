
public class Livro extends ItemDoAcervo {
    private String autor;

    public Livro(String titulo, String autor, int ano) {
        super(titulo, ano);
        setAutor(autor);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == "") {
            System.out.println("Erro: título inválido.");
        } else {
            this.autor = autor;
        }
    }

    @Override
    public int getPrazo() {
        return 14;
    }

    @Override
    public String toString() {
        return "Livro '" + getTitulo() + "', de " + super.toString() + "Autor:" + autor + " (" + getAno() + ") - Status: " + getStatus();
    }

    @Override
    public double getMulta_Por_dia() {
        return 0.75;
    }
}