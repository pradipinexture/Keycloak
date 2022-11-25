import java.awt.print.Book;
import java.util.*;

class  Student implements Comparable<Student>{
    int id;
    String name;
    float cgpa;

    Student(int id,String name,float cgpa){
        this.id=id;
        this.name=name;
        this.cgpa=cgpa;
    }

    int getId(){
        return this.id;
    }

    String getName(){
        return  this.name;
    }

    float getCgpa(){
        return this.cgpa;
    }

    @Override
    public int compareTo(Student student) {
        if(this.cgpa == student.getCgpa()){ // both student have a same cgpa then go with name.
            if (name.compareTo(student.getName()) == 0){ // // both student have a same name then go with id.
                if(id > student.getId()){
                    return -1;
                }
                else if(id < student.getId() ) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
            else{
                return  name.compareTo(student.getName());
            }
        }
        else if(this.cgpa > student.getCgpa()) { // current student cgpa gretter then last student
            return -1;
        }
        else{// current student cgpa lesser then last student
            return  1;
        }
    }
}

class Priorities {

    PriorityQueue<Student> pq = new PriorityQueue<>();

    public List<Student> getStudents(List<String> events) {
        for (String event : events) {
            //System.out.println(event);
            if (event.startsWith("SERVED")) {
                pq.poll();
            } else if (event.startsWith("ENTER")) {
                String[] s = event.split(" ");
                Student student = new Student(Integer.parseInt(s[3]), s[1], Float.parseFloat(s[2]));
                pq.add(student);
            }
        }
        List<Student> students = new ArrayList<Student>();
        while (!pq.isEmpty()) {
            students.add(pq.poll());
        }
        return students;
    }
}

public class StudentPriorityExample {

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String args[]){
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
