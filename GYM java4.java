package BM23AI069;

import java.util.Scanner;
public class GYM {
    public static void main(String[]args){
        Scanner s1= new Scanner(System.in);
        System.out.println("wlecome to gym membership management system!");
        System.out.print("ente member name: ");
        String name= s1.nextLine();
        System.out.print("enter member age:");
        int age = s1.nextInt();
        System.out.print("is the membership active? (tue/false):");
        boolean isActive=s1.nextBoolean();
        System.out.print("enter membership duration(in months):");
        int duration = s1.nextInt();
        double membershipfee = duration*50.0;
        System.out.println("\n --------Member details--------");
        System.out.println("NAME:"+ name);
        System.out.println("age:"+ age);
        System.out.println("mem status:" + (isActive? "active": "inactve"));
        System.out.println("mem duration" + duration + "month");
        System.out.println("mem fee:" + membershipfee);
        if(isActive){
            System.out.println("thank you");
        } else{
            System.out.println("inactive membership");
        }
        s1.close();
    }
}
