package ed.ito;

public class ListaEstatica<E> implements Lista<E> {
	
	private E items[];
	private int p,u;
	private int limite,n;
	
	public ListaEstatica() {
		this.limite=10;
		this.clear();
	}
	
	public ListaEstatica(int limite) {
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
		if(this.isEmpty()) 
			this.p=0;
		for(int i=this.n;i>0;i--)
			this.items[i]=this.items[i-1];
		this.items[this.p]=item;
		this.u++;
		this.n++;
		
	}

	@Override
	public void addLast(E item) throws ExcepcionDeListaLlena {
		// TODO Auto-generated method stub
		if(this.isFull())
			throw new ExcepcionDeListaLlena();
		if(this.isEmpty())
			this.p++;
		this.u++;
		this.items[this.u]=item;
		this.n++;
	}

	@Override
	public E deleteFirst() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		E item= this.items[this.p];
		for(int i=0;i<this.n;i++)
			this.items[i]=this.items[i+1];
		this.u--;
		this.n--;
		if(this.n==0)
			this.p=-1;
		return item;
	}

	@Override
	public E deleteLast() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		E item= this.items[this.u];
		this.u--;
		this.n--;
		if(this.n==0)
			this.p=-1;
		return item;
	}

	@Override
	public E delete(int i) throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		E item=null;
		if(i>0 && i<=this.n) {
		   item= this.items[i-1];
		   for(int j=i-1;j<this.n-1;j++)
			    this.items[j]=this.items[j+1];
		this.u--;
		this.n--;
		if(this.n==0)
			this.p=-1;
		}
		return item;
	}

	@Override
	public E delete(E item) throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		int i;
		for(i=0;i<this.n;i++)
			if(this.items[i].equals(item)) 
				break;
		if(i<this.n) {
			for(int j=i;j<this.n-1;j++)
				this.items[j]=this.items[j+1];
			this.n--;
			if(this.n==0)
				this.p=-1;
			this.u--;
		}
		else
			item=null;
		return item;
	}

	@Override
	public E first() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		return this.items[this.p];
	}

	@Override
	public E last() throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		return this.items[this.u];
	}

	@Override
	public E getItem(int i) throws ExcepcionDeListaVacia {
		// TODO Auto-generated method stub
		if(this.isEmpty())
			throw new ExcepcionDeListaVacia();
		E item=null;
		if(i>0 && i<=this.n) 
		   item= this.items[i-1];
		return item;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.n;
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
	public void clear() {
		// TODO Auto-generated method stub
		this.p=this.u=-1;
		this.items= (E [])new Object[this.limite];
		this.n=0;
	}

	@Override
	public int search(E item) {
		// TODO Auto-generated method stub
		int pos=-1;
		for(int i=0;i<this.n;i++)
			if(this.items[i].equals(item)) {
				pos=i+1;
				break;
			}
		return pos;
	}

}