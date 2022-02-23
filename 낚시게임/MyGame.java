package 낚시게임;

import e_oop.ScanUtil;

public class MyGame {
	
    Fish f;	
	Character c;
	Item it;
	
	MyGame(){
		
		// 캐릭터 초기화(이름,레벨,경험치,코인,럭,스피드,업그레이드)
		c = new Character(null,1,0,2000,0,0,0);
		
		//기본낚싯대 초기화(이름,가격,갯수,성공률,스피드,고품질)
		c.naciBox[0] = new Item("초보자용 낙싯대",1000,1,0,0,0);
		
		
		//기본장비 초기화(이름,가격,갯수,성공률,스피드,고품질)
		c.miggi[0] = new Item("미끼",50,5,0,0,0); //미끼 전용 장비칸
		c.equipment[0] = c.naciBox[0];//낙싯대 전용 장비칸
		
		it =new Item(); //아이템 객체 생성
		f = new Fish(); //물고기 객체 생성
//		c.naciBox[1] = it.item[1]; 
//	    c.fishBox[0] = f.riverFish1[3];
	}
	
	public static void main(String[] args) {
		new MyGame().start();
	}
	
	void start() {
			System.out.println("┍——————- /ᐠ｡ꞈ｡ᐟ\\ —————————┑");
			System.out.println("         낚시 게임            ");
			System.out.println("┕———————————————————————-┙");
			System.out.println("     닉네임을 설정해주세요.     ");
			System.out.println("——————————————————————————");
			System.out.print("==>");
			c.name = ScanUtil.nextLine();
			System.out.println("캐릭터 설정 완료!");
			while(true) {
				System.out.println("————————————————————————————————————————————————————");
				System.out.println("1.캐릭터정보  2.민물낚시  3.바다낚시  4.상점  5.창고  0.종료");
				System.out.println("————————————————————————————————————————————————————");
				System.out.print("==>");
				int input = ScanUtil.nextInt();
				
			switch(input){
			case 1: 
				c.status();
				break;
			case 2:
				c.fishing(f,1); // 물고기 정보랑 숫자 1 전달 (숫자 1 : 민물낚시 , 숫자 0: 바다낚시) 
				break;
			case 3:
				if(c.level >= 3) {
					c.fishing(f, 0);
				}else {
					
					System.out.println("레벨이 부족합니다..ㅜ.ㅜ ( 3레벨 이상부터 이용가능 )");
					
				}
				break;
			case 4:
				int num = 0;
				num = it.displayItem(c.coin);
				if(num != -1) {
					c.buyItem(it.item, num);
				}
				break;
			case 5:
				c.inven();
				break;
			case 0:
				System.out.println("게임이 종료되었습니다.");
				System.exit(0);
				
			}
		}
	}

}