public class Main {
    public static void main(String[] args) {
        System.out.println("== Árvore do Código Morse ==");
        Arvore arvore = new Arvore();
        arvore.inicializarPadrao();

        System.out.println("\n[Exibição]");
        arvore.exibir();

        System.out.println("\n[Buscas]");
        System.out.println("... -> " + arvore.buscarPorCaminho("..."));
        System.out.println("--- -> " + arvore.buscarPorCaminho("---"));
        System.out.println(".-  -> " + arvore.buscarPorCaminho(".-"));

        System.out.println("\n[Decodificação]");
        String sos = "... --- ...";
        System.out.println(sos + " -> " + arvore.decodificarMensagem(sos));

        System.out.println("\n[Remoção de 'S' (...)]");
        System.out.println("Antes: " + arvore.buscarPorCaminho("..."));
        arvore.removerSimbolo("...");
        System.out.println("Depois: " + arvore.buscarPorCaminho("..."));

        System.out.println("\n[Entrada do usuário (opcional)]");
        System.out.println("Digite uma mensagem em Morse (caracteres separados por espaço). Ex.: ... --- ...");
        java.io.Console cons = System.console();
        if (cons != null) {
            String linha = cons.readLine("> ");
            if (linha != null) {
                String dec = arvore.decodificarMensagem(linha);
                System.out.println("Decodificado: " + dec);
            } else {
                System.out.println("Nenhuma linha lida.");
            }
        } else {
            System.out.println("Console não disponível neste ambiente.");
        }

        System.out.println("\nFim.");
    }
}
