package before;

public class NumberBaseball {
    private static final int baseballCount = 3;

    public void execute(){
        System.out.println("숫자야구게임에 오신것을 환영합니다.");
        gameStart();
    }

    public void gameStart(){
        int[] randomNumber = makeRandomNumberArray();

    }

    public int[] makeRandomNumberArray(){
        int[] randomNumber = new int[baseballCount];
        for (int i = 0; i < baseballCount; i++) {
            randomNumber[i] = noDuplicateNumber(randomNumber);
        }
        return randomNumber;
    }

    private int noDuplicateNumber(int[] randomNumber) {
        int n = (int) (Math.random() * 9) + 1;

        while (randomNumber[0] == n || randomNumber[1] == n){
            n = (int) (Math.random() * 9);
        }
        return n;
    }
}
