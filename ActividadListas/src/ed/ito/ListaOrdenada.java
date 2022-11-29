package ed.ito;

public class ListaOrdenada<E> extends ListaDinamica<E> {
	
	public ListaOrdenada() {
		super();
	}
	
	public ListaOrdenada(int limite) {
		super(limite);
	}
	
	public void addFirst(E item) throws ExcepcionDeListaLlena{
		
	}
	
    public void addLast(E item) throws ExcepcionDeListaLlena{
		
	}
    
    public void add(E item) throws ExcepcionDeListaLlena{
    	if(this.isFull())
    		throw new ExcepcionDeListaLlena();
    	NodoLista<E> nuevo = new NodoLista<E>(item);
    	if(this.isEmpty()) {
    		this.p=this.u=nuevo;
    	}else {
    		NodoLista<E> aux = this.p, ant = null;
    		Comparable<E> datos = (Comparable<E>)aux.getItem(); 
    		while(datos.compareTo(item)<0 && aux.getSig()!=null) {
    			ant=aux;
    			aux=ant.getSig();
    			datos = (Comparable<E>)aux.getItem();
    		}
    		if(datos.compareTo(item)>=0)
    			if(ant==null) {
    				nuevo.setSig(this.p);
    				this.p=nuevo;
    			}else {
    				nuevo.setSig(aux);
    				ant.setSig(nuevo);
    			}
    		else {
    		    u.setSig(nuevo);	
    		    u=nuevo;
    		}
    	}
        this.n++;
    }
}