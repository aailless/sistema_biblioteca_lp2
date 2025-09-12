public abstract class ItemDoAcervo {
    private String titulo;
    private int ano;
    private StatusItem status;

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        int ano_atual = 2025;
        if (ano > ano_atual) {
            System.out.println("Erro: ano inválido.");
        } else {
            this.ano = ano;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == "") {
            System.out.println("Erro: título inválido.");
        } else {
            this.titulo = titulo;
        }
    }

    public StatusItem getStatus() {
        return status;
    }

    public void setStatus(StatusItem status) {
        this.status = status;
    }

    public ItemDoAcervo (String titulo, int ano){
        setTitulo(titulo);
        setAno(ano);
        setStatus(StatusItem.DISPONIVEL);
    }
    public int getPrazoEmprestimoDias(){
            return 7;
    }
    public double getValorMultaPorDiasAtraso(){
        return  0.75;
    }
}

    

