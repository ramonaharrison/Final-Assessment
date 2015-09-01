package nyc.c4q;

import java.util.ArrayList;

/**
 * Created by Ramona Harrison
 * on 9/1/15.
 */
public interface MemberListener {

    public void addMember(Member member);

    public ArrayList<Member> getAllMembers();

    public int getMemberCount();
}