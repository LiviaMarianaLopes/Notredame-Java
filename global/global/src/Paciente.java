import java.util.Scanner;

public class Paciente {
    private String nome;
    private Ficha fichaMedica;

    public Paciente(String nome, Ficha fichaMedica) {
        this.nome = nome;
        this.fichaMedica = fichaMedica;
    }

    public Paciente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Ficha getFichaMedica() {
        return fichaMedica;
    }

    public void setFichaMedica(Ficha fichaMedica) {
        this.fichaMedica = fichaMedica;
    }
    public  void atualizarFicha() {
        var scanner = new Scanner(System.in);
        Ficha novaFicha = new Ficha();
        while (true) {
            try {
                System.out.println("Sexo: F/M ");
                var sexo = scanner.nextLine();
                if (sexo.equalsIgnoreCase("f") || sexo.equalsIgnoreCase("m")) {
                    novaFicha.setSexo(sexo);
                    break;
                } else {
                    throw new RuntimeException();
                }
            } catch (Exception e) {
                System.out.println("Digite 'F' para feminino ou 'M' para masculino");
            }
        }
        if (novaFicha.getSexo().equalsIgnoreCase("f")){
            while (true) {
                try {


                    System.out.println("Está gravida? S/N");
                    var gravida = scanner.nextLine();

                    if (gravida.equalsIgnoreCase("s")) {
                        novaFicha.setGravidez(true);
                        break;
                    }
                    else if (gravida.equalsIgnoreCase("n")) {
                        novaFicha.setGravidez(false);
                        break;
                    } else {
                        throw new RuntimeException();
                    }
                }

                catch (Exception e){
                    System.out.println("Digite 'S' se estiver grávida ou 'N' se não estiver");
                }
            }
        }
        else{
            novaFicha.setGravidez(false);
        }

        while (true) {
            try {
                System.out.println("Idade: ");
                novaFicha.setIdade(scanner.nextInt());
                scanner.nextLine();
                break;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Insira a idade em forma númerica");
            }
        }
        while (true) {
            try {
                System.out.println("Peso: ");
                novaFicha.setPeso(scanner.nextDouble());
                scanner.nextLine();
                break;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Insira o peso em forma númerica");
            }
        }
        while (true) {
            try {
                System.out.println("Altura: ");
                novaFicha.setAltura(scanner.nextDouble());
                scanner.nextLine();
                break;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Insira a altura em forma númerica");
            }
        }
        System.out.println("Tipo sanguíneo: ");
        novaFicha.setTipoSanguineo(scanner.nextLine());
        System.out.println("Possui alguma doença ou condição especial?\n\rSe sim quais? ");
        novaFicha.setCondicoes(scanner.nextLine());
        System.out.println("Possui alergia a algum medicamento ou outos?\n\rSe sim quais? ");
        novaFicha.setCondicoes(scanner.nextLine());
        while (true) {
            try {


                System.out.println("Fuma? S/N");
                var fuma = scanner.nextLine();

                if (fuma.equalsIgnoreCase("s")) {
                    novaFicha.setTabagismo(true);
                    break;
                }
                else if (fuma.equalsIgnoreCase("n")) {
                    novaFicha.setTabagismo(false);
                    break;
                } else {
                    throw new RuntimeException();
                }
            }

            catch (Exception e){
                System.out.println("Digite 'S' se fuma ou 'N' se não fuma");
            }
        }
        while (true) {
            try {


                System.out.println("vicío em alcool? S/N");
                var fuma = scanner.nextLine();

                if (fuma.equalsIgnoreCase("s")) {
                    novaFicha.setAlcool(true);
                    break;
                }
                else if (fuma.equalsIgnoreCase("n")) {
                    novaFicha.setAlcool(false);
                    break;
                } else {
                    throw new RuntimeException();
                }
            }

            catch (Exception e){
                System.out.println("Digite 'S' se possui vicío em alcool ou 'N' se não ");
            }
        }
        this.fichaMedica = novaFicha;


    }
    @Override
    public String toString() {
        return "Paciente{" +
                "nome: '" + nome + '\'' +
                ", \n\rFicha Medica: " + fichaMedica +
                '}';
    }
}
