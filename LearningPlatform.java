interface Recorded {
    void playRecordedLecture();
}

interface Live {
    void streamLiveLecture();
}

abstract class Course {
    String title;

    public Course(String Ptitle) {
        this.title = Ptitle;
    }

    abstract void startCourseSession();
}

// 3. Concrete Implementation: Recorded Course
class RecordedCourse extends Course implements Recorded {
    public RecordedCourse(String title) {
        super(title);
    }

    @Override
    void startCourseSession() {
        System.out.println(title + " : Session Started.");
    }

    @Override
    public void playRecordedLecture() {
        System.out.println("Playing video lecture...");
    }
}

// 4. Concrete Implementation: Live Course
class LiveCourse extends Course implements Live {
    public LiveCourse(String title) {
        super(title);
    }

    @Override
    void startCourseSession() {
        System.out.println(title + " : Session Started.");
    }

    @Override
    public void streamLiveLecture() {
        System.out.println("Connecting to Live Stream...");
    }
}
    class HybridCourse extends Course implements Recorded, Live {
        public HybridCourse(String title) {
            super(title);
        }

        @Override
        void startCourseSession() {
            System.out.println(title + " : Session Started.");
        }

        @Override
        public void playRecordedLecture() {
            System.out.println("Playing video lecture...");
        }

        @Override
        public void streamLiveLecture() {
            System.out.println("Connecting to Live Stream...");
        }
    }

    public class LearningPlatform {
        public static void main(String[] args) {
            RecordedCourse oop = new RecordedCourse("Object-Oriented Programming");
            LiveCourse calculus = new LiveCourse("Calculus");
            HybridCourse dld = new HybridCourse("Digital logic design");

            oop.startCourseSession();
            oop.playRecordedLecture();

            calculus.startCourseSession();
            calculus.streamLiveLecture();

            dld.startCourseSession();
            dld.playRecordedLecture();
            dld.streamLiveLecture();

        }
    }