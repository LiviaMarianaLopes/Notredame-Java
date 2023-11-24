import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {


        //Variável para armazenar os Logins cadastrados
        var logins = new ArrayList<Login>();
        System.out.println("=====Bem-vindo(a) ao site da Notredame=====");
        while (true) {
            try {
                System.out.println("1.Cadastrar\r\n2.Fazer login\n\r3.Sair");
                var scanner = new Scanner(System.in);
                var opcao = scanner.nextInt();
                scanner.nextLine();
                if (opcao == 1) {
                    //Chama o método para cadastrar um novo Login e adiciona o novo Login na lista de Logins
                    logins.add(criarLogin(logins));
                } else if (opcao == 2) {
                    var continuar = 0;
                    if (!logins.isEmpty()) {
                        while (true) {
                            //Pega as informações de login
                            System.out.println("Digite seu username ou email cadastrado: ");
                            String username = scanner.nextLine();
                            System.out.println("Digite a senha: ");
                            String senha = scanner.nextLine();
                            //Verifica o login usando o método verificarLogin
                            if (verificarLogin(logins, username, senha)) {
                                //Salva em uma variável o login que foi logado
                                Login loginLogado = (saberLogin(logins, username, senha));
                                System.out.println("Login efetuado com sucesso");
                                while (true) {
                                    try {
                                        System.out.println("1. Preencher/Atualizar fichas médicas\n\r" +
                                                "2. Visualizar fichas médicas\n\r" +
                                                "3. Ponto socorro\n\r4. Emergência\n\r5. Sair");
                                        var escolha = scanner.nextInt();
                                        scanner.nextLine();
                                        if (escolha == 1) {
                                            for (Login l : logins) {

                                                if (l.equals(loginLogado)) {
                                                    //Verifica se existe alguma produto na lista de produtos do usuário
                                                    if (!l.getMembros().isEmpty()) {
                                                        while (true){
                                                        System.out.println("Qual ficha você gostaria de atualizar ou preencher? ");
                                                        int cont = 0;
                                                        for (Paciente m : l.getMembros()){
                                                            System.out.println(cont+". "+m.getNome());
                                                            cont += 1;
                                                        }
                                                            int sair = cont +1;
                                                        try{

                                                            System.out.println(cont +". Outro\n\r"+sair+". Sair");
                                                        var resp = scanner.nextInt();
                                                        scanner.nextLine();
                                                        if (resp >= 0 && resp < cont){
                                                            l.getMembros().get(resp).atualizarFicha();
                                                        }
                                                        else if (resp == cont){
                                                            l.getMembros().add(cadastrarMembro());
                                                        }

                                                        else if (resp == sair){
                                                            break;
                                                        }
                                                        else{
                                                            throw new RuntimeException();
                                                        }
                                                        }
                                                        catch (Exception e){
                                                            scanner.nextLine();
                                                            System.out.println("Digite um número de 0 à "+ sair);
                                                        }
                                                    }
                                                    }

                                                    else{
                                                        l.getMembros().add(cadastrarMembro());

                                                    }
                                                }

                                            }


                                        }
                                        else if (escolha == 2) {
                                            for (Login l : logins) {

                                                if (l.equals(loginLogado)) {
                                                    //Verifica se existe algum paciente na lista do usuário
                                                    if (!l.getMembros().isEmpty()) {
                                                        //Mostra no console os produtos que existem na lista de produtos do usuário
                                                        System.out.println("Fichas Médicas:");
                                                        for (Paciente p : l.getMembros()) {
                                                            System.out.println(p);
                                                        }
                                                    } else {
                                                        System.out.println("Você ainda não possui nenhuma ficha cadastrada");
                                                    }

                                                }

                                            }

                                        } else if (escolha == 3) {
                                            while (true){
                                            try {
                                                System.out.println("Qual unidade você deseja comparecer?\n\r" +
                                                        "1. Rua Dr. Fernando Faleiros de Lima 2233 (Centro), Franca, SP\n\r" +
                                                        "2. Rua Bresser, 1954 - Mooca " +
                                                        "São Paulo - SP\n\r" +
                                                        "3. Rua Dom Alberto Gonçalves, 1500 - Vila Tamandaré " +
                                                        "Ribeirão Preto - SP\n\r" +
                                                        "4. Avenida Pereira Barreto, 846 - Baeta Neves " +
                                                        "São Bernardo do Campo - SP\n\r" +
                                                        "5. Avenida Autonomistas, 2502 - Vila Yara " +
                                                        "Osasco - SP\n\r" +
                                                        "6. Avenida Tiradentes, 1015 - Jardim Santa Edwirges " +
                                                        "Guarulhos - SP\n\r" +
                                                        "7. Cancelar");
                                                var unidade = scanner.nextInt();
                                                scanner.nextLine();
                                                if (unidade >= 0 && unidade <= 6) {

                                                    for (Login l : logins) {

                                                        if (l.equals(loginLogado)) {
                                                            if (!l.getMembros().isEmpty()) {
                                                                while (true) {
                                                                    System.out.println("Para qual paciente seria o atendimento?\n\r ");
                                                                    int cont = 0;
                                                                    for (Paciente m : l.getMembros()) {
                                                                        System.out.println(cont + ". " + m.getNome());
                                                                        cont += 1;
                                                                    }
                                                                    int sair = cont + 1;
                                                                    try {

                                                                        System.out.println(cont + ". Outro\n\r" + sair + ". Sair");
                                                                        var resp = scanner.nextInt();
                                                                        scanner.nextLine();
                                                                        if (resp >= 0 && resp < sair) {
                                                                            System.out.println("Por favor insira as informmações do comparecimento: ");
                                                                            var sintomas = scanner.nextLine();
                                                                            System.out.println("Tomou alguma medicação? se sim qual? ");
                                                                            var medicamentos = scanner.nextLine();
                                                                            System.out.println("Certo! já enviamos as informações para agilizar o processo, estamos ao seu aguardo!");


                                                                            break;
                                                                        }
                                                                        else if(resp == sair ){
                                                                            break;

                                                                        }

                                                                        else {
                                                                            throw new RuntimeException();
                                                                        }
                                                                    } catch (Exception e) {
                                                                        scanner.nextLine();
                                                                        System.out.println("Digite um número de 0 à " + sair);
                                                                    }
                                                                    break;
                                                                }
                                                            }



                                                            break;
                                                        }
                                                        break;
                                                    }break;
                                                }else if (unidade == 7) {
                                                    break;
                                                } else {
                                                    throw new RuntimeException();
                                                }
                                            }
                                                catch (Exception e){
                                                scanner.nextLine();
                                                    System.out.println("Digite um número de 1 à 7");
                                                }

                                        }
                                        }
                                        else if (escolha == 4) {
                                            while (true){
                                            try {
                                                System.out.println("Qual endereço devemos realizar o socorro?\n\r" +
                                                        "1. Localização atual\n\r" +
                                                        "2. Endereço cadastrado\n\r" +
                                                        "3. Outro\n\r" +
                                                        "4. Cancelar");
                                                var local = scanner.nextInt();
                                                scanner.nextLine();
                                                if (local == 3){
                                                    System.out.println("Digite o endereço: ");
                                                    scanner.nextLine();
                                                }
                                                if (local == 1 || local == 2|| local == 3){
                                                    System.out.println("Estamos a caminho!");
                                                    if (!loginLogado.getMembros().isEmpty()){
                                                        while (true) {
                                                            System.out.println("Para qual paciente seria o atendimento?\n\r ");
                                                            int cont = 0;
                                                            for (Paciente m : loginLogado.getMembros()) {
                                                                System.out.println(cont + ". " + m.getNome());
                                                                cont += 1;
                                                            }

                                                            try {

                                                                System.out.println(cont + ". Outro\n\r" );
                                                                var resp = scanner.nextInt();
                                                                scanner.nextLine();
                                                                if (resp >= 0 && resp <= cont) {
                                                                    System.out.println("Já estamos nos preparando para o socorro");
                                                                    break;
                                                                }

                                                                else {
                                                                    scanner.nextLine();
                                                                    throw new RuntimeException();
                                                                }
                                                            } catch (Exception e) {
                                                                scanner.nextLine();
                                                                System.out.println("Digite um número de 0 à " + cont);
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if (local == 4){
                                                    break;
                                                }
                                                else{
                                                    throw new RuntimeException();
                                                }

                                            }
                                            catch (Exception e){
                                                scanner.nextLine();
                                                System.out.println("Digite um número de 1 à 4");
                                            }
                                        }
                                        }

                                        else if (escolha == 5) {
                                            break;
                                        } else {
                                            throw new RuntimeException();
                                        }

                                    } catch (Exception e) {
                                        System.out.println("Digite um número de 1 à 5");

                                    }

                                }
                                break;
                            } else {
                                System.out.println("Username ou senha inválido\n\r1. Voltar ao menu principal\n\rQualquer outro número para tentar novamente");
                                continuar = scanner.nextInt();
                                scanner.nextLine();
                                if (continuar == 1) {
                                    break;
                                } else {
                                    continue;
                                }


                            }
                        }
                    }
                    else{
                            System.out.println("Nenhum cadastro registrado, crie um cadastro  para realizar o login");

                        }


                    }
                    else if (opcao == 3) {
                    System.out.println("Encerrando o programa");
                    break;
                } else {
                    throw new RuntimeException();
                }

            } catch (Exception e) {
                System.out.println("Digite um número de 1 à 3");
            }
        }
    }

    // Método para verificar se o Login que o usuário inseriu está correto
    public static boolean verificarLogin(ArrayList<Login> logins, String username, String senha) {
        for (Login l : logins) {

            //Verifica se o username inserido é igual ao email cadastrado
            if (l.getEmail().equals(username)) {
                //Verifica se a senha inserida corresponde a senha cadastrada
                if (l.getSenha().equals(senha)) {
                    return true;

                }
            }

        }
        return false;
    }

    //Método para poder salvar em uma variável o Login
    public static Login saberLogin(ArrayList<Login> logins, String username, String senha) {
        for (Login l : logins) {

            if (l.getEmail().equals(username)) {
                if (l.getSenha().equals(senha)) {

                    //retorna o Login que corresponde ao username e senha inseridos
                    return l;

                }
            }

        }
        return null;
    }

    //Método para realizar um cadastro
    public static Login criarLogin(ArrayList<Login> logins) {

            var scanner = new Scanner(System.in);
            Login novoLogin = new Login();
            System.out.println("Nome: ");
            novoLogin.setNome(scanner.nextLine());


            while (true) {
                try {
                    System.out.println("Telefone ou celular: ");
                    novoLogin.setTelefone(scanner.nextInt());
                    scanner.nextLine();
                    break;
                } catch (Exception e) {
                    scanner.nextLine();
                    System.out.println("Digite apenas os números com o DDD");
                }
            }

            while (true) {
                try {
                    System.out.println("Email: ");
                    var email = scanner.nextLine();
                    var achou = 0;
                    if (email.contains("@") && email.contains(".com")) {


                        if (!logins.isEmpty()) {
                            for (Login l : logins) {
                                //Confere se o email já foi cadastrado
                                if (l.getEmail().equals(email)) {
                                    System.out.println("Este email já foi cadastrado");
                                    achou = 1;
                                    break;
                                }
                            }
                        }
                        if (achou == 0) {
                            novoLogin.setEmail(email);
                            break;
                        }
                    } else {
                        throw new RuntimeException();
                    }
                } catch (Exception e) {
                    System.out.println("Digite um endereço de email válido");
                }
            }
            System.out.println("endereço: ");
            novoLogin.setEndereco(scanner.nextLine());

            System.out.println("Crie uma senha: ");
            novoLogin.setSenha(scanner.nextLine());
            //Retorna o Login cadastrado
            return novoLogin;


        }
    public static Paciente cadastrarMembro() {
        var scanner = new Scanner(System.in);
        Paciente novoPaciente = new Paciente();
        Ficha novaFicha = new Ficha();System.out.println("Nome: ");
        novoPaciente.setNome(scanner.nextLine());
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

        novoPaciente.setFichaMedica(novaFicha);
        return novoPaciente;
    }

}





