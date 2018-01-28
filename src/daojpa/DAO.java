/**IFPB - Curso SI 
 * Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */


package daojpa;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.eclipse.persistence.config.PersistenceUnitProperties;


public class DAO<T> implements DAOInterface<T> {
	protected static EntityManager manager;

	public DAO(){}

	public static void abrir(){
		if(manager==null){
			//propriedades do persistence.xml  podem ser alteradas		
			HashMap<String,String> properties = new HashMap<String,String>();		
//			properties.put(PersistenceUnitProperties.JDBC_DRIVER, "com.mysql.jdbc.Driver" );	
//			properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:mysql://127.0.0.1:3306/teste");
//			properties.put(PersistenceUnitProperties.JDBC_USER, "root");
//			properties.put(PersistenceUnitProperties.JDBC_PASSWORD, "root");
//			properties.put(PersistenceUnitProperties.DDL_GENERATION, "create-tables");
//			properties.put(PersistenceUnitProperties.DDL_GENERATION_MODE, "database");
//			properties.put(PersistenceUnitProperties.LOGGING_LEVEL, "off");
//			properties.put(PersistenceUnitProperties.LOGGING_FILE, "log.txt");
			System.out.println("Oi, vou tentar criar a conex�o agora.");
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("teste", properties);
			manager = factory.createEntityManager();
		}
	}
	public static void fechar(){
		if(manager != null)
			manager = null;
	}
	public void persistir(T obj){
		manager.persist(obj);
	}
	public T atualizar(T obj){
		return manager.merge(obj);
	}
	public void apagar(T obj) {
		manager.remove(obj);
	}
	public void reler(T obj){
		manager.refresh(obj);
	}	
	@SuppressWarnings("unchecked")
	public List<T> listar(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query query = manager.createQuery("select x from " + type.getSimpleName() + " x");
		return (List<T>) query.getResultList();
	}

	//----------------------- TRANSA��O   ----------------------
	public static void iniciar(){
		if(!manager.getTransaction().isActive())
			manager.getTransaction().begin();
	}
	public static void efetivar(){
		if(manager.getTransaction().isActive()){
			manager.getTransaction().commit();
			manager.clear();		// ---- esvaziar o cache de objetos
		}
	}
	public static void cancelar(){
		if(manager.getTransaction().isActive())
			manager.getTransaction().rollback();
	}



	//	@SuppressWarnings("unchecked")
	//	public T localizar(Object chave){	----- localizar pela chave primaria
	//		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
	//				.getGenericSuperclass()).getActualTypeArguments()[0];
	//		return manager.find(type, chave);
	//	}
	

}

