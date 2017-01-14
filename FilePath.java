import java.io.*;
import java.util.*;

public class FilePath {
	private String oldName;
	private String newName;
	private String parentPath;
	private String newDisplayName;
	RenFile alfa;
	FilePath(File file) {
		setOldName(file);
		setNewName(file);
	}

	public void setOldName(File file) {

		String dir = file.getPath();
		String [] brokenOldName = dir.split("\\\\");
		int posNewName = brokenOldName.length - 1;
		String realName = "";
		int i = 0;
		while (i < posNewName) {
			realName += brokenOldName[i] + "/";
			i++;
		}
		setDirPath(realName);
		oldName = getDirPath() + file.getName() + ".pdf";
	}

	public String getOldName() {
		return oldName;
	}

	public void setDirPath(String s) {
		parentPath = s;
	}

	public String getDirPath() {
		return parentPath;
	}

	/* Set's the name to be Displayed and the name used to rename*/
	public void setNewName(File file) { 
		alfa = new RenFile(file);
		String name = alfa.getFileName();
		newName = getDirPath() + name + ".pdf";
		setNewDisplayName(name);
	}

	public String getNewName() {
		return newName;
	}

	public void setNewDisplayName(String name) {
		newDisplayName = name;
	}

	public String getNewDisplayName() {
		return newDisplayName;
	}
}