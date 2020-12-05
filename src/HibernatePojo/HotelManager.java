package HibernatePojo;
import java.awt.List;
import java.util.Iterator;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
		 System.out.println("Perro " + c.getIdCliente() + " insertado		correctamente");
		}
	//read
	@SuppressWarnings("rawtypes")
	public static List read() {
		 String c = "FROM clientes";
		 Session sessionObj = getSessionFactory().openSession();
		 List results = (List) sessionObj.createQuery(c).list();
		 Iterator perrossiterator = ((java.util.List) results).iterator();
		 while (perrossiterator.hasNext()) {
			 Clientes c2 = (Clientes) perrossiterator.next();
		 System.out.println(" - " + c2.getNombre() + " - " +
		c2.getApellidos() + " - " + c2.getEmail() + " - " + c2.getDni()+" - "+c2.getClave());
		 }
		 sessionObj.close();
		 return results;
		} 
	// update
	public static void update(Clientes cliente) {
		 Session sessionObj = getSessionFactory().openSession();
		 Transaction transObj = sessionObj.beginTransaction();
		 Clientes c3 = (Clientes) sessionObj.load(Clientes.class, cliente.getIdCliente());
		 /* Modificamos todos los atributos */
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
		 Clientes peliculaBD = (Clientes) sessionObj.load(Clientes.class,
		cliente.getIdCliente());
		 sessionObj.delete(peliculaBD);
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
