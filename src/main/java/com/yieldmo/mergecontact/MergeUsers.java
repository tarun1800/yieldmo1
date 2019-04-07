package com.yieldmo.mergecontact;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.yieldmo.common.Contact;

import java.util.*;
import java.util.stream.Collectors;
import java.lang.Object.*;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;


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

    }


    public   static  Map<String,Map<String,String>> filterPhone(List<Contact> contacts) {

        Map<String,String>  phone = contacts.stream().collect(Collectors.toMap(x->x.getName(),x->x.getEmail(),(oldValue,newValue) -> oldValue));
      //  System.out.println(phone);

      //  phone.forEach((x,y) -> System.out.println( "Key :" + x + ' ' + "Value:" + ' ' +y));



        Map<String,Map<String,String>> map = contacts.stream().collect(Collectors.groupingBy(Contact::getPhone,Collectors.toMap(x->x.getName(),x->x.getEmail())));


        map.values().stream().collect(Collectors.toList());
        return map;
    }

}
