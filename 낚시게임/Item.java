package 낚시게임;

import e_oop.ScanUtil;

public class Item {
	
	String name;
	int price; //가격
	int count;
	int luck;
	int speed;
	int upgrade;
	Item[] item = new Item[4];
	
	@Override
	public String toString() {
		return  name + " ,가격:" + price + "코인 " + count +"개 (성공률 " + luck +  
				"증가 스피드 " + speed + "증가 물고기등급 " + upgrade + "증가)"; 
 	}
	
	Item(String name, int price, int count, int luck, int speed, int upgrade){
		this.name = name;
		this.price = price;
		this.count = count;
		this.luck = luck;
		this.speed = speed;
		this.upgrade = upgrade;
	}
	
    Item(){
    	item[0] = new Item("미끼",50,5,0,0,0);
    	item[1] = new Item("중급자용 낚싯대",3000,1,1,1,1);
    	item[2] = new Item("전문가용 낚싯대",5000,1,2,2,2);
    	item[3] = new Item("최상급 낚싯대",10000,1,3,3,3);
    }
    
    
    int displayItem(int coin) {
    	System.out.println();
    	System.out.println("< 상점 > - Coin으로 아이템을 구매할 수 있습니다.              나의코인:" + coin);
    	System.out.println("---------------------------------------------------------------------");
    	System.out.println("1." + item[0].name + " ,가격:" + item[0].price + "코인 " + item[0].count + "개" );
    	for(int i = 1; i < item.length; i++ ) {
    		System.out.println(i+1 + "." + item[i]);
    	}
    	System.out.println();
    	System.out.println("===============================");
    	System.out.println("아이템 구매하기(1번) 나가기(아무숫자)");
    	System.out.println("===============================");
    	
    	int input = ScanUtil.nextInt();
    	if(input == 1) {
    		System.out.println("구매할 아이템의 숫자를 입력해주세요");
    		input = ScanUtil.nextInt();
    		if(input > 4 || input <=0) {
    			System.out.println("잘못 입력하셨습니다.");
    			displayItem(coin);
    		}
    		
    		return input - 1;
    		
    	}else {
    		return -1;
    	}
    	
    }
    
     	
}