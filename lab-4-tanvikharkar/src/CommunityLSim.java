import java.util.*;

/**
 * A class that represents the community and simulates
 * the running of the lottery.
 */
public final class CommunityLSim {

    ArrayList<CommunityMember> communityMembers;
    Random random = new Random();
    //you will need to add more instance variables

    /**
     * Creates a new Community with the specified number of people
     * @param numP The number of people in the community
     */
    public CommunityLSim(int numP) {
        //create the players
        this.communityMembers = new ArrayList<>();

        for (int i = 0; i < numP; i++) {
            if (i < numP /2.0)
                this.communityMembers.add(new CommunityMember(CMemberKind.POORLY_PAID, (float)(99+Math.random())));
            else
                this.communityMembers.add(new CommunityMember(CMemberKind.WELL_PAID, (float)(100.1+Math.random())));
        }
    }

    public int getSize() {
        return this.communityMembers.size();
    }

    public CommunityMember getPlayer(int i) {
        return this.communityMembers.get(i);
    }

    /**
     * Give each community member some pocket change.
     * Give POORLY_PAID community members 0.03f, and give
     * WELL_PAID community members 0.1f.
     */
    // TODO: Implement this method.
    public void addPocketChange() {
        for (CommunityMember member : communityMembers) {
            if (member.getKind() == CMemberKind.POORLY_PAID) {
                member.addMoney(0.03f);
            }
            else if (member.getKind() == CMemberKind.WELL_PAID) {
                member.addMoney(0.1f);
            }
        }
    }

    // TODO: Write a method that computes a new list of lottery players,
    //  choosing from the list of community members.
    //  You will likely want to change this method signature.
    private void reDoWhoPlays() {


    }

    /* generate some random indices for who might play the lottery
        in a given range of indices */

    /**
     * Generate a number of random indices within an interval
     * @param communitySize The size of the community playing the lottery
     */
    // TODO: Implement this method. You will likely want to change this
    //  method signature.
    public List<Integer> randomUniqIndx(int communitySize) {
        int numI = communitySize / 2;  // half the community population
        List<Integer> indices = new ArrayList<>();
        int randomNum = 0;
        int check = 0;
        while (check < communitySize) {
            if (check < 0.6 * communitySize) {
                randomNum = random.nextInt((communitySize / 2) + 1);
                if (check == 0) {
                    indices.add(randomNum);
                    check++;
                }
                else if (check >= 1 && indices.contains(randomNum)) {
                    // do nothing
                    check = check;
                }
                else {
                    indices.add(randomNum);
                    check++;
                }
            }
            else {
                randomNum = random.nextInt((communitySize - communitySize / 2) + 1) + communitySize / 2;
                if (check == 0.6 * communitySize) {
                    indices.add(randomNum);
                    check++;
                }
                else if (check >= 0.6 * communitySize && indices.contains(randomNum)) {
                    // do nothing
                    check = check;
                }
                else {
                    indices.add(randomNum);
                    check++;
                }
            }
        }
        return indices;
    }

    public void simulateYears(int numYears) {
        // Simulate the lottery (see steps below)
        for (int year=0; year < numYears; year++) {
            addPocketChange();
            // TODO Add pocket change for all community members, whether or not they're playing.
            // TODO Re-compute the players who are playing the lottery in the current year.
            // TODO Simulate the lottery for those players.

            // 4. Update everyone's money for that year.
            for (CommunityMember cm : this.communityMembers) {
                cm.updateMoneyEachYear();
            }
        }
    }

}
