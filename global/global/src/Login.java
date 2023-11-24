import java.util.ArrayList;
public class Login {
    private String email;
    private String senha;
    private String nome;
    private int telefone;
   private String endereco;
   private ArrayList  <Paciente> membros;

    public Login(String email, String senha, String nome, int telefone, String endereco) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.membros = new ArrayList<>();
    }

    public Login() {
        this.membros = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Paciente> getMembros() {
        return membros;
    }

    public void setMembros(ArrayList<Paciente> membros) {
        this.membros = membros;
    }
}
