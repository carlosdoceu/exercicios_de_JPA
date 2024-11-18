package modelo.teste.manytomany;

import infra.DAO;
import modelo.manytomany.Sobrinho;
import modelo.manytomany.Tio;

public class NovoTioSobrinho {
	public static void main(String[] args) {
		Sobrinho sobrinho1 = new Sobrinho("Sobrinho1");
		Sobrinho sobrinho2= new Sobrinho("Sobrinho2");
//		Sobrinho sobrinho3 = new Sobrinho();
//		Sobrinho sobrinho4 = new Sobrinho();
//		Sobrinho sobrinho5 = new Sobrinho();
		
		Tio tio1 = new Tio("Tio1");
		Tio tio2 = new Tio("Tio2");
		Tio tio3 = new Tio("Tio3");
		Tio tio4 = new Tio("Tio4");
		Tio tio5 = new Tio("Tio5");
		
		tio1.getSobrinhos().add(sobrinho1);
		sobrinho1.getTios().add(tio1);
		
		tio1.getSobrinhos().add(sobrinho2);
		sobrinho2.getTios().add(tio1);
		
		
		tio2.getSobrinhos().add(sobrinho1);
		sobrinho1.getTios().add(tio2);
		
		tio2.getSobrinhos().add(sobrinho2);
		sobrinho2.getTios().add(tio2);
		
		
		DAO<Object> dao = new DAO<>();
		
		dao.abrirT()
		.incluir(tio1)
		.incluir(tio2)
		.incluir(sobrinho1)
		.incluir(sobrinho2)
		.fecharT()
		.fechar();
		
		
	}

}
