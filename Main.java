import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        org.antlr.v4.runtime.ANTLRInputStream inputstream =null;
        inputstream = new org.antlr.v4.runtime.ANTLRInputStream("a=10; print a;");
        ProjectLexer projectLexer = new ProjectLexer(inputstream);
        CommonTokenStream commonTokenStream=new CommonTokenStream(projectLexer);
        ProjectParser projectParser= new ProjectParser(commonTokenStream);
        ProjectParser.ProgramContext tree= projectParser.program();
        MyVisitor myVisitor=new MyVisitor();
        ProjectBaseVisitor<String> visitor=myVisitor;
        tree.accept(visitor);
        System.out.println(myVisitor.getResult());
    }
}
