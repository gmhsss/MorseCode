public class No {
    public char valor; // '\0' indica vazio
    public No esq;     // ponto '.'
    public No dir;     // traço '-'

    public No() {
        this.valor = '\0';
        this.esq = null;
        this.dir = null;
    }
}
