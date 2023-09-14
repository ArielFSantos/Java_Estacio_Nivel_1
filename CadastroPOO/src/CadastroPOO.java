import java.io.IOException;
import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class CadastroPOO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                case 1:
                    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpar a nova linha

                    if (tipo == 1) {
                        // Incluir Pessoa Física
                        PessoaFisica pessoaFisica = lerDadosPessoaFisica(scanner);
                        pessoaFisicaRepo.inserir(pessoaFisica);
                    } else if (tipo == 2) {
                        // Incluir Pessoa Jurídica
                        PessoaJuridica pessoaJuridica = lerDadosPessoaJuridica(scanner);
                        pessoaJuridicaRepo.inserir(pessoaJuridica);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 2:
                    // Implementar a opção de Alterar aqui
                    break;
                case 3:
                    // Implementar a opção de Excluir aqui
                    break;
                case 4:
                    // Implementar a opção de Exibir pelo ID aqui
                    break;
                case 5:
                    // Implementar a opção de Exibir todos aqui
                    break;
                case 6:
                    try {
                        // Salvar dados
                        pessoaFisicaRepo.persistir(prefixoArquivos + ".fisica.bin");
                        pessoaJuridicaRepo.persistir(prefixoArquivos + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        // Recuperar dados
                        pessoaFisicaRepo.recuperar(prefixoArquivos + ".fisica.bin");
                        pessoaJuridicaRepo.recuperar(prefixoArquivos + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static PessoaFisica lerDadosPessoaFisica(Scanner scanner) {
        // Implementar a leitura dos dados da Pessoa Física aqui
        return null;
    }

    private static PessoaJuridica lerDadosPessoaJuridica(Scanner scanner) {
        // Implementar a leitura dos dados da Pessoa Jurídica aqui
        return null;
    }
}