
public class ArrayTest {
	public static void main(String[] args) {
		//단일문자 5개값이 저장될수 있는 배열 선언및 생성
		//변수명 :star
		/*
		char[] star;
		star= new char[5];
		char j=65;
		//각 인덱스에 a,b,c,d,e,값대입
		for (int i = 0; i <=4; i++) {
			
				star[i]=j;
				j++;
				System.out.println(star[i]);
			
		}
		*/
		//배열초기화
		//1~10사이의 숫자가 저장된 배열의 숫자 출현횟수를 출력
		//결과 1의 출현횟수 2, 2의출현횟수2,3의출현횟수3, 4 1 ,5 2,6 1
		/*
		int[] arr={1,4,3,7,10,2,3,5,7,3,2,8,6,1,5};
		int[] arr1= new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr1[arr[i]-1]++;
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.println((i+1)+"의 출현횟수:"+arr1[i]);
		}
		*/
		int[][] arr2=new int[3][4];
		/*arr2[0][0]=1;
		arr2[0][1]=2;
		arr2[0][2]=3;
		arr2[0][3]=4;
		
		arr2[1][0]=5;
		arr2[1][1]=6;
		arr2[1][2]=7;
		arr2[1][3]=8;
		
		arr2[2][0]=9;
		arr2[2][1]=10;
		arr2[2][2]=11;
		arr2[2][3]=12;
		
		*/
		/*for (int i = 0; i <= arr2.length; i++) {
			arr2[0][i]=i+1;
			System.out.println("arr2[0]["+i+"]:"+arr2[0][i]);
		}*/
		/*
		int a1=1;
		for (int i = 0; i <=2; i++) {
			for (int k = 0; k <=arr2.length; k++) {
				arr2[i][k]=a1;
				a1++;
				System.out.println("arr2["+i+"]["+k+"]:"+arr2[i][k]);
			}
			
		}
		*/
		
		
		int[][] arr3=new int[5][];
		for (int i = 0;i<arr3.length; i++) {
			arr3[i]=new int[i+1];				
		}
      
		int mr=arr3.length;
		for (int i = 0;i<mr; i++) {
			arr3[i][0]=1;
			int mc=arr3[i].length;
		
			arr3[i][mc-1]=1;
			if(i>=1){
			for (int j = 1; j <mc-1; j++) {
				arr3[i][j]=arr3[i-1][j-1]+arr3[i-1][j];
			}
			
			}
		}
		for (int i = 0;i<mr; i++) {
	
			int mc=arr3[i].length;
			for (int j = 0; j <mc; j++) {
				System.out.print(arr3[i][j]);
				System.out.print("\t");
			}
			System.out.println();
			}
		}
			
	
	}


