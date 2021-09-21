import java.text.DecimalFormat;

public class actualMemory {
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	public static String memoryConversion(String memory) {
		String output = "";
		
		double memSize = Double.valueOf(memory.substring(0, memory.length()-2));
		String memUnit = memory.substring(memory.length()-2);
		
		if(memUnit.equals("MB"))
			output += ((int)(0.93*memSize)) + memUnit;
		else if(memUnit.equals("GB") && 0.93*memSize < 1)
			output += ((int)(0.93*1024*memSize)) + "MB";
		else
			output += df2.format(0.93*memSize) + memUnit;
		
		return output;
	}
	
	public static void main(String[] args) {
		System.out.println(memoryConversion("32GB"));
		System.out.println(memoryConversion("2GB"));
		System.out.println(memoryConversion("512MB"));
		
		System.out.println(memoryConversion("1.2GB"));
		System.out.println(memoryConversion("1.02GB"));
		System.out.println(memoryConversion("1GB"));
	}
}
