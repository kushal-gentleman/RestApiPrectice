package prectice_java;

public class ChangePlaceOfString {

	public static void main(String[] args) {


		//driver.findElement(By.xpath("//input[@type='file']")).sendkeys(pathOfFile);
		
		String str="abc de";
		
		    char[] chr= str.toCharArray();
		    
		    for(int i=chr.length-1;i>=0;i--) {
		    	
		    	System.out.print(chr[i]);
		    	
		    }

	}

}
