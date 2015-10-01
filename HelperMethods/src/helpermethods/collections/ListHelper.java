package helpermethods.collections;
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
	 * Given a list (instance of X) of type T, return a list (instance of X) of only the elements that match the sub class (U extends T)
	 * @param list
	 * @param classToMatch
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public <T, U extends T> List<U> getSubListOfSameListType(List<T> list, Class<U> classToMatch) throws InstantiationException, IllegalAccessException{
		
		Class listType = list.getClass();
		List<U> subList = (List<U>) listType.newInstance();
		
		for(T t : list){
			if(classToMatch.isInstance(t)){
				subList.add((U) t);
			}
		}
		return subList;
	}
	
}
