package 낚시게임;

import e_oop.ScanUtil;

public class Character {

	String name;
	int level;
	int coin;
	int luck; //낚시 성공률
	int speed; //낚시 속도 
	int upgrade; //물고기 등급 
	private int exp;
	final int maxExp = 10;
    Fish[] fishBox = new Fish[30]; //내 물고기 
    Item[] naciBox = new Item[5]; //내 낙싯대
    Item[] equipment = new Item[1]; // 장착중인 낙싯대
    Item[] miggi = new Item[1]; //나의 미끼
	
    int num = 0;
    
	
	
    // 경험치가 10 이상이면 레벨 1씩 증가 
	public void setExp(int exp) {
		if(exp >= 10) {			
			this.exp = 0;
			this.level++;
		}else {
			this.exp = exp;
		}
	}
 
    Character(String name, int level, int exp, int coin, int luck, int speed, int upgrade){
    	this.name = name;
    	this.level = level;
    	this.exp = exp;
    	this.coin = coin;
        this.luck = luck;
        this.speed = speed;
        this.upgrade = upgrade;
    }
    //캐릭터 정보
    void status() {
    	System.out.println("--------------------------------------------------");
    	System.out.println("< " + name + "의 정보 >");
    	System.out.println("LV." + level);
    	System.out.print("exp : ");
    	for(int i = 0; i < exp; i++) {
    		System.out.print("■");
    	}
    	for(int i = 0; i < maxExp - exp; i++) {
    		System.out.print("□");
    	}
    	System.out.println();
    	System.out.println("성공률   : " + luck);
        System.out.println("스피드   : " + speed);
        System.out.println("물고기품질 : " + upgrade);
        System.out.println("--------------------------------------------------");
        System.out.println("<장비중인 아이템>");
    	System.out.println(equipment[0].name);
    	System.out.println("미끼 (" + miggi[0].count + "개)");
    }
    
    //경험치 얻기 
    void getExp() {
    	this.exp += 5;
    	setExp(this.exp);
    	System.out.println("5의 경험치를 얻었습니다.");
    }
    
    //아이템 구매하기 
    void buyItem(Item[] item, int num) {
		if (this.coin >= item[num].price) {
			 this.coin -= item[num].price;
			System.out.println(item[num].name + "을 구매하였습니다.");
			//깍인 코인 
			System.out.println(item[num].price + "코인이 깍였습니다.");
			if(item[num].name.equals("미끼")) {
				miggi[0].count += item[num].count;
			}else {
				for (int i = 0; i < naciBox.length; i++) {
					if(naciBox[i] == null) {
						naciBox[i] = item[num];
						break;
					}else if (item[num].name.equals(naciBox[i].name)) {
						naciBox[i].count++;
						break;
					}
				}
			}
		}else {
			System.out.println("Coin이 부족합니다.");
		}
    }
    
