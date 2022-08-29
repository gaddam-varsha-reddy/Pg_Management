package com.wavemaker;
import com.wavemaker.manager.BedManager;
import com.wavemaker.manager.BookingManager;
import com.wavemaker.manager.RoomManager;
import com.wavemaker.manager.UserManager;
import com.wavemaker.manager.implementation.BedOperations;
import com.wavemaker.manager.implementation.BookingOperations;
import com.wavemaker.manager.implementation.RoomOperations;
import com.wavemaker.manager.implementation.UserOperations;
import com.wavemaker.model.Bed;
import com.wavemaker.model.Booking;
import com.wavemaker.model.Room;
import com.wavemaker.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RoomManager roomManager=new RoomOperations();
        BedManager bedManager=new BedOperations();
        BookingManager bookingManager=new BookingOperations();
        UserManager userManager=new UserOperations();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n!=13) {
            switch (n) {
                case 1:
                    System.out.println("Add Room");
                    int id=0;
                    System.out.println("Enter roomno");
                    int roomno=sc.nextInt();
                    System.out.println("Enter floorno");
                    int floorno=sc.nextInt();
                    System.out.println("Enter totalbeds");
                    int totalbeds=sc.nextInt();
                    roomManager.addRoom(new Room(id,roomno,floorno,totalbeds));
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 2:
                    System.out.println("Delete Room");
                    System.out.println("enter roomno");
                    int roomNo=sc.nextInt();
                    System.out.println("enter floorno");
                    int floorNo=sc.nextInt();
                    roomManager.deleteRoom(floorNo,roomNo);
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 3:
                    System.out.println("Display Room");
                    List<Room> roomList;
                    roomList=roomManager.displayRooms();
                    for(Room listItem:roomList){
                        System.out.println("Id:" +listItem.getId()+"\tRoomNo:" +listItem.getRoomNo()+"\tFloorNo:" +listItem.getFloorNo()+ "\tTotalBeds:"+ listItem.getTotalBeds());
                    }
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 4:
                    System.out.println("add Bed");
                    System.out.println("Enter roomId");
                    int roomId=sc.nextInt();
                    System.out.println("Enter total beds");
                    int totalBeds=sc.nextInt();
                    bedManager.addBed(roomId,totalBeds);
                    System.out.println("Enter n");
                    n= sc.nextInt();
                    break;
                case 5:
                    System.out.println("delete Bed");
                    System.out.println("Enter roomId");
                    roomId=sc.nextInt();
                    System.out.println("Enter total beds");
                    totalBeds=sc.nextInt();
                    bedManager.deleteBed(roomId,totalBeds);
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 6:
                    System.out.println("Display Beds");
                    List<Bed> bedList;
                    bedList=bedManager.displayBeds();
                    for(Bed listItem:bedList){
                        System.out.println("Id:" +listItem.getId()+"\tRoomId:" +listItem.getRoomId() + "\tBedNo:"+ listItem.getBedNo() + "\tisFull:" +listItem.isFull());
                    }
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 7:
                    System.out.println("add Booking");
                    System.out.println("Enter userId");
                    int userId=sc.nextInt();
                    System.out.println("Enter bedId");
                    int bedId=sc.nextInt();
                    bookingManager.addBooking(userId,bedId);
                    System.out.println("Enter n");
                    n= sc.nextInt();
                    break;
                case 8:
                    System.out.println("delete Booking");
                    System.out.println("Enter userId");
                    userId=sc.nextInt();
                    System.out.println("Enter bedId");
                    bedId=sc.nextInt();
                    bookingManager.deleteBooking(userId,bedId);
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 9:
                    System.out.println("Display Booking");
                    List<Booking> bookingList;
                    bookingList=bookingManager.displayBookings();
                    for(Booking listItem:bookingList){
                        System.out.println("Id:" +listItem.getId()+"\tUser_Id:" +listItem.getUserId() + "\tBed_Id:"+ listItem.getBedId() );
                    }
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 10:
                    System.out.println("add User");
                    id=0;
                    System.out.println("Enter first name");
                    String firstName=sc.next();
                    System.out.println("Enter last name");
                    String lastName=sc.next();
                    System.out.println("Enter mobile no");
                    String mobileNo=sc.next();
                    System.out.println("Enter email");
                    String email=sc.next();
                    System.out.println("Enter Age");
                    int age=sc.nextInt();
                    userManager.addUser(new User(id,firstName,lastName,mobileNo,email,age));
                    System.out.println("Enter n");
                    n= sc.nextInt();
                    break;
                case 11:
                    System.out.println("delete User");
                    System.out.println("Enter email");
                    email=sc.next();
                    userManager.deleteUser(email);
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 12:
                    System.out.println("Display Users");
                    List<User> userList ;
                    userList=userManager.displayUsers();
                    for(User listItem:userList){
                        System.out.println("Id:" +listItem.getId()+"\tFirst_Name:" +listItem.getFirstName() + "\tLast_Name:"+ listItem.getLastName() +"\tMobile_No:" +listItem.getMobileNo() + "\tEmail:" +listItem.getEmail()+ "\tAge:" + listItem.getAge() );
                    }
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                case 13:
                    System.out.println("Exit");
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
                default:
                    System.out.println("Enter valid numb");
                    System.out.println("Enter n");
                    n=sc.nextInt();
                    break;
            }
        }


    }
}
