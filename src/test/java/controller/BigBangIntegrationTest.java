package controller;

import model.Member;
import org.junit.Test;
import repository.MemberRepository;

import static org.junit.Assert.*;

/**
 * Created by Deni on 25/04/2018.
 */
public class BigBangIntegrationTest {

    private MemberRepository repo = new MemberRepository();

    private MemberController ctrl = new MemberController(repo);

    @Test
    public void allFunctions() throws Exception {
        ctrl.addMember("ana",1);
        ctrl.addEntry("cost",1,1);
        ctrl.allEntries();
        assertTrue(true);
    }
}