import java.io.File;
public class ReformatFileName {
    /* theFiles stores the whole files we want to
    * rename
    * in it's array
    */
    public static void main(String... args) {
        NameFormatter nf;
        File[] theFiles = new File("c:/Users/cotote/Desktop/Temp").listFiles();
        for(File f : theFiles) {
            String fName = f.getName(); //Get's the name of the File
            //System.out.print(fName);

            nf = new NameFormatter(fName); //reformats the name
            /* Creates a new File with the correct name */
            File formerName = new File(f.getAbsolutePath());
            
            String thePath = "c:/Users/cotote/Desktop/Temp/"; 
            String myPath = thePath.concat(nf.getTheFileName());
            System.out.println(myPath);
            File correctName = new File(myPath);

            formerName.renameTo(correctName);
            System.out.print(formerName.getName() + " : ");
            System.out.println(nf.getTheFileName());
        }
    }
}
//