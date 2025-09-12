public class DVD extends ItemDoAcervo {
    private int Duracaominutos;

    public int getDuracaominutos(){
        return Duracaominutos;
    }

    public void setDuracaominutos(int duracaominutos){
        Duracaominutos = duracaominutos;
    }

    public DVD(String titulo, int ano, int duracaominutos){
        super(titulo, ano);
        setDuracaominutos(duracaominutos);
    }

    @Override
    public int getPrazoEmprestimoDias() {
        return 3;
    }
    @Override
    public double getValorMultaPorDiasAtraso(){
        return 2.0;
    }
    @Override
    public String toString() {
        return "DVD "+ getTitulo()+ ", do ano " +getAno()+" -"+getDuracaominutos()+" min - STATUS:"+getStatus();
    }
}


