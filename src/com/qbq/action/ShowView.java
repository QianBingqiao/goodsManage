package com.qbq.action;

import java.util.Scanner;

import com.qbq.service.AllInterface;
import com.qbq.service.DealFactory;
import com.qbq.utils.DBUtity;

public class ShowView {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String doStr;//操作
		do{
			printMenu();
			doStr = sc.next();
			if(doStr.equalsIgnoreCase("0")){
				break;	
			}
			AllInterface deal;
			DealFactory dealFactory = new DealFactory();
			deal = dealFactory.createDeal(doStr);
			if(deal !=null){
				deal.enterPrompt();//打印加以提示信息
				
				if(deal.getImport() !=0){
					System.out.println("获取输入数据失败");
				}else{
					if(deal.doDeal() != 0){
//						deal.showResult();
						System.out.println("doDeal failed!");
						continue;
					}else{
//						deal.showResult();
						System.out.println("doDeal success!");
						continue;
					}
				}
			}else{
				System.out.println("创建交易实例出错");
			}	
		}while(!doStr.equals("0"));
		sc.close();
		
		System.out.println("系统正常退出! EXIT!");
		
		
		
	}
	
	public static void printMenu() {
		System.out.println("------------------商品销售系统------------- ");
		System.out.println("--1商品信息添加*********--2商品信息修改*********");
		System.out.println("--3商品信息查询*********--4采购信息添加*********");
		System.out.println("--5采购信息查询*********--6销售信息添加*********");
		System.out.println("--7销售报表************--8库存查询************");
		System.out.println("-----------0:退出--------------------------");
		System.out.println("请输入相应的代号执行相应的操作，输入0退出");
	}

}
