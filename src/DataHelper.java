import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHelper{
    Date data = new Date(System.currentTimeMillis());
    private Date dataParaManipular;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    public DataHelper() {
        this.dataParaManipular = data;
    }
    
    public String getData(){
        return this.formato.format(dataParaManipular);
    }
}
