package personal_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class input_info {

    public static void writeCSV() { //������ �Է� �� �Ʒ��� ���� ������ �߰��� �Է��� �� ���� ���� �Լ�..
    	defines def = new defines();
    	Scanner scan = new Scanner(System.in);
    	int numberOfInfo = 0;
    	boolean ch = true;

    	//��� ��Ʈ�� ����
        BufferedWriter bufWriter = null;

        //��ǰ �Ӽ� �Է� : info ��̸���Ʈ.
        System.out.println("��ǰ�� �Ӽ����� �Է����ּ���. �� �Է��Ͻø� '����'�� �Է����ּ���.");
        boolean check = true;
        while(check) {
        	if(scan.hasNext("����")) {
    		   def.info.add("\r"); //�����Է� ������ ������ �ٹٲ� ���ֱ�.
        		check = false;
    		   System.out.println("��ǰ���� �Է��� ��ġ�ڽ��ϴ�.");
    		   break;
    	   }else 
    		   def.info.add(numberOfInfo, scan.nextLine());
        	numberOfInfo++;
       }
      		System.out.print("�Է��Ͻ� ��ǰ ������  ");
      		if(numberOfInfo==0) System.out.println("�����ϴ�.");
        		for(int i=0; i<numberOfInfo; i++) {
        		if(i<numberOfInfo-1) System.out.print(def.info.get(i)+",");
        		if(i==numberOfInfo-1) System.out.print(def.info.get(i)+" �Դϴ�.");
        		}
        		//�Ӽ��Է� �Ϸ�.
        		
        //csv���� �б�
        if(numberOfInfo!=0) {
        	
        
        List<List<String>> allData = readCSV();
        try{
            bufWriter = Files.newBufferedWriter(Paths.get("C:/Inventory_sales_management/items5.csv"),Charset.forName("UTF-8"));
          //�߰��� �� �ʿ�
 
            for(int i=0; i<def.info.size(); i++) { 
            if(i<def.info.size()-1) bufWriter.append(def.info.get(i)+","); 
            if(i==def.info.size()-1) bufWriter.append(def.info.get(i)); 
            
            }
            
            //============================�����Լ�===================================
            
            for(List<String> newLine : allData){
            	List<String> list = newLine;
            	for(String data : list) {
            		bufWriter.append(data+",");
            			
            	}
            	bufWriter.newLine();
             }
            
            
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bufWriter != null){
                    bufWriter.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        }
    	}


    
    public static List<List<String>> readCSV(){
        defines def = new defines();
        //��ȯ�� ����Ʈ
        
        BufferedReader br = null;
        
        try{
            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
            
            String line = "";
            int count = 0; // count�� 0�� ��ǰ �Ӽ������̱� ������ ��ŵ �� �о����.
            while((line = br.readLine()) != null ){
            	List<String> tmpList = new ArrayList<String>();
            	String array[] = line.split(",");
            	if(count==0) {
            		count++; 
            		continue; 
            	}else
                //CSV 1���� �����ϴ� ����Ʈ
            	//�迭���� ����Ʈ ��ȯ
                tmpList = Arrays.asList(array);
                def.infoCell.add(tmpList);
             }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        return def.infoCell; //��ǰ �Ӽ����� ������ �� ���� �� ä �������� �迭
    }
    
    
    
    public static List<String> itemInfo(int num){
        defines def = new defines();
        num=0;
        //��ȯ�� ����Ʈ
        
        BufferedReader br = null;
        
        try{
            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
            
            String line = "";
            int count = 0; // count�� 0�� ��ǰ �Ӽ������̱� ������ ��ŵ �� �о����.
            while((line = br.readLine()) != null ){
            	List<String> tmpList = new ArrayList<String>();
            	String array[] = line.split(",");
            	if(count==0) {
            		count++; 
            		continue; 
            	}else
                //CSV 1���� �����ϴ� ����Ʈ
            	//�迭���� ����Ʈ ��ȯ
                tmpList = Arrays.asList(array);
                def.infoCell.add(tmpList);
             }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
		
        return def.infoCell.get(num); //��ǰ �Ӽ����� ������ �� ���� �� ä �������� �迭
    }
    
    
    public static List<List<String>> readCSVOnlyItem(){
        defines def = new defines();
        //��ȯ�� ����Ʈ
        
        BufferedReader br = null;
        
        try{
            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
            
            String line = "";
            while((line = br.readLine()) != null ){
            	List<String> tmpList = new ArrayList<String>();
            	String array[] = line.split(",");
                  //CSV 1���� �����ϴ� ����Ʈ
            	//�迭���� ����Ʈ ��ȯ
                tmpList = Arrays.asList(array);
                def.infoCell.add(tmpList);
             }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        return def.infoCell; //��ǰ �Ӽ����� ������ �� ���� �� ä �������� �迭
    }
    
    public static List<String> readItem(int num){
        defines def = new defines();
        //��ȯ�� ����Ʈ
        
        BufferedReader br = null;
        
        try{
            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
            
            String line = "";
            int count = 0; // count�� 0�� ��ǰ �Ӽ������̱� ������ ��ŵ �� �о����.
            while((line = br.readLine()) != null ){
            	List<String> tmpList = new ArrayList<String>();
            	String array[] = line.split(",");
            	if(count==0) {
            		count++; 
            		continue; 
            	}else
                //CSV 1���� �����ϴ� ����Ʈ
            	//�迭���� ����Ʈ ��ȯ
                tmpList = Arrays.asList(array);
                def.infoCell.add(tmpList);
             }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        return def.infoCell.get(num); //��ǰ �Ӽ����� ������ �� ���� �� ä �������� �迭
    }
    
 	String info(int num) {
		 defines def = new defines();
	        
	        //��ȯ�� ����Ʈ
	        
	        BufferedReader br = null;
	        
	        try{
	            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));

	            String line = "";

	            while((line = br.readLine()) != null ){
	            	String array[] = line.split(",");
	            		def.info = Arrays.asList(array);
	            		break;
	            	}

	           
	        }catch(FileNotFoundException e){
	            e.printStackTrace();
	        }catch(IOException e){
	            e.printStackTrace();
	        }finally{
	            try{
	                if(br != null){
	                    br.close();
	                }
	            }catch(IOException e){
	                e.printStackTrace();
	            }
	        }
	        return def.info.get(num);
	    }
 	
 	int infoCount() {
		 defines def = new defines();
	        
	        //��ȯ�� ����Ʈ
	        
	        BufferedReader br = null;
	        
	        try{
	            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));

	            String line = "";

	            while((line = br.readLine()) != null ){
	            	String array[] = line.split(",");
	            		def.info = Arrays.asList(array);
	            		break;
	            	}

	           
	        }catch(FileNotFoundException e){
	            e.printStackTrace();
	        }catch(IOException e){
	            e.printStackTrace();
	        }finally{
	            try{
	                if(br != null){
	                    br.close();
	                }
	            }catch(IOException e){
	                e.printStackTrace();
	            }
	        }
	        return def.info.size();
	    }
 	
	public static List<String> infoList() {
		 defines def = new defines();
	        
	        //��ȯ�� ����Ʈ
	        
	        BufferedReader br = null;
	        
	        try{
	            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));

	            String line = "";

	            while((line = br.readLine()) != null ){
	            	String array[] = line.split(",");
	            		def.info = Arrays.asList(array);
	            		break;
	            	}

	           
	        }catch(FileNotFoundException e){
	            e.printStackTrace();
	        }catch(IOException e){
	            e.printStackTrace();
	        }finally{
	            try{
	                if(br != null){
	                    br.close();
	                }
	            }catch(IOException e){
	                e.printStackTrace();
	            }
	        }
	        return def.info;
	    }
 	
 	
    public static void add_item() {
    	defines def = new defines();
    	Scanner scan = new Scanner(System.in);
    	input_info wc = new input_info();
    	List<String> info = infoList();
    	System.out.println(info.size()); //ã��
    	
    	//��� ��Ʈ�� ����
        BufferedWriter bufWriter = null;

        //��ǰ �ű��Է� 
        System.out.println("��ǰ �ű� �Է��Դϴ�. �׸� �Է��Ͻ÷��� ���Ḧ �����ּ���.");

        int numberOfInfo = 0;
        while(numberOfInfo<info.size()) {
        	if(numberOfInfo==info.size()) {
        		System.out.println("�� �̻� �Է��� ������ �����ϴ�.");
            	break;
        	}
        	System.out.println(info.get(numberOfInfo)+" : ");
        	if(scan.hasNext("����")) {
    		   def.item.add("\r"); //�����Է� ������ ������ �ٹٲ� ���ֱ�.
    		   System.out.println("��ǰ �Է��� ��ġ�ڽ��ϴ�.");
    		   break;
    	   }else if(numberOfInfo < info.size()) {
    		   def.item.add(numberOfInfo, scan.nextLine());
    		   numberOfInfo++;
    		   continue;
    	   }
       }
      		System.out.print("�Է��Ͻ� ��ǰ��  ");
      		if(numberOfInfo==0) System.out.println("�����ϴ�.");
        		for(int i=0; i<numberOfInfo; i++) {
        		if(i<numberOfInfo-1) System.out.println(wc.info(i)+" : "+def.item.get(i));
        		if(i==numberOfInfo-1) System.out.println(wc.info(i)+" : "+def.item.get(i)+" �Դϴ�.");
        		}
        		//��ǰ�Է� �Ϸ�.
        		
        //csv���� �б�
        
        List<List<String>> allData = readCSVOnlyItem();
        try{
            bufWriter = Files.newBufferedWriter(Paths.get("C:/Inventory_sales_management/items5.csv"),Charset.forName("UTF-8"));
//            //�߰��� �� �ʿ�
            //============================�����Լ�===================================
            
            for(List<String> newLine : allData){
            	List<String> list = newLine;
            	
            	for(String data : list) {
            		bufWriter.append(data+",");
            	}
            	bufWriter.newLine();
             }
            //==================������ csv�� �������ִ� ����Լ�==================
            for(int i=0; i<def.item.size(); i++) { 
            	bufWriter.append(def.item.get(i)+","); 
            }
            

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bufWriter != null){
                    bufWriter.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
		
    	}
    
    public static void sales() { //�̿ϼ�
    	defines def = new defines();
    	Scanner scan = new Scanner(System.in);
    	input_info wc = new input_info();
    	String item = scan.next();
    	
    	for(int i = 0; i<def.item.size(); i++) {
    		System.out.println(def.item.get(i));
    	}
    }
    
    public static int readAllItem() {
    	        defines def = new defines();
    	        //��ȯ�� ����Ʈ
    	        BufferedReader br = null;
    	        try{
    	        	
    	        	br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
    	            List<String> tmpList = new ArrayList<String>();
    	            
    	            String line = "";
    	            while((line = br.readLine()) != null ){
    	            	String array[] = line.split(",");
    	                  //CSV 1���� �����ϴ� ����Ʈ
    	            	//�迭���� ����Ʈ ��ȯ
    	                tmpList = Arrays.asList(array);
    	                def.infoCell.add(tmpList);
    	          
    	            }
//    	            for(int i =0; i<def.infoCell.size(); i++) {
//    	            	System.out.println(def.infoCell.get(i));
//    	            	def.infoCell.get(i);
//    	            }
    	            
    	        }catch(FileNotFoundException e){
    	            e.printStackTrace();
    	        }catch(IOException e){
    	            e.printStackTrace();
    	        }finally{
    	            try{
    	                if(br != null){
    	                    br.close();
    	                }
    	            }catch(IOException e){
    	                e.printStackTrace();
    	            }
    	        }
    	        return def.infoCell.size(); //��ǰ �Ӽ����� ������ �� ���� �� ä �������� �迭
    	    }
    	
    public static void showAllItem() {
        defines def = new defines();
        //��ȯ�� ����Ʈ
        BufferedReader br = null;
        try{
        	
        	br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
            List<String> tmpList = new ArrayList<String>();
            
            String line = "";
            while((line = br.readLine()) != null ){
            	String array[] = line.split(",");
                  //CSV 1���� �����ϴ� ����Ʈ
            	//�迭���� ����Ʈ ��ȯ
                tmpList = Arrays.asList(array);
                def.infoCell.add(tmpList);
          
            }
            for(int i =0; i<def.infoCell.size(); i++) {
            	System.out.println(def.infoCell.get(i));
            	def.infoCell.get(i);
            }

            

            
            
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
    
    

		public static String excel(int a, int b) {
		String[][] indat = new String[2880][100];
		input_info wc = new input_info();
		int row = 0;
		int i = 0;
		
        File file    =  new File("C:\\Inventory_sales_management\\items5.csv");
        File file2    =  new File("C:\\Inventory_sales_management");
        if (!file2.exists()) {
            file2.mkdirs();    // ������ ������� ���� ����
        }

         
         try {

      
             BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
             String line = "";
             
  
             while ((line = br.readLine()) != null) {
                 // -1 �ɼ��� ������ "," ���� �� ���鵵 �б� ���� �ɼ�
                 String[] token = line.split(",", -1);
                 for(i=0;i<wc.infoCount();i++)  indat[row][i] = token[i];
                 
                 // CSV���� �о� �迭�� �ű� �ڷ� Ȯ���ϱ� ���� ���
//                 for(i=0;i<wc.infoCount();i++)   {
//                	 System.out.print(indat[row][i] + ",");
//                 }System.out.println("");
                 row++;

             }

             br.close();
  
         } 
         catch (FileNotFoundException e) {
             e.printStackTrace();
         } 
         catch (IOException e) {
             e.printStackTrace();
         }
     return indat[a][b];
		}


		public void search() {
			input_info wc = new input_info();
			defines def= new defines();

			Scanner scan = new Scanner(System.in);
			System.out.println("�˻��� ��ǰ�� �Է����ּ���."); // 
			String ser = scan.next();
			for(int i = 0; i<wc.readAllItem(); i++) {

				if(ser.equals(excel(i,0))) {
					for(int j = 0; j<wc.infoCount(); j++) { //�Ӽ����� ��ü �ҷ�����
						System.out.print(wc.info(j)+"\t"); 
						System.out.print(excel(i,j));
						System.out.println("");
					}
				
				}
			}
			
		}
		
		
		public void sale() {
			singleton single = singleton.getInstance();
			input_info wc = new input_info();
			defines def= new defines();
			Scanner scan = new Scanner(System.in);
			int checkNum = 0;
			boolean chec = true;
			while(chec) {
				if(checkNum>0) {
					System.out.println("���ư��÷��� 0���� �����ּ���.");
					checkNum = scan.nextInt();
					if(checkNum == 0) break;
				}
				
			System.out.println("�Ǹ��� ��ǰ�� �Է����ּ���."); // 
			String ser = scan.next();
			
			int allow = 0;
			int cate_index = 0; //��� �Ӽ� �ε�����ȣ
			int item_index = 0;
			int quan = 0;
			int count=0;
			for(int i=0; i<wc.infoCount(); i++) {
				if("���".equals(wc.info(i))) cate_index = i; 
			}
			for(int i = 0; i<wc.readAllItem(); i++) {
				if(ser.equals(excel(i,0))) {
					item_index = i;
					System.out.println("�Ǹ��� ������ �Է����ּ���. (�� ���:"+excel(item_index,cate_index)+"��)");
					quan = Integer.parseInt(excel(item_index,cate_index));
					count = scan.nextInt();	
					if(quan<count) {
						System.out.println("��� �����մϴ�."); 
						break;
					}else {
						System.out.print(excel(item_index,0)+"�� "+count+"�� �Ǹ��մϴ�.");
						System.out.println("");
						System.out.print("1.���� \t 2.���");
						
					
			int b=0;	
			allow = single.iscan(b);
			if(allow==1) {
				quan = Integer.parseInt(excel(item_index,cate_index));
				//���� ������ �����ϴ� �Լ� �ʿ�.
			      BufferedReader br = null;
			        
			        try{
			            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
			            
			            String line = "";
			            while((line = br.readLine()) != null ){
			            	List<String> tmpList = new ArrayList<String>();
			            	String array[] = line.split(",");
			            	//CSV 1���� �����ϴ� ����Ʈ
			            	//�迭���� ����Ʈ ��ȯ
			                tmpList = Arrays.asList(array);
			                def.infoCell.add(tmpList);
			             }
			            int newQuan=Integer.parseInt(def.infoCell.get(item_index).get(cate_index));
			            newQuan=newQuan-count;
			            def.infoCell.get(item_index).set(cate_index, Integer.toString(newQuan));
			            System.out.print(excel(item_index,0)+"�� "+count+"�� �ǸŰ� ���εǾ����ϴ�.");
			        }catch(FileNotFoundException e){
			            e.printStackTrace();
			        }catch(IOException e){
			            e.printStackTrace();
			        }finally{
			            try{
			                if(br != null){
			                    br.close();
			                }
			            }catch(IOException e){
			                e.printStackTrace();
			            }
			        }
				
				List<List<String>> allData = def.infoCell;
		        BufferedWriter bufWriter = null;
				try{
		            bufWriter = Files.newBufferedWriter(Paths.get("C:/Inventory_sales_management/items5.csv"),Charset.forName("UTF-8"));
		          //�߰��� �� �ʿ�
		          //==================������ csv�� �������ִ� ����Լ�==================
		            for(int x=0; x<def.info.size(); x++) { 
		            if(x<def.info.size()-1) bufWriter.append(def.info.get(x)+","); 
		            if(x==def.info.size()-1) bufWriter.append(def.info.get(x)); 
		            
		            }
		            
		            //============================�����Լ�===================================
		            
		            for(List<String> newLine : allData){
		            	List<String> list = newLine;
		            	for(String data : list) {
		            		bufWriter.append(data+",");
		            			
		            	}
		            	bufWriter.newLine();
		             }
		            
		            
		            
		        }catch(FileNotFoundException e){
		            e.printStackTrace();
		        }catch(IOException e){
		            e.printStackTrace();
		        }finally{
		            try{
		                if(bufWriter != null){
		                    bufWriter.close();
		                }
		            }catch(IOException e){
		                e.printStackTrace();
		            }
		        }
		     
			}
			if(allow==2) break;
		}
		}
			}
			checkNum++;
			}
		}
		
		
		public void saleCode() {
			singleton single = singleton.getInstance();
			input_info wc = new input_info();
			defines def= new defines();
			Scanner scan = new Scanner(System.in);
			boolean chec = true;
			int checkNum = 0;
			while(chec) {
				
			System.out.println("�Ǹ��� ��ǰ�� �ڵ带 �Է����ּ���.");
			if(checkNum>0) {
				System.out.println("���ư��÷��� 0���� �����ּ���.");
				checkNum = scan.nextInt();
				if(checkNum == 0) break;
			}
			String ser = scan.next();
			
			int allow = 0;
			int cate_index = 0; //��� �Ӽ� �ε�����ȣ
			int item_index = 0;
			int quan = 0;
			int count=0;
			int codeNum = 0;
			for(int i=0; i<wc.infoCount(); i++) {
				if("���".equals(wc.info(i))) cate_index = i; 
			}
			for(int i=0; i<wc.infoCount(); i++) {
				if("�ڵ�".equals(wc.info(i))) codeNum = i; 
			}
			for(int i = 0; i<wc.readAllItem(); i++) {
				if(ser.equals(excel(i,codeNum))) {
					item_index = i;
					System.out.println(excel(item_index,0)+"�� �����ϼ̽��ϴ�. �Ǹ��� ������ �Է����ּ���. (�� ���:"+excel(item_index,cate_index)+"��)");
					quan = Integer.parseInt(excel(item_index,cate_index));
					count = scan.nextInt();	
					if(quan<count) {
						System.out.println("��� �����մϴ�."); 
						break;
					}else {
						System.out.print(excel(item_index,0)+"�� "+count+"�� �Ǹ��մϴ�.");
						System.out.println("");
						System.out.print("1.���� \t 2.���");
						
					
			int b=0;	
			allow = single.iscan(b);
			if(allow==1) {
				quan = Integer.parseInt(excel(item_index,cate_index));
				//���� ������ �����ϴ� �Լ� �ʿ�.
			      BufferedReader br = null;
			        
			        try{
			            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
			            
			            String line = "";
			            while((line = br.readLine()) != null ){
			            	List<String> tmpList = new ArrayList<String>();
			            	String array[] = line.split(",");
			            	//CSV 1���� �����ϴ� ����Ʈ
			            	//�迭���� ����Ʈ ��ȯ
			                tmpList = Arrays.asList(array);
			                def.infoCell.add(tmpList);
			             }
			            int newQuan=Integer.parseInt(def.infoCell.get(item_index).get(cate_index));
			            newQuan=newQuan-count;
			            def.infoCell.get(item_index).set(cate_index, Integer.toString(newQuan));
			            System.out.print(excel(item_index,0)+"�� "+count+"�� �ǸŰ� ���εǾ����ϴ�.");
			        }catch(FileNotFoundException e){
			            e.printStackTrace();
			        }catch(IOException e){
			            e.printStackTrace();
			        }finally{
			            try{
			                if(br != null){
			                    br.close();
			                }
			            }catch(IOException e){
			                e.printStackTrace();
			            }
			        }
				
				List<List<String>> allData = def.infoCell;
		        BufferedWriter bufWriter = null;
				try{
		            bufWriter = Files.newBufferedWriter(Paths.get("C:/Inventory_sales_management/items5.csv"),Charset.forName("UTF-8"));
		          //�߰��� �� �ʿ�
		          //==================������ csv�� �������ִ� ����Լ�==================
		            for(int x=0; x<def.info.size(); x++) { 
		            if(x<def.info.size()-1) bufWriter.append(def.info.get(x)+","); 
		            if(x==def.info.size()-1) bufWriter.append(def.info.get(x)); 
		            
		            }
		            
		            //============================�����Լ�===================================
		            
		            for(List<String> newLine : allData){
		            	List<String> list = newLine;
		            	for(String data : list) {
		            		bufWriter.append(data+",");
		            			
		            	}
		            	bufWriter.newLine();
		             }
		            
		            
		            
		        }catch(FileNotFoundException e){
		            e.printStackTrace();
		        }catch(IOException e){
		            e.printStackTrace();
		        }finally{
		            try{
		                if(bufWriter != null){
		                    bufWriter.close();
		                }
		            }catch(IOException e){
		                e.printStackTrace();
		            }
		        }
		     
			}
			if(allow==2) break;
		}
		}
			}
			checkNum++;
			}
		}
		
		
		public void searchCategory() {
			input_info wc = new input_info();
			defines def= new defines();

			Scanner scan = new Scanner(System.in);
			System.out.println("�˻��� ī�װ��� �Է����ּ���."); // 
			String ser = scan.next();
			int cate_index = 0;
			for(int i=0; i<wc.infoCount(); i++) {
				if("ī�װ�".equals(wc.info(i))) cate_index = i;
			}
			for(int i = 0; i<wc.readAllItem(); i++) {
				if(ser.equals(excel(i,cate_index))) {
					for(int j = 0; j<wc.infoCount(); j++) { //�Ӽ����� ��ü �ҷ�����
						System.out.print(wc.info(j)+"\t"); 
						System.out.print(excel(i,j));
						System.out.println("");
					}
				
				}
			}
			
		}
		
		
    
    }




