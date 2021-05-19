public enum Prioridade {
    
    BAIXA(1),NORMAL(2),ALTA(3);
    
    private int valor;
    
    Prioridade(int valor){
        this.valor = valor;
    }
    
    public int getValor() {
        return this.valor;
    }
}