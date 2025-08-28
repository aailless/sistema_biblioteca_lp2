import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private usuario usuario;
    private LocalDate dataEmprestimo;

    public Emprestimo(Livro livro, usuario usuario, LocalDate dataEmprestimo){
        this.livro = Livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
}
