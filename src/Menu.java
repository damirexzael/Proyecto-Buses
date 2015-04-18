import java.util.ArrayList;
import java.util.Scanner;


public class  Menu {
	private static Agencia agencia = new Agencia();
	private static Scanner leer = new Scanner(System.in);

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		// Agregar Lugares
		Lugar valpo = agencia.agregarLugar("valparaiso");
		Lugar stgo = agencia.agregarLugar("santiago");
		Lugar tmco = agencia.agregarLugar("temuco");
		
		// Agregar tramos
		Tramo tramo1 = agencia.agregarTramo(valpo, stgo, 2500);
		Tramo tramo2 = agencia.agregarTramo(valpo, tmco, 10000);
		Tramo tramo3 = agencia.agregarTramo(tmco, valpo, 10000);
		Tramo tramo4 = agencia.agregarTramo(tmco, stgo, 8000);
		
		// Agregar bus
		Bus bus1 = tramo1.agregarBus("04", "03","14", "20", "04", "02", "2015");
		Bus bus2 = tramo1.agregarBus("04", "03","14", "20" , "05", "02", "2015");
		Bus bus3 = tramo1.agregarBus("04", "03","14", "20", "06", "02", "2015");
		Bus bus4 = tramo1.agregarBus("04", "03","14", "20","07", "02", "2015");

		// Agregar cliente
		Cliente cliente1 = agencia.agregarCliente("111111111", "nombres", "apellidos", "fechaNacimiento", true, "telefono");
		Cliente cliente2 = agencia.agregarCliente("222222222", "nombres", "apellidos", "fechaNacimiento", true, "telefono");
		Cliente cliente3 = agencia.agregarCliente("333333333", "nombres", "apellidos", "fechaNacimiento", true, "telefono");
		Cliente cliente4 = agencia.agregarCliente("44444444", "nombres", "apellidos", "fechaNacimiento", true, "telefono");
		Cliente cliente5 = agencia.agregarCliente("181944773", "nombres", "apellidos", "fechaNacimiento", true, "telefono");
		
		// ComprarPasaje
		agencia.comprarPasaje(bus1, "181944773", "wdas", tramo1.getSalida(), tramo1.getLlegada(), 33, 2343423);
//		cliente1.agregarPasaje(tramo1.getSalida(), tramo1.getLlegada(), 33, tramo1.getTarifa(), bus1);
//		cliente1.agregarPasaje(tramo1.getSalida(), tramo1.getLlegada(), 33, tramo1.getTarifa(), bus2);


