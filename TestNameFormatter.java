public class TestNameFormatter {
	public static void main(String[] args) {
		String name = "3018 OGBE NATHANIEL .J";
		NameFormatter nf = new NameFormatter(name);
		System.out.print(nf.getTheFileName());
		//String trimmedName = ts.getString(); 
		//ts.setCharArray(trimmedName);
	}
}