package controller;

import model.Entry;
import model.Member;
import org.junit.Test;
import repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Deni on 25/04/2018.
 */
public class MemberControllerGetAllTest {
    private MemberRepository repo = new MemberRepository();

    private MemberController ctrl = new MemberController(repo);

    @Test
    public void allEntries() throws Exception {
        repo.addMember(new Member("a", 1));
        Entry e = new Entry("cost", 1, 1);
        repo.addEntry(e);
        List<Entry> list = new ArrayList<>();
        list.add(e);
        assertEquals(list, ctrl.allEntries());


    }
}