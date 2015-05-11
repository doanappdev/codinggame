class Solution {
    
    //int foo = Integer.parseInt("1234");
    // Math.abs(-5); convert negative to positve

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String TEMPS = null;
        
        try {
            TEMPS = in.nextLine(); // the N temperatures expressed as integers ranging from -273 to 5526
        } catch (NoSuchElementException e) {
            System.err.println("NoSuchElementException: " + e.getMessage());
        }
        
        int LESS_THAN = 0;
        int GREATER_THAN = 1;
        int temp, closestTemp = 5526, convertToPositive;
        int prevTemp;
        String result = "0";
        int[] tempArray;
        int[] negativeNumbers;
        String[] strTemp; 
        
        
        if(N != 0) {
            tempArray = new int[N];
            strTemp = TEMPS.split(" ");
            for(int i = 0; i < strTemp.length; i++) {
                tempArray[i] = Integer.parseInt(strTemp[i]);    // covert string values to int
                System.err.println("Debug: " + Integer.parseInt(strTemp[i]));
            }
        
            for(int i = 0; i < tempArray.length; i++) {
            
                //temp = Integer.parseInt(strTemp[i]);
                temp = tempArray[i];
                 System.err.println("Debug: temp = " + Integer.parseInt(strTemp[i]));
                if(temp < 0) {
                    convertToPositive = Math.abs(temp);     // convert to positive number
                    temp = temp + convertToPositive;
                    //convertToPositive = Math.abs(temp);     // convert to positive number
                    temp = convertToPositive;               // assign value to temp
                }
            
            
                if(temp < closestTemp) {
                    closestTemp = temp;
                } 
            }
            
            result = String.valueOf(closestTemp);           // convert int to string
        } 
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result);
    }
    
    
}