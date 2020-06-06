public class Entregavel implements IEntregavel {
    private String content;

    public Entregavel(String c){
        content = c;
    }
    
    @Override
    public String getContent() {
        return content;
    }
    
}
