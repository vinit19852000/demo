package com.example.demo.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.StockData;
import com.example.demo.Repo.Stockrepo;
import com.example.demo.Service.StockService;


@RestController
@RequestMapping("/real-time-stock-data")
public class RealTimeStockData {
	int index=1;
    
	
	@Autowired
	StockService service;
	
	@Autowired
	Stockrepo stockrepo;
	
	@PutMapping("/update-stockdata")
	public ResponseEntity<Object> getall(@RequestParam String password) throws IOException, InterruptedException{
		
		
		if(password.equalsIgnoreCase("vinit1985")) {
			 String json=service.updateAndSaveLatestData();
			 
			 StockData stockData=new StockData();
			 stockData.setJsonData(json);

			return ResponseEntity.ok(stockrepo.save(stockData));
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PASSWORD IS WRONG");

	}
	

	@GetMapping("/best-performance")
	public ResponseEntity<Object> bestperformance() throws Exception{
		
		
		
		List<StockData> list=stockrepo.findAll();
		
		String json=list.stream()
	               .max(Comparator.comparing(StockData::getCreatedAt)).get().getJsonData().toString();
		HashMap<String,Set<String>>  hmap=new LinkedHashMap<String, Set<String>>() ;
 
         StringTokenizer st=new StringTokenizer(json,",");
         

         int i=1;
         while(st.hasMoreTokens()) {
        	 
        	 
        	 String data=st.nextToken();

        	 String fullstring=data.replaceAll("\"", "").replaceAll("\\{", "");
        	 
        	 
        	 String value=fullstring.split("=")[1];
             String mykey=fullstring.split("=")[0];
        	 
        	 String array[]=value.trim().split("\\|");
             

             Set<String> set=new HashSet<String>(List.of(array));
             
             hmap.put(mykey.trim(),set);
           
         }
         
         System.out.print("no erorr.........................");
         
         
         List<String> stocklist=new ArrayList<String>();
         index=1;
         
         hmap.forEach((k,v)->{
        	 
        	 
        	       String a[]=k.split(":");
        	       
        	       if(a[0].equalsIgnoreCase("High")) {
                       v.forEach(s->{
                       	
                       	stocklist.add(index+":"+s);
                       	index++;
                       });
        	       }

         });
         
         return ResponseEntity.ok(stocklist);
         
	}
	
	@GetMapping("/low-risk")
	public ResponseEntity<Object> lowrisk() throws Exception{
		
		
		
		List<StockData> list=stockrepo.findAll();
		
		String json=list.stream()
	               .max(Comparator.comparing(StockData::getCreatedAt)).get().getJsonData().toString();
		HashMap<String,Set<String>>  hmap=new LinkedHashMap<String, Set<String>>() ;
 
         StringTokenizer st=new StringTokenizer(json,",");
         

         int i=1;
         while(st.hasMoreTokens()) {
        	 
        	 
        	 String data=st.nextToken();

        	 String fullstring=data.replaceAll("\"", "").replaceAll("\\{", "");
        	 
        	 
        	 String value=fullstring.split("=")[1];
             String mykey=fullstring.split("=")[0];
        	 
        	 String array[]=value.trim().split("\\|");
             

             Set<String> set=new HashSet<String>(List.of(array));
             
             hmap.put(mykey.trim(),set);
           
         }
         
         System.out.print("no erorr.........................");
         
         
         List<String> stocklist=new ArrayList<String>();
         index=1;
         
         hmap.forEach((k,v)->{
        	 
        	 
        	       String a[]=k.split(":");
        	       
        	       if(a[5].equalsIgnoreCase("Low")) {
                       v.forEach(s->{
                       	
                       	stocklist.add(index+":"+s);
                       	index++;
                       });
        	       }

         });
         
         return ResponseEntity.ok(stocklist);
         
	}


	
	@GetMapping("/can-invest-now-stocks")
	public ResponseEntity<Object> caninvestnow(@RequestParam String password) throws Exception{
		
		
		
		if(password.equalsIgnoreCase("vinit1985")) {
			List<StockData> list=stockrepo.findAll();
			
			String json=list.stream()
		               .max(Comparator.comparing(StockData::getCreatedAt)).get().getJsonData().toString();
			HashMap<String,Set<String>>  hmap=new LinkedHashMap<String, Set<String>>() ;
	 
	         StringTokenizer st=new StringTokenizer(json,",");
	         

	         int i=1;
	         while(st.hasMoreTokens()) {
	        	 
	        	 
	        	 String data=st.nextToken();

	        	 String fullstring=data.replaceAll("\"", "").replaceAll("\\{", "");
	        	 
	        	 
	        	 String value=fullstring.split("=")[1];
	             String mykey=fullstring.split("=")[0];
	        	 
	        	 String array[]=value.trim().split("\\|");
	             

	             Set<String> set=new HashSet<String>(List.of(array));
	             
	             hmap.put(mykey.trim(),set);
	           
	         }
	         
	         System.out.print("no erorr.........................");
	         
	         
	         List<String> stocklist=new ArrayList<String>();
	         index=1;
	         
	         hmap.forEach((k,v)->{
	        	 
	        	 
	        	       String a[]=k.split(":");
	        	       
	        	       if(a[4].equalsIgnoreCase("Good")) {
	                       v.forEach(s->{
	                       	
	                       	stocklist.add(index+":"+s);
	                       	index++;
	                       });
	        	       }

	         });
	         
	         return ResponseEntity.ok(stocklist);

		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong Password");
		}
		
		         
	}


	@GetMapping("/high-profitability")
	public ResponseEntity<Object> highprofitablity() throws Exception{
		
		
		
		List<StockData> list=stockrepo.findAll();
		
		String json=list.stream()
	               .max(Comparator.comparing(StockData::getCreatedAt)).get().getJsonData().toString();
		HashMap<String,Set<String>>  hmap=new LinkedHashMap<String, Set<String>>() ;
 
         StringTokenizer st=new StringTokenizer(json,",");
         

         int i=1;
         while(st.hasMoreTokens()) {
        	 
        	 
        	 String data=st.nextToken();

        	 String fullstring=data.replaceAll("\"", "").replaceAll("\\{", "");
        	 
        	 
        	 String value=fullstring.split("=")[1];
             String mykey=fullstring.split("=")[0];
        	 
        	 String array[]=value.trim().split("\\|");
             

             Set<String> set=new HashSet<String>(List.of(array));
             
             hmap.put(mykey.trim(),set);
           
         }
         
         System.out.print("no erorr.........................");
         
         
         List<String> stocklist=new ArrayList<String>();
         index=1;
         
         hmap.forEach((k,v)->{
        	 
        	 
        	       String a[]=k.split(":");
        	       
        	       if(a[3].equalsIgnoreCase("High")) {
                       v.forEach(s->{
                       	
                       	stocklist.add(index+":"+s);
                       	index++;
                       });
        	       }

         });
         
         return ResponseEntity.ok(stocklist);
         
	}


	@GetMapping("/high-growth")
	public ResponseEntity<Object> highgrwoth() throws Exception{
		
		
		
		List<StockData> list=stockrepo.findAll();
		
		String json=list.stream()
	               .max(Comparator.comparing(StockData::getCreatedAt)).get().getJsonData().toString();
		HashMap<String,Set<String>>  hmap=new LinkedHashMap<String, Set<String>>() ;
 
         StringTokenizer st=new StringTokenizer(json,",");
         

         int i=1;
         while(st.hasMoreTokens()) {
        	 
        	 
        	 String data=st.nextToken();

        	 String fullstring=data.replaceAll("\"", "").replaceAll("\\{", "");
        	 
        	 
        	 String value=fullstring.split("=")[1];
             String mykey=fullstring.split("=")[0];
        	 
        	 String array[]=value.trim().split("\\|");
             

             Set<String> set=new HashSet<String>(List.of(array));
             
             hmap.put(mykey.trim(),set);
           
         }
         
         System.out.print("no erorr.........................");
         
         
         List<String> stocklist=new ArrayList<String>();
         index=1;
         
         hmap.forEach((k,v)->{
        	 
        	 
        	       String a[]=k.split(":");
        	       
        	       if(a[2].equalsIgnoreCase("High")) {
                       v.forEach(s->{
                       	
                       	stocklist.add(index+":"+s);
                       	index++;
                       });
        	       }

         });
         
         return ResponseEntity.ok(stocklist);
         
	}


	@GetMapping("/low-valuation")
	public ResponseEntity<Object> lowvaluation() throws Exception{
		
		
		
		List<StockData> list=stockrepo.findAll();
		
		String json=list.stream()
	               .max(Comparator.comparing(StockData::getCreatedAt)).get().getJsonData().toString();
		HashMap<String,Set<String>>  hmap=new LinkedHashMap<String, Set<String>>() ;
 
         StringTokenizer st=new StringTokenizer(json,",");
         

         int i=1;
         while(st.hasMoreTokens()) {
        	 
        	 
        	 String data=st.nextToken();

        	 String fullstring=data.replaceAll("\"", "").replaceAll("\\{", "");
        	 
        	 
        	 String value=fullstring.split("=")[1];
             String mykey=fullstring.split("=")[0];
        	 
        	 String array[]=value.trim().split("\\|");
             

             Set<String> set=new HashSet<String>(List.of(array));
             
             hmap.put(mykey.trim(),set);
           
         }
         
         System.out.print("no erorr.........................");
         
         
         List<String> stocklist=new ArrayList<String>();
         index=1;
         
         hmap.forEach((k,v)->{
        	 
        	 
        	       String a[]=k.split(":");
        	       
        	       if(a[1].equalsIgnoreCase("Low")) {
                       v.forEach(s->{
                       	
                       	stocklist.add(index+":"+s);
                       	index++;
                       });
        	       }

         });
         
         return ResponseEntity.ok(stocklist);
         
	}


	@GetMapping("/stock-list")
	public ResponseEntity<Object> getletest() throws Exception{
		
		
		
		List<StockData> list=stockrepo.findAll();
		
		String json=list.stream()
	               .max(Comparator.comparing(StockData::getCreatedAt)).get().getJsonData().toString();
		HashMap<String,Set<String>>  hmap=new LinkedHashMap<String, Set<String>>() ;
 
         StringTokenizer st=new StringTokenizer(json,",");
         

         int i=1;
         while(st.hasMoreTokens()) {
        	 
        	 
        	 String data=st.nextToken();

        	 String fullstring=data.replaceAll("\"", "").replaceAll("\\{", "");
        	 
        	 
        	 String value=fullstring.split("=")[1];
             String mykey=fullstring.split("=")[0];
        	 
        	 String array[]=value.trim().split("\\|");
             

             Set<String> set=new HashSet<String>(List.of(array));
             
             hmap.put(mykey.trim(),set);
           
         }
         
         System.out.print("no erorr.........................");
         
         
         List<String> stocklist=new ArrayList<String>();
         index=1;
         
         hmap.forEach((k,v)->{
        	 
                    v.forEach(s->{
                    	
                    	stocklist.add(index+":"+s);
                    	index++;
                    });
         });
         
         return ResponseEntity.ok(stocklist);
         
	}
}
