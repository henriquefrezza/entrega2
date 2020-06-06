public class PontoInicial{
    public static void main(String[] args) throws InterruptedException {
        var editora = new PublishingCompany();

        var dailyEstadao = new Entregavel("Estadao Daily Content");
        var weeklyEstadao = new Entregavel("Estadao Weekly Content");
        var weeklyMarieClaire = new Entregavel("Marie Claire Weekly Content");

        editora.putEntregravel("dailyEstadao", dailyEstadao);
        editora.putEntregravel("weeklyyEstadao", weeklyEstadao);
        editora.putEntregravel("weeklyMarieClaire", weeklyMarieClaire);

        var jose = new Pessoa("dailyEstadao");
        var joao = new Pessoa("weeklyyEstadao"); 
        var maria = new Pessoa("weeklyMarieClaire");

        editora.addObserver(jose);
        editora.addObserver(joao);
        editora.addObserver(maria);
		
		System.out.println("------------------------------------------------");

        editora.iniciar();

    }
}