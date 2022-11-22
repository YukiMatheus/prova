

import java.io.IOException;
import java.util.Scanner;

import aplicativos.Pessoa;
import aplicativos.Piloto;

public class AppPilotos {
    private static final int i = 0;

    public static void main(String[] args) throws InterruptedException, IOException {
        int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                //Cadastre seu piloto aqui
                Piloto piloto = new Piloto();
                System.out.println("Nome do piloto:" );
                piloto.setNome(in.nextLine());
                System.out.println("CPF do piloto:" );
                piloto.setCpf(in.nextLine());
                System.out.println("Brevê do piloto:");
                piloto.setBreve(in.nextLine());;
                System.out.println("Matricula:(Apenas digitos numerais)");
                piloto.setMatricula(in.nextInt()); 
                     
              
                pilotos[qtdCadastrados] = piloto;
                qtdCadastrados++;
        
                System.out.println("\nPiloto cadastrado com sucesso.");

                                          } 
                           
                else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui
                
                for(Pessoa piloto : pilotos){
                    if(piloto != null){
                        System.out.printf("\nNome: %s\n", piloto.getNome());
                        System.out.printf("CPF: %s\n", piloto.getCpf());
                        System.out.printf("Brevê: %s\n ", ((Piloto)piloto).getBreve());
                        System.out.printf("Matricula: %d\n" , ((Piloto)piloto).getmatricula());
                        System.out.println("\n****************************************");
                    }
                }

                voltarMenu(in);
            } else if (opcao == 3) {
                System.out.print("\nDigite o CPF do piloto desejado: ");
                String CPFpiloto = in.nextLine(); 

                for (int i = 0; i < pilotos.length + 1; i++) {
                    try {
                        if (pilotos[i].getCpf().toString().equals(CPFpiloto)) {
                            System.out.printf("\nNome: %s \nMatricula: %d \nBrevê: %s\n",
                                    pilotos[i].getNome(), 
                                    ((Piloto) pilotos[i]).getmatricula(),
                                    ((Piloto) pilotos[i]).getBreve());
                            break;                        }
                         else if (i < pilotos.length + 1) {
                            continue;                        }
                    } catch (Exception e) {
                        System.out.println("\nPiloto não localizado, verifique o CPF e tente novamente.");
                        voltarMenu(in);      
                                 }                }                    }

             else if (opcao == 4) {
                System.out.print("Insira nova quantidade de registros: ");
                int newArrayValue = in.nextInt();
                Pessoa[] newPilotos = new Pessoa[pilotos.length + newArrayValue];
                for (int i=0; i<pilotos.length; i++);{
                    newPilotos[i]= pilotos[i];

                    MAX_ELEMENTOS = newPilotos.length;
                    pilotos= newPilotos;
                }
             }
          
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}