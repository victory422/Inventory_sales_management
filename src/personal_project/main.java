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
			single.print("ȯ���մϴ�. ������ �������Դϴ�. ����Ͻ� ����� �������ּ���.");
			single.print("1. ��ǰ ���� �Է� �� ����");
			single.print("2. ��ǰ �˻�");
			single.print("3. �ǸŰ���");
			single.print("4. ����м�");
			
//		int choice = scan.nextInt();
		switch (single.iscan(choice)) {
		case 1: 
			while(true) {
			single.print("1. ��ǰ �Ӽ����� �Է�");
			single.print("2. ������ �Է�");
			single.print("0. ���ư���");
			int choice2 = 0;
			
			switch (single.iscan(choice2)) {
			
			case 1 :  
				wc.writeCSV(); //������ �Ӽ� �ޱ� (�ǸŰ� ��) (������ info<>) �� ���� ����� �� ������ ��������� ����.
			break;
			
			case 2: 
				wc.add_item(); // �����۸���Ʈ �ű��߰�(���� ������ �Ʒ��� ����)
			break;
			
			case 0 : break;
			} break;
			}
			
		case 2:
		boolean check = true;
		while(check) {
			single.print("�˻��Ͻ� ��ǰ�� �Է����ּ���.");
			single.print("1. ��ü��ǰ ����");
			single.print("2. ��ǰ�̸� �˻��ϱ�");
			single.print("3. ī�װ� �˻��ϱ�");
			single.print("0. ���ư���");
		int choice2 = 0;
		
			switch (single.iscan(choice2)) {
			
				case 1 : wc.showAllItem();  // ��ü �����۸���Ʈ ��ȯ. //�� ��� �� ������ ���� 
					break;
				case 2: wc.search(); // ��ǰ�� �˻�
					break;
				case 3: wc.searchCategory(); // ī�װ� �˻� 
					break;
				case 0 : check = false; 
				} 
				}
				
		
			break;
		case 3:
			boolean check2 = true;
			while(check2) {
				single.print("�ǸŰ��� �׸��Դϴ�.");
				single.print("1. ��ǰ������ �Ǹ�");
				single.print("2. �ڵ�� �Ǹ�");
				single.print("0. ���ư���");
			int choice2 = 0;
			
				switch (single.iscan(choice2)) {
				
					case 1 : wc.sale(); //��ǰ������ �Ǹ� 
						break;
					case 2: wc.saleCode(); // �ڵ�� �Ǹ�
						break;
					case 0 : check2 = false; break;
					} 
					}
		
			break;
		case 4: single.print("����м�");
			break;

		
		}
		}
		
//		single.isc)an();
//		single.output();
//		wc.writeCSV(); //������ �Ӽ� �ޱ� (�ǸŰ� ��) (������ info<>) �� ���� ����� �� ������ ��������� ����.
//		for(int i = 0; i<wc.infoCount(); i++) { //�Ӽ����� ��ü �ҷ�����
//			if(wc.infoCount()-1 > i) System.out.print(wc.info(i)+"\t"); 
//			if(wc.infoCount()-1 == i) System.out.println(wc.info(i));
//		}
//		System.out.println(wc.readItem(2)); // ������ �ϳ��� ���� ��ü ��ȯ
//		System.out.println(wc.readAllItem()); // ��ü �����۸���Ʈ ��ȯ. //�� ��� �� ������ ���� 

//		wc.add_item(); // �����۸���Ʈ �ű��߰�(���� ������ �Ʒ��� ����)
//		System.out.println(wc.infoCount()); //�Ӽ����� ����
//		System.out.println(wc.info(0)); //�Ӽ����� �ϳ� �ҷ�����
//		wc.sales();
//		System.out.println(wc.excel(4,1)); // csv������ 2�߹迭�� �ҷ����� �Լ�(���� index, ����index)
		
		
		
	}
}
