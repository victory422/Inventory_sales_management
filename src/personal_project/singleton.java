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
		System.out.println(st+"�� �Է��߽��ϴ�.");
		}
	
	public int iscan(int a) {
		Scanner iscan = new Scanner(System.in);
		int i = 0;
		while(i==0) {
			if(iscan.hasNextInt()==false) {
				iscan.next();
				System.out.println("�Է°��� �߸��Ǿ����ϴ�. �ٽ� �Է����ּ���.");
			}else {
				a= iscan.nextInt();
				System.out.println(a+"�� �Է��ϼ̽��ϴ�.");
				i = 1;
				
			}
			}
   return  a;
		}
	
	void input() {
		
		
	}
	

	
} //������ ��ȣ
