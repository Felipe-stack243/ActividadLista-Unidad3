package ed.ito;

public class ListaDinamica<E> implements Lista<E> {
	
	protected NodoLista<E> p,u;
	protected int n;
	private int limite;

	public ListaDinamica() {
		this.limite=50;
		this.clear();
	}
	
	public ListaDinamica(int limite) {
		this.limite=limite;
		this.clear();
	}
	
	@Override
	public void add(E item) throws ExcepcionDeListaLlena {
		// TODO Auto-generated method stub
		this.addLast(item);
	}

	@Override
	public void addFirst(E item) throws ExcepcionDeListaLlena {
		// TODO Auto-generated method stub
		if(this.isFull())
			throw new ExcepcionDeListaLlena();
		
		NodoLista<E> nuevo= new NodoLista(item);
		
		if(this.isEmpty()) 
			this.u=nuevo;
		 else 
			nuevo.setSig(this.p);
		this.p=nuevo;
		this.n++;
	}

	@Override
	public void addLast(E item) throws ExcepcionDeListaLlena {
		// TODO Auto-generated method stub
		if(this.isFull())
			throw new ExcepcionDeListaLlena();
		
		NodoLista<E> nuevo= new NodoLista(item);
		
		if(this.isEmpty()) 
			this.p=nuevo;
		 else 
			this.u.setSig(nuevo);
		this.u=nuevo;
		this.n++;
	}

	@Override
	public E deleteFirst() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		E r=this.p.getItem();
		if(this.p==this.u) {
			this.p=this.u=null;
		}else
			this.p=this.p.getSig();
		this.n--;
		return r;
	}

	@Override
	public E deleteLast() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		E r=this.u.getItem();
		
		if(this.p==this.u) {
			this.p=this.u=null;
		}else {	
		     NodoLista<E> aux=this.p;
		     while(aux.getSig().getSig()!=null)
			    aux=aux.getSig();
		     this.u=aux;
		     this.u.setSig(null);
		}
		this.n--;
		return r;
	}

	@Override
	public E delete(int i) throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		E r=null;
		if(this.n>=i) {
			if(this.u==this.p){
				this.u=this.p=null;
			}else {
				NodoLista<E> aux=this.p,ant=null;
			    for(int j=1;j<i;j++) {
				    ant=aux;
				    aux=ant.getSig();
			    }
			    if(this.p==aux)
			    	this.p=aux.getSig();
			    else {
			    	ant.setSig(aux.getSig());
			    	if(aux==this.u)
			    		this.u=ant;
			    }
			}
			this.n--;
		}
		return r;
	}

	@Override
	public E delete(E item) throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		NodoLista<E> aux=this.p,ant=null;
		while(!aux.getItem().equals(item) && aux.getSig()!=null) {
			ant=aux;
			aux=ant.getSig();
		}
		E r=null;
		if(aux.getItem().equals(item)) {
			r=item;
			if(this.p==this.u) {
				this.p=this.u=null;
			}else { if(this.u==aux) 
				       this.u=ant;
			        ant.setSig(aux.getSig());
			}
			this.n--;
		}
		return r;
	}

	@Override
	public E first() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		return p.getItem();
	}

	@Override
	public E last() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		return u.getItem();
	}

	@Override
	public E getItem(int i) throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		if(this.n<i)
			return null;
		NodoLista<E> aux=this.p;
		for(int j=1;j<i;j++)
			aux=aux.getSig();
		return aux.getItem();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.n;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.p=this.u=null;
		this.n=0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.n==0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return this.n==this.limite;
	}

	@Override
	public int search(E item) {
		// TODO Auto-generated method stub
		NodoLista<E> aux=this.p;
		int i=1, k=-1;
		while(aux!=null) {
			if(aux.getItem().equals(item)) {
				k=i;
				break;
			}
			aux=aux.getSig();
			i++;
		}
		return k;
	}

}