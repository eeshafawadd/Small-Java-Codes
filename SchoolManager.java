
import java.util.*;
/**
 * This class manages employees in a school and their lists/sets.
 * Your implementation of this class or methods should not contains:
 * 1. System.out.println statements. Instead, you need to return the result. 
 * 2. Scanner operations(e.g., input.nextInt()). Instead, refer to the input parameters of this method.
 */
public class SchoolManager {
	
		// TODO: Your implementation starts here
		/*  Your implementation starts here
		 * Recall that :
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, you need to return the result.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
	
	private MyList overtimeList;
    private MySet seminarRegistrationList;
	
    public SchoolManager() {
    	overtimeList = new MyList();
    	seminarRegistrationList = new MySet();
    } 
    
    public void addToOvertimeList(Employee employee) {
    	 overtimeList.add(employee);
    }
    
    public void addToSeminarRegistrationList(Employee employee) {
    	seminarRegistrationList.add(employee);
    }
    
    public int getOvertimeEmployeeCount() {
    	return overtimeList.getSize();
    }
    
    public int getSeminarRegistrationsCount() {
    	return seminarRegistrationList.getSize();
    }
    
    public String displayOvertimeList() {
    	String str="";
		if (overtimeList.isEmpty()) {
			return "Overtime List: No employees in the overtime list.";
		}
		else {
			str+="Overtime List: [";
			for (int i=0; i<overtimeList.getSize(); i++) {
				
				//if at the last element
				if (i==overtimeList.getSize()-1)
					str+= overtimeList.get(i);
				
				//if not:
				else {
					str+= overtimeList.get(i) + ", ";
				}
			}
		}
		return str + "]";
    }
    
    public String displaySeminarRegistrationList() {
    	String str="";
		if (seminarRegistrationList.isEmpty()) {
			return "Registration List: No employees in the registration list.";
		}
		else {
			str+="Registration List: [";
			for (int i=0; i<seminarRegistrationList.getSize(); i++) {
				
				//if at the last element
				if (i==seminarRegistrationList.getSize()-1)
					str+= seminarRegistrationList.get(i);
				
				//if not:
				else {
					str+= seminarRegistrationList.get(i) + ", ";
				}
			}
		}
		return str + "]";
    	
    }
    
	
}
/**
 * 
 * This class represents an employee in the school management system.
 * Your implementation of this class or methods should not contains:
 * 1. System.out.println statements. Instead, you need to return the result. 
 * 2. Scanner operations(e.g., input.nextInt()). Instead, refer to the input parameters of this method.
 */
class Employee {
	
		// TODO: Your implementation starts here
		/* 
		 * Recall that :
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, you need to return the result.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
	
	private String name;
	private int age;
	private String employeeId; 
	
	public Employee(String name, int age, String employeeId) {
		this.name=name;
		this.age=age;
		this.employeeId=employeeId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public String getEmployeeId() {
		return this.employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId=employeeId;
	}
	
	@Override
	public String toString() {
		
		//"{Alice (ID: T124)}"
		String str = "{" + getName() + " (ID: " + getEmployeeId() + ")}";
		return str;
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, employeeId, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && Objects.equals(employeeId, other.employeeId) && Objects.equals(name, other.name);
	}
	
	
	
	
}
/**
 * 
 * This class represents a container that stores objects in an array-like
 * structure. Your implementation of this class or methods should not contains:
 * 1. System.out.println statements. Instead, you need to return the result. 
 * 2. Scanner operations(e.g., input.nextInt()). Instead, refer to the input parameters of this method.
 */
class Container {
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	/**
	 * The initial size of the container.
	 */
	protected final int INITIAL_SIZE = 10;
	/**
	 * The array that holds the objects.
	 */
	protected Object[] list;
	/**
	 * The number of elements currently stored in the container.
	 */
	protected int size;
	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	
	public void add(Object obj) {
		if (size == list.length) {
			//if array is full, create new array with double the capacity
			int capacity = list.length * 2;
			Object[] list2 = new Object[capacity];
			
			//copy elements from old list into new list
			for (int i=0; i<capacity; i++) {
				list2[i]=list[i];
			}
			list=list2;
		}
		
		//if array is not full, add it to the end
		list[size]=obj;
		size++;
		
		
	}
	
