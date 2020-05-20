package personal_project;

import java.util.ArrayList;
import java.util.List;

public class defines {
//	String item = "";	//아이템 이름
	String category = "";	//카테고리
	int quantity = 0;	//재고
	int price = 0;	//판매가
	int cost = 0; //원가
	int sales = 0; //매출
	List<String> item = new ArrayList<String>(); // 아이템 리스트
	List<String> info = new ArrayList<>(); //아이템 속성 넣기위한 배열.
	List<List<String>> infoCell = new ArrayList<List<String>>(); //아이템리스트+정보 표 (아이템 세로, 정보 가로)
	public String[] infoList = new String[100]; //아이템별 속성 불러오기 위한 배열.
	
}
