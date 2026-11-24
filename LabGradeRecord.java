
package lab.grade.record;

public class LabGradeRecord {

    private String studentName;
    private int quizScore;
    private int labScore;

    // Constructor
    public LabGradeRecord(String studentName, int quizScore, int labScore) {
        this.studentName = studentName;
        this.quizScore = (quizScore >= 0 && quizScore <= 100) ? quizScore : 0;
        this.labScore = (labScore >= 0 && labScore <= 100) ? labScore : 0;
    }

    // Get the final grade
    public double getFinalGrade() {
        return (quizScore + labScore) / 2.0;
    }

    // Check if the student is passing
    public boolean isPassing() {
        return getFinalGrade() >= 75;
    }

    // Update scores only if both are valid
    public boolean updateScores(int quizScore, int labScore) {

        if (quizScore < 0 || quizScore > 100 ||
            labScore < 0 || labScore > 100) {
            return false;
        }

        this.quizScore = quizScore;
        this.labScore = labScore;

        return true;
    }

    public static void main(String[] args) {

        LabGradeRecord ana = new LabGradeRecord("Ana", 80, 90);
        System.out.println(ana.getFinalGrade() + "; " + (ana.isPassing() ? "passing" : "not passing"));

        LabGradeRecord ben = new LabGradeRecord("Ben", 101, 85);
        System.out.println(ben.getFinalGrade() + "; " + (ben.isPassing() ? "passing" : "not passing"));

        boolean step3 = ana.updateScores(95, 101);
        System.out.println(step3 + "; grade stays " + ana.getFinalGrade());

        boolean step4 = ana.updateScores(74, 75);
        System.out.println(step4 + "; " + ana.getFinalGrade() + "; " + (ana.isPassing() ? "passing" : "not passing"));

        boolean step5 = ana.updateScores(75, 75);
        System.out.println(step5 + "; " + ana.getFinalGrade() + "; " + (ana.isPassing() ? "passing" : "not passing"));

        System.out.println("Still " + ben.getFinalGrade() + "; " + (ben.isPassing() ? "passing" : "not passing"));
    }
}

// Validating both scores before assigning them prevents partial updates.
// If the quiz score is valid but the lab score is invalid,
// the student's previous scores should remain unchanged.
// Validating both inputs first ensures that both scores are saved together
// or neither field is changed.
