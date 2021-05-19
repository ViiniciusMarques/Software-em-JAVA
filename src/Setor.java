import java.util.ArrayList;

public class Setor {
    private String nome;
    private int codIdentificacao;
    private double orcamento;
    private ArrayList<Produto> produtos = new ArrayList<>();
    
    public void removerItem(String nome){
        for(int i=0; i < produtos.size(); i++){
            if(produtos.get(i).getNome().equals(nome)){
                produtos.remove(i);
            }
        }
    }
    
    public void alterarItem(Produto produto, String nome){
        for(int i=0; i < produtos.size(); i++){
            if(produtos.get(i).getNome().equals(nome)){
                produtos.set(i, produto);        
            }
        }
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodIdentificacao() {
        return codIdentificacao;
    }

    public void setCodIdentificacao(int codIdentificacao) {
        this.codIdentificacao = codIdentificacao;
    }

}
