public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = new No();
    }

    public void inicializarPadrao() {
        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.", 'F');
        inserir("--.", 'G');
        inserir("....", 'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-", 'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-", 'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');

        inserir("-----", '0');
        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
    }

    public void inserir(String caminho, char c) {
        No atual = raiz;
        int i = 0;
        int n = caminho.length();
        while (i < n) {
            char ch = caminho.charAt(i);
            if (ch == '.') {
                if (atual.esq == null) {
                    atual.esq = new No();
                }
                atual = atual.esq;
            } else if (ch == '-') {
                if (atual.dir == null) {
                    atual.dir = new No();
                }
                atual = atual.dir;
            }
            i = i + 1;
        }
        atual.valor = c;
    }

    public char buscarPorCaminho(String caminho) {
        No atual = raiz;
        int i = 0;
        int n = caminho.length();
        while (i < n) {
            char ch = caminho.charAt(i);
            if (ch == '.') {
                if (atual.esq == null) {
                    return '?';
                }
                atual = atual.esq;
            } else if (ch == '-') {
                if (atual.dir == null) {
                    return '?';
                }
                atual = atual.dir;
            } else {
                return '?';
            }
            i = i + 1;
        }
        if (atual == null) {
            return '?';
        }
        if (atual.valor == '\0') {
            return '?';
        }
        return atual.valor;
    }

    public String decodificarMensagem(String mensagemMorse) {
        String resultado = "";
        String token = "";
        int i = 0;
        int n = mensagemMorse.length();

        while (i < n) {
            char ch = mensagemMorse.charAt(i);
            if (ch == ' ') {
                if (token.length() > 0) {
                    char dec = buscarPorCaminho(token);
                    resultado = resultado + dec;
                    token = "";
                }
            } else {
                token = token + ch;
            }
            i = i + 1;
        }
        if (token.length() > 0) {
            char dec = buscarPorCaminho(token);
            resultado = resultado + dec;
        }
        return resultado;
    }

    public void removerSimbolo(String caminho) {
        No atual = raiz;
        int i = 0;
        int n = caminho.length();
        while (i < n) {
            char ch = caminho.charAt(i);
            if (ch == '.') {
                if (atual.esq == null) {
                    return;
                }
                atual = atual.esq;
            } else if (ch == '-') {
                if (atual.dir == null) {
                    return;
                }
                atual = atual.dir;
            } else {
                return;
            }
            i = i + 1;
        }
        if (atual != null) {
            atual.valor = '\0';
        }
    }

    public void exibir() {
        exibirRec(raiz, 0);
    }

    private void exibirRec(No no, int nivel) {
        if (no == null) {
            return;
        }
        String indent = repetir("  ", nivel);
        char mostrar = no.valor == '\0' ? '-' : no.valor;
        System.out.println(indent + mostrar);
        exibirRec(no.esq, nivel + 1);
        exibirRec(no.dir, nivel + 1);
    }

    private String repetir(String s, int vezes) {
        String r = "";
        int i = 0;
        while (i < vezes) {
            r = r + s;
            i = i + 1;
        }
        return r;
    }
}
