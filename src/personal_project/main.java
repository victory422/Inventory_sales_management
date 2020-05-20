package personal_project;

import java.util.List;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		singleton single = singleton.getInstance();
		input_info wc = new input_info();
		defines def = new defines();
		Scanner scan = new Scanner(System.in);

		int choice = 0; 
		
	
		while (true) {
			single.print("환영합니다. 불편한 편의점입니다. 사용하실 기능을 선택해주세요.");
			single.print("1. 상품 정보 입력 및 수정");
			single.print("2. 상품 검색");
			single.print("3. 판매관리");
			single.print("4. 매출분석");
			
//		int choice = scan.nextInt();
		switch (single.iscan(choice)) {
		case 1: 
			while(true) {
			single.print("1. 상품 속성정보 입력");
			single.print("2. 아이템 입력");
			single.print("0. 돌아가기");
			int choice2 = 0;
			
			switch (single.iscan(choice2)) {
			
			case 1 :  
				wc.writeCSV(); //아이템 속성 받기 (판매가 등) (저장은 info<>) ※ 기존 저장된 각 값들이 따라오지는 않음.
			break;
			
			case 2: 
				wc.add_item(); // 아이템리스트 신규추가(기존 데이터 아래에 저장)
			break;
			
			case 0 : break;
			} break;
			}
			
		case 2:
		boolean check = true;
		while(check) {
			single.print("검색하실 상품을 입력해주세요.");
			single.print("1. 전체상품 보기");
			single.print("2. 상품이름 검색하기");
			single.print("3. 카테고리 검색하기");
			single.print("0. 돌아가기");
		int choice2 = 0;
		
			switch (single.iscan(choice2)) {
			
				case 1 : wc.showAllItem();  // 전체 아이템리스트 소환. //값 출력 시 아이템 갯수 
					break;
				case 2: wc.search(); // 상품별 검색
					break;
				case 3: wc.searchCategory(); // 카테고리 검색 
					break;
				case 0 : check = false; 
				} 
				}
				
		
			break;
		case 3:
			boolean check2 = true;
			while(check2) {
				single.print("판매관리 항목입니다.");
				single.print("1. 상품명으로 판매");
				single.print("2. 코드로 판매");
				single.print("0. 돌아가기");
			int choice2 = 0;
			
				switch (single.iscan(choice2)) {
				
					case 1 : wc.sale(); //상품명으로 판매 
						break;
					case 2: wc.saleCode(); // 코드로 판매
						break;
					case 0 : check2 = false; break;
					} 
					}
		
			break;
		case 4: single.print("매출분석");
			break;

		
		}
		}
		
//		single.isc)an();
//		single.output();
//		wc.writeCSV(); //아이템 속성 받기 (판매가 등) (저장은 info<>) ※ 기존 저장된 각 값들이 따라오지는 않음.
//		for(int i = 0; i<wc.infoCount(); i++) { //속성정보 전체 불러오기
//			if(wc.infoCount()-1 > i) System.out.print(wc.info(i)+"\t"); 
//			if(wc.infoCount()-1 == i) System.out.println(wc.info(i));
//		}
//		System.out.println(wc.readItem(2)); // 아이템 하나의 정보 전체 소환
//		System.out.println(wc.readAllItem()); // 전체 아이템리스트 소환. //값 출력 시 아이템 갯수 

//		wc.add_item(); // 아이템리스트 신규추가(기존 데이터 아래에 저장)
//		System.out.println(wc.infoCount()); //속성정보 갯수
//		System.out.println(wc.info(0)); //속성정보 하나 불러오기
//		wc.sales();
//		System.out.println(wc.excel(4,1)); // csv파일을 2중배열로 불러오는 함수(세로 index, 가로index)
		
		
		
	}
}
