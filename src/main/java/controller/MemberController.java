package controller;

import exceptions.DuplicateKeyException;
import exceptions.InvalidIdException;
import exceptions.InvalidNameException;
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
        invalidIdException.validate(id);

        Member aMemebr = new Member(name,id);

        mr.addMember(aMemebr);
    }

    public void addEntry(Entry oneEntry) {
        mr.addEntry(oneEntry);    	
    }

     public List<Entry> allEntries() {
        
    	
        List<Entry> allE= new ArrayList<>();
        allE = this.mr.getAllEntries();
        return allE;
    }
} 