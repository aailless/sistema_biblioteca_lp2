public class Revista extends ItemDoAcervo {
    private int edicao;

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public Revista(String titulo, int ano, int edicao) {
        super(titulo, ano);
        setEdicao(edicao);
    }

    @Override
    public String toString() {
        return "Revista" + getTitulo() + ", ano" + getAno() + ", edicao=" + edicao + ", Status" + getStatus();
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 10;
    }

    @Override
    public double getValorMultaPorDiasAtraso(){
        return 1.0;
    }

}