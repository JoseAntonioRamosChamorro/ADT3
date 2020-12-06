package hibernatePojo;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;
public class HotelManager {


	private static SessionFactory getSessionFactory() {

		SessionFactory sessionFactory = new Configuration()
				.addAnnotatedClass(Clientes.class).configure().buildSessionFactory();
		return sessionFactory;

	}
	//crear
	public static void create(Clientes c) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(c);
		transObj.commit();
		sessionObj.close();
		System.out.println("Cliente " + c.getIdCliente() + " insertado		correctamente");
	}
	//read

	public static List read() {
		Session sessionObj = getSessionFactory().openSession();
		String c = "FROM Clientes";
		List results =  sessionObj.createQuery(c).list();
		sessionObj.close();
		return results;
	} 
	// update
	public static void update(Clientes cliente) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Clientes c3 = (Clientes) sessionObj.load(Clientes.class, cliente.getIdCliente());
		//Modificamos todos los atributos 
		c3.setNombre(cliente.getNombre());
		c3.setApellidos(cliente.getApellidos());
		c3.setEmail(cliente.getEmail());
		c3.setDni(cliente.getDni());
		c3.setClave(cliente.getClave());
		transObj.commit();
		sessionObj.close();
		System.out.println("Actualizado correctamente");
	} 

	//delete
	public static void delete(Clientes cliente) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Clientes client = (Clientes) sessionObj.load(Clientes.class,cliente.getIdCliente());
		sessionObj.delete(client);
		transObj.commit();
		sessionObj.close();
		System.out.println("Eliminado correctamente");
	} 

	public static void main(String[] args) {

		Clientes p1 = new Clientes("JoséAnt", "Ramos", "joseantonioramoschamorro@gmail.com", "12345678A",
				"12345678A");
		
	
		create(p1); 
		read();
		update(p1);	 
		delete(p1);

	}

}
