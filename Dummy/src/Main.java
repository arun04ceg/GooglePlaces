
public class Main {
	public static void main(String[] args) {
		CharSequence a = "Arun";
		modifyString(a);
		System.out.println(a);
	}
	
	public static void modifyString(CharSequence a) {
		a = "Praveen";
	}
}

public class Dummy {
	
	public void modifyString(String a) {
		a = "Praveen";
	}
}
