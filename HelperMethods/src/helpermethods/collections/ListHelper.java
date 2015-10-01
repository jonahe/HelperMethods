package helpermethods.collections;
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
	
	public <T, U extends T> List<U> getSubList(List<T> list, Class<U> classToExtract){
		
		List<U> subList = new ArrayList<U>();
		
		for(T t : list){
			if(classToExtract.isInstance(t)){
				subList.add((U) t);
			}
		}
		return subList;
	}
}
