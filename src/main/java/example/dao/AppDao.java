package example.dao;

public interface AppDao<T, ID> {
	T getById(ID identity);
	
//	void create(T newData);
//	Collection<T> getAll();
//	void deleteById(ID identity);
//	void update(T updateData);
	
	
	
}
