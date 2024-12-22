import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class projetoForca {
    public static String[] lerPalavras() throws FileNotFoundException {
        Scanner kb=new Scanner(System.in);
        System.out.println("Digite o caminho do ficheiro com as palavras");
        String caminho_ficheiro= kb.nextLine();
        File arquivo=new File(caminho_ficheiro);

        if (!arquivo.exists()){
            System.out.println("Caminho do ficheiro incorreto ou sem permissão");
            return new String[0];
        }

        Scanner contar=new Scanner(arquivo);
        int quantidade_palavras=0;

        while (contar.hasNextLine()){
            contar.nextLine();
            quantidade_palavras++;
        }
        contar.close();

        String[] palavras=new String[quantidade_palavras];
        Scanner ler=new Scanner(arquivo);
        int contador=0;

        while (ler.hasNextLine()){
            palavras[contador]= ler.nextLine().trim();
            contador++;
        }
        ler.close();
        return palavras;
    }
    public static boolean checkLerPalavras(String[]palavras){
        if (palavras.length==0){
            System.out.println("Não foram encontradas palavras, por isso o jogo não pode começar");
            return false;
        }
        return true;
    }

    public static String nomeJogador(){
        Scanner ler=new Scanner(System.in);
        System.out.println("Digite o seu nome");
        return ler.nextLine();
    }

    public static String escolherPalavraAleatoria(String[] palavras){
        Random random=new Random();

        int indice= random.nextInt(palavras.length);

        return palavras[indice];
    }

    public static void MenuJogo(String nome){
        System.out.printf("Bem vindo ao jogo da forca %s!%n",nome);
        System.out.println("O objetivo do jogo é acertar a palavra no mínimo de tentativas possiveis");
        System.out.println("Vamos começar!");
    }

    public static boolean checkCaracter(String palavra, char caracter){
        for (int i = 0; i < palavra.length(); i++) {
            if ((palavra.charAt(i)) == caracter){
                return true;
            }
        }
        return false;
    }

    public static char[] inicializar_palavra(String palavra){
        char[] status= new char[palavra.length()];
        for (int i = 0; i < status.length; i++) {
            status[i]='_';
        }
        return status;
    }

    public static char[] atualizar_status(char[] status, String palavra, char caractere){
        for (int i = 0; i < status.length; i++) {
            if (palavra.charAt(i)==caractere){
                status[i]=palavra.charAt(i);
            }
        }
        return status;
    }

    public static void printStatus(char[] status){
        for (int i = 0; i < status.length; i++) {
            System.out.print(status[i]);
        }
        System.out.println();
    }

    public static boolean hasGuessedTheWord(char[] status,String palavra){
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i)!=status[i]){
                return false;
            }
        }
        return true;
    }

    public static void guessWord(String palavra){
        Scanner ler=new Scanner(System.in);
        int tentativas=palavra.length();
        char[] status=inicializar_palavra(palavra);
        while (tentativas>0 && !hasGuessedTheWord(status,palavra)) {
            System.out.println("Insira uma letra:");
            char caracter=ler.next().toLowerCase().charAt(0);
            while (!Character.isLetter(caracter)){
                System.out.println("Digite apenas uma letra");
                caracter=ler.next().toLowerCase().charAt(0);
            }

            if (checkCaracter(palavra,caracter)){
                atualizar_status(status,palavra,caracter);
                System.out.println("Boa,acertou uma letra");
            }else {
                tentativas--;
                System.out.printf("Letra incorreta! Ainda tem %d tentativas%n", tentativas);
            }
            printStatus(status);
        }
        if (tentativas==0){
            System.out.println("Esgotou as tentativas");
            System.out.printf("A palavra secreta era :%s",palavra);
        }
        else {
            System.out.printf("Parabéns, acertou a palavra ainda com %d tentativas restantes",tentativas);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String nome_jogador=nomeJogador();
        MenuJogo(nome_jogador);
        String[] palavras=lerPalavras();
        if (checkLerPalavras(palavras)) {
            String palavra_a_adivinhar = escolherPalavraAleatoria(palavras);
            guessWord(palavra_a_adivinhar);
        }
    }
}