    //내창고
    void inven() {
    	System.out.println();
    	System.out.println("< 소지 낚싯대 목록 >                           나의코인:" + coin);
    	System.out.println("---------------------------------------------------------------------");
    	for(int i = 0; i < naciBox.length; i++) {
    		if(naciBox[i] == null) {
    			num = i;//아이템 목록 갯수 
    			break;
    		}
    			if(naciBox[i].name == equipment[0].name ) { //장비중인 아이템이랑 같을때 
    				System.out.print("1.(장착중)");
    				System.out.print(naciBox[0]);
    				System.out.println();
    			}else {
    				System.out.println(i+1 + "." + naciBox[i]);
    			}
    	}
    	System.out.println();
    	System.out.println("< 잡은 물고기 목록 >");
    	System.out.println("--------------------------------------------------------------------");
    
    	for(int i = 0; i < fishBox.length; i++) {
    		
    		if(fishBox[i] == null) {
    			break;
    		}
    			System.out.println(fishBox[i]);
    	}
    	System.out.println();
    	System.out.println("=================================================");
    	System.out.println("낚싯대변경(1번) 낚싯대팔기(2번) 물고기팔기(3번) 나가기(아무숫자)");
    	System.out.println("=================================================");
    	int input = ScanUtil.nextInt();
    	if(input == 1) {
    		System.out.println("변경할 낚싯대의 번호를 입력하세요.");
    		input =ScanUtil.nextInt();
    		if(input > num || input <= 0) {
    			System.out.println("해당되는 낚싯대의 번호가 없습니다...");
    			inven();
    		}else if(input == 1){
    			System.out.println("이미 장착중인 낚싯대입니다.");
    			inven();
    		}else {
    			//낙싯대 변경 - 장착중인 낙싯대 맨 앞으로 순서 변경 
    			Item temp = naciBox[0];
				naciBox[0] = naciBox[input-1];
				naciBox[input-1] = temp;
				
    			System.out.println(naciBox[0].name + "으로 변경되었습니다.");
    			equipment[0] = naciBox[0];
    			this.luck = naciBox[0].luck;
    			this.speed = naciBox[0].speed;
    			this.upgrade = naciBox[0].upgrade;
    		}
    	}else if(input == 2) { //낙싯대 판매 
    	    System.out.println("판매할 낚싯대의 번호를 입력하세요.");
    	    input = ScanUtil.nextInt();
    	    if(input > num || input <= 0) {
    	    	System.out.println("해당되는 낚싯대가 없습니다.");
    	    }else if(input == 1){
    			System.out.println("장착중인 낚싯대는 판매할 수 없습니다.");
    			inven();
    		}else {
    			System.out.println(naciBox[input-1].name + "가 판매되었습니다.");
    			System.out.println(naciBox[input-1].price +"코인을 얻었습니다.");
    			this.coin += naciBox[input-1].price;
    			if(naciBox[input-1].count > 1) {
    				naciBox[input-1].count--;
    			}else {
    				naciBox[input-1] = null;
					for (int i = 0; i < naciBox.length; i++) {
						if (naciBox[i] == null) {
							naciBox[i] = naciBox[i + 1];
							naciBox[i + 1] = null;
						}
						if (naciBox[i] == null && naciBox[i + 1] == null) {
							break;
						}
					}
    			}
    			
				
    		}
    	}else if(input ==3) { //물고기 판매 
    		System.out.println("판매할 물고기의 이름을 입력해주세요.");
    		String name = ScanUtil.nextLine();
    		boolean b = false;
    		int num = 0;
			for (int i = 0; i < fishBox.length; i++) {
				if (fishBox[i] != null) {
					if (name.equals(fishBox[i].name)) {
						System.out.println(fishBox[i].name +"를 판매하였습니다.");
						System.out.println(fishBox[i].price +"를 얻었습니다.");
						this.coin += fishBox[i].price;
						if(fishBox[i].count > 1) {
							fishBox[i].count--;
							b = true;
							break;
						}else {
							fishBox[i] = null;
							b = true;
							break;
						}
					}
				}
				
			}
			if (!b) {
					System.out.println("해당되는 물고기가 없습니다.");
					inven();
				}
			//물고기 정렬 
			for (int i = 0; i < fishBox.length; i++) {
				if (fishBox[i] == null) {
					fishBox[i] = fishBox[i + 1];
					fishBox[i + 1] = null;
				}
				if (fishBox[i] == null && fishBox[i + 1] == null) {
					break;
				}
			}
			
			
    	}
    }
    
 
    //물고기 잡기
    void fishing(Fish f, int ab) {
		if (miggi[0].count >= 1) {
			miggi[0].count--;
			System.out.println("미끼 1개를 잃었습니다.");
			try {
				System.out.print("낚시중");
				//스피드 높아질 수록 물고기 잡는 속도 감소 
				for (int i = 0; i < 5 - this.speed; i++) {
					Thread.sleep(1000);
					System.out.print(" ♥ ");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			//물고기 등급별 확률 
			//luck 높아질수록 물고기 잡을 성공률 높아짐 
			int num = 0;
			if (Math.random() > 0.5 - luck * 0.1) { //50퍼센트 
				// 물고기 잡았을대 저장 메소드
				// 물고기 등급 확률별로
				double random = (double)(Math.random());
//				System.out.println(random);
				if (0.9 - upgrade*0.1 < random) {   //0.9 ~ 1 10퍼센트  upgrade 1증가시 10퍼센트 증가 
					// 최상급  2개
				 	 num = (int)(Math.random()*2); //물고기 저장 
				 	 saveFish(ab,num,"a",f);
				}else if(0.7 - upgrade*0.1 < random) { //20퍼센트 0.7 ~ 0.9 
					// 상급 4개
					 num = (int)(Math.random()*4);
					 saveFish(ab,num,"b",f);
				}else if(0.4 - upgrade*0.1 < random) { //30퍼센트 0.4 ~ 0.7
					// 중급 6개
					 num = (int)(Math.random()*6);
					 saveFish(ab,num,"c",f);
				}else {//40퍼센트 0 ~ 0.4
					// 하급 7개
				     num = (int)(Math.random()*7);
				     saveFish(ab,num,"d",f);
				}
             
			} else {
				System.out.println("\n물고기를 놓쳤습니다... ㅜ.ㅜ");
			}

		} else {
			System.out.println("미끼가 부족합니다.");
		}
    }
    
    //물고기 저장
    void saveFish(int ab, int num,String grade, Fish f) {//num 랜덤값
        System.out.println();
    	for (int i = 0; i < fishBox.length; i++) {
			if (ab == 1) {
				if( grade == "a") {
					if (fishBox[i] == null) {
						fishBox[i] = f.riverFish4[num];
						fishBox[i].count++;
						System.out.println(f.riverFish4[num].name +"을 잡았다!");
						break;
					} else if (f.riverFish4[num].name.equals(fishBox[i].name)) {
						fishBox[i].count++;
						System.out.println(f.riverFish4[num].name +"을 잡았다!");
						break;
					}
				}else if(grade == "b"){
					if (fishBox[i] == null) {
						fishBox[i] = f.riverFish3[num];
						fishBox[i].count++;
						System.out.println(f.riverFish3[num].name +"을 잡았다!");
						break;
					} else if (f.riverFish3[num].name.equals(fishBox[i].name)) {
						fishBox[i].count++;
						System.out.println(f.riverFish3[num].name +"을 잡았다!");
						break;
					}
				}else if(grade == "c") {
					if (fishBox[i] == null) {
						fishBox[i] = f.riverFish2[num];
						fishBox[i].count++;
						System.out.println(f.riverFish2[num].name +"을 잡았다!");
						break;
					} else if (f.riverFish2[num].name.equals(fishBox[i].name)) {
						fishBox[i].count++;
						System.out.println(f.riverFish2[num].name +"을 잡았다!");
						break;
					}
				}else{
					if (fishBox[i] == null) {
						fishBox[i] = f.riverFish1[num];
						fishBox[i].count++;
						System.out.println(f.riverFish1[num].name +"을 잡았다!");
						break;
					} else if (f.riverFish1[num].name.equals(fishBox[i].name)) {
						fishBox[i].count++;
						System.out.println(f.riverFish1[num].name +"을 잡았다!");
						break;
					}
				}
				
			}else {
				if( grade == "a") {
					if (fishBox[i] == null) {
						fishBox[i] = f.seaFish4[num];
						fishBox[i].count++;
						System.out.println(f.seaFish4[num].name +"을 잡았다!");
						break;
					} else if (f.seaFish4[num].name.equals(fishBox[i].name)) {
						fishBox[i].count++;
						System.out.println(f.seaFish4[num].name +"을 잡았다!");
						break;
					}
				}else if(grade == "b"){
					if (fishBox[i] == null) {
						fishBox[i] = f.seaFish3[num];
						fishBox[i].count++;
						System.out.println(f.seaFish3[num].name +"을 잡았다!");
						break;
					} else if (f.seaFish3[num].name.equals(fishBox[i].name)) {
						fishBox[i].count++;
						System.out.println(f.seaFish3[num].name +"을 잡았다!");
						break;
					}
				}else if(grade == "c") {
					if (fishBox[i] == null) {
						fishBox[i] = f.seaFish2[num];
						fishBox[i].count++;
						System.out.println(f.seaFish2[num].name +"을 잡았다!");
						break;
					} else if (f.seaFish2[num].name.equals(fishBox[i].name)) {
						fishBox[i].count++;
						System.out.println(f.seaFish2[num].name +"을 잡았다!");
						break;
					}
				}else{
					if (fishBox[i] == null) {
						fishBox[i] = f.seaFish1[num];
						fishBox[i].count++;
						System.out.println(f.seaFish1[num].name +"을 잡았다!");
						break;
					} else if (f.seaFish1[num].name.equals(fishBox[i].name)) {
						fishBox[i].count++;
						System.out.println(f.seaFish1[num].name +"을 잡았다!");
						break;
					}
				}
				
			}
		}//for 문 종료 
    	getExp();
    	
    }
    
    
}