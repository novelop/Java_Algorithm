package 낚시게임;

public class Fish {

	String name;
	int price;	
    int count;
	
	@Override
	public String toString() {
		return name +", 가격:" + price + "코인 " + count + "개"; 
	}

	Fish[] riverFish1;
	Fish[] riverFish2;
	Fish[] riverFish3;
	Fish[] riverFish4;
	
	Fish[] seaFish1;
	Fish[] seaFish2;
	Fish[] seaFish3;
	Fish[] seaFish4;
	

    Fish(String name, int price, int count){
    	this.name = name;
    	this.price = price;
    	this.count = count;
    }
    
    Fish(){
    	//민물고기
    			//하급
    			riverFish1 = new Fish[7];
    			riverFish1[0] = new Fish("피라미",200,0);
    			riverFish1[1] = new Fish("붕어",160,0);
    			riverFish1[2] = new Fish("잉어",300,0);
    			riverFish1[3] = new Fish("송사리",300,0);
    			riverFish1[4] = new Fish("올챙이",400,0);
    			riverFish1[5] = new Fish("다슬기",100,0);
    			riverFish1[6] = new Fish("베스",120,0);
    			//중급
    			riverFish2 = new Fish[6];
    			riverFish2[0] = new Fish("송어",1500,0);
    			riverFish2[1] = new Fish("황어",1200,0);
    			riverFish2[2] = new Fish("금붕어",1300,0);
    			riverFish2[3] = new Fish("미꾸라지",1400,0);
    			riverFish2[4] = new Fish("개구리",1200,0);
    			riverFish2[5] = new Fish("가물치",1100,0);
    			//상급
    			riverFish3 = new Fish[4];
    			riverFish3[0] = new Fish("비단잉어",3000,0);
    			riverFish3[1] = new Fish("연어",5000,0);
    			riverFish3[2] = new Fish("참게",4000,0);
    			riverFish3[3] = new Fish("가재",3000,0);
    			//최상급
    			riverFish4 = new Fish[2];
    			riverFish4[0] = new Fish("철갑상어",10000,0);
    			riverFish4[1] = new Fish("왕연어",9000,0);
    		
		
		//바다 물고기
				//하급
				seaFish1 = new Fish[7];
				seaFish1[0] = new Fish("전갱이",150,0);
				seaFish1[1] = new Fish("농어",400,0);
				seaFish1[2] = new Fish("쏨뱅이",240,0);
				seaFish1[3] = new Fish("노가리",300,0);
				seaFish1[4] = new Fish("가자미",400,0);
				seaFish1[5] = new Fish("넙치",800,0);
				seaFish1[6] = new Fish("오징어",500,0);
				//중급
				seaFish2 = new Fish[6];
				seaFish2[0] = new Fish("광어",2500,0);
				seaFish2[1] = new Fish("해마",2100,0);
				seaFish2[2] = new Fish("흰동가리",2300,0);
				seaFish2[3] = new Fish("개복치",4000,0);
				seaFish2[4] = new Fish("도미",3000,0);
				seaFish2[5] = new Fish("돌돔",4000,0);
				//상급
				seaFish3 = new Fish[4];
				seaFish3[0] = new Fish("가오리",5000,0);
				seaFish3[1] = new Fish("산갈치",9000,0);
				seaFish3[2] = new Fish("복어",5000,0);
				seaFish3[3] = new Fish("다랑어",7000,0);
				//최상급
				seaFish4 = new Fish[2];
				seaFish4[0] = new Fish("상어",15000,0);
				seaFish4[1] = new Fish("청새치",10000,0);
	
    }
    
}