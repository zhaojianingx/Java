package algorithm;

/**
 * @author zjn
 **/
public class GoalParserInterpretation {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }

    public static void main(String[] args) {
        System.out.println(new GoalParserInterpretation().interpret("G()(al)"));
    }
}
