public class Ficha {
    private int idade;
    private String alergias;
    private String condicoes;
    private String tipoSanguineo;
    private double peso;
    private double altura;
    private String sexo;
    private boolean gravidez;
    private boolean tabagismo;
    private boolean alcool;

    public Ficha(int idade, String alergias, String condicoes, String tipoSanguineo, double peso, double altura, String sexo, boolean gravidez, boolean tabagismo, boolean alcool) {
        this.idade = idade;
        this.alergias = alergias;
        this.condicoes = condicoes;
        this.tipoSanguineo = tipoSanguineo;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.gravidez = gravidez;
        this.tabagismo = tabagismo;
        this.alcool = alcool;
    }

    public Ficha() {
    }


    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCondicoes() {
        return condicoes;
    }

    public void setCondicoes(String condicoes) {
        this.condicoes = condicoes;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isGravidez() {
        return gravidez;
    }

    public void setGravidez(boolean gravidez) {
        this.gravidez = gravidez;
    }

    public boolean isTabagismo() {
        return tabagismo;
    }

    public void setTabagismo(boolean tabagismo) {
        this.tabagismo = tabagismo;
    }

    public boolean isAlcool() {
        return alcool;
    }

    public void setAlcool(boolean alcool) {
        this.alcool = alcool;
    }

    @Override
    public String toString() {
        return
                "\n\ridade: " + idade +
                ", \n\ralergias='" + alergias + '\'' +
                ", \n\rcondicoes='" + condicoes + '\'' +
                ", \n\tTipo Sanguineo='" + tipoSanguineo + '\'' +
                ", \n\rpeso=" + peso +
                ", \n\raltura=" + altura +
                ", \n\rsexo='" + sexo + '\'' +
                ", \n\rgravidez=" + gravidez +
                ", \n\rtabagismo=" + tabagismo +
                ", \n\ralcool=" + alcool +
                '}';
    }
}
