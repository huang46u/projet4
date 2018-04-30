package lsystem;

public class TestGrammar {

	public static void main(String[] args) {
		Grammar a=new Grammar("Test");
		char as ='X';
		a.addGeneration("X","F[$$$[*X][/X]]");
		a.addGeneration("X","F[%%%[*X][/X]]");
		a.addGeneration("X","F[$[*X][/X]]");
		
		System.out.println(a.find(""+as));
		System.out.println(a.getGeneration());
		a.setStart("X");
		a.iterate(1);
		System.out.println(a.getResult());
		a.iterate(1);
		System.out.println(a.getResult());
		a.setResult(a.getPrecRes());
		System.out.println(a.getResult());
	}

}
