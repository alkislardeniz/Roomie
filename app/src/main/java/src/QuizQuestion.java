package src;
import java.util.Arrays;

/**
 * Created by eliztekcan on 28.10.2017.
 */
public class QuizQuestion
{
    private String[] options;
    private int correctAnswerIndex;
    private String question;
    private int grades;
    private String currentAnswer;

    public QuizQuestion()
    {
        options = new String[4];
        for (int i = 0; i < 4; i++)
            options[i] = "";

        correctAnswerIndex = 0;
        question = "";
        grades = 0;
    }

    public QuizQuestion(String[] options, int correctAnswerIndex, String question)
    {
        this.options            = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.question           = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "QuizQuestion{" +
                "options=" + Arrays.toString(options) +
                ", correctAnswerIndex=" + correctAnswerIndex +
                ", question='" + question + '\'' +
                '}';
    }
}