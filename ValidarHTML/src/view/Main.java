//package view;
//
//import control.HTMLValidator;
//import java.io.File;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Digite o caminho do arquivo HTML: ");
//        String caminho = sc.nextLine();
//
//        File arquivo = new File(caminho);
//        HTMLValidator validador = new HTMLValidator();
//
//        try {
//            boolean valido = validador.validarArquivo(arquivo);
//            if (valido) {
//                System.out.println("Arquivo HTML bem formatado!");
//                System.out.println("Tags encontradas:");
//                validador.imprimirContador();
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
//        }
//    }
//}
;