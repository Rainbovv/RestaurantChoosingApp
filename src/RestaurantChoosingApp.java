public class RestaurantChoosingApp {
	static int portions = 5;
	static int specialPortions = 10;
    
	public static void main (String[] args) {
    	 
    	SushiRestaurant.Info.printMenu();
    	VeganRestaurant.Info.printMenu();
    }
 }

  // ###################### RESTAURANT CLASSES ##########################
class VeganRestaurant {
	
	static class Info extends Templates{
		
		static void printName() {

			System.out.println("########### Vegan Pure Restaurant ###########");    	  
		}
		  
		static void printMenu() {
			
			printName();
			printAddress();	  
			menuTemp(Menu.getPrice(),SpecialMenu.getPrice());
			
		}
		  
		static void printAddress() {
    	  
			System.out.println("-- UpTown Str 77/B, Maxicity               --");
        }
	}
	  
    static class Menu {
    	  	
    	static double getPrice() {    		
    		return 50.00;    		
        }
    }
    
    static class SpecialMenu {
    	
    	static double getPrice() {
    		return 200.00;
    	}
    }
 }

class SushiRestaurant {
	
	
	
	static class Info extends Templates {
				
		static void printName() {
			System.out.println("########### Sushi Mini Restaurant ###########");    	  
		}
		  
		static void printMenu() {
			
			printName();
			printAddress();	
			menuTemp(Menu.getPrice(),SpecialMenu.getPrice());
		}
		  
		static void printAddress() {   	  
			System.out.println("-- DownTown Str 88/A, Minicity             --");
		}
	}
	
	static class Menu{
		
		static double getPrice() {   		
    		return 100.00;
		}
	}
		
	static class SpecialMenu{
		
		static double getPrice() {   		
    		return 300.00;
		}
	}
}

// ################### Output & Calculating TEMPLATES ##################
class Templates extends RestaurantChoosingApp {
	
    static void menuTemp(double price, double specialPrice) {
    	
    	System.out.printf("MENU %10s 1  portion %14.2f MDL%n" +
		 				  "MENU %1$10s %-2s portions%-6s%8.2f MDL%n" +
		 				  "SPECIAL MENU %1$2s 1  portion %14.2f MDL%n" +
		 				  "SPECIAL MENU %1$2s %-2s portions%-6s%8.2f MDL%n%n",
		 				  "x", price, portions , "(-" + (int)(100 - discount(portions,price) * 100)
		 				  +"%)", finalPrice(portions,price), specialPrice, specialPortions, "(-" + 
		 				  (int)(100 - discount(specialPortions,specialPrice) * 100) + "%)",
		 				  finalPrice(specialPortions, specialPrice));
    }
    
    static double finalPrice(int portions, double price) {   		 
		return price * portions * discount(portions,price); 
    }
    
    static double discount(int portions, double price){
        
    	double coef = 1.0;
    	
    	if (price == VeganRestaurant.Menu.getPrice() || price == VeganRestaurant.SpecialMenu.getPrice()) {
    		if(portions >= 30) {
    			coef = 0.7;
    		}else {
    			for (int i = 1; i <= portions; i++) {
    				if (i == 5) {
    					coef -= 0.05;
    					i -= 5;
    					portions -= 5;
    				}
    			}	
    		}
    	}else {		
    	
    		if (portions >= 15)
    			coef = 0.7;
    		else if (portions >= 10)
    			coef = 0.8;
    		else if (portions >= 5) 
    			coef = 0.9;
    		else
    			coef = 1.0;
    	}
    	
		return coef;
    }
}