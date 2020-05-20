package personal_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class singleton {

	private static singleton single = new singleton(); 
	
	public static singleton getInstance () {
		return single;
	}
	void print(String print) {
		System.out.println(print);
	}
	
	void sscan() {
		Scanner sscan = new Scanner(System.in);
		String st = sscan.next();
		System.out.println(st+"을 입력했습니다.");
		}
	
	public int iscan(int a) {
		Scanner iscan = new Scanner(System.in);
		int i = 0;
		while(i==0) {
			if(iscan.hasNextInt()==false) {
				iscan.next();
				System.out.println("입력값이 잘못되었습니다. 다시 입력해주세요.");
			}else {
				a= iscan.nextInt();
				System.out.println(a+"을 입력하셨습니다.");
				i = 1;
				
			}
			}
   return  a;
		}
	
	void input() {
		
		
	}
	

	
} //마지막 괄호
