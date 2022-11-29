package ed.ito;

public interface Lista<E> {
	public void add(E item) throws ExcepcionDeListaLlena;
	public void addFirst(E item) throws ExcepcionDeListaLlena;
	public void addLast(E item)throws ExcepcionDeListaLlena;
	public E deleteFirst() throws ExcepcionDeListaVacia;
	public E deleteLast() throws ExcepcionDeListaVacia;
	public E delete(int i) throws ExcepcionDeListaVacia;
	public E delete(E item)throws ExcepcionDeListaVacia;
	public E first()throws ExcepcionDeListaVacia;
	public E last() throws ExcepcionDeListaVacia;
	public E getItem(int i) throws ExcepcionDeListaVacia;
	public int size();
	public void clear();
	public boolean isEmpty();
	public boolean isFull();
    public int search(E item);
}