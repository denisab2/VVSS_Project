package controller;

import exceptions.DuplicateKeyException;
import exceptions.InvalidIdException;
import exceptions.InvalidNameException;
import exceptions.InvalidTypeException;
import repository.MemberRepository;

import model.Member;
import model.Entry;



import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemberController {
	
    private MemberRepository mr;
    private InvalidNameException nameException= new InvalidNameException("");
    private InvalidIdException invalidIdException = new InvalidIdException("");
    
    public MemberController(MemberRepository newMr){    	
    	this.mr =newMr;    	
    }
    
    public void addMember(String name, int id) throws InvalidNameException, DuplicateKeyException, InvalidIdException {

        nameException.validate(name);
        if(!invalidIdException.validate(id))
            throw new InvalidIdException("Id not valid");

        Member aMemebr = new Member(name,id);

        mr.addMember(aMemebr);
    }


    public void addEntry(String type,int valueInt,int idInt) throws InvalidTypeException, InvalidIdException {

        if(!type.equals("income") && !type.equals("cost"))
            throw new InvalidTypeException();
        if(!invalidIdException.validate(idInt))
            throw new InvalidIdException("Id not valid");

        if(mr.checkIdUnique(new Member("", valueInt)))
            throw new InvalidIdException("Id does not exist.");


        Entry oneEntry = new Entry(type, valueInt, idInt);
        mr.addEntry(oneEntry);
    }


     public List<Entry> allEntries() {
        
         return this.mr.getAllEntries();

    }
} 