	public Object remove (Object obj) {
		for (int i=0; i<size;i++) {
			if (list[i].equals(obj) && list[i]!=null) {
				
				//shift elements to the left to fill up the space from removed obj
				for (int j=i; j<size-1; j++) {
					list[j]= list[j+1];  
				}
				
				//remove last element
				list[size-1]=null; //last element
				size--;
				return obj;
			}
		}
		return null;
	}
	
	public int getSize() {
		
		return size;
		
	}
	
	public boolean isEmpty() {
		if (size==0) 
			return true;
		else
			return false;
		
	}
	
	public boolean contains(Object obj) {
		for (int i=0; i<size; i++) {
			if (list[i].equals(obj) && list[i]!=null) {
				return true;
			}
		}
		return false;
	}
	
	public int countOccurrences(Object obj) {
		int occ=0;
		for (int i=0; i<size; i++) {
			if (list[i].equals(obj) && list[i]!=null) {
				occ++;
			}
		}
		return occ;
	}
	
	@Override
	public String toString() {
		// ex: "[Element0, Element1, Element2, Element3, Element4]";
		String str="";
		str+="[";
		for (int i=0; i<size-1; i++) {
			str+=list[i];
			str+=", ";
		}
		str+=list[size-1];
		str+="]";
		return str;
	}
	
}
/**
 * This class simulates an ArrayList concept, where you can add unlimited number
 * of elements to the list.
 */
class MyList extends Container {
	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	public MyList() {
		list = new Object[INITIAL_SIZE];
		size = 0;
	}
	
	@Override
	public void add(Object obj) {
		if (size == list.length) {
			//if array is full, create new array with double the capacity
			int capacity = list.length * 2;
			Object[] list2 = new Object[capacity];
			
			//copy elements from old list into new list
			for (int i=0; i<size; i++) {
				list2[i]=list[i];
			}
			list=list2;
		}
		
		//if array is not full, add it to the end
		list[size]=obj;
		size++;
	}
	
	@Override
	public Object remove(Object obj) {
		for (int i=0; i<size;i++) {
			if (list[i].equals(obj) && list[i]!=null) {
				
				//shift elements to the left to fill up the space from removed obj
				for (int j=i; j<size-1; j++) {
					list[j]= list[j+1];  
				}
				
				//remove last element
				list[size-1]=null; //last element
				size--;
				return obj;
			}
		}
		return null;
	}
	
	public Object get(int index) {
		for (int i=0; i<size; i++) {
			if (i==index) {
				return list[i];
			}
		}
		//throw exception
		throw new IndexOutOfBoundsException("out of bound");
	}
	
	
}
/**
 * This class simulates a custom set that stores unique elements.
 */
class MySet extends Container {
	
	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	
	public MySet() {
		list = new Object[INITIAL_SIZE];
		size = 0;
	}
	
	@Override
	public void add(Object obj) {
		
		if (size == list.length) {
			//if array is full, create new array with double the capacity
			int capacity = list.length * 2;
			Object[] list2 = new Object[capacity];
			
			//copy elements from old list into new list
			for (int i=0; i<size; i++) {
				list2[i]=list[i];
			}
			list=list2;
		}
		
		//if it does not contain the object
		if (!contains(obj)) {
			list[size]=obj;
			size++;
		}
		
		
	}
	
	@Override
	public Object remove (Object obj) {
		return super.remove(obj);
	}
	
	public Object get(int index) {
		for(int i = 0; i<size; i++) {
			if(i==index) 
				return list[i];
		}
		//instead of returning null, throw IndexOutOfBoundsException
		throw new IndexOutOfBoundsException("out of bound");
	}
	
}

