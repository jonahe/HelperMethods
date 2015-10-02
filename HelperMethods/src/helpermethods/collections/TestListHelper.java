package helpermethods.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestListHelper {
	
	static int counter = 1;
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		
		TestListHelper program = new TestListHelper();
		ListHelper listHelp = new ListHelper();
		
		Person p1 = program.new Person();
		Person p2 = program.new Person();
		Person p3 = program.new Person();
		Student s4 = program.new Student();
		Student s5 = program.new Student();
		Student s6 = program.new Student();
		Teacher t7 = program.new Teacher();
		Teacher t8 = program.new Teacher();
		Teacher t9 = program.new Teacher();
		
		List<Person> persons = new ArrayList<Person>();
		Collections.addAll(persons, p1, p2, p3, s4, s5, s6, t7, t8, t9);
		
		System.out.println("Whole list: ");
		persons.forEach(System.out::println);
		
		LinkedList<Principal> linkedListOfTeacher =
				listHelp.getAllSubclassInstancesFromList(persons, Person.class, LinkedList.class);
		
		System.out.println("Only teachers:");
		linkedListOfTeacher.forEach(System.out::println);
		
		
	}
	
	
	
	
	
	

	class Person {
		int id;
		
		Person(){
			id = counter++;
		}
		@Override
		public String toString(){
			return "Person{" + id + "}";
		}
	}
	
	class Teacher extends Person {
		int id;
		Teacher(){
			id = counter++;
		}
		
		@Override
		public String toString(){
			return "Teacher{" + id + "}";
		}
	}
	
	class Student extends Person {		
		int id;
		Student(){
			id = counter++;
		}
		@Override
		public String toString(){
			return "Student{" + id + "}";
		}
	}
	
	class Principal extends Teacher {
		int id;
		Principal(){
			id = counter++;
		}
		@Override
		public String toString(){
			return "Principal{" + id + "}";
		}
	}
}

