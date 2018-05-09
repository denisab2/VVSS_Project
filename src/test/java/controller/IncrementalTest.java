package controller;

import model.Entry;
import org.junit.Test;
import repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Deni on 09/05/2018.
 */
public class IncrementalTest {
    private MemberRepository repo = new MemberRepository();

    private MemberController ctrl = new MemberController(repo);

    @Test
    public void test1() throws Exception {
        Entry e = new Entry("cost", 1, 1);
        ctrl.addMember("ana",1);

        assertEquals(repo.getMembers().get(0).getName(),"ana");
        assertEquals(repo.getMembers().get(0).getId(),1);


    }

    @Test
    public void test2() throws Exception {
        Entry e = new Entry("cost", 1, 1);
        ctrl.addMember("ana",1);
        ctrl.addEntry(e.getType(),e.getValue(),e.getIdMember());

        assertEquals(repo.getMembers().get(0).getName(),"ana");
        assertEquals(repo.getMembers().get(0).getId(),1);
        assertEquals(repo.getAllEntries().get(0).getType(), "cost");
        assertEquals(repo.getAllEntries().get(0).getIdMember(), 1);
        assertEquals(repo.getAllEntries().get(0).getValue(), 1);

    }

    @Test
    public void test3() throws Exception {
        Entry e = new Entry("cost", 1, 1);
        ctrl.addMember("dana",1);
        ctrl.addEntry(e.getType(),e.getValue(),e.getIdMember());

        assertEquals(repo.getMembers().get(0).getName(),"dana");
        assertEquals(repo.getMembers().get(0).getId(),1);
        assertEquals(repo.getAllEntries().get(0).getType(), "cost");
        assertEquals(repo.getAllEntries().get(0).getIdMember(), 1);
        assertEquals(repo.getAllEntries().get(0).getValue(), 1);
        List<Entry> list = new ArrayList<>();
        list.add(e);
        assertEquals(1, ctrl.allEntries().size());
    }

}