		// Abrir ventana BuscarBuses
//		BuscarBuses frame = new BuscarBuses(agencia, cliente1);
//		frame.setVisible(true);
		
//		System.out.println(agencia.validarRut("18648133K"));
		
//		LoginRut frame = new LoginRut(agencia);
//		frame.setVisible(true);
//		
		MenuPrincipal frame = new MenuPrincipal(agencia);
		frame.setVisible(true);
		
//		menuPrincipal();
//		MenuPato menu = new MenuPato();
		System.out.println("¡Gracias por usar nuestra aplicacion!");
		
	}

	public static void menuPrincipal() {
		String opcion;
		System.out.println("MENU PRINCIPAL");
		System.out.println("0.- Para salir de la aplicacion.");
		System.out.println("1.- Para agregar un lugar.");
		System.out.println("2.- Para editar un lugar.");
		System.out.println("3.- Para listar todos los lugares.");
		System.out.println("4.- Para agregar un Tramo.");
		System.out.println("5.- Para listar todos los Tramos.");

		leer = new Scanner(System.in);
		opcion = leer.next();
		if(opcion.equals("1"))
			menuAgregarLugar();
		else if(opcion.equals("2"))
			menuEditarLugar();
		else if(opcion.equals("3")) 
			menuListarLugares();
		else if(opcion.equals("4")) 
			menuAgregarTramo();
		else if(opcion.equals("5")) 
			menuListaTramos();
		else if(!opcion.equals("0"))
			menuPrincipal();

	}

	public static void menuAgregarLugar() {
		System.out.println("AGREGAR LUGAR");
		System.out.print("Ingrese cantidad de lugares que quiere agregar: ");

		leer = new Scanner(System.in);
		int opcion = leer.nextInt();
		String lugar;
		ArrayList<String> agregados = new ArrayList<String>();
		
		for(int i = 0; i < opcion; i++) {
			System.out.print("Escriba el lugar " + (i + 1) + "/" + opcion + ": ");
			leer = new Scanner(System.in);
			lugar = leer.nextLine();
			Lugar lugarAgregado = agencia.agregarLugar(lugar);
			if(lugarAgregado!=null)
				agregados.add(lugarAgregado.getLugar());
		}
		if(agregados.size() > 0)
			System.out.println("Se agregaron: ");
		else
			System.out.println("No se agrego ningun lugar.");
		for(int i=0; i < agregados.size(); i++)
			System.out.println(agregados.get(i));
		menuPrincipal();		
	}
	

	public static void menuEditarLugar() {
		System.out.print("Nombre del lugar a editar: ");

		leer = new Scanner(System.in);
		String opcion = leer.nextLine();
		
		Lugar lugar = agencia.buscarLugar(opcion);
		if(lugar!=null)
			menuEditarLugar(lugar);
		else {
			System.out.println("No se ha encontrado un lugar llamado \"" + opcion + "\"");
			menuPrincipal();
		}
	}
	
	public static void menuEditarLugar(Lugar lugar) {
		System.out.println("EDITAR LUGAR \"" + lugar.getLugar() + "\"");
		System.out.println("0.- Para salir de la aplicacion.");
		System.out.println("1.- Para volver al menu principal.");
		System.out.println("2.- Para editar otro lugar.");
		System.out.println("3.- Para cambiar el nombre.");
		System.out.println("4.- Para borrar este lugar.");

		leer = new Scanner(System.in);
		String opcion = leer.next();
		
		if(opcion.equals("1"))
			menuPrincipal();
		else if(opcion.equals("2")) {
			menuEditarLugar();
		}
		else if(opcion.equals("3")) {
			System.out.print("Escriba un nuevo nombre: ");

			leer = new Scanner(System.in);
			String nombre = leer.nextLine();
			
			if(agencia.buscarLugar(nombre) == null) {
				lugar.setLugar(nombre);
				System.out.println("Se ha editado correctamente.");
			}
			else
				System.out.println("Ya existe otro lugar con ese nombre.");
			menuEditarLugar(lugar);
		}
		else if(opcion.equals("4")) {
			if(agencia.borrarLugar(lugar)!=null)
				System.out.println("Se ha borrado correctamente.");
			else
				System.out.println("No se ha podido borrar el lugar.");
			menuPrincipal();
		}
		else if(!opcion.equals("0")) {
			System.out.println("Error al seleccionar una opcion, intente otra vez.");
			menuEditarLugar(lugar);
		}
	}
	
	public static void menuListarLugares() {
		Lugar[] lista = agencia.listarLugares();
		System.out.println("LISTA LUGARES");
		for(int i = 0; i < lista.length; i++)
			System.out.println((i + 1) + ".- Para editar " + lista[i].getLugar());
		System.out.println("Otro numero para volver al menu principal.");
		

		leer = new Scanner(System.in);
		int opcion = leer.nextInt();
		
		if(opcion > 0 && opcion < lista.length + 1)
			menuEditarLugar(lista[opcion-1]);
		else
			menuPrincipal();
	}
	
	public static void menuAgregarTramo() {
		if(agencia.listarLugares().length > 1) {
			System.out.println("AGREGAR TRAMO");
			System.out.println("Para cancelar ingrese 0.");
			Lugar[] lista = agencia.listarLugares();
			for(int i = 0; i < lista.length; i++)
				System.out.println((i + 1) + ".- " + lista[i].getLugar());
			Lugar salida = null;
			int lugar1=-1;
			while(salida == null && lugar1!=0) {
				System.out.print("Seleccione salida: ");
				leer = new Scanner(System.in);
				lugar1 = leer.nextInt();
				if(lugar1 > 0 && lugar1 < lista.length + 1) {
					salida = lista[lugar1 - 1];
				}
				else if(lugar1!=0)
					System.out.println("Numero fuera de rango, intente nuevamente.");
			}
			if(lugar1!=0) {
				Lugar llegada = null;
				int lugar2=-1;
				while(llegada == null && lugar2!=0 || lugar1 == lugar2) {
					System.out.print("Seleccione llegada: ");
					leer = new Scanner(System.in);
					lugar2 = leer.nextInt();
					if(lugar2 > 0 && lugar2 < lista.length + 1) {
						llegada = lista[lugar2 - 1];
					}
					else if(lugar2!=0)
						System.out.println("Numero fuera de rango, intente nuevamente.");
					if(lugar1 == lugar2)
						System.out.println("No puede ser el lugar de salida igual al lugar de llegada.");
				}
				if(lugar2!=0) {
					int tarifa=-1;
					while(tarifa < 1) {
						System.out.print("Ingrese tarifa: ");
						leer = new Scanner(System.in);
						tarifa = leer.nextInt();
					}
					if(tarifa!=0) {
						agencia.agregarTramo(salida, llegada, tarifa);
						System.out.println("Se ha agregado correctamente el tramo.");
					}
				}
					
			}
			menuPrincipal();
		}
		else {
			System.out.println("Primero tienes que tener un minimo de dos lugares.");
			menuPrincipal();
		}
	}
	
	public static void menuListaTramos() {
		System.out.println("LISTA DE TRAMOS");
		if(agencia.listarTramos().length == 0)
			System.out.println("Aun no se ha agregado algun tramo.");
		System.out.println("0.- Para volver al menu principal.");
		for(int i=0; i < agencia.listarTramos().length; i++)
			System.out.println((i + 1) + ".- Para editar el tramo " + agencia.listarTramos()[i].getSalida().getLugar() + 
					"-" + agencia.listarTramos()[i].getLlegada().getLugar() + " con una tarifa de " + agencia.listarTramos()[i].getTarifa());
		
		int opcion = leer.nextInt();
		
		if(opcion == 0)
			menuPrincipal();
		else if(opcion > 0 && opcion < agencia.listarTramos().length + 1)
			menuEditarTramo(agencia.listarTramos()[opcion - 1]);
		else if(opcion!=0) {
			System.out.println("Numero fuera del rango, intente otra vez.");
			menuListaTramos();
		}
	}
	
	public static void menuEditarTramo(Tramo tramo) {
		System.out.println("EDITAR TRAMO \"" + tramo.getSalida().getLugar() + " - " + tramo.getLlegada().getLugar() + "\" con una tarifa de " + tramo.getTarifa());
		System.out.println("0.- Para volver al menu principal.");
		System.out.println("1.- Para volver a la lista de tramos.");
		System.out.println("2.- Para cambiar el precio.");
		System.out.println("3.- Para borrar tramo.");

		leer = new Scanner(System.in);
		int opcion = leer.nextInt();
		
		if(opcion == 0)
			menuPrincipal();
		else if(opcion == 1) 
			menuListaTramos();
		else if(opcion == 2) {
			System.out.print("Ingrese la nueva tarifa: ");
			leer = new Scanner(System.in);
			int precio = leer.nextInt();
			if(tramo.setTarifa(precio))
				System.out.println("Se ha cambiado correctamente la tarifa.");
			else
				System.out.println("La tarifa tiene que ser mayor a cero.");
			menuEditarTramo(tramo);
		}
		else if(opcion == 3) {
			if(agencia.borrarTramo(tramo)!=null)
					System.out.println("Se ha eliminado correctamente este tramo.");
			else
				System.out.println("No se ha podido borrar este tramo.");
			menuPrincipal();
		}
		else if(opcion!=0)
			menuEditarTramo(tramo);
	}
}
