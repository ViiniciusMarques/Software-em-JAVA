import java.util.Random;
import java.util.ArrayList;

public class Pedido {
    private int numero;
    private Double valorTotal;
    private String prioridade;
    private String responsavel;
    private Enum status;
    private ArrayList<Requisicao> requisicoes = new ArrayList<>();
    
    public double setValorTotal(Pedido pedido){
        this.valorTotal = 0.0;
        for(Requisicao r: requisicoes){
           this.valorTotal += r.getProduto().getValor()*r.getQuantidade();
        }
        return this.valorTotal;
    }
    
     public double getValorTotal(){
        return valorTotal;
    }
    
    public int setNumero(Pedido pedido) {
       Random random = new Random();
       this.numero = random.nextInt(32767);
       return numero;
    }
    
     public int getNumero() {
        return numero;
    }

    public ArrayList<Requisicao> getRequisicoes() {
        return requisicoes;
    }

    public void setRequisicoes(ArrayList<Requisicao> requisicoes) {
        this.requisicoes = requisicoes;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }
    
}
