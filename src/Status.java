public enum Status {
    AGUARDANDO(1), FINALIZADO(2), CANCELADO(3);
    
    private int valor;
    
    Status(int valor){
        this.valor = valor;
    }
    
    public int getValor() {
        return this.valor;
    }
    
}
