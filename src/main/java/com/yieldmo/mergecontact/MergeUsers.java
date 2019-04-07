package com.yieldmo.mergecontact;


import com.yieldmo.common.Contact;

import java.util.*;
import java.util.stream.Collectors;



public class MergeUsers {



    public static  void main(String [] args){

        List<Contact> contactLists = Arrays.asList(
                new Contact("MR. X","123-456-7890","x@yieldmo.com"),
                new Contact("MS. Y","456-789-1234","y@yieldmo.com"),
                new Contact("MR. X1","123-456-7890","x@gmail.com"),
                new Contact("Ms. Y1","456-789-9999","y@yieldmo.com"));

        contactLists.forEach(Contact -> System.out.println("Name :" + ' ' +  Contact.getName() + ' ' + "phone :" + Contact.getPhone() +
                ' ' +  "email :" + Contact.getEmail()));

        Map<String,Map<String,String>> phFilter = filterPhone(contactLists);

        phFilter.forEach((x,y)->System.out.println("Phone : " + x + ' ' + "Name :" + ' ' + y.keySet().stream().collect(Collectors.toList()) + ' '+ "email :" + ' ' + y.values().stream().collect(Collectors.toList())));


        Map<String,Map<String,String>> emFilter = filterEmail(contactLists);

        emFilter.forEach((x,y)->System.out.println("Email : " + x + ' ' + "Name :" + ' ' + y.keySet().stream().collect(Collectors.toList()) + ' '+ "Phone :" + ' ' + y.values().stream().collect(Collectors.toList())));


    }


    public   static  Map<String,Map<String,String>> filterPhone(List<Contact> contacts) {

        Map<String,String>  phone = contacts.stream().collect(Collectors.toMap(x->x.getName(),x->x.getEmail(),(oldValue,newValue) -> oldValue));



        Map<String,Map<String,String>> map = contacts.stream().collect(Collectors.groupingBy(Contact::getPhone,Collectors.toMap(x->x.getName(),x->x.getEmail())));


        map.values().stream().collect(Collectors.toList());
        return map;
    }


    public   static  Map<String,Map<String,String>> filterEmail(List<Contact> contacts) {

        Map<String,String>  email = contacts.stream().collect(Collectors.toMap(x->x.getName(),x->x.getPhone(),(oldValue,newValue) -> oldValue));



        Map<String,Map<String,String>> map = contacts.stream().collect(Collectors.groupingBy(Contact::getEmail,Collectors.toMap(x->x.getName(),x->x.getPhone())));


        map.values().stream().collect(Collectors.toList());
        return map;
    }

}
