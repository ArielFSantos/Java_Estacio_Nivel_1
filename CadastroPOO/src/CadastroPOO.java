import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;


public class CadastroPOO {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
            PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();
            
            String prefixoArquivos = "cadastro";
            
            int opcao;
            do {
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Incluir");
                System.out.println("2 - Alterar");
                System.out.println("3 - Excluir");
                System.out.println("4 - Exibir pelo ID");
                System.out.println("5 - Exibir todos");
                System.out.println("6 - Salvar dados");
                System.out.println("7 - Recuperar dados");
                System.out.println("0 - Sair");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar a nova linha
                
                switch (opcao) {
                    case 1 -> {
                        System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                        int tipo = scanner.nextInt();
                        scanner.nextLine(); // Limpar a nova linha
                        switch (tipo) {
                            case 1 -> {
                                // Incluir Pessoa Física
                                PessoaFisica pessoaFisica = lerDadosPessoaFisica(scanner);
                                pessoaFisicaRepo.inserir(pessoaFisica);
                        }
                            case 2 -> {
                                // Incluir Pessoa Jurídica
                                PessoaJuridica pessoaJuridica = lerDadosPessoaJuridica(scanner);
                                pessoaJuridicaRepo.inserir(pessoaJuridica);
                        }
                            default -> System.out.println("Opção inválida.");
                        }
                    }

                    case 2 -> {
                        System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                        int tipoAlterar = scanner.nextInt();
                        scanner.nextLine(); // Limpar a nova linha
                    switch (tipoAlterar) {
                        case 1 ->                             {
                                // Alterar Pessoa Física
                                System.out.println("Informe o ID da Pessoa Física que deseja alterar:");
                                int idAlterar = scanner.nextInt();
                                scanner.nextLine(); // Limpar a nova linha
                                PessoaFisica pessoaFisicaAlterar = lerDadosPessoaFisica(scanner);
                                pessoaFisicaAlterar.setId(idAlterar);
                                pessoaFisicaRepo.alterar(pessoaFisicaAlterar);
                            }
                        case 2 ->                             {
                                // Alterar Pessoa Jurídica
                                System.out.println("Informe o ID da Pessoa Jurídica que deseja alterar:");
                                int idAlterar = scanner.nextInt();
                                scanner.nextLine(); // Limpar a nova linha
                                PessoaJuridica pessoaJuridicaAlterar = lerDadosPessoaJuridica(scanner);
                                pessoaJuridicaAlterar.setId(idAlterar);
                                pessoaJuridicaRepo.alterar(pessoaJuridicaAlterar);
                            }
                        default -> System.out.println("Opção inválida.");
                    }
                    }
                    case 3 -> {
                        System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                        int tipoExcluir = scanner.nextInt();
                        scanner.nextLine(); // Limpar a nova linha
                    switch (tipoExcluir) {
                        case 1:
                            {
                                // Excluir Pessoa Física
                                System.out.println("Informe o ID da Pessoa Física que deseja excluir:");
                                int idExcluir = scanner.nextInt();
                                scanner.nextLine(); // Limpar a nova linha
                                pessoaFisicaRepo.excluir(idExcluir);
                                break;
                            }
                        case 2:
                            {
                                // Excluir Pessoa Jurídica
                                System.out.println("Informe o ID da Pessoa Jurídica que deseja excluir:");
                                int idExcluir = scanner.nextInt();
                                scanner.nextLine(); // Limpar a nova linha
                                pessoaJuridicaRepo.excluir(idExcluir);
                                break;
                            }
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    }
                    case 4 -> {
                        System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                        int tipoExibir = scanner.nextInt();
                        scanner.nextLine(); // Limpar a nova linha
                        
                        if (tipoExibir == 1) {
                            // Exibir Pessoa Física pelo ID
                            System.out.println("Informe o ID da Pessoa Física que deseja exibir:");
                            int idExibir = scanner.nextInt();
                            scanner.nextLine(); // Limpar a nova linha
                            
                            PessoaFisica pessoaFisicaExibir = pessoaFisicaRepo.obter(idExibir);
                            if (pessoaFisicaExibir != null) {
                                pessoaFisicaExibir.exibir();
                            } else {
                                System.out.println("Pessoa Física não encontrada.");
                            }
                        } else if (tipoExibir == 2) {
                            // Exibir Pessoa Jurídica pelo ID
                            System.out.println("Informe o ID da Pessoa Jurídica que deseja exibir:");
                            int idExibir = scanner.nextInt();
                            scanner.nextLine(); // Limpar a nova linha
                            
                            PessoaJuridica pessoaJuridicaExibir = pessoaJuridicaRepo.obter(idExibir);
                            if (pessoaJuridicaExibir != null) {
                                pessoaJuridicaExibir.exibir();
                            } else {
                                System.out.println("Pessoa Jurídica não encontrada.");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    }
                    case 5 -> {
                        System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                        int tipoExibirTodos = scanner.nextInt();
                        scanner.nextLine(); // Limpar a nova linha
                    switch (tipoExibirTodos) {
                        case 1 -> {
                            // Exibir todas as Pessoas Físicas
                            List<PessoaFisica> todasPessoasFisicas = pessoaFisicaRepo.obterTodos();
                            for (PessoaFisica pf : todasPessoasFisicas) {
                                pf.exibir();
                                System.out.println();
                            }
                        }
                        case 2 -> {
                            // Exibir todas as Pessoas Jurídicas
                            List<PessoaJuridica> todasPessoasJuridicas = pessoaJuridicaRepo.obterTodos();
                            for (PessoaJuridica pj : todasPessoasJuridicas) {
                                pj.exibir();
                                System.out.println();
                            }
                        }
                        default -> System.out.println("Opção inválida.");
                    }
                    }
                    case 6 -> {
                        try {
                            // Salvar dados
                            pessoaFisicaRepo.persistir(prefixoArquivos + ".fisica.bin");
                            pessoaJuridicaRepo.persistir(prefixoArquivos + ".juridica.bin");
                            System.out.println("Dados salvos com sucesso.");
                        } catch (IOException e) {
                            System.out.println("Erro ao salvar os dados: " + e.getMessage());
                        }
                    }
                    case 7 -> {
                        try {
                            // Recuperar dados
                            pessoaFisicaRepo.recuperar(prefixoArquivos + ".fisica.bin");
                            pessoaJuridicaRepo.recuperar(prefixoArquivos + ".juridica.bin");
                            System.out.println("Dados recuperados com sucesso.");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                        }
                    }
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            } while (opcao != 0);
        }
    }

    private static PessoaFisica lerDadosPessoaFisica(Scanner scanner) {
    System.out.println("Digite o nome da Pessoa Física:");
    String nome = scanner.nextLine();

    System.out.println("Digite o CPF da Pessoa Física:");
    String cpf = scanner.nextLine();

    System.out.println("Digite a idade da Pessoa Física:");
    int idade = scanner.nextInt();
    
    scanner.nextLine();
        // Crie um objeto PessoaFisica com os dados lidos
        // Limpar a nova linha
    return new PessoaFisica(nome, cpf, idade);
}


    private static PessoaJuridica lerDadosPessoaJuridica(Scanner scanner) {
    System.out.println("Digite o nome da Pessoa Jurídica:");
    String nome = scanner.nextLine();

    System.out.println("Digite o CNPJ da Pessoa Jurídica:");
    String cnpj = scanner.nextLine();

    // Crie um objeto PessoaJuridica com os dados lidos
    PessoaJuridica pessoaJuridica = new PessoaJuridica(nome, cnpj);

    return pessoaJuridica;
}

}
