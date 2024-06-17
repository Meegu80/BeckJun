import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BioCalendar {
    // 신체 리듬 주기 (23일)
    public static final int PHYSICAL = 23;
    // 감정 리듬 주기 (28일)
    public static final int EMOTIONAL = 28;
    // 지성 리듬 주기 (33일)
    public static final int INTELLECTUAL = 33;

    // 바이오리듬 값을 계산하는 메서드
    public static double getBioRhythm(long days, int index, int max) {
        // 바이오리듬 값 계산 공식
        return max * Math.sin((days % index) * 2 * Math.PI / index);
    }

    // 프로그램의 시작점
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 생년월일 입력받기
        System.out.print("생년을 입력하세요 (예: 1980): ");
        int year = scanner.nextInt();

        System.out.print("생월을 입력하세요 (예: 12): ");
        int month = scanner.nextInt();

        System.out.print("생일을 입력하세요 (예: 4): ");
        int day = scanner.nextInt();

        // 입력받은 생년월일 설정
        LocalDate birthDate = LocalDate.of(year, month, day);
        // 오늘 날짜 설정
        LocalDate currentDate = LocalDate.now();

        // 기준일부터 오늘까지의 일수 차이 계산
        long days = ChronoUnit.DAYS.between(birthDate, currentDate);

        // 바이오리듬 값을 계산
        double phyval = getBioRhythm(days, PHYSICAL, 100); // 신체 지수 계산
        double emoVal = getBioRhythm(days, EMOTIONAL, 100); // 감정 지수 계산
        double intVal = getBioRhythm(days, INTELLECTUAL, 100); // 지성 지수 계산

        // 계산된 바이오리듬 값 출력
        System.out.printf("나의 신체 지수는 %.2f입니다.\n", phyval);
        System.out.printf("나의 감정 지수는 %.2f입니다.\n", emoVal);
        System.out.printf("나의 지성 지수는 %.2f입니다.\n", intVal);

        scanner.close();
    }
}
