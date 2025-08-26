import java.util.Objects;

public class usuario {
    private String nome;
    private String email;
    private String senha;

    public usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public String getnome(){
        return nome;
    }

    public void setNome(String nome) {
        if(nome.isEmpty()){ // tratamento de erro p retur vazio
            System.out.println("erro, campo vazio");
        }else{
            this.nome = nome;
        }
    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        if (email.isEmpty()) {
            System.out.println("erro, campo vazio");
        } else {
            this.email = email;
        }
    }

    @Override
    public String toString() {
        return "usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        usuario usuario = (usuario) o;
        return Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, senha);
    }
}
