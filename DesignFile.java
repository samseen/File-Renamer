import java.io.File;

public class DesignFile {
	private String name;
	private String patFolder;
	public DesignFile(File aFile) {
		String absName = aFile.getAbsolutePath();
		String[] fileNameArr = absName.split("\\\\");
		name = fileNameArr[5];
		patFolder = fileNameArr[fileNameArr.length - 1];
	}
	public String getTheFileName() {
		return name;
	}

	public String getPatientFileName() {
		return patFolder;
	}
}