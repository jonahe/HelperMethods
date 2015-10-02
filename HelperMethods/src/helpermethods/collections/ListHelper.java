package helpermethods.collections;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListHelper {

	public <T, U extends T> List<U> getSubList(List<T> list, U objectToExtraxtClassFrom){
		
		Class wantedClass = objectToExtraxtClassFrom.getClass();
		List<U> subList = new ArrayList<U>();
		
		for(T t : list){
			if(wantedClass.isInstance(t)){
				subList.add((U) t);
			}
		}
		return subList;
	}
	
	
	/**
	 * Given a list of type T, return a list of only the elements that match the sub class (U extends T)
	 * @param list
	 * @param classToMatch
	 * @return
	 */
	public <T, U extends T> List<U> getSubList(List<T> list, Class<U> classToMatch){
		
		List<U> subList = new ArrayList<U>();
		
		for(T t : list){
			if(classToMatch.isInstance(t)){
				subList.add((U) t);
			}
		}
		return subList;
	}
	
	/**
	 * Given a list (instance of List, L) of type O, return a list (instance of L) of only the elements that match the sub class W (W extends O)
	 * <p>
	 * Example: Get a linked list of all teachers in a list of Persons (Teacher, Student)<br>
	 *  getSubListOfSameListType(listOfPersons, Student.class, LinkedList.class)  
	 * 
	 * @param list
	 * @param classToMatch
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	// O = Original type, W = Wanted type extends O, L = type extending List<W>
	public <O, W extends O, L extends List<W>> L getAllSubclassInstancesFromList(	
																			List<O> list, 
																			Class<W> classToMatch, 
																			Class<L> listReturnType) 
																			throws InstantiationException, IllegalAccessException{
		
		
		System.out.println(list.getClass().toGenericString());
		
		L subList = listReturnType.newInstance();
		
		
		for(O o : list){
			// if object of type T matches the class we want - add it do list
			if(classToMatch.isInstance(o)){
				subList.add((W) o);
			}
		}
		//TODO: see why the compiler doesn't warn when (for example) the return of ArrayList<Person> is being called to create a ArrayList<Teacher>
		return subList;
	}
	
	
	// O = Original type, W = Wanted type extends O, L = type extending List<W>, I = Input list, containing objects of type O
	public <O, W extends O, L extends List<W>, I extends List<O>> L getAllSubclassInstancesFromListV2(	
																			I list, 
																			Class<W> classToMatch) 
																			throws InstantiationException, IllegalAccessException{
		// L = something extending List<W>
		L subList = (L) list.getClass().newInstance();
		System.out.println(list.getClass().toString());
		
		for(O o : list){
			// if object of type T matches the class we want - add it do list
			if(classToMatch.isInstance(o)){
				subList.add((W) o);
			}
		}
		
		return subList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
