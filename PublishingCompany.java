import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Random;

public class PublishingCompany implements Subject {

    private List<Observer> observers;
    private Map<String, IEntregavel> entregaveis;

    public PublishingCompany() {
        observers = new ArrayList<>();
        entregaveis = new HashMap<>();
    }

    public void iniciar() throws InterruptedException {
        
        Date startDate = Calendar.getInstance().getTime();
        
        while(observers.size() > 0){
            
            Date currentDate = Calendar.getInstance().getTime();
            
            if (currentDate.getTime() - startDate.getTime() > 86400){
                notifyObservers();
                startDate = currentDate;
            } 
            Thread.sleep(10000);
        }
        System.out.println("Falimos");
    }

    public void putEntregravel(String key, IEntregavel value){
        entregaveis.put(key, value);
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);

    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);

    }

    @Override
    public void notifyObservers() {
        
        Calendar date = Calendar.getInstance();

        Map<String, IEntregavel> realEntregaveis;
        
        if(date.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){  
            realEntregaveis = entregaveis;
        }
        else{
            realEntregaveis = entregaveis.entrySet()
            .stream()
            .filter(e -> e.getKey().contains("daily"))
            .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        }    
        
		List<Observer> observersToRemove = new ArrayList<>();
		
        for (Observer o : observers) {
			o.update(realEntregaveis);
			
 			Random gerador = new Random();
			
			if (gerador.nextInt(10) == 0) {
				observersToRemove.add(o);
			}
        }
		for (Observer o : observersToRemove){
			observers.remove(o);
			System.out.println("------------------------------------------------\nObserver Removido");
		}
        System.out.println("------------------------------------------------");
    }
}