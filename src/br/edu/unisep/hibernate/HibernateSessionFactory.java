package br.edu.unisep.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	
private static SessionFactory sessionFactory;
	
	/*
	 * C�digo definido no bloco de inicializa��o estatico ser� executado
	 * apenas uma �nica vez, na primeira utiliza��o da classe DespesaDAO
	 */
	static {
		
		Configuration config = new Configuration();
		/*
		 * Carrega as configura��es definidade no arquivo hibernate.cfg.xml,
		 * aplicando-as ao objeto configuration
		 */
		config.configure();
		
		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
		srb.applySettings(config.getProperties());
		
		StandardServiceRegistry reg = srb.build();
		
		/*
		 * Cria o objeto SessionFActory, que ser� responsavel por gerar objetos
		 * Session, que ser�o utilizados para comunica��o com o banco de dados.
		 */
		sessionFactory = config.buildSessionFactory(reg);	
	}
	
	/*
	 * M�todo respons�vel por retornar uma sess�o de comunica��o
	 * com o banco de dados 
	 */
	public static Session getSession(){
		return sessionFactory.openSession();
	}

}
