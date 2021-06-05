package br.com.caelum.tarefas.hibernate;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;

public class GeraTabela {

	public static void main(String[] args) {

		adicionaNovaTarefa();
//		buscandoPorId();
//		removendoPorId();

	}

	public static void adicionaNovaTarefa() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");

		EntityManager manager = factory.createEntityManager();

		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Estudar JPA");
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());

		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
		
	}
	
	public static void buscandoPorId() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();

		Tarefa encontrada = manager.find(Tarefa.class, 3L);
		
		System.out.println(encontrada.getId());
		System.out.println(encontrada.getDescricao());

		manager.close();
		factory.close();
		
	}
	
	public static void removendoPorId() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();

		Tarefa encontrada = manager.find(Tarefa.class, 3L);
		
		System.out.println(encontrada.getId());
		System.out.println(encontrada.getDescricao());
		
		// apaga o objeto do banco
		manager.getTransaction().begin();
		manager.remove(encontrada);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
		
	}

}
