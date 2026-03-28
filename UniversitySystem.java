interface AssignmentSystem {
    void submitAssignment();
}

interface QuizSystem {
    void takeQuiz();
}

abstract class Course {
    String title;

    public Course(String Ptitle) {
        this.title = Ptitle;
    }

    abstract void startCourse();
}

class ProgrammingCourse extends Course implements AssignmentSystem, QuizSystem {

    public ProgrammingCourse(String title) {
        super(title);
    }

    @Override
    void startCourse() {
        System.out.println("Starting Course: " + title);
        System.out.println("Initializing IDE...");
    }

    @Override
    public void submitAssignment() {
        System.out.println("Assignment submitted for " + title);
    }

    @Override
    public void takeQuiz() {
        System.out.println("Quiz started.");
    }
}

interface GuestInstructor {
    void teachOneTime();
}


public class UniversitySystem {
    public static void main(String[] args) {
        ProgrammingCourse oop = new ProgrammingCourse("Object-Oriented Programming");

        GuestInstructor specialist = new GuestInstructor() {
            @Override
            public void teachOneTime() {
                System.out.println("Topic : How to implement OOP in real life examples?");
                System.out.println("Today we will look at depths of OOP!");
            }
        };

        specialist.teachOneTime();
        oop.submitAssignment();
        oop.takeQuiz();

    }
}
