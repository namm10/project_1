package day16;

import java.util.Scanner;

public class Cafe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //입력을 받을라면 스캐너 필요
		int count = 0; //갯수를 저장할 count
		//↓메뉴주문은 총 5개까지 가능
		String orderList[]=new String[5]; //주문할 메뉴를저장할 문자열 -5개메뉴받을수있게저장
		//↓총금액 저장할 변수
		int total = 0; //주문하면 누적시키고 취소하면 차감 결제하면 전체금액이 얼마인지 나타낸다
		while(true) {
			System.out.println("Nam Cafe");
			System.out.print("1. 주문하기 ");
			System.out.print("2. 취소하기 ");
			System.out.print("3. 결제하기 ");
			System.out.println("4. 끝내기");
			System.out.print("입력 : "); //입력을 받을라면 스캐너 필요
			int num = sc.nextInt(); //정수형으로 입력받기
			if (num==1) { //num1번을 입력하면 주문하기
				String menuName=""; 
				int menuPrice=0; //초기값으로 0 설정해줌
				System.out.println("1. 아메리카노\t3800원");
				System.out.println("2. 에스프레스\t2400원");
				System.out.println("3. 카페라떼\t4200원");
				System.out.println("4. 밀크티\t\t5100원");
				System.out.print("주문할 메뉴번호 : ");
				int menuNum=sc.nextInt(); //번호로 입력받기
				if(menuNum==1) { //메뉴1이라면
					menuName="아메리카노";
					menuPrice=3800;
				}
				else if(menuNum==2) { //메뉴2라면
					menuName="에스프레스";
					menuPrice=2400;
				}
				else if(menuNum==3) { //메뉴3이라면
					menuName="카페라떼";
					menuPrice=4200;
				}
				else if(menuNum==4) { //메뉴4라면
					menuName="밀크티";
					menuPrice=5100;
				}
				else { //이모든게 아니라면
					System.out.println("잘못입력하셨습니다.");
					continue; //반복의 처음으로 돌아가라
				}
				//↓total에 menuPrice를 누적
				total+=menuPrice; //주문한 메뉴의 가격을 누적한다
				orderList[count]=menuName; //orderList에 menuName추가
				count++;
				System.out.println("주문한 메뉴는 "+menuName+"입니다.");
				System.out.println("가격은 "+menuPrice+"입니다.");
			} 
			else if (num==2) { //2번을 입력하면 취소하기
				System.out.println("주문한 메뉴 리스트");
				for(int i=0; i<count; i++) { //0위치부터 count위치까지 내가3을 주문하면 count위치는 3
					System.out.println(i+1+"."+orderList[i]);//count전까지가 내가 출력해야되는 orderList의 i번째가 될꺼다
				}					//↑i+1번 사용자한테 이중에서 넌 몇번째를 삭제할껀지 번호로 물어봄
				System.out.print("취소할 메뉴번호 : "); //지우고싶은 번호를
				int cancelNum=sc.nextInt(); //입력받는다
				if(1<=cancelNum && cancelNum<=count) { 
					String delMenu=orderList[cancelNum-1]; //delMenu를 만들었다 orderList에 내가 삭제하고자하는것에(cancelNum)-1을 저장함
					System.out.println(delMenu+" 메뉴삭제");
					for(int i=cancelNum-1; i<count; i++) { //취소할려는 cancelNum-1위치부터 i<count할때까지
						orderList[i]=orderList[i+1]; //orderList에 i번째 있는걸 orderList에 i+1번으로 바꿈
					}
					if(delMenu.equals("아메리카노")) { //delMenu가 아메리카노랑 equals같으면
						total-=3800; //아메리카노 가격만큼 차감
					}
					else if(delMenu.equals("에소프레소")) { //delMenu가 에소프레소 equals같으면
						total-=2400; //에소프레소 가격만큼 차감
					}
					else if(delMenu.equals("카페라떼")) { //delMenu가 카페라떼 equals같으면
						total-=4200; //카페라떼 가격만큼 차감
					}
					else if(delMenu.equals("밀크티")) { //delMenu가 밀크티 equals같으면
						total-=5100; //밀크티 가격만큼 차감
					}
					count--; //주문한개수 감소
				}
			}
			else if (num==3) { //3번을 입력하면 결제하기
				System.out.println("결제할 금액 : "+total+"원"); 
				System.out.print("지불할 금액 : ");
				int money=sc.nextInt();
				if(money<total) { //money보다 total이 더 크면 
					System.out.println("잔돈이 부족합니다.");
					continue; //금액이 부족해서 다시 돌아감
				}else { //그게아니라면 
					System.out.println("잔돈은 "+(money-total)+"원 입니다."); //를 출력하고
					total=0; //total을 0으로 만든다
					for(int i=0; i<5; i++) { //0~5까지 반복
						orderList[i]=""; //0~4까지를 빈문자로 넣음
					}
					count=0;
				}
			}
			else if (num==4) { //4번을 입력하면 끝내기
				System.out.println("주문종료");
				break;
			} 
			else { //이모든게 아니면
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}

}
