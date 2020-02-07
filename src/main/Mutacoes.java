package main;

import java.util.ArrayList;
import java.util.List;

public class Mutacoes {

	static class Objeto {
		private int primitivo;
		private String propriedade;
		private List<Objeto> colecao;
		private Object self;
		private Objeto eu = this;

		public Objeto() {
			primitivo = 1;
			propriedade = "propriedade";
			colecao = new ArrayList<>();
			Objeto objeto = new Objeto(1, "propriedade", new ArrayList<>());
			colecao.add(objeto);
		}

		public Objeto(int pm, String p, List<Objeto> c) {
			this.primitivo = pm;
			this.propriedade = p;
			this.colecao = c;
		}

		public int getPrimitivo() {
			return primitivo;
		}

		public void setPrimitivo(int primitivo) {
			this.primitivo = primitivo;
		}

		public String getPropriedade() {
			return propriedade;
		}

		public void setPropriedade(String propriedade) {
			this.propriedade = propriedade;
		}

		public List<Objeto> getColecao() {
			return colecao;
		}

		public void setColecao(List<Objeto> colecao) {
			this.colecao = colecao;
		}

		public Object getSelf() {
			return self;
		}

		public void setSelf(Object self) {
			this.self = self;
		}

		public Objeto getEu() {
			return eu;
		}

		public void setEu(Objeto eu) {
			this.eu = eu;
		}

		@Override
		public String toString() {
			return String.format(" %d(primitivo: %d propriedade: %s colecao: %s) ", this.hashCode(),
					this.primitivo, this.propriedade, this.colecao.toString());
		}
	}
	
	public static void m3() {
		List<Objeto> list = new ArrayList<>();
		Objeto objeto = new Objeto();
		
		list.add(objeto);
		
		System.out.println(list);
		
		Objeto objeto2 = objeto;
		objeto2.setPrimitivo(2);
		
		System.out.println(list);
		
		
	}
	
	public static void m4() {
		List<Objeto> list = new ArrayList<>();
		Objeto objeto = new Objeto();
		
		list.add(objeto);
		
		System.out.println(list);
		
		Objeto objeto2 = troca(objeto);
		objeto2.setPrimitivo(2);
		
		System.out.println(list);
		
		
	}
	
	public static void m5() {
		int i = 1;
		int[] array = {i};
		
		for(int ii : array) {
			System.out.println(ii);
		}
		i = 2;		
		for(int ii : array) {
			System.out.println(ii);
		}
	}
	
	public static void m7() {
		Integer i = Integer.valueOf(1);
		Integer[] array = {i};
		
		for(Integer ii : array) {
			System.out.println(ii);
		}
		array[0] = i;
		i = Integer.valueOf(0);;
		for(Integer ii : array) {
			System.out.println(ii);
		}
	}
	
	public static void m6() {
		int i = 1;
		int[] array = {i};
		
		for(int ii : array) {
			System.out.println(ii);
		}
		array[0] = i;
		i = 0;
		for(int ii : array) {
			System.out.println(ii);
		}
	}
	
	public static void m2() {
		List<Objeto> list = new ArrayList<>();
		Objeto objeto = new Objeto();
		
		list.add(objeto);
		
		System.out.println(list);
		
		objeto.setPrimitivo(2);
		
		System.out.println(list);
		
		
	}

	public static void main(String[] args) {
		m6();
	}
	
	public static Objeto troca(Objeto objeto) {
		Objeto o = objeto;		
		return o;
	}

	public static void mudaParametro(String parametro) {
		parametro = String.valueOf(parametro.hashCode());
	}

	public static void mudaParametro(int parametro) {
		parametro = Integer.valueOf(parametro).hashCode();
	}

	public static void mudaParametro(Object parametro) {
		parametro = parametro.hashCode();
	}

	public static void mudaObjeto(Objeto objeto) {
		objeto.setPropriedade(objeto.getPropriedade() + String.valueOf(objeto.getPrimitivo()));
		// objeto.getColecao().add(objeto.getEu());
		objeto.setPrimitivo(objeto.getPrimitivo() + 1);
	}
}
