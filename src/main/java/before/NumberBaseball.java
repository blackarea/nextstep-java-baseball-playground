package before;

import java.util.Scanner;

public class NumberBaseball {
    private static final int baseballCount = 3;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        NumberBaseball nb = new NumberBaseball();
        nb.execute();
    }

    public void execute() {
        System.out.println("숫자야구게임에 오신것을 환영합니다.");
        boolean play = true;
        while (play) {
            play = playGame();
        }
    }

    public boolean playGame() {
        int[] randomNumberArr = makeRandomNumberArray();
        boolean threeStrike = false;
        int[] inputNumberArr;
        while (!threeStrike) {
            printInputMessage();
            inputNumberArr = intToArray(scanNumber());
            threeStrike = isGameOver(judgeResult(randomNumberArr, inputNumberArr));
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playAgain = sc.nextLine();
        while (!playAgain.equals("1") && !playAgain.equals("2")){
            System.out.println("다시 입력해주세요");
            playAgain = sc.nextLine();
        }
        return playAgain.equals("1");
    }

    public boolean isGameOver(String message) {
        System.out.println(message);
        return message.equals("3S");
    }

    public String judgeResult(int[] randomArr, int[] inputNumberArr) {
        int strikeCount = judgeStrike(randomArr, inputNumberArr);
        int ballCount = judgeBall(randomArr, inputNumberArr);

        if (ballCount != 0 && strikeCount != 0) {
            return ballCount + "B " + strikeCount + "S";
        }
        if (ballCount != 0) {
            return ballCount + "B";
        }
        if (strikeCount != 0) {
            return strikeCount + "S";
        }
        return "4B";
    }

    public int judgeStrike(int[] randomArr, int[] inputNumberArr) {
        int count = 0;
        for (int i = 0; i < baseballCount; i++) {
            if (isSameNumber(randomArr[i], inputNumberArr[i])) {
                count++;
            }
        }
        return count;
    }

    public int judgeBall(int[] randomArr, int[] inputNumberArr) {
        int count = 0;
        for (int i = 0; i < baseballCount; i++) {
            if (containNumberNotSameIndex(randomArr[i], inputNumberArr, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSameNumber(int number1, int number2) {
        return number1 == number2;
    }

    private boolean containNumberNotSameIndex(int number, int[] array, int index) {
        for (int i = 0; i < baseballCount; i++) {
            if (isSameNumber(number, array[i]) && i != index) {
                return true;
            }
        }
        return false;
    }

    public int[] intToArray(int threeNumber) {
        int[] array = new int[baseballCount];
        for (int i = 0; i < baseballCount; i++) {
            array[i] = (int) (threeNumber / Math.pow(10, baseballCount - 1 - i)) % 10;
        }

        return array;
    }

    public int scanNumber() {
        String inputString = sc.nextLine();
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 다른 값이 입력 되었습니다. 다시 입력해주세요");
            return scanNumber();
        }

        if (inputString.length() != 3) {
            System.out.println("본 게임은 3자리 숫자의 숫자 야구 게임입니다. 3자리만 입력해주세요");
            return scanNumber();
        }
        return inputNumber;
    }

    private void printInputMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public int[] makeRandomNumberArray() {
        int[] randomNumber = new int[baseballCount];
        for (int i = 0; i < baseballCount; i++) {
            randomNumber[i] = noDuplicateNumber(randomNumber);
        }
        return randomNumber;
    }

    private int noDuplicateNumber(int[] randomNumber) {
        int n = (int) (Math.random() * 9) + 1;

        while (randomNumber[0] == n || randomNumber[1] == n) {
            n = (int) (Math.random() * 9);
        }
        return n;
    }
}
