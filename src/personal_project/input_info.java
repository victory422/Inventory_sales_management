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

    public static void writeCSV() { //데이터 입력 시 아래로 들어가기 때문에 추가로 입력할 때 쓰면 좋을 함수..
    	defines def = new defines();
    	Scanner scan = new Scanner(System.in);
    	int numberOfInfo = 0;
    	boolean ch = true;

    	//출력 스트림 생성
        BufferedWriter bufWriter = null;

        //상품 속성 입력 : info 어레이리스트.
        System.out.println("상품별 속성값을 입력해주세요. 다 입력하시면 '종료'를 입력해주세요.");
        boolean check = true;
        while(check) {
        	if(scan.hasNext("종료")) {
    		   def.info.add("\r"); //정보입력 마지막 열에서 줄바꿈 해주기.
        		check = false;
    		   System.out.println("상품정보 입력을 마치겠습니다.");
    		   break;
    	   }else 
    		   def.info.add(numberOfInfo, scan.nextLine());
        	numberOfInfo++;
       }
      		System.out.print("입력하신 상품 정보는  ");
      		if(numberOfInfo==0) System.out.println("없습니다.");
        		for(int i=0; i<numberOfInfo; i++) {
        		if(i<numberOfInfo-1) System.out.print(def.info.get(i)+",");
        		if(i==numberOfInfo-1) System.out.print(def.info.get(i)+" 입니다.");
        		}
        		//속성입력 완료.
        		
        //csv파일 읽기
        if(numberOfInfo!=0) {
        	
        
        List<List<String>> allData = readCSV();
        try{
            bufWriter = Files.newBufferedWriter(Paths.get("C:/Inventory_sales_management/items5.csv"),Charset.forName("UTF-8"));
          //추가할 때 필요
 
            for(int i=0; i<def.info.size(); i++) { 
            if(i<def.info.size()-1) bufWriter.append(def.info.get(i)+","); 
            if(i==def.info.size()-1) bufWriter.append(def.info.get(i)); 
            
            }
            
            //============================저장함수===================================
            
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
        //반환용 리스트
        
        BufferedReader br = null;
        
        try{
            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
            
            String line = "";
            int count = 0; // count값 0은 상품 속성정보이기 때문에 스킵 후 읽어오기.
            while((line = br.readLine()) != null ){
            	List<String> tmpList = new ArrayList<String>();
            	String array[] = line.split(",");
            	if(count==0) {
            		count++; 
            		continue; 
            	}else
                //CSV 1행을 저장하는 리스트
            	//배열에서 리스트 반환
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
        
        return def.infoCell; //상품 속성정보 가져올 때 가로 줄 채 가져오는 배열
    }
    
    
    
    public static List<String> itemInfo(int num){
        defines def = new defines();
        num=0;
        //반환용 리스트
        
        BufferedReader br = null;
        
        try{
            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
            
            String line = "";
            int count = 0; // count값 0은 상품 속성정보이기 때문에 스킵 후 읽어오기.
            while((line = br.readLine()) != null ){
            	List<String> tmpList = new ArrayList<String>();
            	String array[] = line.split(",");
            	if(count==0) {
            		count++; 
            		continue; 
            	}else
                //CSV 1행을 저장하는 리스트
            	//배열에서 리스트 반환
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
		
        return def.infoCell.get(num); //상품 속성정보 가져올 때 가로 줄 채 가져오는 배열
    }
    
    
    public static List<List<String>> readCSVOnlyItem(){
        defines def = new defines();
        //반환용 리스트
        
        BufferedReader br = null;
        
        try{
            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
            
            String line = "";
            while((line = br.readLine()) != null ){
            	List<String> tmpList = new ArrayList<String>();
            	String array[] = line.split(",");
                  //CSV 1행을 저장하는 리스트
            	//배열에서 리스트 반환
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
        
        return def.infoCell; //상품 속성정보 가져올 때 가로 줄 채 가져오는 배열
    }
    
    public static List<String> readItem(int num){
        defines def = new defines();
        //반환용 리스트
        
        BufferedReader br = null;
        
        try{
            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
            
            String line = "";
            int count = 0; // count값 0은 상품 속성정보이기 때문에 스킵 후 읽어오기.
            while((line = br.readLine()) != null ){
            	List<String> tmpList = new ArrayList<String>();
            	String array[] = line.split(",");
            	if(count==0) {
            		count++; 
            		continue; 
            	}else
                //CSV 1행을 저장하는 리스트
            	//배열에서 리스트 반환
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
        
        return def.infoCell.get(num); //상품 속성정보 가져올 때 가로 줄 채 가져오는 배열
    }
    
 	String info(int num) {
		 defines def = new defines();
	        
	        //반환용 리스트
	        
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
	        
	        //반환용 리스트
	        
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
	        
	        //반환용 리스트
	        
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
    	System.out.println(info.size()); //찾기
    	
    	//출력 스트림 생성
        BufferedWriter bufWriter = null;

        //상품 신규입력 
        System.out.println("상품 신규 입력입니다. 그만 입력하시려면 종료를 눌러주세요.");

        int numberOfInfo = 0;
        while(numberOfInfo<info.size()) {
        	if(numberOfInfo==info.size()) {
        		System.out.println("더 이상 입력할 정보가 없습니다.");
            	break;
        	}
        	System.out.println(info.get(numberOfInfo)+" : ");
        	if(scan.hasNext("종료")) {
    		   def.item.add("\r"); //정보입력 마지막 열에서 줄바꿈 해주기.
    		   System.out.println("상품 입력을 마치겠습니다.");
    		   break;
    	   }else if(numberOfInfo < info.size()) {
    		   def.item.add(numberOfInfo, scan.nextLine());
    		   numberOfInfo++;
    		   continue;
    	   }
       }
      		System.out.print("입력하신 상품은  ");
      		if(numberOfInfo==0) System.out.println("없습니다.");
        		for(int i=0; i<numberOfInfo; i++) {
        		if(i<numberOfInfo-1) System.out.println(wc.info(i)+" : "+def.item.get(i));
        		if(i==numberOfInfo-1) System.out.println(wc.info(i)+" : "+def.item.get(i)+" 입니다.");
        		}
        		//상품입력 완료.
        		
        //csv파일 읽기
        
        List<List<String>> allData = readCSVOnlyItem();
        try{
            bufWriter = Files.newBufferedWriter(Paths.get("C:/Inventory_sales_management/items5.csv"),Charset.forName("UTF-8"));
//            //추가할 때 필요
            //============================저장함수===================================
            
            for(List<String> newLine : allData){
            	List<String> list = newLine;
            	
            	for(String data : list) {
            		bufWriter.append(data+",");
            	}
            	bufWriter.newLine();
             }
            //==================실제로 csv로 저장해주는 기능함수==================
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
    
    public static void sales() { //미완성
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
    	        //반환용 리스트
    	        BufferedReader br = null;
    	        try{
    	        	
    	        	br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
    	            List<String> tmpList = new ArrayList<String>();
    	            
    	            String line = "";
    	            while((line = br.readLine()) != null ){
    	            	String array[] = line.split(",");
    	                  //CSV 1행을 저장하는 리스트
    	            	//배열에서 리스트 반환
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
    	        return def.infoCell.size(); //상품 속성정보 가져올 때 가로 줄 채 가져오는 배열
    	    }
    	
    public static void showAllItem() {
        defines def = new defines();
        //반환용 리스트
        BufferedReader br = null;
        try{
        	
        	br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
            List<String> tmpList = new ArrayList<String>();
            
            String line = "";
            while((line = br.readLine()) != null ){
            	String array[] = line.split(",");
                  //CSV 1행을 저장하는 리스트
            	//배열에서 리스트 반환
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
            file2.mkdirs();    // 폴더가 없을경우 폴더 생성
        }

         
         try {

      
             BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
             String line = "";
             
  
             while ((line = br.readLine()) != null) {
                 // -1 옵션은 마지막 "," 이후 빈 공백도 읽기 위한 옵션
                 String[] token = line.split(",", -1);
                 for(i=0;i<wc.infoCount();i++)  indat[row][i] = token[i];
                 
                 // CSV에서 읽어 배열에 옮긴 자료 확인하기 위한 출력
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
			System.out.println("검색할 상품을 입력해주세요."); // 
			String ser = scan.next();
			for(int i = 0; i<wc.readAllItem(); i++) {

				if(ser.equals(excel(i,0))) {
					for(int j = 0; j<wc.infoCount(); j++) { //속성정보 전체 불러오기
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
					System.out.println("돌아가시려면 0번을 눌러주세요.");
					checkNum = scan.nextInt();
					if(checkNum == 0) break;
				}
				
			System.out.println("판매할 상품을 입력해주세요."); // 
			String ser = scan.next();
			
			int allow = 0;
			int cate_index = 0; //재고 속성 인덱스번호
			int item_index = 0;
			int quan = 0;
			int count=0;
			for(int i=0; i<wc.infoCount(); i++) {
				if("재고".equals(wc.info(i))) cate_index = i; 
			}
			for(int i = 0; i<wc.readAllItem(); i++) {
				if(ser.equals(excel(i,0))) {
					item_index = i;
					System.out.println("판매할 수량을 입력해주세요. (현 재고:"+excel(item_index,cate_index)+"개)");
					quan = Integer.parseInt(excel(item_index,cate_index));
					count = scan.nextInt();	
					if(quan<count) {
						System.out.println("재고가 부족합니다."); 
						break;
					}else {
						System.out.print(excel(item_index,0)+"를 "+count+"개 판매합니다.");
						System.out.println("");
						System.out.print("1.승인 \t 2.취소");
						
					
			int b=0;	
			allow = single.iscan(b);
			if(allow==1) {
				quan = Integer.parseInt(excel(item_index,cate_index));
				//수량 새로이 저장하는 함수 필요.
			      BufferedReader br = null;
			        
			        try{
			            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
			            
			            String line = "";
			            while((line = br.readLine()) != null ){
			            	List<String> tmpList = new ArrayList<String>();
			            	String array[] = line.split(",");
			            	//CSV 1행을 저장하는 리스트
			            	//배열에서 리스트 반환
			                tmpList = Arrays.asList(array);
			                def.infoCell.add(tmpList);
			             }
			            int newQuan=Integer.parseInt(def.infoCell.get(item_index).get(cate_index));
			            newQuan=newQuan-count;
			            def.infoCell.get(item_index).set(cate_index, Integer.toString(newQuan));
			            System.out.print(excel(item_index,0)+"를 "+count+"개 판매가 승인되었습니다.");
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
		          //추가할 때 필요
		          //==================실제로 csv로 저장해주는 기능함수==================
		            for(int x=0; x<def.info.size(); x++) { 
		            if(x<def.info.size()-1) bufWriter.append(def.info.get(x)+","); 
		            if(x==def.info.size()-1) bufWriter.append(def.info.get(x)); 
		            
		            }
		            
		            //============================저장함수===================================
		            
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
				
			System.out.println("판매할 상품의 코드를 입력해주세요.");
			if(checkNum>0) {
				System.out.println("돌아가시려면 0번을 눌러주세요.");
				checkNum = scan.nextInt();
				if(checkNum == 0) break;
			}
			String ser = scan.next();
			
			int allow = 0;
			int cate_index = 0; //재고 속성 인덱스번호
			int item_index = 0;
			int quan = 0;
			int count=0;
			int codeNum = 0;
			for(int i=0; i<wc.infoCount(); i++) {
				if("재고".equals(wc.info(i))) cate_index = i; 
			}
			for(int i=0; i<wc.infoCount(); i++) {
				if("코드".equals(wc.info(i))) codeNum = i; 
			}
			for(int i = 0; i<wc.readAllItem(); i++) {
				if(ser.equals(excel(i,codeNum))) {
					item_index = i;
					System.out.println(excel(item_index,0)+"을 선택하셨습니다. 판매할 수량을 입력해주세요. (현 재고:"+excel(item_index,cate_index)+"개)");
					quan = Integer.parseInt(excel(item_index,cate_index));
					count = scan.nextInt();	
					if(quan<count) {
						System.out.println("재고가 부족합니다."); 
						break;
					}else {
						System.out.print(excel(item_index,0)+"를 "+count+"개 판매합니다.");
						System.out.println("");
						System.out.print("1.승인 \t 2.취소");
						
					
			int b=0;	
			allow = single.iscan(b);
			if(allow==1) {
				quan = Integer.parseInt(excel(item_index,cate_index));
				//수량 새로이 저장하는 함수 필요.
			      BufferedReader br = null;
			        
			        try{
			            br = Files.newBufferedReader(Paths.get("C:\\Inventory_sales_management\\items5.csv"));
			            
			            String line = "";
			            while((line = br.readLine()) != null ){
			            	List<String> tmpList = new ArrayList<String>();
			            	String array[] = line.split(",");
			            	//CSV 1행을 저장하는 리스트
			            	//배열에서 리스트 반환
			                tmpList = Arrays.asList(array);
			                def.infoCell.add(tmpList);
			             }
			            int newQuan=Integer.parseInt(def.infoCell.get(item_index).get(cate_index));
			            newQuan=newQuan-count;
			            def.infoCell.get(item_index).set(cate_index, Integer.toString(newQuan));
			            System.out.print(excel(item_index,0)+"를 "+count+"개 판매가 승인되었습니다.");
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
		          //추가할 때 필요
		          //==================실제로 csv로 저장해주는 기능함수==================
		            for(int x=0; x<def.info.size(); x++) { 
		            if(x<def.info.size()-1) bufWriter.append(def.info.get(x)+","); 
		            if(x==def.info.size()-1) bufWriter.append(def.info.get(x)); 
		            
		            }
		            
		            //============================저장함수===================================
		            
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
			System.out.println("검색할 카테고리를 입력해주세요."); // 
			String ser = scan.next();
			int cate_index = 0;
			for(int i=0; i<wc.infoCount(); i++) {
				if("카테고리".equals(wc.info(i))) cate_index = i;
			}
			for(int i = 0; i<wc.readAllItem(); i++) {
				if(ser.equals(excel(i,cate_index))) {
					for(int j = 0; j<wc.infoCount(); j++) { //속성정보 전체 불러오기
						System.out.print(wc.info(j)+"\t"); 
						System.out.print(excel(i,j));
						System.out.println("");
					}
				
				}
			}
			
		}
		
		
    
    }




