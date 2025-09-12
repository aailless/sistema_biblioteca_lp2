//RESPOSTA DO EXERCICIO 0 : Não,  não seria possível instanciar um ItemDoAcervo diretamente no main
// pois provavelmente causaria um erro de compilação por que a classe ItemDoAcervo foi projetada para
// ser uma classe base ou classe abstrata. O propósito dela não é ser usada sozinha, mas sim definir
// as características comuns (como título e ano) que todas as subclasses, como Livro ou Revista, irão herdar.
// A maneira correta de criar um novo item seria instanciando uma das subclasses, para quecada objeto
// represente um item concreto e válido na biblioteca.
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Biblioteca {

    private List<ItemDoAcervo> acervo;
    private List<Usuario> listaDeUsuarios;
    private List<Emprestimo> registrosDeEmprestimos;
    private int PrazoEmprestimoDias = 7;
    private double ValorMultaPorDiasAtraso = 0.75;

    public List<ItemDoAcervo> buscar(String termo) {
        String termoLowerCase = termo.toLowerCase();

        List<ItemDoAcervo> resultados = new ArrayList<>();
            for (ItemDoAcervo item : this.acervo) {
                boolean corresponde = false;

                if (item.getTitulo().toLowerCase().contains(termoLowerCase)) {
                    corresponde = true;
                }
                if (item instanceof Livro) {
                    Livro livro = (Livro) item;
                    if (livro.getAutor().toLowerCase().contains(termoLowerCase)) {
                        corresponde = true;
                    }
                }
                if (corresponde) {
                    resultados.add(item);
                }
            }

            return resultados;
        }


    public Biblioteca() {
        this.acervo = new ArrayList<>();
        this.listaDeUsuarios = new ArrayList<>();
        this.registrosDeEmprestimos = new ArrayList<>();
    }

    public void realizarEmprestimo(String idUsuario, String titulo) {

        Usuario usuarioDoEmprestimo = pesquisarUsuarioPorNome(idUsuario);
        if(usuarioDoEmprestimo == null) {
            System.out.println("Erro: usuário não cadastrado.");
            return;
        }
        ItemDoAcervo ItemDoEmprestimo = pesquisarItemPorTitulo(titulo);
        if(ItemDoEmprestimo == null) {
            System.out.println("Erro: livro não cadastrado.");
            return;
        }
        if(ItemDoEmprestimo.getStatus() == StatusItem.EMPRESTADO) {
            System.out.println("Erro: livro já emprestrado.");
            return;
        }else {
            ItemDoEmprestimo.setStatus(StatusItem.EMPRESTADO);
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucaoPrevista = dataEmprestimo.plusDays(ItemDoEmprestimo.getPrazoEmprestimoDias());
            Emprestimo emprestimo = new Emprestimo(ItemDoEmprestimo, usuarioDoEmprestimo, dataEmprestimo, dataDevolucaoPrevista);
            registrosDeEmprestimos.add(emprestimo);
            System.out.println("Emprestimo realizado com sucesso!");
            System.out.println("O livro '" + ItemDoEmprestimo.getTitulo()
                    + "' foi emprestado para o usuário " + usuarioDoEmprestimo.getNome()
                    + " na data " + emprestimo.getDataEmprestimo()
                    + " e tem de ser devolvido em " + emprestimo.getDataDevolucaoPrevista());
        }
    }

    public Emprestimo buscarEmprestimoAtivoPorItem(ItemDoAcervo item) {
        for (Emprestimo emprestimo : registrosDeEmprestimos) {
            if(emprestimo.getItem().getTitulo().equalsIgnoreCase(item.getTitulo())) {
                if(emprestimo.getDataDevolucaoReal() == null) {
                    return emprestimo;
                }
            }
        }
        return null;
    }

    public void realizarDevolucao(String titulo) {
        ItemDoAcervo item = pesquisarItemPorTitulo(titulo);
        if(item == null) {
            System.out.println("Erro: esse livro não está cadastrado.");
            return;
        }
        Emprestimo emprestimo = buscarEmprestimoAtivoPorItem(item);
        if(emprestimo == null) {
            System.out.println("Erro: esse emprestimo não existe.");
            return;
        }
        LocalDate hoje = LocalDate.of(2025, 9, 20); // alterei a dava de devoluçao apenas para simular o calculo da muta de atraso
        long dias = ChronoUnit.DAYS.between(emprestimo.getDataDevolucaoPrevista(), hoje);

        if(dias > 0) {
            double multa = dias * item.getValorMultaPorDiasAtraso();
            System.out.println("item devolvido. Você precisa pagar uma multa de R$" + multa);
        } else {
            System.out.println("item devolvido.");
        }
        emprestimo.getItem().setStatus(StatusItem.DISPONIVEL);
        emprestimo.setDataDevolucaoReal(hoje);
    }

    public ItemDoAcervo pesquisarItemPorTitulo(String titulo) {
        for(ItemDoAcervo item : this.acervo) {
            if(item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }
        return null;
    }

    public Usuario pesquisarUsuarioPorNome(String Nome) {
        for(Usuario usuario : this.listaDeUsuarios) {
            if(usuario.getNome().equals(Nome)) {
                return usuario;
            }
        }
        return null;
    }

//    public List<Livro> pesquisarLivroPorTermo(String termo) {
//
//    }

    public void listarAcervo() {
        System.out.println("Itens no Acervo");
        for (var item : acervo) {
            System.out.println(item);
        }
    }

    public void cadastrarItem(ItemDoAcervo item) {
        this.acervo.add(item);
        System.out.println("O item " + item.getTitulo() + " foi cadastrado.");
    }

    public void cadastrarUsuario(Usuario usuario) {
        this.listaDeUsuarios.add(usuario);
        System.out.println("O usuário " + usuario.getNome() + " foi cadastrado.");
    }

    public static void main(String[] args) {
        Livro livroJavaComoProgramar = new Livro("Java Como Programar", "Deitel", 2014);
        Livro livroMemoria = new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881);
        Usuario meuUsuario = new Usuario("ane", "aailless", "123");
        Biblioteca minhaBiblioteca = new Biblioteca();
        minhaBiblioteca.cadastrarItem(livroJavaComoProgramar);
        minhaBiblioteca.cadastrarItem(livroMemoria);
        minhaBiblioteca.cadastrarUsuario(meuUsuario);
        minhaBiblioteca.listarAcervo();
        minhaBiblioteca.realizarEmprestimo("ane", "Java Como Programar");
        minhaBiblioteca.listarAcervo();
        minhaBiblioteca.registrosDeEmprestimos.get(0).setDataDevolucaoPrevista(LocalDate.of(2025, 7, 31));
        minhaBiblioteca.realizarDevolucao("Java Como Programar");
        minhaBiblioteca.listarAcervo();

        Revista revista = new Revista("capricho",2025, 01);
        System.out.println(revista);

        DVD barbie = new DVD("barbie", 2000, 120);
        minhaBiblioteca.cadastrarItem(barbie);
        minhaBiblioteca.listarAcervo();
        minhaBiblioteca.realizarEmprestimo("ane", "barbie");
        minhaBiblioteca.registrosDeEmprestimos.get(0).setDataDevolucaoPrevista(LocalDate.of(2025, 7, 31));

        minhaBiblioteca.listarAcervo();
        minhaBiblioteca.realizarDevolucao("barbie");
        minhaBiblioteca.listarAcervo();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o termo de busca (título ou autor):");
        String termoDeBusca = scanner.nextLine();

        List<ItemDoAcervo> resultados = minhaBiblioteca.buscar(termoDeBusca);
        System.out.println("\n--- Resultados da Busca ---");
            if (resultados.isEmpty()) {
                System.out.println("Nenhum item encontrado.");
            } else {
                for (ItemDoAcervo item : resultados) {
                    if (item instanceof Livro) {
                        Livro livro = (Livro) item;
                        System.out.println("- " + livro.getTitulo() + " (Autor: " + livro.getAutor() + ")");
                    } else {
                        System.out.println("- " + item.getTitulo());
                    }
                }
            }

            scanner.close();
            }
}



