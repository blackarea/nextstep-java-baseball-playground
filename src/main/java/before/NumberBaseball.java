package before;

import java.util.Scanner;

public class NumberBaseball {
    private static final int baseballCount = 3;

    public void execute(){
        System.out.println("숫자야구게임에 오신것을 환영합니다.");
        gameStart();
    }

    public void gameStart(){
        int[] randomNumberArr = makeRandomNumberArray();
        boolean threeStrike = false;
        int[] inputNumberArr;
        while (!threeStrike){
            printMessage();
            inputNumberArr = intToArray(scanNumber());
            threeStrike = isGameOver(judgeResult(inputNumberArr, randomNumberArr));
        }
    }

    private String judgeResult(int[] inputNumberArr, int[] randomArr) {

        return null;
    }

    public int[] intToArray(int threeNumber){
        int[] array = new int[baseballCount];

        return array;
    }

    public int scanNumber() {
        Scanner sc = new Scanner(System.in);
        String inputNumber;
        try {
            inputNumber = sc.nextLine();
        }catch (NumberFormatException e){
            throw new NumberFormatException("숫자가 아닌 다른 값이 입력 되었습니다.");
        }

        if(inputNumber.length() != 3){
            System.out.println("본 게임은 3자리 숫자의 숫자 야구 게임입니다. 3자리만 입력해주세요");
            return scanNumber();
        }
        return Integer.parseInt(inputNumber);
    }

    private void printMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    private void outMessage(){

    }

    private boolean isGameOver(String message) {

        //message에 따라서 o
        return false;
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
