
public class Quiz1 {
	public static void main(String[] args) {
		
		/*1. 다음 arr1배열의 내용을 오른쪽 90도회전하여 arr2에 붙여넣기하는 코드를 완성하시오.

		int[][] arr1=new int[3][4];
		int a1=1;
		for (int i = 0; i <3; i++) {
			for (int j = 0; j <4; j++) {
				arr1[i][j]=a1;
				a1++;
			}
		}
		int[][] arr2=new int[4][3];
		for (int i = 0; i <4; i++) {
			for (int j = 0; j <3; j++) {
				arr2[i][j]=arr1[2-j][i];			}
		}
		for(int row=0; row<arr2.length; row++){
			   for(int col=0; col<arr2[row].length; col++){
			      System.out.print( arr2[row][col]);
			      System.out.print("\t");
			   }
			  System.out.println( );
			}
		 */
		/*2. arr3변수에 다음과 같은 숫자가 저장될 수 있도록  완성하시오.
		int[][] arr3=new int[4][3];
		int a2=1;
		for (int i = 0; i <3; i++) {
			for (int j = 0; j <4; j++) {
				arr3[j][i]=a2;
			a2++;
			}
		} 
		for (int i = 0; i <4; i++) {
			for (int j = 0; j <3; j++) {
				System.out.print(arr3[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		 */
		/*3. 다음arr4배열은 각 학생별DB점수, JAVA점수, WEB점수이다. 
		int[][] arr4 = { { 90, 100, 35},{ 88, 93, 22},
				{77, 91, 45},{ 66, 83, 93},{ 55, 72, 92} };
		int[] sum=new int[5];
		double[] avg=new double[5];
		int db=0;
		int java=0;
		int web=0;
		for (int i = 0; i <5; i++) {
			for (int j = 0; j <3; j++) {
				sum[i]=sum[i]+arr4[i][j];
				
			}
			db+=arr4[i][0];
			java+=arr4[i][1];
			web+=arr4[i][2];
		}
		for (int i = 0; i <5; i++) {
			avg[i]=(double)(sum[i])/3;
		}
		for (int i = 0; i <5; i++) {
			System.out.println(i+1+"번학생: 총점="+sum[i]
					+"평균 ="+avg[i]);
		}
		System.out.println("db과목평균="+(float)(db)/5);
		System.out.println("java과목평균="+(float)(java)/5);
		System.out.println("web과목평균="+(float)(web)/5);
		*/	
		
		/*4. 다음 숫자들을 SELECTION정렬기법을 이용하여 내림차순 정렬하시오.
		int [ ] arr5 = { 4, 6, 1, 9, 5, 3, 7};
		int min, temp;
	    for (int i = 0; i < arr5.length - 1; i++) {
	    	min = i;
	        for (int j = i + 1; j < arr5.length; j++) {
	            if (arr5[j] > arr5[min]) {
	            	min = j;
	            }
	        }
	        temp = arr5[min];
	        arr5[min] = arr5[i];
	        arr5[i] = temp;
	    }
	    for(int i=0; i<arr5.length; i++){
		    System.out.print(arr5[i]);
		   System.out.print("\t");
		}
		System.out.println();
		*/
		/*5. 위의 숫자들을 BUBBLE정렬기법으로 내림차순 정렬하시오.
		int [ ] arr5 = { 4, 6, 1, 9, 5, 3, 7};
		int temp=0;
		int a5=arr5.length;
		for (int i = a5-1; i >0; i--) {
			for (int j = 0; j <i; j++) {	
				if(arr5[j]<arr5[j+1]){
					temp = arr5[j];
			        arr5[j] = arr5[j+1];
			        arr5[j+1] = temp;
				}
			}
		}
		 for(int i=0; i<arr5.length; i++){
			    System.out.print(arr5[i]);
			   System.out.print("\t");
			}
			System.out.println();
		*/
	}
}
