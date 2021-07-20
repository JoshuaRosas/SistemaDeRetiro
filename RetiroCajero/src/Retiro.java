import javax.swing.JOptionPane;
import java.util.Date;
import java.util.ArrayList;
public class Retiro {
	//prueba 1 dni 70766663 codigo cajero 1521
	//prueba 2 dni 76034593 codigo cajero 1522
	//prueba 3 dni 71206666 codigo cajero 1523

	public static void main(String[] args) {
		Date fechaActual=new Date();
	
		ListLinked <Tarjeta> tarjeta_linked = new ListLinked<Tarjeta>();
		ListLinked <Cajero> cajero_linked = new ListLinked<Cajero>();
		ListLinked <Banco> banco_linked = new ListLinked<Banco>();
		ArrayList <String>dnis=new ArrayList<String>();
		
		int numtra=1;
		int condi=1;
		int selec;
		
		
		Cajero cajero1=new Cajero(2150508,"Av.Parra 217, Arequipa");
		
		Cliente cli1=new Cliente("Ismael Rodriguez Hanco","70766663","Calle los Arces 217" );
		Cliente cli2=new Cliente("Joshua Rosas Mendizabal","76034593","Calle los Alamos 217" );
		Cliente cli3=new Cliente("Mathias Miranda Rivera","71206666","Calle Nilo 217" );
		
		Cuenta cuenta0=new Cuenta("215-99742247-0-37",2000,2000,"Ahorros");
		Cuenta cuenta1=new Cuenta("215-99742247-0-26",700,700,"Corriente");
		Cuenta cuenta2=new Cuenta("215-99742247-0-21",20000,15000,"Ahorros");
		
		Banco banco1=new Banco(321,"BCP",3119898,"www.viabcp.com",cuenta0);//fijas
		Banco banco2=new Banco(128,"Scotiabank",2119590,"www.scotiabank.com",cuenta0);
		Banco banco3=new Banco(451,"Interbank",1005555,"www.interbank.com",cuenta0);
		
		Tarjeta t1=new Tarjeta("4557880597426185","Debito","05/21","186",1521,cuenta0,cli1);
		Tarjeta t2=new Tarjeta("4557880597426181","Debito","05/21","186",1522,cuenta1,cli2);
		Tarjeta t3=new Tarjeta("4557880597426181","Debito","05/21","186",1523,cuenta2,cli3);
		
		dnis.add("70766663");
		dnis.add("76034593");
		dnis.add("71206666");
		
		//ingreso informacion
		cajero_linked.insertFirst(cajero1);
		
		banco_linked.insertFirst(banco1);
		banco_linked.insertFirst(banco2);
		banco_linked.insertFirst(banco3);
		
		tarjeta_linked.insertFirst(t1);
		tarjeta_linked.insertFirst(t2);
		tarjeta_linked.insertFirst(t3);
		
	
	
		//JOptionPane.showMessageDialog(null,tarjeta_linked.searchData(t3));
		JOptionPane.showMessageDialog(null,"Bienvenido al cajero multired SIA \n"+ "Introdusca su tarjeta en la ranura...");
		while(condi!=0) {
			selec =Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a la interfaz de seleccion \n"
					+ "Antes de empezar con su retiro elija su Banco \n"
					+ "1. BCP\n"
					+ "2. ScotiaBank\n"
					+ "3. Interbank\n"
					+ "4. Devolver tarjeta"));
			switch(selec) {
			case 1:
				JOptionPane.showMessageDialog(null,"Bienvenido a su agente BCP");
				String dniingreso1 =JOptionPane.showInputDialog("Ingrese su numero de DNI valido\n");
				int  codcajingreso1 =Integer.parseInt(JOptionPane.showInputDialog("Ingrese los 4 digitos de u codigo de cajero\n"));
				Tarjeta veritar=new Tarjeta();
				veritar.setClavcaj(codcajingreso1);
				while (tarjeta_linked.searchData(veritar)==null ||dnis.contains(dniingreso1)==false) {
					JOptionPane.showMessageDialog(null,"Clave de cajero o dni incorrecta");	
					 dniingreso1 =JOptionPane.showInputDialog("Ingrese su numero de DNI valido\n");
					 codcajingreso1 =Integer.parseInt(JOptionPane.showInputDialog("Ingrese los 4 digitos de u codigo de cajero\n"));
					 veritar.setClavcaj(codcajingreso1);
				}
				JOptionPane.showMessageDialog(null,"Ingreso exitoso");
				Tarjeta p1= new Tarjeta();
				p1.setClavcaj(codcajingreso1);
				Tarjeta dtran=tarjeta_linked.searchData(p1);
				JOptionPane.showMessageDialog(null,"Saldo Disponible: "+dtran.getNumcuen().getSaldis());
				double montretiro=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a retirar"));
				double retiro =retirar(dtran.getNumcuen().getSaldis(),montretiro);
				double retirocon=retirar(dtran.getNumcuen().getSalcon(),montretiro);
				if (retiro==-1)
					JOptionPane.showMessageDialog(null,"El saldo de su cuenta es insuficiente");
				else {
					JOptionPane.showMessageDialog(null,"Retiro realizado, recoja su voucher de retiro");
					JOptionPane.showMessageDialog(null,"                                                     BANCO: "+banco1.getNombre()+"\n"
							+ "PARA MAYOR INFORMACION: \n"
							+ "TEL: "+banco1.getTel()+"\n"
							+ "DIRWEB: "+banco1.getDirweb()+"\n"
							+ "----------------------------------------------------------------\n"
							+ "FECHA Y HORA:"+fechaActual+"\n"
							+ "NRO OPE: "+numtra+"  TARJETA: "+dtran.getNumtar()+"\n"
							+ "----------------------------------------------------------------\n"
							+ "RETIRO \n"
							+ "CTA AHORROS: "+dtran.getNumcuen().getNumcuenta()+"\n"
							+ "MONTO: "+"S/ "+montretiro+"\n"
							+ "SALDO CONTABLE: "+"S/ "+retirocon+"\n"
							+ "SALDO DISPONIBLE: "+"S/"+retiro+"\n"
							+ "VALIDACION VISA CHIP\n"
							+ "A0000000031010 \n"
							+ "ARQC BC4978641250D25DP \n"
							+ "----------------------------------------------------------------\n"
							+ "BCP EL BANCO DE LAS OPORTUNIDADES");
					          
				}
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Bienvenido a su agente Scotiabank");
				String dniingreso2 =JOptionPane.showInputDialog("Ingrese su numero de DNI valido\n");
				int codcajingreso2 =Integer.parseInt(JOptionPane.showInputDialog("Ingrese los 4 digitos de u codigo de cajero\n"));
				Tarjeta veritar1=new Tarjeta();
				veritar1.setClavcaj(codcajingreso2);
				while (tarjeta_linked.searchData(veritar1)==null||dnis.contains(dniingreso2)==false) {
					dniingreso2 =JOptionPane.showInputDialog("Ingrese su numero de DNI valido\n");
					codcajingreso2 =Integer.parseInt(JOptionPane.showInputDialog("Ingrese los 4 digitos de u codigo de cajero\n"));
					veritar1.setClavcaj(codcajingreso2);
					
				}
				JOptionPane.showMessageDialog(null,"Ingreso exitoso");
				Tarjeta p2= new Tarjeta();
				p2.setClavcaj(codcajingreso2);
				Tarjeta dtran1=tarjeta_linked.searchData(p2);
				JOptionPane.showMessageDialog(null,"Saldo Disponible: "+dtran1.getNumcuen().getSaldis());
				double montretiro1=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a retirar"));
				double retiro1 =retirar(dtran1.getNumcuen().getSaldis(),montretiro1);
				double retirocon1=retirar(dtran1.getNumcuen().getSalcon(),montretiro1);
				if (retiro1==-1)
					JOptionPane.showMessageDialog(null,"El saldo de su cuenta es insuficiente");
				else {
					JOptionPane.showMessageDialog(null,"Retiro realizado, recoja su voucher de retiro");
					JOptionPane.showMessageDialog(null,"                                                     BANCO: "+banco2.getNombre()+"\n"
							+ "PARA MAYOR INFORMACION: \n"
							+ "TEL: "+banco2.getTel()+"\n"
							+ "DIRWEB: "+banco2.getDirweb()+"\n"
							+ "----------------------------------------------------------------\n"
							+ "FECHA Y HORA:"+fechaActual+"\n"
							+ "NRO OPE: "+numtra+"  TARJETA: "+dtran1.getNumtar()+"\n"
							+ "----------------------------------------------------------------\n"
							+ "RETIRO \n"
							+ "CTA AHORROS: "+dtran1.getNumcuen().getNumcuenta()+"\n"
							+ "MONTO: "+"S/ "+montretiro1+"\n"
							+ "SALDO CONTABLE: "+"S/ "+retirocon1+"\n"
							+ "SALDO DISPONIBLE: "+"S/"+retiro1+"\n"
							+ "VALIDACION VISA CHIP\n"
							+ "A0000000031010 \n"
							+ "ARQC BC4978641250D25DB \n"
							+ "----------------------------------------------------------------\n"
							+ "SCOTIABANK EL BANCO LIDER EN EL PERU");
					          
				}
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Bienvenido a su agente Interbank");
				String dniingreso3 =JOptionPane.showInputDialog("Ingrese su numero de DNI valido\n");
				int codcajingreso3 =Integer.parseInt(JOptionPane.showInputDialog("Ingrese los 4 digitos de u codigo de cajero\n"));
				Tarjeta veritar2=new Tarjeta();
				veritar2.setClavcaj(codcajingreso3);
				while (tarjeta_linked.searchData(veritar2)==null||dnis.contains(dniingreso3)==false) {
					dniingreso3 =JOptionPane.showInputDialog("Ingrese su numero de DNI valido\n");
					codcajingreso3 =Integer.parseInt(JOptionPane.showInputDialog("Ingrese los 4 digitos de u codigo de cajero\n"));
					veritar2.setClavcaj(codcajingreso3);
				}
				JOptionPane.showMessageDialog(null,"Ingreso exitoso");
				Tarjeta p3= new Tarjeta();
				p3.setClavcaj(codcajingreso3);
				Tarjeta dtran2=tarjeta_linked.searchData(p3);
				JOptionPane.showMessageDialog(null,"Saldo Disponible: "+dtran2.getNumcuen().getSaldis());
				double montretiro2=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a retirar"));
				double retiro2 =retirar(dtran2.getNumcuen().getSaldis(),montretiro2);
				double retirocon2=retirar(dtran2.getNumcuen().getSalcon(),montretiro2);
				if (retiro2==-1)
					JOptionPane.showMessageDialog(null,"El saldo de su cuenta es insuficiente");
				else {
					JOptionPane.showMessageDialog(null,"Retiro realizado, recoja su voucher de retiro");
					JOptionPane.showMessageDialog(null,"                                                     BANCO: "+banco3.getNombre()+"\n"
							+ "PARA MAYOR INFORMACION: \n"
							+ "TEL: "+banco3.getTel()+"\n"
							+ "DIRWEB: "+banco3.getDirweb()+"\n"
							+ "----------------------------------------------------------------\n"
							+ "FECHA Y HORA:"+fechaActual+"\n"
							+ "NRO OPE: "+numtra+"  TARJETA: "+dtran2.getNumtar()+"\n"
							+ "----------------------------------------------------------------\n"
							+ "RETIRO \n"
							+ "CTA AHORROS: "+dtran2.getNumcuen().getNumcuenta()+"\n"
							+ "MONTO: "+"S/ "+montretiro2+"\n"
							+ "SALDO CONTABLE: "+"S/ "+retirocon2+"\n"
							+ "SALDO DISPONIBLE: "+"S/"+retiro2+"\n"
							+ "VALIDACION VISA CHIP\n"
							+ "A0000000031010 \n"
							+ "ARQC BC4978641250D25DPC \n"
							+ "----------------------------------------------------------------\n"
							+ "INTERBANK CREANDO EL FUTURO JUNTOS");
					          
				}
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Retire su tarjeta");
				condi=1;
				break;
			default:
				JOptionPane.showMessageDialog(null,"Ingrese una opcion valida");
				
				break;	
			}
			
			numtra=numtra+1;
			
		}
		
		

	}
	static double retirar(double x, double y) {
		if (x<y) {
			return -1;
		}
		else {
		return x-y;}
	}

}
