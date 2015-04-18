import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AgenciaDeBuses {

	static BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		final Agencia agencia = new Agencia();

		menu(agencia);
		System.out.println("Gracias por preferir nuestros servicios :)");
		/*falta reporte de archivos en las clases*/
	}
	public static void menu(final Agencia agencia) throws IOException{
		int opcion=0;
		int opcion2=0;

		while(opcion<4){
			System.out.println(" 1.-Abrir ventana"
					+"\n 2.-Eliminar"
					+"\n 3.-Editar"
					+"\n 4.-Salir");

			String ingresado=leer.readLine();
			agencia.esNumero(ingresado);
			opcion=Integer.parseInt(ingresado);

			if(opcion<4){
				if(opcion==1){
					
					EventQueue.invokeLater(new Runnable() {

						public void run() {
							try {
								MenuPrincipal frame = new MenuPrincipal(agencia);

								frame.setVisible(true);

							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
				}
				
				if(opcion==2){
					System.out.println("Eliminar");

				}
				if(opcion==3){
					System.out.println("Editar");
					
				}
				
				
			}
		}
	}

}
