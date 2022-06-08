import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Jogo {

    private static final Scanner in = new Scanner(System.in);

    private static int premio[] = {0, 500, 1000, 2000, 3000, 5000, 10000, 15000, 20000,
            30000, 50000, 100000, 150000, 300000, 500000, 1000000};
    static int acertos = 0;
    static int rodada = 1;
    static boolean continua = true;

    static String perguntas[][] = {
            {"Qual a unidade de medida usada para medir reistência resistência?", "1) Faraday", "2) Volts", "3) Ampere", "4) Ohm"},
            {"Qual um exemplo de dispositivo de saída?", "1) Processador", "2) Monitor", "3) HD", "4) Memória RAM"},
            {"Qual o tipo de memória mais rápida?", "1) Flash", "2) SSD", "3) Cache", "4) HDD"},
            {"Qual o nome do primeiro computador da história?", "1) ENIAC", "2) Bourne", "3) Bourne", "4) ENAD"},
            {"Qual o primeiro Sistema Operacional da história?", "1) Windows", "2) Linux", "3) GM-NAA I/0", "4) IBM z/OS"},
            {"Um software antivírus é um programa responsável por :",
                    "1) dividir os recursos da máquina entre os processos em execução.",
                    "2) prevenir, procurar, detectar e remover programas maliciosos.",
                    "3) arranjar em espaço contíguo os arquivos contidos em disco.",
                    "4) realizar a atualização do sistema operacional."},
            {"Qual componente é responsável pela leitura dos conteudos de um computador quando requeridos, " +
                    "mas não armazenam permanente esses conteúdos?",
                    "1) Memória RAM", "2) Teclado", "3) Monitor", "4) HD"},
            {"Quais simbolos são exemplos de operadores lógicos utilizados em programação?",
                    "1) && e +", "2) ! e *", "3) >= e /", "4) &&, || e !"},
            {"As estruturas de repetição na linguagem Java, permitem executar mais de uma vez um mesmo trecho de código. " +
                    "É correto afirmar que, quando se sabe de antemão quantas vezes o loop deverá ser executado, " +
                    "o comando utilizado é o:", "1) if", "2) for", "3) while", "4) do while"},
            {"Na linguagem Java, a palavra-chave que deve ser usada para especificar que uma variável não pode ser modificada é",
                    "1) static", "2) const", "3) final", "4) constante"},
            {"Qual dos seguintes itens possui apenas tipos válidos usados em lógica de programação (tipos primitivos)?",
                    "1) O Inteiro, Temporal, Caractere, Double", "2) O Inteiro, Booleano, Tipografia, Double",
                    "3) O Inteiro, Booleano, Caractere, Double", "4) O Temporal, Triple, Caractere, Double"},
            {"Um trecho de código dentro de um algoritmo precisa ser repetido exatamente 62 vezes em sequência. " +
                    "Qual das estruturas a seguir é a mais indicada para realizar essa tarefa?",
                    "1) While", "2) if / else", "3) array", "4) for"},
            {"O que é Compilação?", "1) Comandos contidos no código-fonte são executados à medida em que são traduzidos," +
                    "sendo necessária a interpretação toda vez que se quiser rodar o programa.", "2) Tradução do código-fonte " +
                    "em um ou mais arquivos que podem ser armazenados e executados quantas vezes se desejar, sem necessitar de nova compilação.",
                    "3) junção de comandos do código-fonte em um arquivo empacotado para distribuição por um meio específico para instalação do programa.",
                    "4) Execução das instruções contidas em um script contendo o código-fonte, de forma sequencial."},
            {"Qual a diferença entre os operadores lógicos E (AND) e OU (OR)?",
                    "1) O operador AND retorna verdadeiro somente se todas as expressões de entrada forem verdadeiras, " +
                            "ao passo que o operador OR retorna verdadeiro se pelo menos uma das expressões de entrada for verdadeira.",
                    "2) O operador AND retorna falso somente se todas as expressões de entrada forem verdadeiras, " +
                            "ao passo que o operador OR retorna falso se pelo menos uma das expressões de entrada for verdadeira.",
                    "3) O operador OR retorna verdadeiro somente se todas as expressões de entrada forem verdadeiras, " +
                            "ao passo que o operador AND retorna verdadeiro se pelo menos uma das expressões de entrada for verdadeira.",
                    "4) O operador OR retorna verdadeiro somente se todas as expressões de entrada forem falsas, " +
                            "ao passo que o operador AND retorna verdadeiro se pelo menos uma das expressões de entrada for verdadeira."},
            {"A respeito dos componentes de um computador, é correto afirmar que o termo Ryzen 5 1600 da AMD refere-se a um tipo de: ",
                    "1) SSD", "2) Placa Mãe", "3) Processador", "4) Memória RAM"},


    };

    private static final String RESET = "\u001B[0m";
    private static final String VERMELHO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARELO = "\u001B[33m";
    private static final String AZUL = "\u001B[34m";
    private static final String ROXO = "\u001B[35m";
    private static final String BRANCO = "\u001B[37m";
    static int op;
    static List<Integer> listSorteado = new ArrayList();

    public static void main(String[] args) {
        limparTela();
        do {
            op = mostrarMenu(in);
            continua = true;
            switch (op) {
                case 1:
                    limparTela();
                    mostrarInstrucao();
                    decisao();
                    break;
                case 2:
                    limparTela();
                    listSorteado = new ArrayList();
                    rodada = 1;
                    acertos = 0;
                    int resposta, opcao, pergunta;
                    while (continua && acertos < 15) {
                        limparTela();
                        continua = mostrarPergunta();
                    }
                    if (acertos == 15) {
                        limparTela();
                        premioDeAcerto();
                    }
                    decisao();
                    break;
                case 3:
                    limparTela();
                    creditos();
                    decisao();
                    break;
                case 4:
                    limparTela();
                    System.out.format("\nVocê selecionou a opção 4, Sair\n");
                    System.out.format("Você está saindo\n");
                    break;
                default:
                    System.out.format("Selecione uma opção de 1 a 4: ");
                    break;
            }
            limparTela();
        }
        while (op == 1); {
            System.out.print(RESET);
        }
    }

    public static int mostrarMenu(Scanner in) {
        System.out.println(ROXO + "################################################################");
        System.out.println(ROXO + "#############    Quem quer ser um milionário??    ##############");
        System.out.println(ROXO + "################################################################");
        System.out.println(AZUL + "\n1 - Instruções");
        System.out.println(AZUL + "2 - Jogar");
        System.out.println(AZUL + "3 - Créditos");
        System.out.print(AZUL + "4 - Sair\n" +
                AMARELO + "Escolha uma opção: ");
        in.reset();
        return in.nextInt();
    }

    public static void mostrarInstrucao() {
        System.out.print(AZUL + "\nVocê selecionou a opção 1.\n\n-----------  Instruções  -----------\n");
        System.out.print(VERDE + "Bem vindo ao jogo Quem quer ser um milionário, onde você estará em um quiz de perguntas da área de TI."
                + "\nVocê começará seu jogo inicialmente com R$ 0,00, e a cada pergunta respondida por você, sua recompensa " +
                "irá aumentar de acordo com a tabela de recompensas do jogo, porém, "
                + "caso não acerte a questão, você perderá a oportunidade de continuar no Quiz e receberá de prêmio, "
                + "nada caso tenha errado uma questão antes da quinta questão, se errar a partir da quinta questão, sua recompensa será de acordo com o porto seguro em que estiver." +
                " Portos seguros:\nA partir da pergunta 5: R$ 5000,00\nA partir da pergunta 10: R$ 10000,00\n");
    }

    public static void creditos() {
        System.out.print(AZUL + "\nVocê selecionou a opção 1.\n\n" +
                "----------- DESENVOLVEDORES DO JOGO -------------");
        System.out.print(VERDE + "\n JOGO DESNVOLVIDO POR:\n LUCAS BELIZARDO DA SILVA OLIVERA" +
                        "\n LUCAS FERREIRA SILVA\n PEDRO DANIEL LIMA FERREIRA RIBEIRO" +
                        "\n PEDRO HENRIQUE VICENTE DE ABREU" +
                        "\n Alunos do primeiro semestre de TADS\n");

    }

    public static void limparTela() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Funções do jogo
    public static void premioDeAcerto() {
        if (acertos < 15) System.out.println(VERDE + "-------- Prêmio atual: R$ " +
                premio[acertos] + ",00--------");
        else System.out.println(VERDE + "Parabens, você venceu o jogo Quem Quer Ser um Milionario" +
                "\n-------- Prêmio: R$ " + premio[acertos] + ",00 --------");
    }

    public static void premioGameOver() {
        if (acertos < 5) System.out.println(VERMELHO + "-------- Prêmio final: R$ 0,00 --------");
        else if (acertos >= 5 && acertos < 10) System.out.println(VERMELHO + "-------- Prêmio final: R$ 5000,00 --------");
        else System.out.println("-------- Prêmio final: R$ 50000,00 --------");
    }

    public static int sorteio() {
        Random sortear = new Random();
        int pergunta;
        boolean existe;
        do {
            pergunta = sortear.nextInt(0, 15);
            int qt = listSorteado.size();
            existe = false;
            for (int i = 0; i < qt; i++) {
                if (pergunta == listSorteado.get(i)) {
                    existe = true;
                }
            }
            if (!existe) {
                listSorteado.add(pergunta);
            }

        } while (existe);
        return pergunta;

    }

    public static boolean mostrarPergunta() {
        boolean resultado = false;
        rodada++;
        int pergunta = sorteio();
        premioDeAcerto();
        System.out.println(BRANCO + " ######################################\n");
        System.out.println(ROXO + "Pergunta " + (acertos + 1));
        System.out.println(ROXO + perguntas[pergunta][0]);
        System.out.println(AZUL + perguntas[pergunta][1]);
        System.out.println(AZUL + perguntas[pergunta][2]);
        System.out.println(AZUL + perguntas[pergunta][3]);
        System.out.println(AZUL + perguntas[pergunta][4]);
        System.out.print(AMARELO + "Escolha uma opção: ");
        int opcao = in.nextInt();
        int resposta = verificaResposta(pergunta);
        if (opcao == resposta) {
            resultado = true;
            System.out.println(VERDE + "Resposta Correta!");
            try {
                System.in.read();
            } catch (Exception ex) {}

            acertos++;
        } else {
            resultado = false;
            System.out.println(VERMELHO + "---------- Resposta incorreta! ---------");
            premioGameOver();
        }

        return resultado;
    }

    public static void decisao() {
        System.out.println(BRANCO + "1 - Voltar ao menu\n2 - Sair");
        op = in.nextInt();
    }

    public static int verificaResposta(int pergunta) {
        int resposta[] = {4, 2, 3, 1, 3, 2, 1, 4, 2, 3, 3, 4, 2, 1, 3};
        return resposta[pergunta];
    }
}