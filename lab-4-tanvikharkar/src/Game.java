import java.util.*;

public class Game {
//    public HashSet<Integer> player = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
//    public HashSet<Integer> lottery = new HashSet<>(Arrays.asList(1, 2, 3, 4, 6));
//    Random gameRandom = new Random();

    public HashSet<Integer> winningLotNumber(int min, int max) {
        HashSet<Integer> hSet = new HashSet<>();
        Random gameRandom = new Random();
        int randomNum = 0;
        int check = 0;
        while (check < 5){
            randomNum = gameRandom.nextInt((max - min) + 1) + min;
            if (check == 0) {
                System.out.println(randomNum);
                hSet.add(randomNum);
                check++;
            }
            else if (check >= 1 && hSet.contains(randomNum)) {	// check if random number is already in hash set
                // do nothing
                check = check;
            }
            else {
                System.out.println(randomNum);
                hSet.add(randomNum);
                check++;
            }
        }
        return hSet;
    }

    public int checkSets(HashSet<Integer> player, HashSet<Integer> lottery) {
        int check = 0;
        for (Integer i : player) {
            if (lottery.contains(i)) {
                check++;
            }
        }
        return check;
    }

    public double totalWinnings(HashSet<Integer> player, HashSet<Integer> lottery) {
        double winnings = -1;
        switch(checkSets(player, lottery)) {
            case 1:
                winnings += 0;
                break;
            case 2:
                winnings += 2;
                break;
            case 3:
                winnings += 11.86;
                break;
            case 4:
                winnings += 198.53;
                break;
            case 5:
                winnings += 212535.83;
                break;
            default:
                winnings += 0;
                break;
        }
        return winnings;
    }
}
