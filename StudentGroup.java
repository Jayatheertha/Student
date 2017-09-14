import java.util.Calendar;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		if(students.length<0)
			  throw new IllegalArgumentException("Array is empty");
	}

	@Override
	public Student getStudent(int index) {
		
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		if(index>=0 && index<students.length)
			students[index]=student;
		else
			 throw new IllegalArgumentException("Index is invalid");
	}

	@Override
	public void addFirst(Student student) {
		if(students.length>0)
			students[0]=student;
		else
			throw new IllegalArgumentException("Array is empty");
	}

	@Override
	public void addLast(Student student) {
		if(students.length>0)
			students[students.length-1]=student;
		else
			throw new IllegalArgumentException("Array is empty");
	}

	@Override
	public void add(Student student, int index) {
            if(students.length==0 || index>=students.length)
                throw new IllegalArgumentException("Array is empty or index is invalid");
	Student[] result = new Student[students.length];
            for(int i = 0; i < index; i++)
                result[i] = students[i];
            result[index] = student;
            for(int i = index + 1; i < students.length; i++)
            result[i] = students[i - 1];
            
    students=result;
    
	
	}

	@Override
	public void remove(int index) {
            int j=0;
            if(students.length==0 || index>=students.length)
                throw new IllegalArgumentException("Array is empty or index is invalid");
            else{
		Student[] result = new Student[students.length-2];
                    for(int i = 0; i <students.length; i++)
                    {
                     if(i!=index)
                     result[j++] = students[i];
                }
                 students=result;
                }
        }

	@Override
	public void remove(Student student) {
		   int j=0,count=0;
            if(students.length==0)
                throw new IllegalArgumentException("Array is empty");
            else {
		Student[] result = new Student[students.length-2];
                    for(int i = 0; i <students.length; i++)
                    {
                     if(!students[i].equals(student) && j<result.length)
                     result[j++] = students[i];
                     else
                         count++;
                }
                    if(count>0 && j==students.length-2)
                 students=result;
                    else
                       throw new IllegalArgumentException("Student does not exist"); 
                }
	}

	@Override
	public void removeFromIndex(int index) {
		if(students.length==0 || index>=students.length || index<0)
                throw new IllegalArgumentException("Array is empty or index is invalid");
                else
                {
                   Student[] result = new Student[index];
                   for(int i=0;i<index;i++)
                       result[i]=students[i];
                students=result;
                }
	}

	@Override
	public void removeFromElement(Student student) {
		int index=-1;
                for(int i=0;i<students.length;i++)
                    if(students[i].equals(student))
                        index=i;
               if(students.length==0)
                throw new IllegalArgumentException("Array is empty");
               if(index==-1)
                    throw new IllegalArgumentException("Element doesn't exist");
               else
                   removeFromIndex(index);
                  
	}

	@Override
	public void removeToIndex(int index) {
            int j=0;
		if(students.length==0 || index>=students.length||index<0)
                throw new IllegalArgumentException("Array is empty or index is invalid");
                else
                {
                   Student[] result = new Student[students.length-index];
                   for(int i=index;i<students.length;i++)
                       result[j++]=students[i];
                students=result;
                }
	}

	@Override
	public void removeToElement(Student student) {
		int index=-1;
                for(int i=0;i<students.length;i++)
                    if(students[i].equals(student))
                        index=i;
               if(students.length==0)
                throw new IllegalArgumentException("Array is empty");
               if(index==-1)
                    throw new IllegalArgumentException("Element doesn't exist");
               else
                   removeToIndex(index);
	}

	@Override
	public void bubbleSort() {
             if(students.length==0)
                throw new IllegalArgumentException("Array is empty");
            Student temp;
		for(int i=0; i < students.length; i++){  
                 for(int j=1; j < (students.length-i); j++){  
                          if(students[j-1].getId() > students[j].getId()){  
                                 //swap elements  
                                 temp = students[j-1];  
                                 students[j-1] = students[j];  
                                 students[j] = temp;  
                         }  
                          
                 }  
         }
                System.out.println("Bubble sort applied");
	}

	@Override
	public Student[] getByBirthDate(Date date) {
             if(students.length==0)
                throw new IllegalArgumentException("Array is empty");
             if(date==null)
                 throw new IllegalArgumentException("Invalid Date");
		int count=0,j=0;
                for(int i=0;i<students.length;i++)
                if(students[i].getBirthDate().equals(date))
                    count++;
                if(count==0)
                     throw new IllegalArgumentException("No Students");
                Student[] result=new Student[count];
                for(int i=0;i<students.length;i++)
                if(students[i].getBirthDate().equals(date))
                    result[j]=students[i];
                
		return result;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
             if(students.length==0)
                throw new IllegalArgumentException("Array is empty");
             if(firstDate==null || lastDate==null)
                 throw new IllegalArgumentException("Invalid Date");
		int count=0,j=0;
                for(int i=0;i<students.length;i++)
                if(students[i].getBirthDate().after(firstDate)&&students[i].getBirthDate().before(lastDate))
                    count++;
                if(count==0)
                     throw new IllegalArgumentException("No Students");
                Student[] result=new Student[count];
                for(int i=0;i<students.length;i++)
                if(students[i].getBirthDate().after(firstDate)&&students[i].getBirthDate().before(lastDate))
                    result[j]=students[i];
                
		return result;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		 if(students.length==0)
                throw new IllegalArgumentException("Array is empty");
                 if(date==null)
                 throw new IllegalArgumentException("Invalid Date");
                 Calendar cal = Calendar.getInstance();
                 cal.setTime(date);
                 cal.add(Calendar.DATE, days);
                 Date date2=cal.getTime();
                 int count=0,j=0;
                for(int i=0;i<students.length;i++)
                if(students[i].getBirthDate().after(date)&&students[i].getBirthDate().before(date2))
                    count++;
                if(count==0)
                     throw new IllegalArgumentException("No Students");
                Student[] result=new Student[count];
                for(int i=0;i<students.length;i++)
                if(students[i].getBirthDate().after(date)&&students[i].getBirthDate().before(date2))
                    result[j]=students[i];
                
		return result;
                 
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
            if(students.length==0 || indexOfStudent>=students.length || indexOfStudent<0)
                throw new IllegalArgumentException("Array is empty or index is invalid");
		 Date now = new Date();
    int nowMonth = now.getMonth()+1;
    int nowYear = now.getYear();
    int result = nowYear - students[indexOfStudent].getBirthDate().getYear();

    if (students[indexOfStudent].getBirthDate().getMonth()+1 > nowMonth) {
        result--;
    }
    else if (students[indexOfStudent].getBirthDate().getMonth()+1 == nowMonth) {
        int nowDay = now.getDate();

        if (students[indexOfStudent].getBirthDate().getDay() > nowDay) {
            result--;
        }
    }
    return result;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
            if(students.length==0)
                throw new IllegalArgumentException("Array is empty");
		int count=0,j=0;
                for(int i=0;i<students.length;i++)
                if(getCurrentAgeByDate(i)==age)
                    count++;
                if(count==0)
                     throw new IllegalArgumentException("No Students");
                Student[] result=new Student[count];
                for(int i=0;i<students.length;i++)
                if(getCurrentAgeByDate(i)==age)
                    result[j]=students[i];
                return result;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
            if(students.length==0)
                throw new IllegalArgumentException("Array is empty");
		double max=students[0].getAvgMark();
                for(int i=0;i<students.length;i++)
                    if(students[i].getAvgMark()>max)
                        max=students[i].getAvgMark();
                int count=0,j=0;
                for(int i=0;i<students.length;i++)
                if(max==students[i].getAvgMark())
                    count++;
                if(count==0)
                     throw new IllegalArgumentException("No Students");
                Student[] result=new Student[count];
                for(int i=0;i<students.length;i++)
                if(max==students[i].getAvgMark())
                    result[j]=students[i];
                return result;
	}

	@Override
	public Student getNextStudent(Student student) {
		if(students.length==0)
                throw new IllegalArgumentException("Array is empty");
                int index=-1;
                for(int i=0;i<students.length;i++)
                    if(students[i].equals(student))
                        index=i;
                if(index<students.length-1)
                    return students[index+1];
                else
                    throw new IllegalArgumentException("No next element");    
	}
}
