import java.util.Map;

public class Pessoa implements Observer {
    
    private String subscription;

    public Pessoa (String subs){
        subscription = subs;
    }

	@Override
    public void update(Map<String, IEntregavel> content) {
        if(content.containsKey(subscription)) showContent(content.get(subscription));        
    }

    public void showContent(IEntregavel c){
        System.out.println(c.getContent());    
    }

    public String getSubscription(){
        return subscription;
    } 
}